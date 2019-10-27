package com.example.yhacks;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CollegePicker extends AppCompatActivity {

    private SharedPreferences sharedPref;
    private RecyclerView collegeRecyclerView;
    private GridLayoutManager layoutManager;
    private UniversityAdapter universityDisplayAdapter;
    private List<University> universityList;
    private Toolbar toolbar;
    private FloatingActionButton finishSetUp;
    private int selected;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_picker);

        sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        toolbar = (Toolbar)findViewById(R.id.toolbar_college_picker);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        universityList = new ArrayList<>();
        universityList.add(new University("Columbia University in the City of New York", "New York, New York", 0));
        wireWidgets();
    }

    private void wireWidgets() {
        //todo get university list + have a fill in your own
        final int backgroundColor = getResources().getColor(R.color.backgroundColor);
        selected = -1;
        context = this;
        layoutManager = new GridLayoutManager(this, 1);

        finishSetUp = findViewById(R.id.finishSetUp);
        finishSetUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, MainActivity.class);
                startActivity(i);
            }
        });

        collegeRecyclerView = findViewById(R.id.uniList);
        collegeRecyclerView.setLayoutManager(layoutManager);
        collegeRecyclerView.setItemAnimator(new DefaultItemAnimator());

        universityDisplayAdapter = new UniversityAdapter(universityList, this);
        collegeRecyclerView.setAdapter(universityDisplayAdapter);

        collegeRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, collegeRecyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @SuppressLint("RestrictedApi")
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        if(position == selected){
                            selected = -1;
                            view.setBackgroundColor(backgroundColor);
                            finishSetUp.setVisibility(View.INVISIBLE);
                        } else{
                            if(selected != -1){
                                layoutManager.findViewByPosition(selected).setBackgroundColor(backgroundColor);
                            }
                            selected = position;
                            view.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                            finishSetUp.setVisibility(View.VISIBLE);
                        }

                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // todo edit college name
                    }
                })
        );

        registerForContextMenu(collegeRecyclerView);

    }

}
