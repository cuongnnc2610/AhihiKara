package com.example.cuong.discover_ahihikara.model;


/**
 * Created by Welcome on 8/27/2016.
 */
public class Song {
    private int icon;
    private String name;
    private String singer;
    private String action;

    public Song(int icon, String name, String singer, String action) {
        this.icon = icon;
        this.name = name;
        this.singer = singer;
        this.action = action;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
