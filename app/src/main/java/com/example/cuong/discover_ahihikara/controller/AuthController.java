package com.example.cuong.discover_ahihikara.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import com.example.cuong.discover_ahihikara.LoginActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;
import java.util.Set;

public class AuthController {
    private final String SHARED_PREFERENCES_NAME="fileuser";
    private final String USER_NAME="username";
    private final String GENDER="gender";
    private final String AVATAR="avatar";
    private final String TOKEN="token";

    public void saveData(String response, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONObject jsonUser = jsonObject.getJSONObject("user");
            editor.putString(USER_NAME,jsonUser.getString("user_name"));
            editor.putInt(GENDER,jsonUser.getInt("gender"));
            editor.putString(AVATAR,jsonUser.getString("avatar"));
            editor.putString(TOKEN,jsonObject.getString("token"));
            editor.apply();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
