package com.example.forthone;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "my_db";
    private static final String TABLE_NAME = "todo";
    private static final int VERSION = 1;


    private static final String ID = "id";
    private static final String Title = "title";
    private static final String DESCRIPTION = "description";
    private static final String STARTED = "started";
    private static final String FINISHED = "finished";


    public DbHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String TABLE_CREATE_QUERY = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Title + " TEXT, " +
                DESCRIPTION + " TEXT, " +
                STARTED + " TEXT, " +
                FINISHED + " TEXT" +
                ");";

        db.execSQL(TABLE_CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(DROP_TABLE_QUERY);
        onCreate(db);

    }

    public void addToDo(ToDo toDo){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Title,toDo.getTitle());
        values.put(DESCRIPTION,toDo.getDescription());
        values.put(STARTED,toDo.getStarted());
        values.put(FINISHED,toDo.getFinished());

        db.insert(TABLE_NAME,null,values);
        db.close();


    }



}
