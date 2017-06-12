package com.rahulraj.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testproject);
    }

    public void listItems(View view){
        ItemLister lister = new ItemLister();
        TextView tView = (TextView) findViewById(R.id.textView3);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        List<String> list = lister.listItems(String.valueOf(spinner.getSelectedItem()));
        StringBuilder sBuilder = new StringBuilder();
        for(String str: list){
            sBuilder.append(str).append('\n');
        }
        tView.setText(sBuilder);
    }
}
