package com.example.testapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import Models.profile;
import controllers.databaseController;
import controllers.singletonDatabase;

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

    singletonDatabase dbInstance;
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

                //check if any of the statements are empty
                AlertDialog.Builder builder = new AlertDialog.Builder(register_page.this);
                if(!firstNameEntered.isEmpty() && !lastNameEntered.isEmpty() && !emailEntered.isEmpty() && !userNameEntered.isEmpty() && !passwordEntered.isEmpty())
                {
                    //successful profile creation.
                    userProfile = new profile(firstNameEntered,lastNameEntered,userNameEntered,passwordEntered,emailEntered);
                    singletonDatabase stdb = singletonDatabase.getInstance();
                    databaseController dbController = stdb.getDatabaseController();
                    dbController.addProfile(userProfile);
                    dbController.fetchProfile("sdfsdf");

                    //Start New Intent(TEST TO BE REPLACED LATER) ~ zahed
                    Intent moveToProfile = new Intent(register_page.this, profileDataDisp.class);
                    startActivity(moveToProfile);
                }
                else{
                    //Alert the user that some fields are empty
                    alertUser(builder);
                }
            }
        });
    }

    private void alertUser(AlertDialog.Builder builder)
    {
        builder.setMessage("Please enter all fields");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}