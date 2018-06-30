package com.example.ayrenz.listapp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Date;

public class CBroadcastedMessage {

    private String message;
    private String author;
    private String date;

    CBroadcastedMessage(String m, String a , String d)
    {
        //default date will be current date
        date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        message = m;
        author = a;
        date = d;

    }

    public String getMessage(){return message;}
    public String getauthor(){return author;}
    public String getdate(){return date;}
}
