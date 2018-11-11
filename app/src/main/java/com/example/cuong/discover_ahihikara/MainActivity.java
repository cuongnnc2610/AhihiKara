package com.example.cuong.discover_ahihikara;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnnewsong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discover);
        btnnewsong= findViewById(R.id.btn_baihatmoi);
        btnnewsong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this ,SongBookActivity.class);
                startActivity(intent);
            }
        });
    }
}
