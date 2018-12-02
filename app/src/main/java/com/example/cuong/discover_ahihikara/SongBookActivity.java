//package com.example.cuong.discover_ahihikara;
//
//import android.graphics.Color;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.GestureDetector;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.ListAdapter;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.cuong.discover_ahihikara.adapter.SongBookAdapter;
//import com.example.cuong.discover_ahihikara.model.Song;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class SongBookActivity extends AppCompatActivity {
//
//    List<Song> nhacViet, nhacAuMi, nhacTatca, nhacMoi;
//    ListView listView;
//    TextView tv_nhacViet, tv_nhacAuMy, tv_nhacTatCa;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_songbook);
//        listView = (ListView) findViewById(R.id.listView);
//        tv_nhacViet = findViewById(R.id.nhacviet);
//        tv_nhacAuMy = findViewById(R.id.nhacaumi);
//        tv_nhacTatCa = findViewById(R.id.nhactatca);
//        nhacViet = new ArrayList<Song>();
//        nhacAuMi = new ArrayList<Song>();
//        nhacTatca = new ArrayList<Song>();
//        nhacMoi = new ArrayList<Song>();
//        getListViet(nhacViet);
//        getListAuMi(nhacAuMi);
//        getListAuMi(nhacTatca);
//        getListViet(nhacTatca);
//        getListAuMi(nhacMoi);
//        getListViet(nhacMoi);
//        //Intent intent=getIntent();
//
//        listView.setAdapter(new SongBookAdapter(this, nhacTatca));
//        setListViewHeightBasedOnChildren(listView);
//        tv_nhacTatCa.setBackgroundColor(Color.LTGRAY);
//        tv_nhacTatCa.setTextColor(Color.BLACK);
//
//        // Khi người dùng click vào các ListItem
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
//                Object o = listView.getItemAtPosition(position);
//                Song song = (Song) o;
//                Toast.makeText(SongBookActivity.this, "Selected :" + " " + song, Toast.LENGTH_LONG).show();
//            }
//        });
//
//    }
//
//    public static void setListViewHeightBasedOnChildren(ListView listView) {
//        ListAdapter listAdapter = listView.getAdapter();
//        if (listAdapter == null) return;
//        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
//        int totalHeight = 0;
//        View view = null;
//        for (int i = 0; i < listAdapter.getCount(); i++) {
//            view = listAdapter.getView(i, view, listView);
//            if (i == 0)
//                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));
//
//            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
//            totalHeight += view.getMeasuredHeight();
//        }
//        ViewGroup.LayoutParams params = listView.getLayoutParams();
//        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
//        listView.setLayoutParams(params);
//    }
//
//
//    private void getListViet(List<Song> list) {
//
//        list.add(new Song(R.drawable.bglc, "Bao Giờ Lấy Chồng", "Bích Phương", "Nghe", "baogiolaychong"));
//        list.add(new Song(R.drawable.cdnd, "Chạm Đáy Nỗi Đau", "Erik", "Nghe", "chamdaynoidau"));
//        list.add(new Song(R.drawable.duyenminhlo, "Duyên Mình Lỡ", "Hương Tràm", "Nghe", "duyenminhlo"));
//        list.add(new Song(R.drawable.guinguoiyeucu, "Gửi Người Yêu Cũ", "Hồ Ngọc Hà", "Nghe", "guinguoiyeucu"));
//        list.add(new Song(R.drawable.lt, "Lạc Trôi", "Sơn Tùng M-TP", "Nghe", "lactroi"));
//    }
//    private void getListAuMi(List<Song> list) {
//        list.add(new Song(R.drawable.flashlight, "Flashlight", "Jessi J", "Nghe", "flashlight"));
//        list.add(new Song(R.drawable.soy, "Shape Of You", "Ed Sheeran", "Nghe", "shapeofyou"));
//        list.add(new Song(R.drawable.flashlight, "Flashlight", "Jessi J", "Nghe", "flashlight"));
//    }
//
//
//    public void NhacViet(View view) {
//        listView.setAdapter(new SongBookAdapter(this, nhacViet));
//        tv_nhacAuMy.setBackgroundColor(Color.TRANSPARENT);
//        tv_nhacTatCa.setBackgroundColor(Color.TRANSPARENT);
//        tv_nhacViet.setBackgroundColor(Color.LTGRAY);
//        tv_nhacAuMy.setTextColor(Color.WHITE);
//        tv_nhacTatCa.setTextColor(Color.WHITE);
//        tv_nhacViet.setTextColor(Color.BLACK);
//    }
//
//    public void NhacAuMi(View view) {
//        listView.setAdapter(new SongBookAdapter(this, nhacAuMi));
//        tv_nhacAuMy.setBackgroundColor(Color.LTGRAY);
//        tv_nhacTatCa.setBackgroundColor(Color.TRANSPARENT);
//        tv_nhacViet.setBackgroundColor(Color.TRANSPARENT);
//        tv_nhacAuMy.setTextColor(Color.BLACK);
//        tv_nhacTatCa.setTextColor(Color.WHITE);
//        tv_nhacViet.setTextColor(Color.WHITE);
//    }
//
//    public void TatCa(View view) {
//        listView.setAdapter(new SongBookAdapter(this, nhacTatca));
//        tv_nhacAuMy.setBackgroundColor(Color.TRANSPARENT);
//        tv_nhacTatCa.setBackgroundColor(Color.LTGRAY);
//        tv_nhacViet.setBackgroundColor(Color.TRANSPARENT);
//        tv_nhacAuMy.setTextColor(Color.WHITE);
//        tv_nhacTatCa.setTextColor(Color.BLACK);
//        tv_nhacViet.setTextColor(Color.WHITE);
//    }
//
//}
