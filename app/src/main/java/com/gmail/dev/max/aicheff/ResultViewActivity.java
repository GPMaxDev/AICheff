package com.gmail.dev.max.aicheff;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultViewActivity extends AppCompatActivity {

    TextView resultTextView;
    ImageView resultImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        resultTextView = findViewById(R.id.resultTextView);
        resultImageView = findViewById(R.id.resultImageView);
    }
}
