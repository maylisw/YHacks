package com.example.yhacks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

/*
Has user make new account; linked from New Account button in LoginScreen
 */
public class CreateAccount extends AppCompatActivity {

    private EditText firstNameInput, lastNameInput, emailInput, passInput, confirmPassInput;
    private Button createAccount;
    private Toolbar toolbar;
    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        wireWidgets();
    }

    public void wireWidgets(){
        createAccount = (Button) findViewById(R.id.create_account_button);
        firstNameInput = (EditText) findViewById(R.id.first_name_editText);
        lastNameInput = (EditText) findViewById(R.id.last_name_edit_text);
        emailInput = (EditText) findViewById(R.id.email_editText);
        passInput = (EditText) findViewById(R.id.password_editText);
        confirmPassInput = (EditText) findViewById(R.id.password_confirm_editText);

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstNameInput == null || firstNameInput.equals("")) {
                    Toast.makeText(CreateAccount.this, "Please Enter a First Name", Toast.LENGTH_SHORT).show();
                }
                if(lastNameInput == null || lastNameInput.equals("")) {
                    Toast.makeText(CreateAccount.this, "Please Enter a Last Name", Toast.LENGTH_SHORT).show();
                }
                if(emailInput == null || emailInput.equals("")) {
                    Toast.makeText(CreateAccount.this, "Please Enter an Email Address", Toast.LENGTH_SHORT).show();
                }
                if(passInput == null || passInput.equals("")) {
                    Toast.makeText(CreateAccount.this, "Please Enter a Valid Password", Toast.LENGTH_SHORT).show();
                }
                if(confirmPassword()){
                    //todo api request
//                    BackendlessUser user = new BackendlessUser();
//                    //                    user.setProperty("name", firstNameInput.getText().toString() + " " + miInput.getText().toString()+". "+lastNameInput.getText().toString());
//                    user.setProperty("name", firstNameInput.getText().toString() + " "+lastNameInput.getText().toString());
//                    user.setProperty("email", emailInput.getText().toString());
//                    user.setProperty("password", passInput.getText().toString());
//                    user.setProperty("username", usernameInput.getText().toString());
//                    user.setProperty("updatedsetup", false);
//                    Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
//                        @Override
//                        public void handleResponse(BackendlessUser response) {
//                            String username = (String) response.getProperty("username");
//                            Toast.makeText(CreateAccount.this, "Welcome " +username+", please confirm your email before logging in.", Toast.LENGTH_LONG).show();
//                        }
//
//                        @Override
//                        public void handleFault(BackendlessFault fault) {
//                            Toast.makeText(CreateAccount.this, fault.getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    });
                    //todo update sharedPref
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(getString(R.string.token), "TOKEN HERE");
                    editor.putString("userEmailAddress", emailInput.getText().toString());
                    editor.putString(getString(R.string.name), firstNameInput + " "+lastNameInput);
                    editor.putInt(getString(R.string.user), 1); //means there is a saved user
                    editor.commit();

                    Intent i = new Intent(CreateAccount.this, SetUpAccount.class);
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
