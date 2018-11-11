package com.example.cuong.discover_ahihikara.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cuong.discover_ahihikara.R;
import com.example.cuong.discover_ahihikara.model.Song;

import java.util.List;

public class SongBookAdapter extends BaseAdapter {

    private List<Song> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public SongBookAdapter(Context aContext, List<Song> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_song, null);
            holder = new ViewHolder();
            holder.iconSong = (ImageView) convertView.findViewById(R.id.iconSong);
            holder.nameSong = (TextView) convertView.findViewById(R.id.nameSong);
            holder.singerSong = (TextView) convertView.findViewById(R.id.singerSong);
            holder.actionSong = (Button) convertView.findViewById(R.id.actionSong);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Song song = this.listData.get(position);
        holder.nameSong.setText(song.getName());
        holder.singerSong.setText(song.getSinger());
        holder.iconSong.setImageResource(song.getIcon());
        holder.actionSong.setText(song.getAction());

        return convertView;
    }
    static class ViewHolder {
        ImageView iconSong;
        TextView nameSong, singerSong;
        Button actionSong;
    }

}