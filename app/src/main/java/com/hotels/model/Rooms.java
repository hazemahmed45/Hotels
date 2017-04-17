package com.hotels.model;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by Hazem on 4/17/2017.
 */

public class Rooms {
    private String name;
    private String price;
    private ArrayList<Bitmap> roomImage;
    private int capacity;
    private String desc;
    private Bitmap PanoImage;

    public Rooms(String name, String price, int capacity, String desc) {
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.desc = desc;
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

    public ArrayList<Bitmap> getRoomImage() {
        return roomImage;
    }

    public void setRoomImage(ArrayList<Bitmap> roomImage) {
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
}
