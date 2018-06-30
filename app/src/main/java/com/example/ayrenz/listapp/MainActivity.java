package com.example.ayrenz.listapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    String[] items;
    String[] prices;
    String[] descriptions;
    public static final String EXTRA_MESSAGE = "com.example.ayrenz.listapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();

       /* myListView = (ListView) findViewById(R.id.myListView);
        items = res.getStringArray((R.array.items));
        prices = res.getStringArray((R.array.prices));
        descriptions = res.getStringArray((R.array.descriptions));*/

        //ItemAdapter itemAdapter = new ItemAdapter(this, items, prices, descriptions);

        //myListView.setAdapter(itemAdapter);

        /* myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
           public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);
                showDetailActivity.putExtra("com.example.ayrenz.ITEM_INDEX", i);
                startActivity(showDetailActivity);
            }
        });*/
    }

    /** Called when the user taps the Send button */
    public void GoToBroadcast(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, BroadcastMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText123);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);

        //Log.i("asd", "ASDASDASDA");
        startActivity(intent);
    }
    public void GoToScheduling(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, SchedulingActivity.class);
        startActivity(intent);
    }
    public void GoToAccidentReport(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, AccidentReportActivity.class);
        startActivity(intent);
    }
    public void GoToTrReport(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, TrReportActivity.class);
        startActivity(intent);
    }
    public void GoToLiveUpdate(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, LiveUpdateActivity.class);
        startActivity(intent);
    }
    public void GoToOGScore(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, OGScoreActivity.class);
        startActivity(intent);
    }

}
