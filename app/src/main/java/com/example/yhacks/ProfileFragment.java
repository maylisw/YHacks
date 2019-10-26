package com.example.yhacks;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

public class ProfileFragment extends android.support.v4.app.Fragment {
    public ProfileFragment() {
    }
    private Context context;
    private View rootView;
    private ImageView profilePic;
    private EditText name;
    private EditText school;
    private EditText year;
    private EditText major;
    private EditText givesHelpFor;
    private EditText needsHelpWith;
    private EditText numGroups;
    private android.support.design.widget.FloatingActionButton addGroup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        context = rootView.getContext();
        wireWidgets();
        return rootView;
    }

    private void wireWidgets() {
        profilePic = rootView.findViewById(R.id.pictureProfile);
        name = rootView.findViewById(R.id.profileName);
        school = rootView.findViewById(R.id.profileSchool);
        year = rootView.findViewById(R.id.profileYear);
        major = rootView.findViewById(R.id.profileMajor);
        givesHelpFor = rootView.findViewById(R.id.isGoodAt);
        needsHelpWith = rootView.findViewById(R.id.needsHelp);
        addGroup = rootView.findViewById(R.id.addCourse);
    }

}
