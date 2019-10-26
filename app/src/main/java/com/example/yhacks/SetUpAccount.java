package com.example.yhacks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SetUpAccount extends AppCompatActivity {
    private SharedPreferences sharedPref;
    private String emailAddress, userToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_account);

        sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        wireWidgets();
    }

    private void wireWidgets() {
        emailAddress = sharedPref.getString("userEmailAddress", "");
        userToken = sharedPref.getString(getString(R.string.token), "");
        //set name to be name from user token
        //todo wire year + major and store values to API


    }

    public void onNextClick(View view) {
        Intent i = new Intent(SetUpAccount.this, CollegePicker.class);
        startActivity(i);
    }
}
