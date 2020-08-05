package com.example.medicalcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import io.github.sidvenu.mathjaxview.MathJaxView;

public class Formula_10 extends MainActivity {
    MathJaxView mathJaxWebView;
    String tex = "$$BMI = {weight \\over height ^2} $$";
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formula10);
        RelativeLayout rLayout = (RelativeLayout) findViewById(R.id.formula1);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        //remove title from toolbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mathJaxWebView =(MathJaxView)findViewById(R.id.formula1Text);
        mathJaxWebView.getSettings().setJavaScriptEnabled(true);
        mathJaxWebView.setText(tex);
//        LayoutInflater inflater = getLayoutInflater();
//        //RelativeLayout container = (RelativeLayout) findViewById(R.id.formula1);
//        inflater.inflate(R.layout.formula1, null);
        calculate();
    }

    public void calculate() {
        Button button = (Button) findViewById(R.id.button);
        EditText height = (EditText) findViewById(R.id.heightIn);
        EditText weight = (EditText) findViewById(R.id.weightIn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView resultView = findViewById(R.id.result);
                EditText heightIn = (EditText) findViewById(R.id.heightIn);
                EditText weightIn = (EditText) findViewById(R.id.weightIn);
                double height = Double.parseDouble(heightIn.getText().toString());
                double weight = Double.parseDouble(weightIn.getText().toString());
                double result = weight / (height*height);
                String stringResult = new Double(result).toString();
                resultView.setText(stringResult);
            }
        });
    }

}
