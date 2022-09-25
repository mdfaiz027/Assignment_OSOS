package com.example.osos_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login;

    ProgressDialog progressDialog;

    private String usernameInput, passwordInput;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.signInUsernameEdtText);
        password = findViewById(R.id.signInPasswordEditText);
        login = findViewById(R.id.login);

        sharedPreferences = getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!validateUsername()) {
                    return;
                }else if(!validatePassword()){
                    return;
                }
                checkUser();
            }
        });
    }

    private void checkUser() {

        progressDialog.show();
        progressDialog.setMessage("loading....");

        usernameInput = username.getText().toString();
        passwordInput = password.getText().toString();

        if(usernameInput.equals("123") && passwordInput.equals("123")){

            editor.putBoolean("status", true);
            editor.commit();

            navigateToHomeActivity();
            finish();
            Toast.makeText(MainActivity.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();

        }else {
            progressDialog.dismiss();
            Toast.makeText(this, "Please check username or password", Toast.LENGTH_SHORT).show();
        }
    }

    private void navigateToHomeActivity() {
        startActivity(new Intent(MainActivity.this, HomeActivity.class));
    }

    private boolean validatePassword() {
        passwordInput = password.getText().toString().trim();

        // if password field is empty
        // it will display error message "Field can not be empty"
        if (passwordInput.isEmpty()) {
            password.setError("Field can not be empty");
            return false;
        }else {
            password.setError(null);
            return true;
        }
    }

    private boolean validateUsername() {
        usernameInput = username.getText().toString().trim();

        // if the email input field is empty
        if (usernameInput.isEmpty()) {
            username.setError("Field can not be empty");
            return false;
        }else {
            username.setError(null);
            return true;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(sharedPreferences.getBoolean("status", false) == true){
            navigateToHomeActivity();
        }
    }
}