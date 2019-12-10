package com.example.menu_app.models;

public class tableNumber {
    String tablenbr;
    String tableid;
    String menu_name;
    String quantity;
    String price;



    public tableNumber(String tablenbr, String tableid, String menu_name, String quantity, String price) {
        this.tablenbr = tablenbr;
        this.tableid = tableid;
        this.menu_name = menu_name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getTablenbr() {
        return tablenbr;
    }

    public void setTablenbr(String tablenbr) {
        this.tablenbr = tablenbr;
    }

    public String getTableid() {
        return tableid;
    }

    public void setTableid(String tableid) {
        this.tableid = tableid;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
