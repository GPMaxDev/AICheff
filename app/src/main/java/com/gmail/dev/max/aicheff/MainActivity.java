package com.gmail.dev.max.aicheff;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //private String resultingRequestString = "";
    private StringBuilder resultingRequestStringBuilder = new StringBuilder();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView inputIngredientsTextView = findViewById(R.id.editTextTextMultiLine);

        Button searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(view -> {
            Intent resultIntent = new Intent(MainActivity.this,
                    ResultViewActivity.class);
            startActivity(resultIntent);
        });

        Button okButton = findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(inputIngredientsTextView.getText() != ""
                        && inputIngredientsTextView.getText() != null){

                    StringBuilder inputIngredientsTextViewStringBuilder = new StringBuilder();
                    inputIngredientsTextViewStringBuilder.append(inputIngredientsTextView.getText());
                    System.out.println(inputIngredientsTextView.getText().toString());// dlya testa
                    Toast.makeText(getApplicationContext(), inputIngredientsTextView
                            .getText()
                            .toString(),
                            Toast.LENGTH_SHORT).show();// dlya testa


                }



            }
        });






    }
}