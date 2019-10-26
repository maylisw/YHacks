package com.example.yhacks;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class SearchFragment extends android.support.v4.app.Fragment {
    private GroupDisplayAdapter groupsDisplayAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SearchView searchInput;
    private Context context;
    private View rootView;
    private android.support.v7.widget.RecyclerView homeListRecyclerView;
    private ArrayList<StudyGroup> studyGroupsList;

    public SearchFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_search, container, false);
        context = rootView.getContext();
        getGroups();
        wireWidgets();
        return rootView;
    }

    private void getGroups() {

    }

    private void wireWidgets() {
        searchInput = rootView.findViewById(R.id.searchInput);
        homeListRecyclerView = rootView.findViewById(R.id.searchList);
        layoutManager = new GridLayoutManager(getActivity(), 1);
        homeListRecyclerView.setLayoutManager(layoutManager);
        homeListRecyclerView.setItemAnimator(new DefaultItemAnimator());
        groupsDisplayAdapter = new GroupDisplayAdapter(studyGroupsList, getContext()); //todo update with other info to be passed (likely the list of groups)
        homeListRecyclerView.setAdapter(groupsDisplayAdapter);
        registerForContextMenu(homeListRecyclerView);
    }

}
