package com.example.cuong.discover_ahihikara;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cuong.discover_ahihikara.adapter.SongBookAdapter;
import com.example.cuong.discover_ahihikara.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongBookActivity extends AppCompatActivity {

    List<Song> nhacViet, nhacAuMi, nhacTatca, nhacMoi;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songbook);
        listView = (ListView) findViewById(R.id.listView);
        nhacViet = new ArrayList<Song>();
        nhacAuMi = new ArrayList<Song>();
        nhacTatca = new ArrayList<Song>();
        nhacMoi = new ArrayList<Song>();
        getListViet(nhacViet);
        getListAuMi(nhacAuMi);
        getListAuMi(nhacTatca);
        getListViet(nhacTatca);
        getListAuMi(nhacMoi);
        getListViet(nhacMoi);
        //Intent intent=getIntent();

        listView.setAdapter(new SongBookAdapter(this, nhacTatca));

        // Khi người dùng click vào các ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Song song = (Song) o;
                Toast.makeText(SongBookActivity.this, "Selected :" + " " + song, Toast.LENGTH_LONG).show();
            }
        });
    }


    private void getListViet(List<Song> list) {

        list.add(new Song(R.drawable.bglc, "Bao Giò Lấy Chồng", "Bích Phương", "Nghe", "guichoanh"));
        list.add(new Song(R.drawable.bglc, "Bao Giò Lấy Chồng", "Bích Phương", "Nghe", "guichoanh"));
        list.add(new Song(R.drawable.bglc, "Bao Giò Lấy Chồng", "Bích Phương", "Nghe", "guichoanh"));
        list.add(new Song(R.drawable.bglc, "Bao Giò Lấy Chồng", "Bích Phương", "Nghe", "guichoanh"));
        list.add(new Song(R.drawable.bglc, "Bao Giò Lấy Chồng", "Bích Phương", "Nghe", "guichoanh"));
        list.add(new Song(R.drawable.bglc, "Bao Giò Lấy Chồng", "Bích Phương", "Nghe", "guichoanh"));
    }
    private void getListAuMi(List<Song> list) {
        Song soy = new Song(R.drawable.bglc, "Bao Giò Lấy Chồng", "Bích Phương", "Nghe", "guichoanh");
        list.add(soy);
    }


    public void NhacViet(View view) {
        listView.setAdapter(new SongBookAdapter(this, nhacViet));
    }

    public void NhacAuMi(View view) {
        listView.setAdapter(new SongBookAdapter(this, nhacAuMi));
    }

    public void TatCa(View view) {
        listView.setAdapter(new SongBookAdapter(this, nhacTatca));
    }

}
