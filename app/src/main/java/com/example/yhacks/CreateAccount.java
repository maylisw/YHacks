package com.example.yhacks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;


/*
Has user make new account; linked from New Account button in LoginScreen
 */
public class CreateAccount extends AppCompatActivity {

    private EditText firstNameInput, lastNameInput, emailInput, passInput, confirmPassInput, profileYear, profileMajor;
    private String name, email, pass, confirmPass, year, major;
    private Button createAccount;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        toolbar = (Toolbar)findViewById(R.id.toolbar_create_account);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        wireWidgets();
    }

    public void wireWidgets(){
        createAccount = (Button) findViewById(R.id.create_account_button);
        firstNameInput = (EditText) findViewById(R.id.first_name_editText);
        lastNameInput = (EditText) findViewById(R.id.last_name_edit_text);
        emailInput = (EditText) findViewById(R.id.email_editText);
        passInput = (EditText) findViewById(R.id.password_editText);
        confirmPassInput = (EditText) findViewById(R.id.password_confirm_editText);
        profileYear = findViewById(R.id.profileYear);
        profileMajor = findViewById(R.id.profileMajor);

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstNameInput == null || firstNameInput.equals("")) {
                    Toast.makeText(CreateAccount.this, "Please Enter a First Name", Toast.LENGTH_SHORT).show();
                }
                else if(lastNameInput == null || lastNameInput.equals("")) {
                    Toast.makeText(CreateAccount.this, "Please Enter a Last Name", Toast.LENGTH_SHORT).show();
                }
                else if(emailInput == null || emailInput.equals("")) {
                    Toast.makeText(CreateAccount.this, "Please Enter an Email Address", Toast.LENGTH_SHORT).show();
                }
                else if(passInput == null || passInput.equals("")) {
                    Toast.makeText(CreateAccount.this, "Please Enter a Valid Password", Toast.LENGTH_SHORT).show();
                } else if(profileYear == null || profileYear.equals("")) {
                    Toast.makeText(CreateAccount.this, "PleaseEnter a valid year", Toast.LENGTH_SHORT).show();
                }
                else if(profileMajor == null || profileMajor.equals("")) {
                    Toast.makeText(CreateAccount.this, "PleaseEnter a valid major", Toast.LENGTH_SHORT).show();
                }
                else if(confirmPassword()){
                    Intent i = new Intent(CreateAccount.this, CollegePicker.class);
                    name = firstNameInput.getText().toString() + lastNameInput.getText().toString();
                    email = emailInput.getText().toString();
                    pass = passInput.getText().toString();
                    year = profileYear.getText().toString();
                    major = profileMajor.getText().toString();
                    i.putExtra("name", name);
                    i.putExtra("email", email);
                    i.putExtra("pass", pass);
                    i.putExtra("year", year);
                    i.putExtra("major", major);
                    startActivity(i);
                }
            }
        });
    }

    //checks to make sure the password was imputed properly in the two EditTexts
    public boolean confirmPassword(){
        if(passInput.getText().toString().equals(confirmPassInput.getText().toString())){
            return true;
        }
        else{
            if(!passInput.getText().toString().equals(confirmPassInput.getText().toString())){
                Toast.makeText(CreateAccount.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    }
}
