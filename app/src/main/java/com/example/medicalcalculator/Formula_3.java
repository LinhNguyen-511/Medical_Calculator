package com.example.medicalcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import io.github.sidvenu.mathjaxview.MathJaxView;

public class Formula_3 extends MainActivity {
    MathJaxView mathJaxWebView;
    String tex = "$$Strong ion difference = {(Na + K + Mg + Ca) - (Cl + Lactate)}$$";
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formula3);
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
        final EditText NaIn = (EditText) findViewById(R.id.NaIn);
        final EditText KIn = (EditText) findViewById(R.id.KIn);
        final EditText MgIn = (EditText) findViewById(R.id.MgIn);
        final EditText CaIn = (EditText) findViewById(R.id.CaIn);
        final EditText ClIn = (EditText) findViewById(R.id.ClIn);
        final EditText LactIn = (EditText) findViewById(R.id.LactIn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView resultView = findViewById(R.id.result);
                double Na = Double.parseDouble(NaIn.getText().toString());
                double K = Double.parseDouble(KIn.getText().toString());
                double Mg = Double.parseDouble(MgIn.getText().toString());
                double Ca = Double.parseDouble(CaIn.getText().toString());
                double Cl = Double.parseDouble(ClIn.getText().toString());
                double Lact = Double.parseDouble(LactIn.getText().toString());

                double result = Na + K + Mg + Ca - Cl - Lact;
                String stringResult = new Double(result).toString();
                resultView.setText(stringResult);
            }
        });
    }

}
