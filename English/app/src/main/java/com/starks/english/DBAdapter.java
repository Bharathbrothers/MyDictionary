package com.starks.english;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by RCP on 1/26/2018.
 */

public class DBAdapter {
    Context c;

    SQLiteDatabase db;
    DBHelper helper;

    public DBAdapter(Context c) {
        this.c = c;
        helper=new DBHelper(c);
    }

    //OPEN DATABASE
    public DBAdapter openDB()
    {
        try {
            db=helper.getWritableDatabase();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return this;
    }
    public void closeDB()
    {
        try {
            helper.close();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
    public long add(String word,String meaning,String sentence)
    {
        try
        {
            ContentValues cv=new ContentValues();
            cv.put(Constants.WORD,word);
            cv.put(Constants.MEANING, meaning);
            cv.put(Constants.SENTENCE,sentence);


            return db.insert(Constants.TB_NAME,Constants.ROW_ID,cv);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return 0;
    }

    //RETRIEVE
    public Cursor getAllPlayers()
    {
        String[] columns={Constants.ROW_ID,Constants.WORD,Constants.MEANING,Constants.SENTENCE};

        return db.query(Constants.TB_NAME,columns,null,null,null,null,null);

    }


}
