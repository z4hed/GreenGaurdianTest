package Global;

import android.app.Application;

import com.google.firebase.FirebaseApp;

import controllers.singletonDatabase;

public class MyApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        FirebaseApp.initializeApp(this);
        //initialize global singleton object
        singletonDatabase.getInstance();
    }
}
