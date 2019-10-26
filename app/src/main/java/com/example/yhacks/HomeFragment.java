package com.example.yhacks;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends android.support.v4.app.Fragment {
        public HomeFragment() {

        }

        private Context context;
        private View rootView;
        private android.support.v7.widget.RecyclerView homeList;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            rootView = inflater.inflate(R.layout.fragment_home, container, false);
            context = rootView.getContext();
            wireWidgets();
            return rootView;
        }

        private void wireWidgets() {
            homeList = rootView.findViewById(R.id.homeList);
        }
}