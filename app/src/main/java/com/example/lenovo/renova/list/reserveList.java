package com.example.lenovo.renova.list;

public class reserveList {
    String date,from,to;

    public reserveList(String date, String from, String to) {
        this.date = date;
        this.from = from;
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
