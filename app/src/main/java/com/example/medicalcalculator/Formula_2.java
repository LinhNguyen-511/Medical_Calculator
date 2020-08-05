package com.example.medicalcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import io.github.sidvenu.mathjaxview.MathJaxView;

public class Formula_2 extends MainActivity {
    MathJaxView mathJaxWebView;
    String tex = "$$Aniongap = {Na^+ + K^+ - Bicarbonade + Cl^- + 0.25 * (40 - Albumin)}$$";
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formula2);
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
        final EditText BicIn = (EditText) findViewById(R.id.BicIn);
        final EditText ClIn = (EditText) findViewById(R.id.ClIn);
        final EditText AlbIn = (EditText) findViewById(R.id.AlbIn);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView resultView = findViewById(R.id.result);
                double Na = Double.parseDouble(NaIn.getText().toString());
                double K = Double.parseDouble(KIn.getText().toString());
                double Bic = Double.parseDouble(BicIn.getText().toString());
                double Cl = Double.parseDouble(ClIn.getText().toString());
                double Alb = Double.parseDouble(AlbIn.getText().toString());
                double result = (Na + K - Bic + Cl) + (0.25 * (40 - Alb));
                String stringResult = new Double(result).toString();
                resultView.setText(stringResult);
            }
        });
    }

}
