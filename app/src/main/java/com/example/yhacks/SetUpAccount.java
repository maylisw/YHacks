package com.example.yhacks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SetUpAccount extends AppCompatActivity {
    private SharedPreferences sharedPref;
    private String emailAddress, userToken;
    private EditText profileName, profileYear, profileMajor;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_account);

        sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        toolbar = (Toolbar)findViewById(R.id.set_up_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        wireWidgets();
    }

    private void wireWidgets() {
        emailAddress = sharedPref.getString("userEmailAddress", "");
        userToken = sharedPref.getString(getString(R.string.token), "");
        //set name to be name from user token
        //store values to API
        profileName = findViewById(R.id.profileName);
        profileYear = findViewById(R.id.profileYear);
        profileMajor = findViewById(R.id.profileMajor);
    }

    public void onNextClick(View view) {
        if(profileName == null || profileName.equals("")) {
            Toast.makeText(this, "Enter a valid profile name", Toast.LENGTH_SHORT).show();
        }
        if(profileYear == null || profileYear.equals("")) {
            Toast.makeText(this, "Enter a valid year", Toast.LENGTH_SHORT).show();
        }
        if(profileMajor == null || profileMajor.equals("")) {
            Toast.makeText(this, "Enter a valid major", Toast.LENGTH_SHORT).show();
        }
        Intent i = new Intent(SetUpAccount.this, CollegePicker.class);
        startActivity(i);
    }
}
