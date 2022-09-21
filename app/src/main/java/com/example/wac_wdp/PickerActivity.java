package com.example.wac_wdp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PickerActivity extends AppCompatActivity implements View.OnClickListener{

    public CardView card1, card2, card3, card4, card5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dress_picker);

        card1 = findViewById(R.id.dress_card_1);
        card2 = findViewById(R.id.dress_card_2);
        card3 = findViewById(R.id.dress_card_3);
        card4 = findViewById(R.id.dress_card_4);
        card5 = findViewById(R.id.dress_card_5);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;
        String body_choice;
        int id = view.getId();

        if (id == R.id.dress_card_1){
            body_choice = "first";
            i = new Intent(this,GownActivity.class);
            i.putExtra("choice_body", body_choice);
            startActivity(i);
        }

        else if (id == R.id.dress_card_2){
            body_choice = "second";
            i = new Intent(this,GownActivity.class);
            i.putExtra("choice_body", body_choice);
            startActivity(i);
        }

        else if (id == R.id.dress_card_3){
            body_choice = "third";
            i = new Intent(this,GownActivity.class);
            i.putExtra("choice_body", body_choice);
            startActivity(i);
        }

        else if (id == R.id.dress_card_4){
            body_choice = "fourth";
            i = new Intent(this,GownActivity.class);
            i.putExtra("choice_body", body_choice);
            startActivity(i);
        }

        else if (id == R.id.dress_card_5){
            body_choice = "fifth";
            i = new Intent(this,GownActivity.class);
            i.putExtra("choice_body", body_choice);
            startActivity(i);
        }

    }
}