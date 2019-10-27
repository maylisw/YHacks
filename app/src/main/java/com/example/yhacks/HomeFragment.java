package com.example.yhacks;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeFragment extends android.support.v4.app.Fragment {
    private HomeGroupDisplayAdapter homeGroupDisplayAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Context context;
    private View rootView;
    private android.support.v7.widget.RecyclerView homeListRecyclerView;

    public HomeFragment() {

    }

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
        homeListRecyclerView = rootView.findViewById(R.id.homeList);
        layoutManager = new GridLayoutManager(getActivity(), 1);

        homeListRecyclerView.setLayoutManager(layoutManager);
        homeListRecyclerView.setItemAnimator(new DefaultItemAnimator());

        MainActivity activity = (MainActivity) getActivity();

        homeGroupDisplayAdapter = new HomeGroupDisplayAdapter(((MainActivity) getActivity()).getMyGroups(), getContext()); //todo update with other info to be passed (likely the list of groups)
        homeListRecyclerView.setAdapter(homeGroupDisplayAdapter);

        homeListRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, homeListRecyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @SuppressLint("RestrictedApi")
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        //todo start intent
                        Intent i = new Intent(context, StudyGroupInfo.class);
                        startActivity(i);
                    }

                    @Override public void onLongItemClick(View view, int position) {

                    }
                })
        );

        registerForContextMenu(homeListRecyclerView);
    }

}