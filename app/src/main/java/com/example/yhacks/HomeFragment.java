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
    private HomeGroupDisplayAdapter homeGroupDisplayAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Context context;
    private View rootView;
    private android.support.v7.widget.RecyclerView searchListRecyclerView;
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
        return rootView;//
    }

    private void getGroups() {
        studyGroupsList = new ArrayList<>();
        studyGroupsList.add(new StudyGroup("erin", "1004", "COMS", "M 3:00 4:00, T 2:30 3:45", "Columbia", "Pupin 1029", 3, 7, 5));
    }

    private void wireWidgets() {
        searchListRecyclerView = rootView.findViewById(R.id.homeList);
        layoutManager = new GridLayoutManager(getActivity(), 1);
        searchListRecyclerView.setLayoutManager(layoutManager);
        searchListRecyclerView.setItemAnimator(new DefaultItemAnimator());
        homeGroupDisplayAdapter = new HomeGroupDisplayAdapter(studyGroupsList, getContext()); //todo update with other info to be passed (likely the list of groups)
        searchListRecyclerView.setAdapter(homeGroupDisplayAdapter);
        registerForContextMenu(searchListRecyclerView);
    }

}