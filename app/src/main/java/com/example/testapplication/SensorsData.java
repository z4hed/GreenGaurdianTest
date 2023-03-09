package com.example.testapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;
import java.util.Map;

public class SensorsData extends AppCompatActivity {

    TextView sensor;
    DatabaseReference mDatabase;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors_data);
        sensor = findViewById(R.id.txt_sensor);
        sensor.setText("4444");

        mDatabase = FirebaseDatabase.getInstance().getReference("sensorData").child("21-11-2023");
//                .child("temp");

        mDatabase.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot d : snapshot.getChildren()) {
//                    Map<String, Object> sensors = (Map<String, Object>) d.getValue();
                    if (d.getKey().toLowerCase().contains("moisture"))
                        sensor.setText("Moisture ="+d.getValue() +"");
//                    double value = Double.valueOf(sensors.get("value").toString());
//                    value= (double) (Math.round(value*100.0) / 100.0);
//                    String info = sensors.get("info").toString();
//                    if (info.toLowerCase().contains("temp"))
//                        sensor.setText(value +"");
//                    if (info.toLowerCase().contains("ph")) {
//                        phValue.setText(value + "");
//                    } else if (info.toLowerCase().contains("tds")) {
//                        tdsValue.setText(value + "");
//                    } else if (info.toLowerCase().contains("turbidity")) {
//                        turbidityValue.setText(value + "");
//                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}