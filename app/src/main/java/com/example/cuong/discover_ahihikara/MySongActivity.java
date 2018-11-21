package com.example.cuong.discover_ahihikara;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cuong.discover_ahihikara.adapter.MySongAdapter;
import com.example.cuong.discover_ahihikara.model.Song;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class MySongActivity extends AppCompatActivity {
    private ListView lvMySong;
    // Add back button & search button to action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_search, menu);
        getSupportActionBar().setTitle(R.string.my_song);

        // Create a back button with id 'home'
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return super.onCreateOptionsMenu(menu);
    }

    // Add event for action bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(this, "Bạn vừa chọn Back button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_search:
                Toast.makeText(this, "Bạn vừa chọn Search button", Toast.LENGTH_SHORT).show();
                break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }

    // Seed & load item to list view
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lv_song);


        lvMySong = (ListView) findViewById(R.id.lvSong);
        final ArrayList<Song> listSong = new ArrayList<>();

        listSong.add(new Song( R.drawable.lac_troi, "Lạc Trôi", "Sơn Tùng", "Nghe", "lactroi"));
        listSong.add(new Song( R.drawable.khoimy1, "Vì Sao", "Khởi My", "Nghe", "visao"));
        listSong.add(new Song( R.drawable.khoimy2, "Gửi Cho Anh", "Khởi My", "Nghe", "guichoanh"));
        listSong.add(new Song( R.drawable.breathless, "Breathless", "Shayne Ward", "Nghe", "breathless"));
        listSong.add(new Song( R.drawable.roinguoithuongcunghoanguoidung, "Rồi Người Thương Cũng Hóa Người Dưng", "Hiền Hồ", "Nghe", "roinguoithuongcunghoanguoidung"));
        listSong.add(new Song( R.drawable.dungainhacveanhay, "Đừng Ai Nhắc Về Anh Ấy", "Trà My", "Nghe", "dungainhacveanhay"));

        MySongAdapter mySongAdapter = new MySongAdapter(this,R.layout.item_song,listSong);
        lvMySong.setAdapter(mySongAdapter);
    }
}
