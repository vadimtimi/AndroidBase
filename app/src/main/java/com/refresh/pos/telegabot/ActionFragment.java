package com.refresh.pos.telegabot;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
//import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ActionFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate( R.layout.fragment_action, container, false );
    }
}
