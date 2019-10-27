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
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
    private String email, name, university, password, year, major;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_picker);
        Intent orgin = getIntent();
        name = orgin.getStringExtra("name");
        email = orgin.getStringExtra("email");
        password = orgin.getStringExtra("password");
        year = orgin.getStringExtra("year");
        major = orgin.getStringExtra("major");

        //todo get items passed from last activity

        sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        toolbar = (Toolbar)findViewById(R.id.toolbar_college_picker);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        universityList = new ArrayList<>();
        //todo make query to get list of UNis
        universityList.add(new University(
                "Columbia University in the City of New York",
                "New York, New York",
                0));
        universityList.add(new University(
                "Yale University",
                "New Haven, Connecticut",
                0));
        universityList.add(new University(
                "Princeton University",
                "Princeton, New Jersey",
                0));
        universityList.add(new University(
                "Harvard University",
                "Cambridge, Massachusetts",
                0));
        universityList.add(new University(
                "University of Pennsylvania",
                "Philadelphia, Pennsylvania",
                0));
        universityList.add(new University(
                "Dartmouth College",
                "Hanover, New Hampshire",
                0));
        universityList.add(new University(
                "Cornell University",
                "Ithaca, New York",
                0));
        universityList.add(new University(
                "Massachusetts Institute of Technology",
                "Cambridge, Massachusetts",
                0));
        wireWidgets();
    }

    private void wireWidgets() {
        final int backgroundColor = getResources().getColor(R.color.backgroundColor);
        selected = -1;
        context = this;
        layoutManager = new GridLayoutManager(this, 1);

        finishSetUp = findViewById(R.id.finishSetUp);
        finishSetUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                university = universityList.get(selected).getName();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(StudyBuddyApi.baseURL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                StudyBuddyApi api = retrofit.create(StudyBuddyApi.class);

                Call<User> call = api.registerUser(email, name, university, password, password, major, year);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {

                        Log.d("stuff", "onResponse: "+response.body().toString());

                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString(getString(R.string.token), response.body().getAuthToken());
                        editor.putString("userEmailAddress", response.body().getEmail());
                        editor.putString(getString(R.string.name), response.body().getName());
                        editor.putInt(getString(R.string.user), 1); //means there is a saved user
                        editor.commit();

                        try {
                            Toast.makeText(CollegePicker.this, response.errorBody().string(), Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                        Intent i = new Intent(context, MainActivity.class);
                        startActivity(i);
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(CollegePicker.this, t.getMessage(), Toast.LENGTH_LONG);
                    }
                });
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
