package com.rahulraj.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class ReceiveMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        TextView textView = (TextView) findViewById(R.id.receivedMessageValue);
        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("message"));
    }


}
