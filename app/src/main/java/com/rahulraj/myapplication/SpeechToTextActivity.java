package com.rahulraj.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;

import java.io.File;

public class SpeechToTextActivity extends AppCompatActivity {
    TextView tView;
    Button button;

    public class SpeechToTextTask extends AsyncTask<String,Integer,String>{

        @Override
        protected String doInBackground(String... params) {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tView.setText("Audio recording started");
                }
            });

            SpeechToText service = new SpeechToText();
            service.setUsernameAndPassword(getString(R.string.username),getString(R.string.password));
            int sampleRate = 16000;
            File audio = new File("src/test/resources/sample1.wav");

            SpeechResults transcript = service.recognize(audio, HttpMediaType.AUDIO_WAV).execute();

            return transcript.toString();
        }

        @Override
        protected void onPostExecute(String result){
            tView.setText(result);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_to_text);
        tView = (TextView) findViewById(R.id.textView9);
        button = (Button) findViewById(R.id.button13);
    }
}
