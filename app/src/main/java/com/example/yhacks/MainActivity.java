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
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Toolbar toolbar;
    private Fragment currentFragment;
    private FragmentManager fm;
    private SharedPreferences sharedPref;
    private String emailAddress, userToken;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            currentFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    currentFragment = new HomeFragment();
                    break;
                case R.id.navigation_search:
                    //currentFragment = new SearchFragment();
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        int thereIsUser = sharedPref.getInt(getString(R.string.user), 0);
        thereIsUser = 0;

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
            currentFragment = new HomeFragment();
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


}
