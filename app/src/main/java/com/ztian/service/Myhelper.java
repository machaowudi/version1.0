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
        db.execSQL("CREATE TABLE musiclove(_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20),emotion VARCHAR(20),time INTEGER)");}

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert(String name,String emotion,String time) {
        SQLiteDatabase db =getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("emotion", emotion);
        values.put("time", time);
        long id = db.insert("musiclove",null,values);
        db.close();
        return true;
    }//插入
    public int delete(String name){
        SQLiteDatabase db = getWritableDatabase();
        int number = db.delete("musiclove", "name=?", new String[]{name});
        db.close();
        return number;
    }//删除

    public long count(){
        SQLiteDatabase db =getWritableDatabase();
        String sql = "select count(*) from musiclove where _id>0";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        long count = cursor.getLong(0);
        cursor.close();
        return count;
    }

    public int update(String name,String emotion ,String time) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("time", time);
        values.put("emotion",emotion);
        int number = db.update("musiclove", values, "name =?", new String[]{name});
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
                String emotion = cursor.getString(cursor.getColumnIndex("emotion"));
                String time = cursor.getString(cursor.getColumnIndex("time"));
                sum=_id+" "+name+" "+emotion+" "+time;
            }
        }
        cursor.close();
        db.close();
        return sum;
    }//查询
    public boolean findname(String name){
        SQLiteDatabase db =getReadableDatabase();
        boolean sum=false;
        Cursor cursor = db.query("musiclove", null, "name=?", new String[]{name},null, null, null);
        if (cursor.getCount() != 0){
           sum=true;
        }
        cursor.close();
        db.close();
        return sum;
    }//查询有无歌曲
    public String  findemotion(String emotion){
        SQLiteDatabase db =getReadableDatabase();
        String sum="";
        Cursor cursor = db.query("musiclove", null, "emotion=?", new String[]{emotion},null, null, null);
        if (cursor.getCount() != 0){
           sum =sum+" "+cursor.getString(cursor.getColumnIndex("name"));
        }
        cursor.close();
        db.close();
        return sum;
    }
}