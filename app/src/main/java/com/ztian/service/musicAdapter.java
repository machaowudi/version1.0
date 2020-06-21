package com.ztian.service;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class musicAdapter extends ArrayAdapter{//适配器


    public musicAdapter(Context context, int resource, List<MUSIC> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MUSIC music = (MUSIC)getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.activity_lovemusic, null);

        ImageView headPortrait = (ImageView)view.findViewById(R.id.headPortrait);
        TextView name = (TextView)view.findViewById(R.id.name);
        TextView news = (TextView)view.findViewById(R.id.news);
        TextView time = (TextView)view.findViewById(R.id.time);

        headPortrait.setImageResource(music.getHeadPortrait());
        name.setText(music.getName());
        news.setText(music.getNews());
        time.setText(music.getTime());
        return view;
    }
    public String getName(){
        View view = LayoutInflater.from(getContext()).inflate(R.layout.activity_lovemusic, null);
        TextView name = (TextView)view.findViewById(R.id.name);
        return name.getText().toString();
    }
}