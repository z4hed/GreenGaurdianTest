package Global;

import android.app.Application;

import controllers.singletonDatabase;

public class MyApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        //initialize global singleton object
        singletonDatabase.getInstance();
    }
}
