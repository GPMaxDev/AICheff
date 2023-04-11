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
    //private StringBuilder resultingRequestStringBuilder = new StringBuilder();//pozje разделить обьявление и инициализацию


    Button okButton, cancelButton, speechButton, searchButton;

    RadioGroup yesNoBuyingRadioGroup, selectTypeOfDishRadioGroup;

    RadioButton firstCourseRadioButton, mainCourseRadioButton,
            dessertRadioButton, anyDishRadioButton, yesRadioButton, noRadioButton;

    TextView inputIngredientsTextView, resultInputInTextView, listOfProductsTextView; /// ????


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         //manual input text
        inputIngredientsTextView = findViewById(R.id.editTextTextMultiLine);
        resultInputInTextView = findViewById(R.id.inputResultTextView);
        listOfProductsTextView = findViewById(R.id.listOfProductsTextView);
        //buttons
        searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(this::onClick);

        okButton = findViewById(R.id.okButton);
        okButton.setOnClickListener(this::onClick);

        cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(this::onClick);

        speechButton = findViewById(R.id.speechButton);
        speechButton.setOnClickListener(this::onClick);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.okButton:
                saveText();
                break;

            case R.id.cancelButton:
                cancelAddText();
                break;
           /* case R.id.speechButton:
                //speechAddText();
                break;*/ //do later to future features
            case R.id.searchButton:
                searchTextRequest();//dodelat peredachu dannih na druguu activity
                break;
            default:
                break;

        }


    }


    private void saveText(){

        if(inputIngredientsTextView.getText() != ""
                && inputIngredientsTextView.getText() != null){

            resultInputInTextView.setText(R.string.sumProductListHeaderString);
            listOfProductsTextView.setText(inputIngredientsTextView.getText());
            Toast.makeText(getApplicationContext(), R.string.successAddProductsToList,
                    Toast.LENGTH_SHORT).show();

        }
    }


    private void searchTextRequest(){
        //dobavit peredachu dannih na druguu activity cherez intent

        Intent resultIntent = new Intent(MainActivity.this,
                ResultViewActivity.class);
        startActivity(resultIntent);
    }

    private void cancelAddText(){
        inputIngredientsTextView.setText("");
        listOfProductsTextView.setText("");
        resultInputInTextView.setText(R.string.sumProductListHeaderString);

         Toast.makeText(getApplicationContext(), R.string.resetToastText,
                Toast.LENGTH_SHORT).show();
    }
}