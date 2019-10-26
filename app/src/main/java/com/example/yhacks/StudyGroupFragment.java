package com.example.yhacks;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;

public class StudyGroupFragment extends android.support.v4.app.Fragment {
    public static final String TAG = "fragments";

    private Context context;
    private View rootView;
    private EditText courseName;
    private EditText department;
    private EditText members;

    public StudyGroupFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_study, container, false);
        context = rootView.getContext();
        wireWidgets();
        return rootView;
    }

    private void wireWidgets() {
        courseName = rootView.findViewById(R.id.courseInput);
        department = rootView.findViewById(R.id.departmentInput);
        members = rootView.findViewById(R.id.memberInput);
    }
}
