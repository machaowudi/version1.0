package com.ztian.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class restore extends AppCompatActivity {
    private Button store;
    private int a=1;
    Myhelper helper = new Myhelper(restore.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restore);
        store=(Button)findViewById(R.id.button);
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if( helper.insert(String.valueOf(a),String.valueOf(a),"340")==true)
               {
                   Toast.makeText(restore.this,String.valueOf(a),Toast.LENGTH_SHORT).show();
                   a++;
               }
            }
        });
    }
    public void count(View v){
        long a=helper.count();
        String sum= helper.find(1);
        Toast.makeText(restore.this,a+" "+sum,Toast.LENGTH_SHORT).show();
    }
    public void check(View v){
       if(helper.findname("fire")==true)
           Toast.makeText(this,"yes",Toast.LENGTH_SHORT).show();
       else
           Toast.makeText(this,"yes",Toast.LENGTH_SHORT).show();
    }
    public void one(View v){
        String sum= helper.find(1);
        Toast.makeText(restore.this,sum,Toast.LENGTH_SHORT).show();
    }
    public void three(View v){
        String sum= helper.find(3);
        Toast.makeText(restore.this,sum,Toast.LENGTH_SHORT).show();
    }
    public void shoucang(View v){
            Intent intent=new Intent(restore.this,lovemusic.class);
             startActivity(intent);
    }
    public void delete(View v){
        int a=helper.delete("2");
        Toast.makeText(this,"删除成功"+a,Toast.LENGTH_SHORT).show();
    }




























}
