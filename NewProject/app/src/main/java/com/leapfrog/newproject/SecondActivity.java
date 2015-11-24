package com.leapfrog.newproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by xander on 11/17/2015.
 */
public class SecondActivity extends AppCompatActivity {
     ListView listView;

    String names[] = {"ram", "shyam", "harry"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, names);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);


    }


}
