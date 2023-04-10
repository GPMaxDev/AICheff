package com.gmail.dev.max.aicheff;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //private String resultingRequestString = "";
    private StringBuilder resultingRequestStringBuilder = new StringBuilder();


    Button okButton, addButton, cancelButton, speechButton, searchButton;

    RadioGroup yesNoBuyingRadioGroup, selectTypeOfDishRadioGroup;

    RadioButton firstCourseRadioButton, mainCourseRadioButton,
            dessertRadioButton, anyDishRadioButton, yesRadioButton, noRadioButton;

    TextView inputIngredientsTextView; /// ????


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         //manual input text
        inputIngredientsTextView = findViewById(R.id.editTextTextMultiLine);
        //buttons
        searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(v -> onClick(v));

        okButton = findViewById(R.id.okButton);
        okButton.setOnClickListener(v -> onClick(v));

        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(v -> onClick(v));

        cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(v -> onClick(v));

        speechButton = findViewById(R.id.speechButton);
        speechButton.setOnClickListener(v -> onClick(v));


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.okButton:
                saveText();
                break;
            case R.id.addButton:
                //addTextToListOfProducts();
                break;

            case R.id.cancelButton:
                cancelAddText();
                break;
            case R.id.speechButton:
                //speechAddText();
                break;
            case R.id.searchButton:
                searchTextRequest();
                break;
            default:
                break;

        }


    }


    private void saveText(){

        if(inputIngredientsTextView.getText() != ""
                && inputIngredientsTextView.getText() != null){

            StringBuilder inputIngredientsTextViewStringBuilder = new StringBuilder();
            inputIngredientsTextViewStringBuilder.append(inputIngredientsTextView.getText());
            System.out.println(inputIngredientsTextView.getText().toString());// dlya testa
            Toast.makeText(getApplicationContext(), inputIngredientsTextView
                            .getText()
                            .toString(),
                    Toast.LENGTH_LONG).show();// dlya testa

        }
    }

    private void searchTextRequest(){
        Intent resultIntent = new Intent(MainActivity.this,
                ResultViewActivity.class);
        startActivity(resultIntent);
    }

    private void cancelAddText(){
        inputIngredientsTextView.setText(R.string.resetToastText);
        Toast.makeText(getApplicationContext(), inputIngredientsTextView
                        .getText()
                        .toString(),
                Toast.LENGTH_LONG).show();// dlya testa



    }

}