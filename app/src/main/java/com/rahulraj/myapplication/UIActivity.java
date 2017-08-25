package com.rahulraj.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class UIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        
    }

    public void onClickSwitch(View view){
        //boolean on=((Switch)view).isChecked();
        Switch sw = (Switch) findViewById(R.id.switch1);
        boolean on= sw.isChecked();
        TextView tView = (TextView) findViewById(R.id.textView5);
        if(on){
            tView.setText("Switched on");
        }
        else{
            tView.setText("Switched off");
        }
    }
}
