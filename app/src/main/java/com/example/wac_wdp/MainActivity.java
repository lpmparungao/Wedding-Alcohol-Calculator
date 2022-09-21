package com.example.wac_wdp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculatorBtn = findViewById(R.id.calculator_btn);
        Button pickerBtn = findViewById(R.id.picker_btn);
        calculatorBtn.setOnClickListener(v -> {
            Intent calculator = new Intent(v.getContext(),CalculatorActivity.class);
            startActivity(calculator);
        });
        pickerBtn.setOnClickListener(v -> {
            Intent picker = new Intent(v.getContext(),PickerActivity.class);
            startActivity(picker);
        });

    }
}