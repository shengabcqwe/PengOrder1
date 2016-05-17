package com.example.shenpeng.pengorder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shenpeng on 4/19/16.
 */
public class FoodDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_BOOK="create TABLE food("+"id integer primary key autoincrement,"+"name text,"+"price text,"+"number integer,"+"imageId integer,"+"score integer)";



    public FoodDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
