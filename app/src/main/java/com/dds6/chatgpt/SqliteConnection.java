package com.dds6.chatgpt;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class SqliteConnection extends SQLiteOpenHelper {

    public static final String COLUM_ID_INTEGER = "COLUM_ID INTEGER";
    public static final String COLUM_NAME = "COLUM_NAME";
    public static final String COLUM_AGE = "COLUM_AGE";
    public static final String COLUM_PROMPT = "COLUM_PROMPT";
    public static final String COLUM_RESPONSE = "COLUM_RESPONSE";
    public static final String PROMPT_TABLE = "PROMPT_TABLE";
    public static final String COLUM_REAL_AGE = "COLUM_REAL_AGE";

    public SqliteConnection(@Nullable Context context) {
        super(context, "prompt.db" , null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CreateTableStatement = "Create Table " + PROMPT_TABLE + " ( " + COLUM_ID_INTEGER + " PRIMARY KEY AUTOINCREMENT , " + COLUM_NAME + " TEXT, " + COLUM_AGE + " INTEGER, " + COLUM_PROMPT + " TEXT, " + COLUM_RESPONSE + " TEXT, " + COLUM_REAL_AGE + " INTEGER)";
        db.execSQL(CreateTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(PromptModel promptModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUM_NAME,promptModel.getName());
        cv.put(COLUM_AGE, promptModel.getAge());
        cv.put(COLUM_PROMPT, promptModel.getPrompt());
        cv.put(COLUM_RESPONSE, promptModel.getResponse());
        cv.put(COLUM_REAL_AGE, promptModel.getResponse());


        long insert = db.insert(PROMPT_TABLE, null, cv);
        if (insert == -1) {
            db.close();
            return true;
        } else {
            return false;
        }
    }
}
