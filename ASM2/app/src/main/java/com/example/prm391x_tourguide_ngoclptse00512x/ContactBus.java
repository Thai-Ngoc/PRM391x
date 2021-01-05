package com.example.prm391x_tourguide_ngoclptse00512x;

public class ContactBus {
    private String busNo;
    private String busRoute;

    public ContactBus(String busNo, String busRoute) {
        this.busNo = busNo;
        this.busRoute = busRoute;
    }

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public String getBusRoute() {
        return busRoute;
    }

    public void setBusRoute(String busRoute) {
        this.busRoute = busRoute;
    }
}
