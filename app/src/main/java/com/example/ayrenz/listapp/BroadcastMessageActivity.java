package com.example.ayrenz.listapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class BroadcastMessageActivity extends AppCompatActivity {

    String KeyMessage =  "Message No ";
    String KeyCurrentMessageIndex = "key";
    int CurrentMessageIndex = 0;

    ListView myListView;
    String[] messages;

    ItemAdapter itemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_message);

        //get the intent that started this ativity and extract the string
        Intent intent = getIntent();
        //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        CurrentMessageIndex = sharedPref.getInt(KeyCurrentMessageIndex, 0);

        myListView = (ListView) findViewById(R.id.BroadcastListView);

        itemAdapter = new ItemAdapter(this);

        StringTokenizer tokens;
        if(CurrentMessageIndex > 0) {
            for (int i = 1; i < CurrentMessageIndex+1; i++) {

                Log.i("asd", "reading message index " + CurrentMessageIndex);
                String Message = sharedPref.getString(KeyMessage + i, "default");

                tokens = new StringTokenizer(Message, ":");
                String author = tokens.nextToken();// take out the author
                String date = tokens.nextToken(); // take out the date
                String message = tokens.nextToken(); //take out the message

                itemAdapter.AddBroadcastMessage(message, author, date);
            }
        }
        myListView.setAdapter(itemAdapter);

    }

    public void BroadcastMessage(View view)
    {
        Log.i("asd", "coming into broadcastmessage");
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        EditText editText = (EditText) findViewById(R.id.BroadcastMessageInput);

        String message = editText.getText().toString();
        String author = "tyrone";
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        itemAdapter.AddBroadcastMessage(message, author, date);

        CurrentMessageIndex++;
        //add the message to the data storage along with the message index
        editor.putString(KeyMessage + CurrentMessageIndex, author + ":" + date + ":" + message);
        editor.putInt(KeyCurrentMessageIndex, CurrentMessageIndex);


        Log.i("asd", "putting key is = " + KeyMessage + CurrentMessageIndex);

        editor.commit();
        Refresh(view);
    }

    public void Refresh(View view)
    {
        Log.i("asd", "coming into the refresh");

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);

        itemAdapter.notifyDataSetChanged();

        String message = "";

        if(CurrentMessageIndex > 0)
            message = sharedPref.getString(KeyMessage + CurrentMessageIndex, "default");


        Log.i("asd", "getting key is = " + KeyMessage + CurrentMessageIndex);

        TextView preview = (TextView) findViewById(R.id.message1);
        //preview.setText(CurrentMessageIndex);
    }
    public void Reset(View view)
    {
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        for(int i = 0; i < 10; i++)
            sharedPref.edit().remove(KeyMessage + i).commit();

        CurrentMessageIndex = 0;
        Log.i("clear", "CLEARING EVERYTHING");
        editor.clear();
        Log.i("clear", "value of key BEFORE putting in is " + sharedPref.getInt(KeyCurrentMessageIndex, 0));
        Log.i("clear", "and message index is " + CurrentMessageIndex);
        editor.putInt(KeyCurrentMessageIndex, CurrentMessageIndex);
        editor.commit();
        itemAdapter.clear();

        Log.i("clear", "value of key after clear is " + sharedPref.getInt(KeyCurrentMessageIndex, 0));

    }

}
