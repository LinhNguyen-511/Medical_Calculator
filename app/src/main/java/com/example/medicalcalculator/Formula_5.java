package com.example.medicalcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import io.github.sidvenu.mathjaxview.MathJaxView;

public class Formula_5 extends MainActivity {
    MathJaxView mathJaxWebView;
    String tex = "$$Creatine clearance = {1000 * Urine creatine * urine volume per 24h \\over Serum creatine}$$";
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formula5);
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
        final EditText UCIn = (EditText) findViewById(R.id.UCIn);
        final EditText UVIn = (EditText) findViewById(R.id.UVIn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView resultView = findViewById(R.id.result);

                double SC = Double.parseDouble(SCIn.getText().toString());
                double UC = Double.parseDouble(UCIn.getText().toString());
                double UV = Double.parseDouble(UVIn.getText().toString());
                double result = 1000 * UC * UV / SC;
                String stringResult = new Double(result).toString();
                resultView.setText(stringResult);
            }
        });
    }

}
