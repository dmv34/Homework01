package com.example.drew.homework01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;

public class simpleCalculator extends AppCompatActivity {

    private TextView newValue;
    private EditText value1;
    private EditText value2;
    private Spinner spinOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calculator);
        addOperatorsToSpinner();
    }

    //add operators to spinner
    public void addOperatorsToSpinner(){
        spinOperator = (Spinner) findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("Select Operator");
        list.add("+");
        list.add("-");
        list.add("*");
        list.add("/");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinOperator.setAdapter(dataAdapter);
    }

    public void calculateNewValue(View v){
        value1 = (EditText) findViewById(R.id.textValue1);
        value2 = (EditText) findViewById(R.id.textValue2);
        newValue = (TextView) findViewById(R.id.newValue);

        if(value1.getText().toString() == ""){
            newValue.setText("Set Value 1");
        }

        else if(value2.getText().toString() == ""){
            newValue.setText("Set Value 2");
        }

        else if(spinOperator.getSelectedItem().toString() == "+"){
            float v1 = Float.parseFloat(value1.getText().toString());
            float v2 = Float.parseFloat(value2.getText().toString());
            float newV = v1 + v2;
            newValue.setText(Float.toString(newV));
        }

        else if(spinOperator.getSelectedItem().toString() == "-"){
            float v1 = Float.parseFloat(value1.getText().toString());
            float v2 = Float.parseFloat(value2.getText().toString());
            float newV = v1 - v2;
            newValue.setText(Float.toString(newV));
        }

        else if(spinOperator.getSelectedItem().toString() == "*"){
            float v1 = Float.parseFloat(value1.getText().toString());
            float v2 = Float.parseFloat(value2.getText().toString());
            float newV = v1 * v2;
            newValue.setText(Float.toString(newV));
        }

        else if(spinOperator.getSelectedItem().toString() == "/"){
            float v1 = Float.parseFloat(value1.getText().toString());
            float v2 = Float.parseFloat(value2.getText().toString());
            float newV = v1 / v2;
            newValue.setText(Float.toString(newV));
        }


        else{
            newValue.setText("Select Operator");
        }
    }
}
