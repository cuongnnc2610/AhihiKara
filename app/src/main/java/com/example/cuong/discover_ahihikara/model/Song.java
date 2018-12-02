package com.example.cuong.discover_ahihikara.model;

import android.net.Uri;
import android.widget.ImageButton;

public class Song {
    private String icon;
    private String name;
    private String singer;
    private String url;
    private ImageButton btnlike;


    public Song(String icon, String name, String singer, String url) {
        this.icon = icon;
        if (name.length() > 15) {
            this.name = name.substring(0, 12) + "...";
        } else {
            this.name = name;
        }
        this.singer = singer;
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 15) {
            this.name = name.substring(0, 12) + "...";
        } else {
            this.name = name;
        }
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getURL() {
        return url;
    }

    public void setURL(String url) {
        this.url = url;
    }

    public ImageButton getBtnlike() { return btnlike;}

    public void setBtnlike(ImageButton btnlike) { this.btnlike = btnlike;}
}
