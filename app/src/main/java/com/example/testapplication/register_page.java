package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import Models.profile;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class register_page extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText userName;
    private EditText password;
    private profile userProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

        firstName = findViewById(R.id.register_first_name);
        lastName = findViewById(R.id.register_last_name);
        email = findViewById(R.id.regitser_email);
        userName = findViewById(R.id.register_username);
        password = findViewById(R.id.register_password);

        //On Click Specifiers
        Button confirmRegistration = findViewById(R.id.register_register_button);
        confirmRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstNameEntered = firstName.getText().toString();
                String lastNameEntered = lastName.getText().toString();
                String emailEntered = email.getText().toString();
                String userNameEntered = userName.getText().toString();
                String passwordEntered = password.getText().toString();
                userProfile = new profile(firstNameEntered,lastNameEntered,userNameEntered,passwordEntered,emailEntered);

            }
        });
    }
}