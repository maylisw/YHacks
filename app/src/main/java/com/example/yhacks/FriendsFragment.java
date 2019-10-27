package com.example.yhacks;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import java.util.ArrayList;

public class FriendsFragment extends android.support.v4.app.Fragment {
        private FriendGroupDisplayAdapter friendGroupDisplayAdapter;
        private RecyclerView.LayoutManager layoutManager;
        private Context context;
        private View rootView;
        private android.support.v7.widget.RecyclerView searchListRecyclerView;
        private ArrayList<User> friendsList;
        private SearchView userSearch;

        public FriendsFragment() {

        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            rootView = inflater.inflate(R.layout.fragment_friends, container, false);
            context = rootView.getContext();
            getGroups();
            wireWidgets();
            return rootView;
        }

        private void getGroups() {
            friendsList = new ArrayList<>();
            friendsList.add(new User("erin", "Columbia", "1004, 2342", "COMS", "multi", "img", "eem23234", "23242", 2));
        }

        private void wireWidgets() {
            searchListRecyclerView = rootView.findViewById(R.id.friendsList);
            layoutManager = new GridLayoutManager(getActivity(), 1);
            searchListRecyclerView.setLayoutManager(layoutManager);
            searchListRecyclerView.setItemAnimator(new DefaultItemAnimator());
            friendGroupDisplayAdapter = new FriendGroupDisplayAdapter(friendsList, getContext()); //todo update with other info to be passed (likely the list of groups)
            searchListRecyclerView.setAdapter(friendGroupDisplayAdapter);
            registerForContextMenu(searchListRecyclerView);
            userSearch = rootView.findViewById(R.id.friendsInput);
        }
}

