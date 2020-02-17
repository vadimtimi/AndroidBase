package com.refresh.pos.telegabot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static String telegrammToken;
    public static String telegrammUser;

    // Показать всплывающее сообщение и Logcat
    private void showToast(String txt) {
        Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
        Log.i( "showToast", txt );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frm_main);

        showToast("onCreate");
    }

    @Override
    protected void  onStart()
    {
        super.onStart();

        showToast("onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();

        showToast("onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        showToast("onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        showToast("onRestoreInstanceState");
    }

    // Обработка нажатия кнопки "Settings"
    public void onClickSettings(View v) {
        Intent intent = new Intent(MainActivity.this, FrmSettings.class);
        startActivity(intent);

        showToast("onClickSettings");
    }
}
