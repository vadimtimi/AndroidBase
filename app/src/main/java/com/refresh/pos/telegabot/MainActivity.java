package com.refresh.pos.telegabot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static String telegrammToken;
    public static String telegrammUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frm_main);
    }

    public void onClickSettings(View v) {
        Intent intent = new Intent(MainActivity.this, frm_settings.class);
        startActivity(intent);
    }
}
