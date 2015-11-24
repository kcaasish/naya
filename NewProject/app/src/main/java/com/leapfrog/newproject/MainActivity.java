package com.leapfrog.newproject;


import android.util.Log;
import android.widget.TextView;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    EditText edit_username;
    EditText edit_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            String str = loadJSONFromAsset();
            Log.v("test", str);
            parseJson(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public void parseJson(String str) throws JSONException {
        JSONObject rootObject = new JSONObject(str);
        final Users mUsers = new Users();
        JSONObject userObject = rootObject.getJSONObject("user");
        mUsers.email = userObject.getString("email");
        mUsers.password = userObject.getString("password");

        edit_username = (EditText) findViewById(R.id.edit_username);
        edit_password = (EditText) findViewById(R.id.edit_password);


        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        Button btnCancel = (Button) findViewById(R.id.btnCancel);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((edit_username.getText().toString().trim().equals(mUsers.email)) && (edit_password.getText().toString().trim().equals(mUsers.password))) {
                    Intent mIntent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(mIntent);
                } else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public String loadJSONFromAsset() {
        String json = null;
        try {

            InputStream is = getAssets().open("status.txt");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();

        }
        return json;

    }


}













