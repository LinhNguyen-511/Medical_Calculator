package com.example.medicalcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import io.github.sidvenu.mathjaxview.MathJaxView;

public class Formula_8 extends MainActivity {
    MathJaxView mathJaxWebView;
    String tex = "$$FEU = {100 * Urine Urea * Serum Creatine\\over Serum Urea * Urine Creatine} $$";
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formula8);
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
        final EditText SUIn = (EditText) findViewById(R.id.SUIn);
        final EditText UCIn = (EditText) findViewById(R.id.UCIn);
        final EditText UUIn = (EditText) findViewById(R.id.UUIn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView resultView = findViewById(R.id.result);

                double SC = Double.parseDouble(SCIn.getText().toString());
                double SU = Double.parseDouble(SUIn.getText().toString());
                double UC = Double.parseDouble(UCIn.getText().toString());
                double UU = Double.parseDouble(UUIn.getText().toString());
                double result = (100 * UU * SC) / (SU *UC);
                String stringResult = new Double(result).toString();
                resultView.setText(stringResult);
            }
        });
    }

}
