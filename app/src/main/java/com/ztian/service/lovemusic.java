package com.ztian.service;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class lovemusic extends AppCompatActivity  {
    private List<MUSIC> linkMains = new ArrayList<>();
    private ListView listView;
    fragment fmm=new fragment();
    Myhelper helper = new Myhelper(lovemusic.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        this.init();
        final musicAdapter myAdapter = new musicAdapter(this,R.layout.activity_lovemusic,linkMains);
        listView = (ListView)this.findViewById(R.id.list_view);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id){
               //传数据

            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                TextView t1=(TextView) view.findViewById(R.id.name);
                String name=t1.getText().toString();
                TextView t2=(TextView) view.findViewById(R.id.news);
                String emotion=t2.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                bundle.putString("emotion",emotion);
                bundle.putLong("id",id);
                fmm.setArguments(bundle);

                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction tx=fm.beginTransaction();
                tx.replace(R.id.menu,fmm);
                tx.commit();
                return false;
            }
        });
      //  listView.setAdapter(myAdapter);
    }

    private void init(){
        long a=helper.count();
        int m=1;
       while(a>=1){
           if (helper.find(m)!=""){
               String []sum=helper.find(m).split(" ");
               int sss = Integer.parseInt(sum[3]);
               //int imageId =getResources().getIdentifier(sum[1],"drawable","com.ztian.service");
               linkMains.add(new MUSIC(R.drawable.fire, sum[1], sum[2], sss / 100 + "分" + sss % 100 + "秒"));
               a--;
           }
           m++;

       }
    }
}
