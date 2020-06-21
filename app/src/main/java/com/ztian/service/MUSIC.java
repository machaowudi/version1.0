package com.ztian.service;

public class MUSIC {
    private int headPortrait;
    private String name;
    private String news;
    private String time;
    public MUSIC(int headPortrait, String name, String news, String time){
        this.headPortrait = headPortrait;
        this.name = name;
        this.news = news;
        this.time = time;
    }
    public int getHeadPortrait() {
        return headPortrait;
    }

    public String getName() {
        return name;
    }

    public String getNews() {
        return news;
    }

    public String getTime() {
        return time;
    }
}
