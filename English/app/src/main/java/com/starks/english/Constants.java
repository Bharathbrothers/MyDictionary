package com.starks.english;

/**
 * Created by RCP on 1/26/2018.
 */

public class Constants {
    //COLUMNS
    static final String ROW_ID="id";
    static final String WORD = "word";
    static final String MEANING = "meaning";
    static final String SENTENCE = "sentence";


    //DB PROPERTIES
    static final String DB_NAME="d_DB";
    static final String TB_NAME="d_TB";
    static final int DB_VERSION='1';

    static final String CREATE_TB="CREATE TABLE d_TB(id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "word TEXT NOT NULL,meaning TEXT NOT NULL,sentence TEXT NOT NULL);";
}
