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

import com.example.cuong.discover_ahihikara.MySongActivity;
import com.example.cuong.discover_ahihikara.PlayVideoActivity;
import com.example.cuong.discover_ahihikara.R;
import com.example.cuong.discover_ahihikara.model.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Welcome on 8/27/2016.
 */
public class MySongAdapter extends ArrayAdapter<Song> {

    private Context context;
    private int resource;
    private List<Song> arrSong;

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
            viewHolder.actionSong = (Button) convertView.findViewById(R.id.actionSong);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Song song = arrSong.get(position);
        viewHolder.iconSong.setBackgroundResource(song.getIcon());
        viewHolder.nameSong.setText(String.valueOf(song.getName()));
        viewHolder.singerSong.setText(song.getSinger());
        viewHolder.actionSong.setText(song.getAction());

        viewHolder.actionSong.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Bạn vừa chọn " + viewHolder.actionSong.getText() + " bài hát " + viewHolder.nameSong.getText(),   Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,PlayVideoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url", song.getURL());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    public class ViewHolder {
        ImageView iconSong;
        TextView nameSong, singerSong;
        Button actionSong;

    }
}
