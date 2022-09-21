package com.example.wac_wdp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NecklineActivity extends AppCompatActivity  implements View.OnClickListener{
    public CardView card1, card2, card3, card4, card5, card6, card7, card8, card9, card10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neckline);

        card1 = findViewById(R.id.card_1);
        card2 = findViewById(R.id.card_2);
        card3 = findViewById(R.id.card_3);
        card4 = findViewById(R.id.card_4);
        card5 = findViewById(R.id.card_5);
        card6 = findViewById(R.id.card_6);
        card7 = findViewById(R.id.card_7);
        card8 = findViewById(R.id.card_8);
        card9 = findViewById(R.id.card_9);
        card10 = findViewById(R.id.card_10);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
        card7.setOnClickListener(this);
        card8.setOnClickListener(this);
        card9.setOnClickListener(this);
        card10.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {

        Intent i;
        int id = view.getId();
        String neckline_choice;
        String body_choice = getIntent().getStringExtra("choice_body");
        String gown_choice = getIntent().getStringExtra("choice_gown");

        if (id == R.id.card_1){
            neckline_choice = "first";
            i = new Intent(this,TrainActivity.class);
            i.putExtra("choice_body", body_choice);
            i.putExtra("choice_gown", gown_choice);
            i.putExtra("choice_neckline", neckline_choice);
            startActivity(i);
        }
        else if (id == R.id.card_2){
            neckline_choice = "second";
            i = new Intent(this,TrainActivity.class);
            i.putExtra("choice_body", body_choice);
            i.putExtra("choice_gown", gown_choice);
            i.putExtra("choice_neckline", neckline_choice);
            startActivity(i);
        }
        else if (id == R.id.card_3){
            neckline_choice = "third";
            i = new Intent(this,TrainActivity.class);
            i.putExtra("choice_body", body_choice);
            i.putExtra("choice_gown", gown_choice);
            i.putExtra("choice_neckline", neckline_choice);
            startActivity(i);
        }
        else if (id == R.id.card_4){
            neckline_choice = "fourth";
            i = new Intent(this,TrainActivity.class);
            i.putExtra("choice_body", body_choice);
            i.putExtra("choice_gown", gown_choice);
            i.putExtra("choice_neckline", neckline_choice);
            startActivity(i);
        }
        else if (id == R.id.card_5){
            neckline_choice = "fifth";
            i = new Intent(this,TrainActivity.class);
            i.putExtra("choice_body", body_choice);
            i.putExtra("choice_gown", gown_choice);
            i.putExtra("choice_neckline", neckline_choice);
            startActivity(i);
        }
        else if (id == R.id.card_6){
            neckline_choice = "sixth";
            i = new Intent(this,TrainActivity.class);
            i.putExtra("choice_body", body_choice);
            i.putExtra("choice_gown", gown_choice);
            i.putExtra("choice_neckline", neckline_choice);
            startActivity(i);
        }
        else if (id == R.id.card_7){
            neckline_choice = "seventh";
            i = new Intent(this,TrainActivity.class);
            i.putExtra("choice_body", body_choice);
            i.putExtra("choice_gown", gown_choice);
            i.putExtra("choice_neckline", neckline_choice);
            startActivity(i);
        }
        else if (id == R.id.card_8){
            neckline_choice = "eighth";
            i = new Intent(this,TrainActivity.class);
            i.putExtra("choice_body", body_choice);
            i.putExtra("choice_gown", gown_choice);
            i.putExtra("choice_neckline", neckline_choice);
            startActivity(i);
        }
        else if (id == R.id.card_9){
            neckline_choice = "ninth";
            i = new Intent(this,TrainActivity.class);
            i.putExtra("choice_body", body_choice);
            i.putExtra("choice_gown", gown_choice);
            i.putExtra("choice_neckline", neckline_choice);
            startActivity(i);
        }
        else if (id == R.id.card_10){
            neckline_choice = "tenth";
            i = new Intent(this,TrainActivity.class);
            i.putExtra("choice_body", body_choice);
            i.putExtra("choice_gown", gown_choice);
            i.putExtra("choice_neckline", neckline_choice);
            startActivity(i);
        }
    }
}
