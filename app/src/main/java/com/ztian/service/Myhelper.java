package com.ztian.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Myhelper extends SQLiteOpenHelper {
    public Myhelper(Context context) {
        super(context, "itcast.db", null, 2);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE musiclove(_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20),singer VARCHAR(20),time INTEGER)");}

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert(String name,String singer,String time) {
        SQLiteDatabase db =getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("singer", singer);
        values.put("time", time);
        long id = db.insert("musiclove",null,values);
        db.close();
        return true;
    }//插入

        public void delete (String name){

            SQLiteDatabase db=getWritableDatabase();
            db.delete("music", "name=?", new String[]{name});
        db.close();
    }//删除

    public long count(){
        SQLiteDatabase db =getWritableDatabase();
        String sql = "select count(*) from musiclove";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        long count = cursor.getLong(0);
        cursor.close();
        return count;
    }

    public int update(String name,String singer ,String time) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("time", time);
        values.put("singer",singer);
        int number = db.update("musiclove", values, " name =?", new        	String[]{name});
        db.close();
        return number;
    }//更新

    public String find(int id){
        SQLiteDatabase db =getReadableDatabase();
        String sum="";
        Cursor cursor = db.query("musiclove", null, "_id=?", new String[]{id+""},null, null, null);
        if (cursor.getCount() != 0){
            while (cursor.moveToNext()){
                String _id = cursor.getString(cursor.getColumnIndex("_id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String singer = cursor.getString(cursor.getColumnIndex("singer"));
                String time = cursor.getString(cursor.getColumnIndex("time"));
                sum=_id+" "+name+" "+singer+" "+time;
            }
        }
        cursor.close();
        db.close();
        return sum;
    }//查询

}