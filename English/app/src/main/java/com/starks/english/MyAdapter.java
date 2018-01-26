package com.starks.english;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by RCP on 1/26/2018.
 */

public class MyAdapter  extends RecyclerView.Adapter<MyHolder>{
    Context c;
    ArrayList<Mean> meanings;

    public MyAdapter(Context c, ArrayList<Mean> meanings) {
        this.c = c;
        this.meanings = meanings;
    }

    //INITIALIZE VIEWHODER
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //VIEW OBJ
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,null);

        //HOLDER
        MyHolder holder=new MyHolder(v);

        return holder;
    }
    //BIND VIEW TO DATA
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {


        holder.wordtxt.setText(meanings.get(position).getWord());
        holder.meantxt.setText(meanings.get(position).getMeaning());
        holder.sentxt.setText(meanings.get(position).getSentence());

        //CLICKED
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Snackbar.make(v,meanings.get(pos).getWord(),Snackbar.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return meanings.size();
    }
}
