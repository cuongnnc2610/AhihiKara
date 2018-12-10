package com.example.cuong.discover_ahihikara.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cuong.discover_ahihikara.PlayVideoActivity;
import com.example.cuong.discover_ahihikara.R;
import com.example.cuong.discover_ahihikara.VideoSinging;
import com.example.cuong.discover_ahihikara.controller.ImageLoadTask;
import com.example.cuong.discover_ahihikara.model.Song;

import java.util.ArrayList;
import java.util.List;

public class MySongAdapter extends ArrayAdapter<Song> {

    private Context context;
    private int resource;
    private ArrayList<Song> arrSong;

    public MySongAdapter(Context context, int resource, ArrayList<Song> arrSong) {
        super(context, resource, arrSong);
        this.context = context;
        this.resource = resource;
        this.arrSong = arrSong;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_song, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.iconSong = (ImageView) convertView.findViewById(R.id.iconSong);
            viewHolder.nameSong = (TextView) convertView.findViewById(R.id.nameSong);
            viewHolder.singerSong = (TextView) convertView.findViewById(R.id.singerSong);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Song song = arrSong.get(position);
        new ImageLoadTask(song.getSingerImageURL(), viewHolder.iconSong).execute();
        String name = song.getName();
        if (name.length() > 18) {
            name = name.substring(0, 15) + "...";
        }
        viewHolder.nameSong.setText(name);
        viewHolder.nameSong.setText(String.valueOf(song.getName()));
        viewHolder.singerSong.setText(song.getSinger());
        return convertView;
    }

    public class ViewHolder {
        ImageView iconSong;
        TextView nameSong, singerSong;
        Button actionSong;

    }
}
