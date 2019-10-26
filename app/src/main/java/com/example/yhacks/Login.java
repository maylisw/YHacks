package com.example.yhacks;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
Initial screen seen when opening app
 */
public class Login extends AppCompatActivity {

    private Button login, newAccount, help;
    private EditText emailInput, passwordInput;
    private CheckBox rememberMe;
    private TextView forgotPassword;
    private Toolbar toolbar;
    private SharedPreferences sharedPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        wireWidgets();
    }

    public void wireWidgets(){
        login = (Button) findViewById(R.id.login_button);
        newAccount = (Button) findViewById(R.id.new_account_button);
        emailInput = (EditText) findViewById(R.id.email_editText);
        passwordInput = (EditText) findViewById(R.id.password_editText);
        toolbar = (Toolbar) findViewById(R.id.toolbar_login);
        forgotPassword = (TextView) findViewById(R.id.forgot_password_textView);
        setSupportActionBar(toolbar);
        setOnClickListeners();
    }

    public void setOnClickListeners(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailInput == null || emailInput.equals("")) {
                    Toast.makeText(Login.this, "Please Enter an Email Address", Toast.LENGTH_SHORT).show();
                }
                if(passwordInput == null || passwordInput.equals((""))) {
                    Toast.makeText(Login.this, "Please Enter a Password", Toast.LENGTH_SHORT).show();
                }
                //todo call api login request
                // updates stored app info
                //todo update
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString(getString(R.string.token), "TOKEN HERE");
                editor.putString("userEmailAddress", emailInput.getText().toString());
                editor.putInt(getString(R.string.user), 1); //means there is a saved user
                //todo get users editor.putString(getString(R.string.name), firstNameInput + " " + lastNameInput);
                editor.commit();

                //Starts Main Activity
                Intent i = new Intent(Login.this, MainActivity.class);
                startActivity(i);

            }
        });
        newAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, CreateAccount.class);
                startActivity(i);
            }
        });
        //todo use api request to get code
//        forgotPassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(!emailInput.getText().equals(null)){
//                    Backendless.UserService.restorePassword(emailInput.getText().toString(), new AsyncCallback<Void>() {
//                        @Override
//                        public void handleResponse(Void response) {
//                            Toast.makeText(LoginScreen.this, "An email has been sent to "+emailInput.getText().toString()+"'s email to restore your password.", Toast.LENGTH_SHORT).show();
//                        }
//
//                        @Override
//                        public void handleFault(BackendlessFault fault) {
//                            Toast.makeText(LoginScreen.this, fault.getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                }
//                else{
//                    Toast.makeText(LoginScreen.this, "Please enter your username", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }
}