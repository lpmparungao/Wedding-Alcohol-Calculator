package com.example.wac_wdp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class GownActivity extends AppCompatActivity implements View.OnClickListener{

    public CardView card1, card2, card3, card4, card5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gown);

        final TextView changing_option1 = findViewById(R.id.card_text_1);
        final TextView changing_option2 = findViewById(R.id.card_text_2);
        final TextView changing_option3 = findViewById(R.id.card_text_3);
        final TextView changing_option4 = findViewById(R.id.card_text_4);
        final TextView changing_option5 = findViewById(R.id.card_text_5);

        final ImageView changing_image1 = findViewById(R.id.gown_image1);
        final ImageView changing_image2 = findViewById(R.id.gown_image2);
        final ImageView changing_image3 = findViewById(R.id.gown_image3);
        final ImageView changing_image4 = findViewById(R.id.gown_image4);
        final ImageView changing_image5 = findViewById(R.id.gown_image5);

        card1 = findViewById(R.id.card_1);
        card2 = findViewById(R.id.card_2);
        card3 = findViewById(R.id.card_3);
        card4 = findViewById(R.id.card_4);
        card5 = findViewById(R.id.card_5);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);

        String body_choice = getIntent().getStringExtra("choice_body");

        switch (body_choice){
            case "first":
                changing_option1.setText(getString(R.string.rectangle_gown_option1));
                changing_image1.setImageResource(R.drawable.gown_aline);
                changing_option2.setText(getString(R.string.rectangle_gown_option2));
                changing_image2.setImageResource(R.drawable.gown_empire);
                changing_option3.setText(getString(R.string.rectangle_gown_option3));
                changing_image3.setImageResource(R.drawable.gown_mermaid);
                changing_option4.setText(getString(R.string.rectangle_gown_option4));
                changing_image4.setImageResource(R.drawable.gown_sheath);
                changing_option5.setText(getString(R.string.rectangle_gown_option5));
                changing_image5.setImageResource(R.drawable.gown_ballgown);
                break;

            case "second":
                changing_option1.setText(getString(R.string.triangle_gown_option1));
                changing_image1.setImageResource(R.drawable.gown_aline);
                changing_option2.setText(getString(R.string.triangle_gown_option2));
                changing_image2.setImageResource(R.drawable.gown_empire);
                changing_option3.setText(getString(R.string.triangle_gown_option3));
                changing_image3.setImageResource(R.drawable.gown_ballgown);
                changing_option4.setText(getString(R.string.triangle_gown_option4));
                changing_image4.setImageResource(R.drawable.gown_mermaid);
                changing_option5.setText(getString(R.string.triangle_gown_option5));
                changing_image5.setImageResource(R.drawable.gown_sheath);
                break;
            case "third":
                changing_option1.setText(getString(R.string.round_gown_option1));
                changing_image1.setImageResource(R.drawable.gown_ballgown);
                changing_option2.setText(getString(R.string.round_gown_option2));
                changing_image2.setImageResource(R.drawable.gown_aline);
                changing_option3.setText(getString(R.string.round_gown_option3));
                changing_image3.setImageResource(R.drawable.gown_mermaid);
                changing_option4.setText(getString(R.string.round_gown_option4));
                changing_image4.setImageResource(R.drawable.gown_sheath);
                changing_option5.setText(getString(R.string.round_gown_option5));
                changing_image5.setImageResource(R.drawable.gown_empire);
                break;
            case "fourth":
                changing_option1.setText(getString(R.string.inverted_gown_option1));
                changing_image1.setImageResource(R.drawable.gown_ballgown);
                changing_option2.setText(getString(R.string.inverted_gown_option2));
                changing_image2.setImageResource(R.drawable.gown_mermaid);
                changing_option3.setText(getString(R.string.inverted_gown_option3));
                changing_image3.setImageResource(R.drawable.gown_aline);
                changing_option4.setText(getString(R.string.inverted_gown_option4));
                changing_image4.setImageResource(R.drawable.gown_sheath);
                changing_option5.setText(getString(R.string.inverted_gown_option5));
                changing_image5.setImageResource(R.drawable.gown_empire);
                break;
            case "fifth":
                changing_option1.setText(getString(R.string.hourglass_gown_option1));
                changing_image1.setImageResource(R.drawable.gown_ballgown);
                changing_option2.setText(getString(R.string.hourglass_gown_option2));
                changing_image2.setImageResource(R.drawable.gown_mermaid);
                changing_option3.setText(getString(R.string.hourglass_gown_option3));
                changing_image3.setImageResource(R.drawable.gown_sheath);
                changing_option4.setText(getString(R.string.hourglass_gown_option4));
                changing_image4.setImageResource(R.drawable.gown_aline);
                changing_option5.setText(getString(R.string.hourglass_gown_option5));
                changing_image5.setImageResource(R.drawable.gown_empire);
                break;
        }

    }

    @Override
    public void onClick(View view) {

        Intent i;
        int id = view.getId();
        String gown_choice;
        String body_choice = getIntent().getStringExtra("choice_body");

        if (id == R.id.card_1){
            gown_choice = "first";
            i = new Intent(this,NecklineActivity.class);
            i.putExtra("choice_body", body_choice);
            i.putExtra("choice_gown", gown_choice);
            startActivity(i);
        }
        else if (id == R.id.card_2){
            gown_choice = "second";
            i = new Intent(this,NecklineActivity.class);
            i.putExtra("choice_body", body_choice);
            i.putExtra("choice_gown", gown_choice);
            startActivity(i);
        }
        else if (id == R.id.card_3){
            gown_choice = "third";
            i = new Intent(this,NecklineActivity.class);
            i.putExtra("choice_body", body_choice);
            i.putExtra("choice_gown", gown_choice);
            startActivity(i);
        }
        else if (id == R.id.card_4){
            gown_choice = "fourth";
            i = new Intent(this,NecklineActivity.class);
            i.putExtra("choice_body", body_choice);
            i.putExtra("choice_gown", gown_choice);
            startActivity(i);
        }
        else if (id == R.id.card_5){
            gown_choice = "fifth";
            i = new Intent(this,NecklineActivity.class);
            i.putExtra("choice_body", body_choice);
            i.putExtra("choice_gown", gown_choice);
            startActivity(i);
        }

    }
}