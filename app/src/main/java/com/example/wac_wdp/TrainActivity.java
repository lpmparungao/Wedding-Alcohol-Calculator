package com.example.wac_wdp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TrainActivity extends AppCompatActivity implements View.OnClickListener{

    public CardView card1, card2, card3, card4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);

        card1 = findViewById(R.id.card_1);
        card2 = findViewById(R.id.card_2);
        card3 = findViewById(R.id.card_3);
        card4 = findViewById(R.id.card_4);


        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent i;
        int id = view.getId();
        String train_choice;
        String body_choice = getIntent().getStringExtra("choice_body");
        String gown_choice = getIntent().getStringExtra("choice_gown");
        String neckline_choice = getIntent().getStringExtra("choice_neckline");

        if (id == R.id.card_1){
            train_choice = "first";
            i = new Intent(this,DressResultsActivity.class);
            i.putExtra("choice_body", body_choice);
            i.putExtra("choice_gown", gown_choice);
            i.putExtra("choice_neckline", neckline_choice);
            i.putExtra("choice_train", train_choice);
            startActivity(i);
        }
        else if (id == R.id.card_2){
            train_choice = "second";
            i = new Intent(this,DressResultsActivity.class);
            i.putExtra("choice_body", body_choice);
            i.putExtra("choice_gown", gown_choice);
            i.putExtra("choice_neckline", neckline_choice);
            i.putExtra("choice_train", train_choice);
            startActivity(i);
        }
        else if (id == R.id.card_3){
            train_choice = "third";
            i = new Intent(this,DressResultsActivity.class);
            i.putExtra("choice_body", body_choice);
            i.putExtra("choice_gown", gown_choice);
            i.putExtra("choice_neckline", neckline_choice);
            i.putExtra("choice_train", train_choice);
            startActivity(i);
        }
        else if (id == R.id.card_4){
            train_choice = "fourth";
            i = new Intent(this,DressResultsActivity.class);
            i.putExtra("choice_body", body_choice);
            i.putExtra("choice_gown", gown_choice);
            i.putExtra("choice_neckline", neckline_choice);
            i.putExtra("choice_train", train_choice);
            startActivity(i);
        }
    }

}