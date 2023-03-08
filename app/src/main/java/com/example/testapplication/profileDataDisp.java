package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class profileDataDisp extends AppCompatActivity {

    TextView Time, UV, Moisture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_data_disp);
        Time = findViewById(R.id.input_time_data);

    }
}