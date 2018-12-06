package com.example.cuong.discover_ahihikara;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cuong.discover_ahihikara.adapter.MySongAdapter;
import com.example.cuong.discover_ahihikara.adapter.SongAdapter;
import com.example.cuong.discover_ahihikara.model.Song;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private String URL_LIST_SONGS = "https://ahihikara.herokuapp.com/api/songs/list";
    private String SHARED_PREFERENCES_NAME = "fileuser";
    private Button btnbaihatmoi, btnxemtatca, btnnhacviet, btnnhacaumy;
    private RecyclerView rv_baihatmoi, rv_baihatyeuthich, rv_nhacviet, rv_nhacaumy, rv_nhachan;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private LinearLayoutManager layoutManager;
    private ImageButton btnmyahihi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);

        rv_baihatmoi = findViewById(R.id.rv_baihatmoi);
        rv_baihatyeuthich = findViewById(R.id.rv_baihatyeuthich);
        rv_nhacviet = findViewById(R.id.rv_nhacviet);
        rv_nhacaumy = findViewById(R.id.rv_nhacaumy);
        rv_nhachan = findViewById(R.id.rv_nhachan);

        final ArrayList<Song> list_baihatmoi = new ArrayList<>();
        final ArrayList<Song> list_baihatyeuthich = new ArrayList<>();
        final ArrayList<Song> list_nhacviet = new ArrayList<>();
        final ArrayList<Song> list_nhacaumy = new ArrayList<>();
        final ArrayList<Song> list_nhachan = new ArrayList<>();

        getFavoriteSongs();
//        list_baihatyeuthich.add(new Song("https://ahihikara.herokuapp.com/singer/lequyen.jpg", "Lạc Trôi", "Sơn Tùng", "lactroi"));
//        list_baihatyeuthich.add(new Song("https://ahihikara.herokuapp.com/singer/lequyen.jpg", "Vì Sao", "Khởi My", "visao"));
//        list_baihatyeuthich.add(new Song("https://ahihikara.herokuapp.com/singer/lequyen.jpg", "Duyên mình lỡ", "Hương Tràm", "duyenminhlo"));
//        list_baihatyeuthich.add(new Song("https://ahihikara.herokuapp.com/singer/lequyen.jpg", "Gửi Cho Anh", "Khởi My", "guichoanh"));
//        list_baihatyeuthich.add(new Song("https://ahihikara.herokuapp.com/singer/lequyen.jpg", "Gửi Cho Anh", "Khởi My", "guichoanh"));
//
//        rv_baihatyeuthich.setHasFixedSize(true);
//        mLayoutManager = new LinearLayoutManager(this);
//        rv_baihatyeuthich.setLayoutManager(mLayoutManager);
//        mAdapter = new SongAdapter(this, R.layout.item_song, list_baihatyeuthich);
//        rv_baihatyeuthich.setAdapter(mAdapter);
//        RecyclerView.ItemDecoration itemDecoration2 =
//                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
//        rv_baihatyeuthich.addItemDecoration(itemDecoration2);
        getNewSongs();
//        list_baihatmoi.add(new Song("https://ahihikara.herokuapp.com/singer/quangle.jpg", "Lạc Trôi", "Sơn Tùng", "lactroi"));
//        list_baihatmoi.add(new Song("https://ahihikara.herokuapp.com/singer/lequyen.jpg", "Vì Sao", "Khởi My", "visao"));
//        list_baihatmoi.add(new Song("https://ahihikara.herokuapp.com/singer/lequyen.jpg", "Duyên mình lỡ", "Hương Tràm", "duyenminhlo"));
//        list_baihatmoi.add(new Song("https://ahihikara.herokuapp.com/singer/lequyen.jpg", "Gửi Cho Anh", "Khởi My", "guichoanh"));
//        list_baihatmoi.add(new Song("https://ahihikara.herokuapp.com/singer/lequyen.jpg", "Gửi Cho Anh", "Khởi My", "guichoanh"));
//
//        rv_baihatmoi.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(this);
//        rv_baihatmoi.setLayoutManager(layoutManager);
//        mAdapter = new SongAdapter(this, R.layout.rv_song, list_baihatmoi);
//        rv_baihatmoi.setAdapter(mAdapter);
//        RecyclerView.ItemDecoration itemDecoration1 = new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL);
//        rv_baihatmoi.addItemDecoration(itemDecoration1);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        getVietnameseSongs();
//        list_nhacviet.add(new Song("https://ahihikara.herokuapp.com/singer/lequyen.jpg", "Lạc Trôi", "Sơn Tùng", "lactroi"));
//        list_nhacviet.add(new Song("https://ahihikara.herokuapp.com/singer/lequyen.jpg", "Vì Sao", "Khởi My", "visao"));
//        list_nhacviet.add(new Song("https://ahihikara.herokuapp.com/singer/lequyen.jpg", "Duyên mình lỡ", "Hương Tràm", "duyenminhlo"));
//        list_nhacviet.add(new Song("https://ahihikara.herokuapp.com/singer/lequyen.jpg", "Gửi Cho Anh", "Khởi My", "guichoanh"));
//        list_nhacviet.add(new Song("https://ahihikara.herokuapp.com/singer/lequyen.jpg", "Gửi Cho Anh", "Khởi My", "guichoanh"));

