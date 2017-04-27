package com.hotels.model;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Hazem on 4/17/2017.
 */

public class Rooms implements Serializable  {
    private String name;
    private String price;
    private ArrayList<String> roomImage;
    private int capacity;
    private String desc;
    private String luxory;
    private Bitmap PanoImage;

    public Rooms(String name, String price, int capacity, String desc,String luxory) {
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.desc = desc;
        this.luxory=luxory;
        roomImage=new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ArrayList<String> getRoomImage() {
        return roomImage;
    }

    public void setRoomImage(ArrayList<String> roomImage) {
        this.roomImage = roomImage;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Bitmap getPanoImage() {
        return PanoImage;
    }

    public void setPanoImage(Bitmap panoImage) {
        PanoImage = panoImage;
    }

    public String getLuxory() {
        return luxory;
    }

    public void setLuxory(String luxory) {
        this.luxory = luxory;
    }
}
