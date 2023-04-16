package com.gmail.dev.max.aicheff;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class ResultViewActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultTextView;
    ImageView resultImageView;

    Button startRequestButton;

    Intent intent;

    String finalRequestString;

    AiRequstSender requstSender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);


        resultTextView = findViewById(R.id.resultTextView);
        resultImageView = findViewById(R.id.resultImageView);
        startRequestButton = findViewById(R.id.startRequestButton);
        requstSender = new AiRequstSender();
        intent = getIntent();
        finalRequestString = intent.getStringExtra("searchRequest");
        startRequestButton.setOnClickListener(this::onClick);
        resultTextView.setText(finalRequestString);

    }


    @Override
    public void onClick(View view) {
        loadAndSetImage(finalRequestString);
    }

    private void loadAndSetImage(String imageRequested){

        System.out.println("search start"); //для теста
        String urlTest = requstSender.getImageUrl(imageRequested);
        System.out.println("search stop"); //для теста
        System.out.println("url: " + urlTest); //для теста

        Picasso.get().load(urlTest) // URL изображения
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        // здесь вы можете использовать загруженное изображение
                        resultImageView.setImageBitmap(bitmap); // установка изображения в ImageView
                    }

                    @Override
                    public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                        // обработка ошибки загрузки изображения
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {
                        // предварительная обработка загрузки изображения
                    }
                });
    }
}
