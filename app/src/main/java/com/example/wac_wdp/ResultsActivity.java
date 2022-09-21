package com.example.wac_wdp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import java.text.DecimalFormat;


public class ResultsActivity extends AppCompatActivity {

    TextView cost,beer_bottles,wine_bottles,liquor_bottles,tip;
    String result,beer_to_buy,wine_to_buy,liquor_to_buy,bartender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alcohol_results);

        cost = findViewById(R.id.tv_estimated_cost);
        beer_bottles = findViewById(R.id.tv_number_of_bottle_beer);
        wine_bottles = findViewById(R.id.tv_number_of_bottle_wine);
        liquor_bottles = findViewById(R.id.tv_number_of_bottle_liquor);
        tip = findViewById(R.id.tv_bartender_tip);

        result = getIntent().getStringExtra("result");
        beer_to_buy = getIntent().getStringExtra("beer to buy");
        wine_to_buy = getIntent().getStringExtra("wine to buy");
        liquor_to_buy = getIntent().getStringExtra("liquor to buy");

        double result_double = Double.parseDouble(result);
        DecimalFormat df = new DecimalFormat("#,###.00");
        String result_final = df.format(result_double);

        String est_cost = ("Estimated cost: " + "₱" + result_final);
        String beer_purchase = ("Bottles of beer to purchase: " + beer_to_buy);
        String wine_purchase = ("Bottles of wine to purchase: " + wine_to_buy);
        String liquor_purchase = ("Bottle of liquor to purchase: " + liquor_to_buy);

        cost.setText(est_cost);
        beer_bottles.setText(beer_purchase);
        wine_bottles.setText(wine_purchase);
        liquor_bottles.setText(liquor_purchase);

        double estimated_cost = Integer.parseInt(result);
        double bartender_tip = (estimated_cost*0.2d);
        String tip_final = df.format(bartender_tip);
        String bar_tip = ("Bartender tip: "+ "₱" + tip_final);
        tip.setText(bar_tip);

    }
}