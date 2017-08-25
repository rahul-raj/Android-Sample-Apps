package com.rahulraj.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ibm.watson.developer_cloud.android.library.audio.StreamPlayer;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;

public class TextToSpeechActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button;
    public class WatsonTask extends AsyncTask<String,Integer,String>{

        @Override
        protected String doInBackground(String... textToSpeak) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textView.setText("Watson is doing work...");
                }
            });

            TextToSpeech textToSpeech = initTextToSpeechService();
            StreamPlayer streamPlayer = new StreamPlayer();
            streamPlayer.playStream(textToSpeech.synthesize(String.valueOf(editText.getText()), Voice.EN_MICHAEL).execute());
            return "work done";
        }

        @Override
        protected void onPostExecute(String result) {
            textView.setText("TTS status: " + result);
        }

        public TextToSpeech initTextToSpeechService(){
           TextToSpeech service = new TextToSpeech();
            service.setUsernameAndPassword(getString(R.string.username),getString(R.string.password));
            return service;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_to_speech);
        textView = (TextView)findViewById(R.id.textView7);
        editText = (EditText) findViewById(R.id.editText3);
        button = (Button)findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(editText.getText());
                WatsonTask task = new WatsonTask();
                task.execute(new String[]{});
            }
        });

    }
}
