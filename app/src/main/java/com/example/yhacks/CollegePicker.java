package com.example.yhacks;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class CollegePicker extends AppCompatActivity {

    private SharedPreferences sharedPref;
    private RecyclerView collegeRecyclerView;
    private GridLayoutManager layoutManager;
    private UniversityAdapter universityDisplayAdapter;
    private List<University> universityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_picker);

        sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        wireWidgets();
    }

    private void wireWidgets() {
        //todo get university list + have a fill in your own
        //collegeRecyclerView = findViewById(R.id.);
        layoutManager = new GridLayoutManager(this, 1);
        collegeRecyclerView.setLayoutManager(layoutManager);
        collegeRecyclerView.setItemAnimator(new DefaultItemAnimator());
        universityDisplayAdapter = new UniversityAdapter(universityList, this);
        collegeRecyclerView.setAdapter(universityDisplayAdapter);
        registerForContextMenu(collegeRecyclerView);

    }
}