//        rv_nhacviet.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(this);
//        rv_nhacviet.setLayoutManager(layoutManager);
//        mAdapter = new SongAdapter(this, R.layout.rv_song, list_nhacviet);
//        rv_nhacviet.setAdapter(mAdapter);
//        RecyclerView.ItemDecoration itemDecoration3 = new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL);
//        rv_nhacviet.addItemDecoration(itemDecoration3);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        getUSUKSongs();
//        list_nhacaumy.add(new Song("https://ahihikara.herokuapp.com/singer/lequyen.jpg", "Flashlight", "Jessi", "flashlight"));
//        list_nhacaumy.add(new Song("https://ahihikara.herokuapp.com/singer/lequyen.jpg", "Flashlight", "Jessi", "flashlight"));
//        list_nhacaumy.add(new Song("https://ahihikara.herokuapp.com/singer/lequyen.jpg", "Flashlight", "Jessi", "flashlight"));
//        list_nhacaumy.add(new Song("https://ahihikara.herokuapp.com/singer/lequyen.jpg", "Flashlight", "Jessi", "flashlight"));
//        list_nhacaumy.add(new Song("https://ahihikara.herokuapp.com/singer/lequyen.jpg", "Flashlight", "Jessi", "flashlight"));
//
//        rv_nhacaumy.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(this);
//        rv_nhacaumy.setLayoutManager(layoutManager);
//        mAdapter = new SongAdapter(this, R.layout.rv_song, list_nhacaumy);
//        rv_nhacaumy.setAdapter(mAdapter);
//        RecyclerView.ItemDecoration itemDecoration4 = new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL);
//        rv_nhacaumy.addItemDecoration(itemDecoration4);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        getTruTinhSongs();
//        list_nhachan.add(new Song("https://ahihikara.herokuapp.com/singer/lequyen.jpg", "Flashlight", "Jessi", "flashlight"));
//        list_nhachan.add(new Song("https://ahihikara.herokuapp.com/singer/lequyen.jpg", "Flashlight", "Jessi", "flashlight"));
//        list_nhachan.add(new Song("https://ahihikara.herokuapp.com/singer/lequyen.jpg", "Flashlight", "Jessi", "flashlight"));
//        list_nhachan.add(new Song("https://ahihikara.herokuapp.com/singer/lequyen.jpg", "Flashlight", "Jessi", "flashlight"));
//        list_nhachan.add(new Song("https://ahihikara.herokuapp.com/singer/lequyen.jpg", "Flashlight", "Jessi", "flashlight"));
//
//        rv_nhachan.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(this);
//        rv_nhachan.setLayoutManager(layoutManager);
//        mAdapter = new SongAdapter(this, R.layout.rv_song, list_nhachan);
//        rv_nhachan.setAdapter(mAdapter);
//        RecyclerView.ItemDecoration itemDecoration5 = new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL);
//        rv_nhachan.addItemDecoration(itemDecoration5);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        btnmyahihi = findViewById(R.id.btn_myahihi);
        btnbaihatmoi= findViewById(R.id.btn_baihatmoi);
        btnxemtatca = findViewById((R.id.btn_xemtatca));
        btnnhacviet = findViewById(R.id.btn_nhacviet);
        btnnhacaumy = findViewById(R.id.btn_nhacaumy);

        btnmyahihi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this ,SettingActivity.class);
                startActivity(intent);
            }
        });
    }

    public void getNewSongs() {
        final ArrayList<Song> list = new ArrayList<>();
        StringRequest request = new StringRequest(Request.Method.GET, URL_LIST_SONGS+"?option=0&limit=5",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonListSong = new JSONObject(response);
                            JSONArray jsonArrayListSong = jsonListSong.getJSONArray("list_song");
                            for (int i=0; i<jsonArrayListSong.length(); i++) {
                                JSONObject jsonSong = jsonArrayListSong.getJSONObject(i);
                                String name = jsonSong.getString("name");
                                String playURL = jsonSong.getString("play_url");
                                String singer = jsonSong.getString("singer");
                                String singerImageURL = jsonSong.getString("singer_image_url");
                                list.add(new Song(singerImageURL, name, singer, playURL));
                                rv_baihatmoi.setHasFixedSize(true);
                                layoutManager = new LinearLayoutManager(getApplicationContext());
                                rv_baihatmoi.setLayoutManager(layoutManager);
                                mAdapter = new SongAdapter(getApplicationContext(), R.layout.rv_song, list);
                                rv_baihatmoi.setAdapter(mAdapter);
                                RecyclerView.ItemDecoration itemDecoration1 = new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.HORIZONTAL);
                                rv_baihatmoi.addItemDecoration(itemDecoration1);
                                layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        int statusCode = error.networkResponse.statusCode;
                        if (statusCode == 401) {
                            Toast.makeText(MainActivity.this, "Need login first", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            Bundle bundle = new Bundle();
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Something was error, please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                }) {
            /**
             * set header
             * */
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<String, String>();
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
                String token = sharedPreferences.getString("token","");
                headers.put("Authorization", token);
                return headers;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }

    public void getFavoriteSongs() {
        final ArrayList<Song> list = new ArrayList<>();
        StringRequest request = new StringRequest(Request.Method.GET, URL_LIST_SONGS+"?option=4&limit=5",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonListSong = new JSONObject(response);
                            JSONArray jsonArrayListSong = jsonListSong.getJSONArray("list_song");
                            for (int i=0; i<jsonArrayListSong.length(); i++) {
                                JSONObject jsonSong = jsonArrayListSong.getJSONObject(i);
                                String name = jsonSong.getString("name");
                                String playURL = jsonSong.getString("play_url");
                                String singer = jsonSong.getString("singer");
                                String singerImageURL = jsonSong.getString("singer_image_url");
                                list.add(new Song(singerImageURL, name, singer, playURL));

                                rv_baihatyeuthich.setHasFixedSize(true);
                                mLayoutManager = new LinearLayoutManager(getApplicationContext());
                                rv_baihatyeuthich.setLayoutManager(mLayoutManager);
                                mAdapter = new SongAdapter(getApplicationContext(), R.layout.item_song, list);
                                rv_baihatyeuthich.setAdapter(mAdapter);
                                RecyclerView.ItemDecoration itemDecoration2 =
                                        new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL);
                                rv_baihatyeuthich.addItemDecoration(itemDecoration2);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        int statusCode = error.networkResponse.statusCode;
                        if (statusCode == 401) {
                            Toast.makeText(MainActivity.this, "Need login first", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            Bundle bundle = new Bundle();
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Something was error, please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                }) {
            /**
             * set header
             * */
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<String, String>();
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
                String token = sharedPreferences.getString("token","");
                headers.put("Authorization", token);
                return headers;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }

    public void getVietnameseSongs() {
        final ArrayList<Song> list = new ArrayList<>();
        StringRequest request = new StringRequest(Request.Method.GET, URL_LIST_SONGS+"?option=1&limit=5",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonListSong = new JSONObject(response);
                            JSONArray jsonArrayListSong = jsonListSong.getJSONArray("list_song");
                            for (int i=0; i<jsonArrayListSong.length(); i++) {
                                JSONObject jsonSong = jsonArrayListSong.getJSONObject(i);
                                String name = jsonSong.getString("name");
                                String playURL = jsonSong.getString("play_url");
                                String singer = jsonSong.getString("singer");
                                String singerImageURL = jsonSong.getString("singer_image_url");
                                list.add(new Song(singerImageURL, name, singer, playURL));
                                rv_nhacviet.setHasFixedSize(true);
                                layoutManager = new LinearLayoutManager(getApplicationContext());
                                rv_nhacviet.setLayoutManager(layoutManager);
                                mAdapter = new SongAdapter(getApplicationContext(), R.layout.rv_song, list);
                                rv_nhacviet.setAdapter(mAdapter);
                                RecyclerView.ItemDecoration itemDecoration3 = new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.HORIZONTAL);
                                rv_nhacviet.addItemDecoration(itemDecoration3);
                                layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        int statusCode = error.networkResponse.statusCode;
                        if (statusCode == 401) {
                            Toast.makeText(MainActivity.this, "Need login first", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            Bundle bundle = new Bundle();
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Something was error, please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                }) {
            /**
             * set header
             * */
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<String, String>();
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
                String token = sharedPreferences.getString("token","");
                headers.put("Authorization", token);
                return headers;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }

    public void getUSUKSongs() {
        final ArrayList<Song> list = new ArrayList<>();
        StringRequest request = new StringRequest(Request.Method.GET, URL_LIST_SONGS+"?option=2&limit=5",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonListSong = new JSONObject(response);
                            JSONArray jsonArrayListSong = jsonListSong.getJSONArray("list_song");
                            for (int i=0; i<jsonArrayListSong.length(); i++) {
                                JSONObject jsonSong = jsonArrayListSong.getJSONObject(i);
                                String name = jsonSong.getString("name");
                                String playURL = jsonSong.getString("play_url");
                                String singer = jsonSong.getString("singer");
                                String singerImageURL = jsonSong.getString("singer_image_url");
                                list.add(new Song(singerImageURL, name, singer, playURL));
                                rv_nhacaumy.setHasFixedSize(true);
                                layoutManager = new LinearLayoutManager(getApplicationContext());
                                rv_nhacaumy.setLayoutManager(layoutManager);
                                mAdapter = new SongAdapter(getApplicationContext(), R.layout.rv_song, list);
                                rv_nhacaumy.setAdapter(mAdapter);
                                RecyclerView.ItemDecoration itemDecoration3 = new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.HORIZONTAL);
                                rv_nhacaumy.addItemDecoration(itemDecoration3);
                                layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        int statusCode = error.networkResponse.statusCode;
                        if (statusCode == 401) {
                            Toast.makeText(MainActivity.this, "Need login first", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            Bundle bundle = new Bundle();
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Something was error, please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                }) {
            /**
             * set header
             * */
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<String, String>();
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
                String token = sharedPreferences.getString("token","");
                headers.put("Authorization", token);
                return headers;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }

    public void getTruTinhSongs() {
        final ArrayList<Song> list = new ArrayList<>();
        StringRequest request = new StringRequest(Request.Method.GET, URL_LIST_SONGS+"?option=3&limit=5",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonListSong = new JSONObject(response);
                            JSONArray jsonArrayListSong = jsonListSong.getJSONArray("list_song");
                            for (int i=0; i<jsonArrayListSong.length(); i++) {
                                JSONObject jsonSong = jsonArrayListSong.getJSONObject(i);
                                String name = jsonSong.getString("name");
                                String playURL = jsonSong.getString("play_url");
                                String singer = jsonSong.getString("singer");
                                String singerImageURL = jsonSong.getString("singer_image_url");
                                list.add(new Song(singerImageURL, name, singer, playURL));
                                rv_nhachan.setHasFixedSize(true);
                                layoutManager = new LinearLayoutManager(getApplicationContext());
                                rv_nhachan.setLayoutManager(layoutManager);
                                mAdapter = new SongAdapter(getApplicationContext(), R.layout.rv_song, list);
                                rv_nhachan.setAdapter(mAdapter);
                                RecyclerView.ItemDecoration itemDecoration3 = new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.HORIZONTAL);
                                rv_nhachan.addItemDecoration(itemDecoration3);
                                layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        int statusCode = error.networkResponse.statusCode;
                        if (statusCode == 401) {
                            Toast.makeText(MainActivity.this, "Need login first", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            Bundle bundle = new Bundle();
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Something was error, please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                }) {
            /**
             * set header
             * */
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<String, String>();
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
                String token = sharedPreferences.getString("token","");
                headers.put("Authorization", token);
                return headers;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}
