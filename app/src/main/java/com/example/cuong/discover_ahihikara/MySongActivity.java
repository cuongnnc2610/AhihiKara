package com.example.cuong.discover_ahihikara;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cuong.discover_ahihikara.adapter.MySongAdapter;
import com.example.cuong.discover_ahihikara.model.Song;

import java.util.ArrayList;

public class MySongActivity extends AppCompatActivity {
    private ListView lvMySong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lv_song);
        getSupportActionBar().setTitle("Bài Hát Của Tôi");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvMySong = (ListView) findViewById(R.id.lvSong);
        final ArrayList<Song> listSong = new ArrayList<>();

        listSong.add(new Song( R.drawable.lac_troi, "Lạc Trôi", "Sơn Tùng", "Nghe"));
        listSong.add(new Song( R.drawable.khoimy1, "Quá Khứ", "Khởi My", "Nghe"));
        listSong.add(new Song( R.drawable.khoimy2, "Gửi Cho Anh", "Khởi My", "Nghe"));

        MySongAdapter customAdaper = new MySongAdapter(this,R.layout.item_song,listSong);
        lvMySong.setAdapter(customAdaper);
    }
}
