package com.example.yhacks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private SharedPreferences sharedPref;
    private String emailAddress, userName, year, major, college;
    private Button logOff;
    private EditText profileName, profileMajor, profileYear, profileCollege;

    public ProfileActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        toolbar = (Toolbar)findViewById(R.id.profileToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        wireWidgets();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void wireWidgets() {
        emailAddress = sharedPref.getString("userEmailAddress", "");
        userName = sharedPref.getString(getString(R.string.name), "");
        year = sharedPref.getString(getString(R.string.year), "");
        major = sharedPref.getString(getString(R.string.major), "");
        college = sharedPref.getString(getString(R.string.college), "");

        profileName = findViewById(R.id.profileName);
        profileName.setText(userName,null );
        profileMajor = findViewById(R.id.profileMajor);
        profileMajor.setText(major, null);
        profileYear = findViewById(R.id.profileYear);
        profileYear.setText(year,null);
        profileCollege = findViewById(R.id.profileSchool);
        profileCollege.setText(college,null);

        logOff = findViewById(R.id.logOut);
    }

    public void logOff(View view) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear().commit();
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }

}
