package com.example.menu_app.models;

import java.util.Comparator;

public class Model {
    private String Name;
    private String price;
    private int image;
    private int quantity;
    private int id;


    public Model(String name, String price, int image, int id) {
        Name = name;
        this.price = price;
        this.image = image;
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public static final Comparator<Model> By_Menu_Ascending=new Comparator<Model>() {
        @Override
        public int compare(Model o1, Model o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    public static final Comparator<Model>By_Menu_Descending=new Comparator<Model>() {
        @Override
        public int compare(Model o1, Model o2) {
            return o2.getName().compareTo(o1.getName());
        }
    };
}


