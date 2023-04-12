package com.gmail.dev.max.aicheff;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultViewActivity extends AppCompatActivity {

    TextView resultTextView;
    ImageView resultImageView;

    Intent intent;

    String finalRequestString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);


        resultTextView = findViewById(R.id.resultTextView);
        resultImageView = findViewById(R.id.resultImageView);
        intent = getIntent();
        finalRequestString = intent.getStringExtra("searchRequest");

        resultTextView.setText(finalRequestString);

    }
}
