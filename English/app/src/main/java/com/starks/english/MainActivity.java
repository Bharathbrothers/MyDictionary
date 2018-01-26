package com.starks.english;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText wordTxt,meanTxt,senTxt;
    RecyclerView rv;
    MyAdapter adapter;
    ArrayList<Mean> meanings =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SHOW INPUT DIALOG
                showDialog();
            }
        });
        rv= (RecyclerView) findViewById(R.id.mRecycler);

        //SET PROPS
        rv.setLayoutManager(new LinearLayoutManager(this));

        rv.setItemAnimator(new DefaultItemAnimator());

        //ADAPTER
        adapter=new MyAdapter(this,meanings);

        //RETRIEVE
        retrieve();
    }
    private void showDialog()
    {
        Dialog d=new Dialog(this);

        //NO TITLE
        d.requestWindowFeature(Window.FEATURE_NO_TITLE);

        d.setContentView(R.layout.inputdialog);

        meanTxt=  d.findViewById(R.id.wordEditTxt);
        wordTxt=  d.findViewById(R.id.meanEditTxt);
        senTxt=  d.findViewById(R.id.senEditTxt);
        Button saveBtn= d.findViewById(R.id.saveBtn);
        final Button retrievebtn=  d.findViewById(R.id.retrieveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(meanTxt.getText().toString(),wordTxt.getText().toString(),senTxt.getText().toString());
            }
        });

        retrievebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrieve();
            }
        });

        d.show();

    }
    private void save(String word,String meaning,String sentence)
    {
        DBAdapter db=new DBAdapter(this);

        //OPEN DB
        db.openDB();

        //COMMIT
        long result=db.add(word,meaning,sentence);

        if(result>0)
        {
            wordTxt.setText("");
            meanTxt.setText("");
            senTxt.setText("");
        }else
        {
            Snackbar.make(wordTxt,"Unable To Save", Snackbar.LENGTH_SHORT).show();
        }

        db.closeDB();

        //REFRESH
        retrieve();
    }
    private void retrieve()
    {
        meanings.clear();

        DBAdapter db=new DBAdapter(this);
        db.openDB();

        //RETRIEVE
        Cursor c=db.getAllPlayers();

        //LOOP AND ADD TO ARRAYLIST
        while (c.moveToNext())
        {
            int id=c.getInt(0);
            String word=c.getString(1);
            String meaning=c.getString(2);
            String sentence=c.getString(3);

            Mean m=new Mean(id,word,meaning,sentence);

            //ADD TO ARRAYLIS
            meanings.add(m);
        }

        //CHECK IF ARRAYLIST ISNT EMPTY
        if(!(meanings.size()<1))
        {
            rv.setAdapter(adapter);
        }

        db.closeDB();

    }

}

