package com.hotels.model;

/**
 * Created by ahmed on 12/04/17.
 */

public class User {
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
    private String Phone;
    private long Points;
    private static User user;

    public User()
    {

    }
    public static User getUser()
    {
        if(user==null)
        {
            user=new User();
        }
        return user;
    }

    public static void setUser(User user) {
        User.user = user;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public long getPoints() {
        return Points;
    }

    public void setPoints(long points) {
        Points = points;
    }
}
