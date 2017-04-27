package com.hotels.model;

import java.io.Serializable;

/**
 * Created by ahmed on 12/04/17.
 */

public class User  {
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
    private String Phone;
    private long Points;
    private int Stays;
    private int Nights;
    private static User user=null;

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

    public void addPoints(long points) {
        if(Points=='\0')
        {
            Points=0;
        }
        Points+=points;
    }

    public int getStays() {
        return Stays;
    }

    public void addStays(int stays) {
        if(Stays=='\0')
        {
            Stays=0;
        }
        Stays+=stays;
    }

    public int getNights() {
        return Nights;
    }

    public void addNights(int nights) {
        if(nights=='\0')
        {
            nights=0;
        }
        Nights+=nights;
    }
}
