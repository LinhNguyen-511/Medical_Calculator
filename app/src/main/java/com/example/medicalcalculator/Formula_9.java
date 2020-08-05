package com.example.medicalcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import io.github.sidvenu.mathjaxview.MathJaxView;

public class Formula_9 extends MainActivity {
    MathJaxView mathJaxWebView;
    String tex = "$$Corrected sodium = {Sodium + 2.4*{Glucose \\over 5.55}} $$";
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formula9);
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
        final EditText SSIn = (EditText) findViewById(R.id.NaIn);
        final EditText SGIn = (EditText) findViewById(R.id.GluIn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView resultView = findViewById(R.id.result);

                double SS = Double.parseDouble(SSIn.getText().toString());
                double SG = Double.parseDouble(SGIn.getText().toString());
                double result = SS + (2.4 * (SG / 5.55));
                String stringResult = new Double(result).toString();
                resultView.setText(stringResult);
            }
        });
    }

}
