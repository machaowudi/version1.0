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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View view, int position, long id){
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String []sum=helper.find(position+1).split(" ");
                Bundle bundle = new Bundle();
                bundle.putString("name",sum[1]);
                bundle.putString("singer",sum[2]);
                bundle.putLong("id",id);
                fmm.setArguments(bundle);

                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction tx=fm.beginTransaction();
                tx.replace(R.id.menu,fmm);
                tx.commit();
                return false;
            }
        });
        listView.setAdapter(myAdapter);
    }

    private void init(){
        long a=helper.count();
        for(int i=1;i<=a;i++)
        {
            String []sum=helper.find(i).split(" ");
            int sss=Integer.parseInt(sum[3]);
            System.out.println(sss/100);
            linkMains.add(new MUSIC(R.drawable.ic_launcher_background,sum[1],sum[2],sss/100+"分"+sss%100+"秒"));
        }
    }
}
