package controllers;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.Nullable;

import Models.profile;

public class databaseController {

    FirebaseDatabase db;
    DatabaseReference userProfileRef;
    databaseController()
    {
        db = FirebaseDatabase.getInstance();
        userProfileRef = db.getReference().child("profile");
    }

    public void addProfile(profile toBeAdded) {
        userProfileRef.child(toBeAdded.getUserName()).setValue(toBeAdded);

    }

    public void fetchProfile(profile toBeFetched)
    {
        userProfileRef.child(toBeFetched.getUserName());
        userProfileRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    profile fetchedProfile = snapshot.getValue(profile.class);
                    Log.d(TAG, "Fetched profile: " + fetchedProfile.toString());
                } else {
                    Log.d(TAG, "Profile not found.");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG, "Fetch profile cancelled: " + error.getMessage());
            }
        });
    }
}
