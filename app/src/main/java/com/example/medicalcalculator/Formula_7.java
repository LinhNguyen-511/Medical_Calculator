package com.example.medicalcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import io.github.sidvenu.mathjaxview.MathJaxView;

public class Formula_7 extends MainActivity {
    MathJaxView mathJaxWebView;
    String tex = "$$FE_{Na} = {100 * (Urine Na * Serum Creatine)\\over Serum Na * Urine Creatine} $$";
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formula7);
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
        final EditText SCIn = (EditText) findViewById(R.id.SCIn);
        final EditText SSIn = (EditText) findViewById(R.id.NaIn);
        final EditText UCIn = (EditText) findViewById(R.id.UCIn);
        final EditText USIn = (EditText) findViewById(R.id.USIn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView resultView = findViewById(R.id.result);

                double SC = Double.parseDouble(SCIn.getText().toString());
                double SS = Double.parseDouble(SSIn.getText().toString());
                double UC = Double.parseDouble(UCIn.getText().toString());
                double US = Double.parseDouble(USIn.getText().toString());
                double result = (100 * US * SC) / (SS * UC);
                String stringResult = new Double(result).toString();
                resultView.setText(stringResult);
            }
        });
    }

}
