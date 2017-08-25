package com.rahulraj.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntitiesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsOptions;

import java.sql.SQLOutput;

public class SentimentActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button;

    public class SentimentAnalysisTask extends AsyncTask<String,Integer,String>{


        @Override
        protected String doInBackground(String... params) {
            //String sentiment;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textView.setText("We are performing watson alchemyAPI");
                }
            });


            NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding(
                    NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27,
                    getString(R.string.username),
                    getString(R.string.password)
            );

            EntitiesOptions entitiesOptions = new EntitiesOptions.Builder()
                    .emotion(true)
                    .sentiment(true)
                    .limit(2)
                    .build();

            KeywordsOptions keywordsOptions = new KeywordsOptions.Builder()
                    .emotion(true)
                    .sentiment(true)
                    .limit(2)
                    .build();

            Features features = new Features.Builder()
                    .entities(entitiesOptions)
                    .keywords(keywordsOptions)
                    .build();

            AnalyzeOptions parameters = new AnalyzeOptions.Builder()
                    .text(editText.getText().toString())
                    .features(features)
                    .build();


            AnalysisResults sentiment = service.analyze(parameters).execute();
            return sentiment.getEntities().toString();
        }

        @Override
        protected void onPostExecute(String result){
            System.out.print(result);
            textView.setText("Sentiment Analysis status: " + result);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentiment);

        textView = (TextView) findViewById(R.id.textView10);
        editText = (EditText) findViewById(R.id.editText4);
        button = (Button) findViewById(R.id.button7);
        textView.setMovementMethod(new ScrollingMovementMethod());
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                textView.setText("Performing sentiment analysis for: "+editText.getText());
                SentimentAnalysisTask sTask = new SentimentAnalysisTask();
                sTask.execute(new String[]{});
            }
        });

    }
}
