package com.example.cuong.discover_ahihikara;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cuong.discover_ahihikara.controller.ImageLoadTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity {

    private Button btnEditUser, btnSetting;
    private TextView tvNameUser, tvAboutUser, tvUserName, tvGender;
    private ImageView imgView;
    private Button favoriteSongs;
    private final String URL_USER = "http://ahihikara.herokuapp.com/api/users/edit";
    private String SHARED_PREFERENCES_NAME = "fileuser";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnEditUser = findViewById(R.id.btn_editUser);
        btnSetting = findViewById(R.id.btn_setting);
        tvNameUser = findViewById(R.id.tv_nameUser);
        tvAboutUser = findViewById(R.id.tv_aboutUser);
        tvUserName = findViewById(R.id.tv_user_name);
        imgView = findViewById(R.id.imv_profilePhoto);
        tvGender = findViewById(R.id.tv_gender);
        favoriteSongs = findViewById(R.id.btn_baihatdathich);

        getUser();

        btnEditUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,EditProfileActivity.class);
                startActivity(intent);
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });

        favoriteSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( ProfileActivity.this, MyFavoriteActivity.class);
                startActivity(intent);
            }
        });
    }

    public void getUser()
    {
        StringRequest request = new StringRequest(Request.Method.GET, URL_USER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONObject user = jsonObject.getJSONObject("user");
                    String username = user.getString("user_name");
                    String nickname = user.getString("nick_name");
                    String about = user.getString("about");
                    String avatar = user.getString("avatar");
                    int gender = user.getInt("gender");
                    tvUserName.setText(username);
                    tvNameUser.setText(nickname);
                    if (gender == 0) {
                        tvGender.setText("Nữ");
                    } else {
                        tvGender.setText("Nam");
                    }
                    tvAboutUser.setText(about);
                    new ImageLoadTask(avatar, imgView).execute();
                    tvAboutUser.setText(about);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },
        new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        int statusCode = error.networkResponse.statusCode;
                        if (statusCode == 401){
                            Toast.makeText(ProfileActivity.this, "Need login first", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            Bundle bundle = new Bundle();
                            startActivity(intent);
                        } else {
                            Toast.makeText(ProfileActivity.this, "Something was error, please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
        }) {
            /**
             * set header
             * */
            public Map<String, String> getHeaders()
            {
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
