package com.example.yhacks;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment currentFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    currentFragment = new HomeFragment();
                    break;
                case R.id.navigation_dashboard:
                    currentFragment = new FriendsFragment();
                    break;
                case R.id.navigation_notifications:
                    currentFragment = new StudyGroupFragment();
                    break;
            }
            //transmits proper fragment
            FragmentManager fm = getSupportFragmentManager();
            if (currentFragment != null) {
                fm.beginTransaction()
                        .replace(R.id.mainFragmentContainer, currentFragment)
                        .commit();
                return true;
            }
            return false;
        }
    };
//oo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
