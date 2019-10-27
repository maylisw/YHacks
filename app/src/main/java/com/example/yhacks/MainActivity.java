package com.example.yhacks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Toolbar toolbar;
    private Fragment currentFragment;
    private FragmentManager fm;
    private SharedPreferences sharedPref;
    private String emailAddress, userToken;
    private List<StudyGroup> myGroups;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            currentFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if(myGroups.size() == 0){
                        currentFragment = new EmptyGroupsFragment();
                    } else {
                        currentFragment = new HomeFragment();
                    }
                    break;
                case R.id.navigation_search:
                    currentFragment = new SearchFragment();
                    break;
                case R.id.navigation_friends:
                    currentFragment = new FriendsFragment();
                    break;
                case R.id.navigation_study:
                    currentFragment = new StudyGroupFragment();
                    break;
            }
            //transmits proper fragment
            if (currentFragment != null) {
                fm.beginTransaction()
                        .replace(R.id.mainFragmentContainer, currentFragment)
                        .commit();
                return true;
            }
            return false;
        }
    };
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myGroups = new ArrayList<>();
        context = this;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(StudyBuddyApi.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        StudyBuddyApi api = retrofit.create(StudyBuddyApi.class);

        Call<User> call = api.registerUser("helllojoe819@gmail.com", "Maylis", "SEAS", "grrr", "grrr", "CS", "2023");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d("Stuff", "onResponse: "+response);
                Log.d("Stuff", "onResponse: "+response.body().getAuthToken());
               // if(response.body().getAuthToken() == null){
                    Toast.makeText(context, "Sorry the authentication did not work please try again", Toast.LENGTH_SHORT).show();
//                    Intent i = new Intent(this, CreateAccount.class);
//                    startActivity(i);
//                } else {
//                    SharedPreferences.Editor editor = sharedPref.edit();
//                    editor.putString(getString(R.string.token), response.body().getAuthToken());
//                    editor.putString("userEmailAddress", response.body().getEmail());
//                    editor.putString(getString(R.string.name), response.body().getName());
//                    editor.putInt(getString(R.string.user), 1); //means there is a saved user
//                    editor.commit();
//
//                    Intent i = new Intent(this, MainActivity.class);
//                    startActivity(i);
//                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG);
            }
        });


        sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        int thereIsUser = sharedPref.getInt(getString(R.string.user), 0);
        thereIsUser = 1;
        if(thereIsUser == 0){ //if no user
            Intent i = new Intent(this, Login.class);
            startActivity(i);
        } else {
            //save user info for use in calls
            emailAddress = sharedPref.getString("userEmailAddress", "");
            userToken = sharedPref.getString(getString(R.string.token), "");

            BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
            navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

            toolbar = (Toolbar)findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            if(myGroups.size() == 0){
                currentFragment = new EmptyGroupsFragment();
            } else {
                currentFragment = new HomeFragment();
            }
            fm = getSupportFragmentManager();
            fm.beginTransaction()
                    .replace(R.id.mainFragmentContainer, currentFragment)
                    .commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        fm = getSupportFragmentManager();
        if (currentFragment != null) {
            fm.beginTransaction()
                    .replace(R.id.mainFragmentContainer, currentFragment)
                    .commit();
        } else {
            currentFragment = new HomeFragment();
            fm.beginTransaction()
                    .replace(R.id.mainFragmentContainer, currentFragment)
                    .commit();
        }
        super.onBackPressed();
    }

    public void onProfileClick(MenuItem item) {
        Toast.makeText(this, "Go to Profile", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
        //launch new activity w/ intent
    }

    public List<StudyGroup> getMyGroups(){
        return myGroups;
    }

    public void addGroup(StudyGroup studyGroup){
        myGroups.add(studyGroup);
    }

    public void removeGroup(StudyGroup studyGroup){
        //todo make effcient lol
        for(int i = 0; i < myGroups.size(); i++){
            StudyGroup sg = myGroups.get(i);
            if(sg.getId() == studyGroup.getId()){
                myGroups.remove(i);
            }
        }
    }

    public boolean inMyGroups(StudyGroup group) {
        //todo make effcient
        for(int i = 0; i < myGroups.size(); i++){
            StudyGroup sg = myGroups.get(i);
            if(sg.getId() == group.getId()){
                return true;
            }
        }
        return false;
    }

}
