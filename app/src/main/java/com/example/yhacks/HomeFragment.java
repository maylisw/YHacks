package com.example.yhacks;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeFragment extends android.support.v4.app.Fragment {
    private GroupDisplayAdapter groupsDisplayAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Context context;
    private View rootView;
    private android.support.v7.widget.RecyclerView homeListRecyclerView;
    private ArrayList<StudyGroup> studyGroupsList;

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
        getGroups();
        wireWidgets();
        return rootView;
    }

    private void getGroups() {
        studyGroupsList = new ArrayList<>();
        //studyGroupsList.add(new StudyGroup());
    }

    private void wireWidgets() {
        homeListRecyclerView = rootView.findViewById(R.id.homeList);
        layoutManager = new GridLayoutManager(getActivity(), 1);
        homeListRecyclerView.setLayoutManager(layoutManager);
        homeListRecyclerView.setItemAnimator(new DefaultItemAnimator());
        groupsDisplayAdapter = new GroupDisplayAdapter(studyGroupsList, getContext()); //todo update with other info to be passed (likely the list of groups)
        homeListRecyclerView.setAdapter(groupsDisplayAdapter);
        registerForContextMenu(homeListRecyclerView);
    }

}