package com.refresh.pos.telegabot;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.pengrad.telegrambot.model.User;

public class FrmMain extends AppCompatActivity implements paramSettings   {

    public static String telegrammToken;
    public static String telegrammUser;

    private SettingsFragment  fragSetting;
    private InfoFragment  fragInfo;
    private ActionFragment fragAction;
    private UsersListFragment fragLoadUsers;

    private int REQCODESETTINGS = 1;

    // Показать всплывающее сообщение и пишет Logcat
    private void showToast(String txt) {
        Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
        Log.i( "showToast", txt );
    }

    private void loadFragment(int FRG) {

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        if(FRG == 0) {
            fragmentTransaction.replace(R.id.fragmCont, fragSetting);
            fragmentTransaction.addToBackStack(null);
        }

        if(FRG == 1) {
            fragmentTransaction.replace(R.id.fragmCont, fragInfo);
            fragmentTransaction.addToBackStack(null);
        }

        if(FRG == 2) {
            fragmentTransaction.replace(R.id.fragmCont, fragAction);
            fragmentTransaction.addToBackStack(null);
        }

        if(FRG == 3) {
            fragmentTransaction.replace(R.id.fragmCont, fragLoadUsers);
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frm_main);

        fragSetting = new SettingsFragment();
        fragInfo = new InfoFragment();
        fragAction = new ActionFragment();
        fragLoadUsers = new UsersListFragment();

        if (savedInstanceState == null) {
            // при первом запуске программы
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fragmCont , fragInfo);
            fragmentTransaction.commit();
        }

        if(savedInstanceState != null)
        {
            showToast("savedInstanceState");

            if(savedInstanceState.getString( "telegrammToken", "" ).equals( "" ) ) {
                showToast(" onCreatetelegrammToken NO FREE");
            }
        }

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
        if(outState != null) {
            outState.putString( "telegrammToken", telegrammToken );
            outState.putString( "telegrammUser", telegrammUser );
        }

        super.onSaveInstanceState(outState);
        showToast("onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        showToast("onRestoreInstanceState");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        showToast("onRestart");
    }
    @Override
    protected void onResume() {
        super.onResume();

        showToast("onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();

        showToast("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        showToast("onDestroy");
    }

    // Обработка нажатия кнопки "Settings"
    public void onClickSettings(View v) {
//        Intent intent = new Intent(this, FrmSettings.class);
//        startActivityForResult(intent, REQCODESETTINGS);

        loadFragment(0);
        showToast("onClickSettings");
    }

    // Обработка нажатия кнопки "Info"
    public void onClickInfo(View v) {
//        String url = getString(R.string.url_telegram);
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//        startActivity(intent);

        loadFragment(1);
        showToast("onClickInfo");
    }

    // Обработка нажатия кнопки "Action"
    public void onClickAction(View v) {

        loadFragment(2);
        showToast("onClickAction");
    }

    // Обработка нажатия кнопки "Load Users List"
    public void onClickUsers(View v) {

        loadFragment(3);
        showToast("onClickUsers");

        // find the CoordinatorLayout id
        View contextView = findViewById(android.R.id.content);
        // Make and display Snackbar
        Snackbar.make(contextView, "Android Snackbar Example", Snackbar.LENGTH_SHORT)
                .show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult( requestCode,  resultCode, data);
        if(requestCode == REQCODESETTINGS){
            if(resultCode == Activity.RESULT_OK){
                String msg = data.getStringExtra("telegrammToken");

                showToast("onActivityResult " + msg);

            }if(resultCode == Activity.RESULT_CANCELED){
                String msg = ("something went wrong");

                showToast("onActivityResult " + msg);
            }

        }
    }
}
