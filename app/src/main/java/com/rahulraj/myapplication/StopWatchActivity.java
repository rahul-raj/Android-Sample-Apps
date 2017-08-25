package com.rahulraj.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class StopWatchActivity extends AppCompatActivity {

    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;
    //private String lifecycleText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);
        if(savedInstanceState!=null){
            seconds=savedInstanceState.getInt("seconds");
            running=savedInstanceState.getBoolean("running");
            wasRunning=savedInstanceState.getBoolean("wasRunning");
        }
        //lifecycleText="onCreate()";
        runStopWatch();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("seconds",seconds);
        savedInstanceState.putBoolean("running",running);
        savedInstanceState.putBoolean("wasRunning",wasRunning);
    }

    @Override
    public void onStop(){
        super.onStop();
        wasRunning=running;
        running=false;
        //lifecycleText="onStop()";
    }

    @Override
    public void onStart(){
      super.onStart();
        if(wasRunning){
            running=true;
        }
        //lifecycleText="onStart()";
    }

    @Override
    public void onRestart(){
        super.onRestart();
        //lifecycleText="onRestart()";
    }

    @Override
    public void onPause(){
        super.onPause();
        wasRunning=running;
        running=false;
        //lifecycleText="onPause()";
    }

    @Override
    public void onResume(){
        super.onResume();
        if(wasRunning){
            running=true;
        }
       // lifecycleText="onResume()";
    }

    public void runStopWatch(){
        final Handler handler = new Handler();
        final TextView textView = (TextView) findViewById(R.id.textView4);
       // final TextView lifeCycle = (TextView) findViewById(R.id.textView5);
        handler.post(new Runnable() {
            @Override
            public void run() {

                int hours = seconds/3600;
                int minutes = seconds/60;
                String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                textView.setText(time);
                //lifeCycle.setText(lifecycleText);
                if(running){
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }

    public void onClickStartButton(View view){
        running = true;
    }

    public void onClickStopButton(View view){
        running = false;
    }

    public void onClickResetButton(View view){
        running = false ;
        seconds = 0;
    }
}
