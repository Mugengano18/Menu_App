package com.example.menu_app.models;

public class tableNumber {
    String tablenbr;
    String tableid;


    public tableNumber(String tablenbr, String tableid) {
        this.tablenbr = tablenbr;
        this.tableid = tableid;
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
}
