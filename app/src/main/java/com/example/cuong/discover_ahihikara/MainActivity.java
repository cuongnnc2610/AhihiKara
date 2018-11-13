package com.example.cuong.discover_ahihikara;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.cuong.discover_ahihikara.adapter.SongBookAdapter;
import com.example.cuong.discover_ahihikara.model.Song;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnbaihatmoi, btnxemtatca, btnnhacviet, btnnhacaumy;
    ListView lv_tatcabaihat;
    List<Song> nhacTatca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);
        lv_tatcabaihat = findViewById(R.id.lv_tatcabaihat);
        final ArrayList<Song> listSong = new ArrayList<>();

        listSong.add(new Song( R.drawable.lac_troi, "Lạc Trôi", "Sơn Tùng", "Nghe", "lactroi"));
        listSong.add(new Song( R.drawable.khoimy1, "Vì Sao", "Khởi My", "Nghe", "visao"));
        listSong.add(new Song( R.drawable.khoimy2, "Gửi Cho Anh", "Khởi My", "Nghe", "guichoanh"));

        btnbaihatmoi= findViewById(R.id.btn_baihatmoi);
        btnxemtatca = findViewById((R.id.btn_xemtatca));
        btnnhacviet = findViewById(R.id.btn_nhacviet);
        btnnhacaumy = findViewById(R.id.btn_nhacaumy);
        lv_tatcabaihat.setAdapter(new SongBookAdapter(this, nhacTatca));
        setListViewHeightBasedOnChildren(lv_tatcabaihat);

        btnbaihatmoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this ,SongBookActivity.class);
                startActivity(intent);
            }
        });

        btnxemtatca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this ,SongBookActivity.class);
                startActivity(intent);
            }
        });

        btnnhacviet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this ,SongBookActivity.class);
                startActivity(intent);
            }
        });

        btnnhacaumy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this ,SongBookActivity.class);
                startActivity(intent);
            }
        });

    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) return;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

}
