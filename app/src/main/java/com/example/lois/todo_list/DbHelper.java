package com.example.lois.todo_list;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLClientInfoException;
import java.util.ArrayList;

/**
 * Created by lois on 30/01/2018.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "ToDoLi";
    private static final int DB_VER = 1;
    public static final String DB_TABLE = "Task";
    public static final String DB_COLUMN_DESC = "Description";
    public static final String DB_COLUMN_ID = "ID";
    public static final String DB_COLUMN_PRIORITY = "Priority";
    public static final String DB_COLUMN_DATE = "Date";
    public static final String DB_COLUMN_NAME = "Name";

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = String.format("CREATE TABLE %s (ID INTEGER PRIMARY KEY AUTOINCREMENT,%s TEXT NOT NULL,%s TEXT NOT NULL,%s TEXT NOT NULL,%s NUMERIC);",DB_TABLE, DB_COLUMN_NAME, DB_COLUMN_DESC, DB_COLUMN_PRIORITY, DB_COLUMN_DATE);
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV){
        String query = String.format("DELETE TABLE IF EXISTS %s", DB_TABLE);
        db.execSQL(query);
        onCreate(db);
    }

    public void insertNewTask(String name, String desc, String prio, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DB_COLUMN_NAME, name);
        values.put(DB_COLUMN_DESC, desc);
        values.put(DB_COLUMN_PRIORITY, prio);
        values.put(DB_COLUMN_DATE, date);
        db.insertWithOnConflict(DB_TABLE, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }

    public void deleteTask(String task){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DB_TABLE, DB_COLUMN_ID + " = ?", new String[]{task});
        db.close();
    }

    public ArrayList<Task> getTaskList(){
        ArrayList<Task> taskList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DB_TABLE, null, null, null, null, null, null);
        while (cursor.moveToNext()){
            Task tmplist = new Task(cursor.getString(cursor.getColumnIndex(DB_COLUMN_NAME)),
                                    cursor.getString(cursor.getColumnIndex(DB_COLUMN_DESC)),
                                    cursor.getInt(cursor.getColumnIndex(DB_COLUMN_ID)),
                                    cursor.getString(cursor.getColumnIndex(DB_COLUMN_PRIORITY)),
                                    cursor.getString(cursor.getColumnIndex(DB_COLUMN_DATE)));
            taskList.add(tmplist);
        }
        cursor.close();
        db.close();
        return taskList;
    }
}
