package com.example.cuong.discover_ahihikara.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.cuong.discover_ahihikara.R;
import com.example.cuong.discover_ahihikara.controller.ImageLoadTask;
import com.example.cuong.discover_ahihikara.model.Song;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {
    private ArrayList<Song> songs;
    private Context context;
    private int resource;

    public SongAdapter(Context context, int resource, ArrayList<Song> songs) {
        this.context = context;
        this.resource = resource;
        this.songs = songs;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = layoutInflater.inflate(resource, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        new ImageLoadTask(songs.get(i).getIcon(), viewHolder.iconSong).execute();
        viewHolder.nameSong.setText(songs.get(i).getName());
        viewHolder.singerSong.setText(songs.get(i).getSinger());
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView iconSong;
        TextView nameSong, singerSong;
        ImageButton btnlike;
        public ViewHolder(View itemView) {
            super(itemView);
            iconSong = itemView.findViewById(R.id.iconSong);
            nameSong = itemView.findViewById(R.id.nameSong);
            singerSong = itemView.findViewById(R.id.singerSong);
            btnlike = itemView.findViewById(R.id.btn_like);
        }
    }
}
