package com.rahulraj.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    public void sendMessage(View view){
        EditText text = (EditText) findViewById(R.id.editText2);
//        Intent intent = new Intent(this, ReceiveMessageActivity.class);
//        intent.putExtra("message", text.getText().toString());
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,text.getText().toString());
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.mailSubject));
        intent = Intent.createChooser(intent, getString(R.string.chooser));
        startActivity(intent);
    }
}
