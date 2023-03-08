package com.example.testapplication;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import Models.timeSeriesData;
import controllers.databaseController;
import controllers.sensorDataRetreiver;
import controllers.singletonDatabase;

public class profileDataDisp extends AppCompatActivity implements sensorDataRetreiver.OnDataRetrievedListener {

    TextView Time, UV, Moisture;
    databaseController dbController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_data_disp);
        Time = findViewById(R.id.input_time_data);
        UV = findViewById(R.id.input_uv_data);
        Moisture = findViewById(R.id.input_moisture_data);

        //sensor data retreiver
        sensorDataRetreiver sdRet = new sensorDataRetreiver(this);
        while(true)
        {
            sdRet.retrieveData();

            singletonDatabase stdb = singletonDatabase.getInstance();
            dbController = stdb.getDatabaseController();

        }
    }

    //implement the callback interface function
    @Override
    public void onDataRetrieved(timeSeriesData data) {
        // Do something with the retrieved data
        if (data != null) {
            if(data != null)
            {
                dbController.addsensorData(data);
            }
            Log.d(TAG, "Retrieved data: " + data.toString());
        } else {
            Log.d(TAG, "Failed to retrieve data.");
        }
    }
}