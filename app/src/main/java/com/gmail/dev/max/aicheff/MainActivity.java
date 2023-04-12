package com.gmail.dev.max.aicheff;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener,
                    RadioGroup.OnCheckedChangeListener {


    private StringBuilder resultingRequestStringBuilder;


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

        //radioGroup
        yesNoBuyingRadioGroup = findViewById(R.id.yesNoRadioGroup);
        yesNoBuyingRadioGroup.setOnCheckedChangeListener(this::onCheckedChanged);

        selectTypeOfDishRadioGroup = findViewById(R.id.selectTypeOfDishRadioGroup);
        selectTypeOfDishRadioGroup.setOnCheckedChangeListener(this::onCheckedChanged);

        //string builder

        resultingRequestStringBuilder = new StringBuilder();


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

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        RadioButton checkedRadioButton = findViewById(i);


        switch (checkedRadioButton.getId()){

            case R.id.yesRadioButton:
                Toast.makeText(getApplicationContext(), "YEs",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.noRadioButton:
                Toast.makeText(getApplicationContext(), "NO",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.firstCourseRadioButton:
                Toast.makeText(getApplicationContext(), "first",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.mainCourseRadioButton:
                Toast.makeText(getApplicationContext(), "Main",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.dessertRadioButton:
                Toast.makeText(getApplicationContext(), "dessert",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.anyDishRadioButton:
                Toast.makeText(getApplicationContext(), "Any",
                        Toast.LENGTH_LONG).show();
                break;
            default:
                break;


        }



    }


    private void saveText(){

        if(inputIngredientsTextView.getText() != ""
                && inputIngredientsTextView.getText() != null){

            resultInputInTextView.setText(R.string.your_product_list);
            listOfProductsTextView.setText(inputIngredientsTextView.getText());
            resultingRequestStringBuilder.setLength(0);
            resultingRequestStringBuilder.append(inputIngredientsTextView.getText());
            Toast.makeText(getApplicationContext(), R.string.success_add_products_to_list,
                    Toast.LENGTH_SHORT).show();

        }
    }
    private void cancelAddText(){
        inputIngredientsTextView.setText("");
        listOfProductsTextView.setText("");

        resultInputInTextView.setText(R.string.your_product_list);

         Toast.makeText(getApplicationContext(), R.string.reset_toast_text,
                Toast.LENGTH_SHORT).show();
    }

    private void searchTextRequest(){

        Intent resultIntent = new Intent(MainActivity.this,
                ResultViewActivity.class);
        resultIntent.putExtra("searchRequest",resultingRequestStringBuilder.toString());
        startActivity(resultIntent);
    }


}