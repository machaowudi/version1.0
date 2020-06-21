package com.ztian.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class restore extends AppCompatActivity {
    private Button store;
    Myhelper helper = new Myhelper(restore.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restore);
        store=(Button)findViewById(R.id.button);
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if( helper.insert("unravel","aaa","340")==true)
               {
                   Toast.makeText(restore.this,"插入111成功",Toast.LENGTH_SHORT).show();
                   long a=helper.count();
                   System.out.println(a);
               }
            }
        });
    }
    public void check(View v){
       String sum= helper.find(1);
        Toast.makeText(restore.this,sum,Toast.LENGTH_SHORT).show();
    }

    public void change(View v){
            Intent intent=new Intent(restore.this,lovemusic.class);
             startActivity(intent);
    }





























}
