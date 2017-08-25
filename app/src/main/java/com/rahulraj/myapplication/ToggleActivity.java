package com.rahulraj.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ToggleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.togglelayout);
    }

    public void onClickToggleButton(View view){
        boolean on = ((ToggleButton)view).isChecked();
        TextView tView = (TextView) findViewById(R.id.textView2);
        if(on){
            tView.setText("Switched on!!");
        }
        else{
            tView.setText("Switched off!!");
        }

    }
}
