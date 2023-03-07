package controllers;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.Nullable;

import Models.profile;

public class databaseController {

    FirebaseDatabase db;
    DatabaseReference userProfileRef;
    DatabaseReference sensorReference;
    private profile savedProf;
    databaseController()
    {
        db = FirebaseDatabase.getInstance();
        userProfileRef = db.getReference().child("userProfile");
        sensorReference = db.getReference().child("sensorData");
    }

    //Creating a fetch Query
    public void addProfile(profile toBeAdded) {
        DatabaseReference prof = userProfileRef.child(toBeAdded.getUserName());
        prof.child("firstName").setValue(toBeAdded.getFirstName());
        prof.child("lastName").setValue(toBeAdded.getUserName());
        prof.child("email").setValue(toBeAdded.getEmail());
        prof.child("userName").setValue(toBeAdded.getUserName());
        prof.child("password").setValue(toBeAdded.getPassword());
    }


    public profile fetchProfile(String toBeFetched)
    {
        Query query = userProfileRef.orderByChild("userName").equalTo(toBeFetched);

        //Asynchronous call to the database to retreive object
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String firstName = snapshot.child("firstName").getValue(String.class);
                String lastName = snapshot.child("lastName").getValue(String.class);
                String userName = snapshot.child("userName").getValue(String.class);
                String password = snapshot.child("password").getValue(String.class);
                String email = snapshot.child("email").getValue(String.class);
                profile fetchedProfile = new profile(firstName, lastName, userName, password, email);
                fetchProfileCallback(fetchedProfile);
                Log.d(TAG, "Fetched profile: " + firstName);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG, "Fetch profile cancelled: " + error.getMessage());
            }

        });


        return null;
    }
    //callback function for the asynchronously fetched profile object
    private profile fetchProfileCallback(profile prof)
    {
        savedProf = prof;
        return savedProf;
    }


}
