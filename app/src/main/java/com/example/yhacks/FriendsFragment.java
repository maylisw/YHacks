package com.example.yhacks;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FriendsFragment extends android.support.v4.app.Fragment {
    public FriendsFragment() {
    }
        private Context context;
        private View rootView;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            rootView = inflater.inflate(R.layout.fragment_friends, container, false);
            context = rootView.getContext();
            return rootView;
        }
}

