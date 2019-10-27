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
import java.util.List;

public class SearchFragment extends android.support.v4.app.Fragment {
    private SearchGroupDisplayAdapter searchGroupsDisplayAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SearchView searchInput;
    private Context context;
    private View rootView;
    private android.support.v7.widget.RecyclerView searchListRecyclerView;
    private List<StudyGroup> studyGroupsList;

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
        MainActivity mainActivity = (MainActivity) getActivity();
        studyGroupsList = new ArrayList<>();
        getGroups();
        wireWidgets();
        return rootView;
    }

    private void getGroups() {
        studyGroupsList = new ArrayList<>();
        studyGroupsList.add(new StudyGroup(
                "Introduction to Computer Science Midterm",
                "1004",
                "COMS",
                "M 3:00 4:00, T 2:30 3:45",
                "Columbia",
                "Pupin 1029",
                3,
                7,
                5)
        );
        studyGroupsList.add(new StudyGroup(
                "Physics Homework",
                "1601",
                "PHYS",
                "W 3:00 4:00, TH 2:30 3:45",
                "Columbia",
                "Butler 1029",
                3,
                7,
                5)
        );
        studyGroupsList.add(new StudyGroup(
                "Chemistry Quiz",
                "1400",
                "CHEM",
                "F 3:00 4:00, S 2:30 3:45",
                "Columbia",
                "Havermeyer 109",
                3,
                7,
                5)//s
        );
    }

    private void wireWidgets() {
        //searchInput = rootView.findViewById(R.id.searchInput);
        searchListRecyclerView = rootView.findViewById(R.id.searchList);
        layoutManager = new GridLayoutManager(getActivity(), 1);
        searchListRecyclerView.setLayoutManager(layoutManager);
        searchListRecyclerView.setItemAnimator(new DefaultItemAnimator());
        searchGroupsDisplayAdapter = new SearchGroupDisplayAdapter(studyGroupsList, getContext()); //todo update with other info to be passed (likely the list of groups)
        searchListRecyclerView.setAdapter(searchGroupsDisplayAdapter);
        registerForContextMenu(searchListRecyclerView);
    }

}
