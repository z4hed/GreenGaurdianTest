package controllers;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

public class singletonDatabase {

    private static singletonDatabase instance = null;
    private static databaseController dbController;

    private singletonDatabase() {
        dbController = new databaseController();
    }

    public static singletonDatabase getInstance() {
        if (instance == null)
        {
            instance = new singletonDatabase();
        }
        return instance;
    }

    public databaseController getDatabaseController()
    {
        return getDatabaseController();
    }
}
