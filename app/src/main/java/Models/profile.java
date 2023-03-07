package Models;


import java.util.ArrayList;

public class profile {
    private String firstName,lastName;
    private String userName, password;
    private String email;

    //plant related data
    ArrayList<String> plantsOwned;

    public profile(String firstName, String lastName, String userName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
