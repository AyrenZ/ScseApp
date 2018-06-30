package com.example.ayrenz.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {


    LayoutInflater mInflater;
    ArrayList<CBroadcastedMessage> BroadcastedMessages;

    public ItemAdapter(Context c)
    {
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        BroadcastedMessages = new ArrayList<CBroadcastedMessage>();
    }
    @Override
    public int getCount() {
        return BroadcastedMessages.size();
    }

    @Override
    public Object getItem(int i) {
        //return items.get(i);
        return (BroadcastedMessages.size() - i - 1);
    }
    public void AddBroadcastMessage(String message, String author, String date)
    {
        CBroadcastedMessage broadcast = new CBroadcastedMessage(message, author, date);
        BroadcastedMessages.add(0,broadcast);
    }
    public void clear()
    {
        BroadcastedMessages.clear();
    }
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View View, ViewGroup viewGroup) {

        View v = mInflater.inflate(R.layout.my_listview_detail, null);
        TextView messageTextView = (TextView) v.findViewById(R.id.messageTextView);
        TextView authorTextView = (TextView) v.findViewById(R.id.authorTextView);
        TextView dateTextView = (TextView) v.findViewById(R.id.dateTextView);

        String message = BroadcastedMessages.get(i).getMessage();
        String author = BroadcastedMessages.get(i).getauthor();
        String date = BroadcastedMessages.get(i).getdate();

        messageTextView.setText(message);
        authorTextView.setText(author);
        dateTextView.setText(date);

        return v;
    }
}
