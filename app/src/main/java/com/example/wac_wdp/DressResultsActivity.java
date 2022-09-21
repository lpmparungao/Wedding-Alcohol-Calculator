package com.example.wac_wdp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DressResultsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dress_results);

        Button btn = findViewById(R.id.results_btn);
        btn.setOnClickListener(v -> {
            Intent main = new Intent(v.getContext(),MainActivity.class);
            startActivity(main);
        });

        String body_choice = getIntent().getStringExtra("choice_body");
        String gown_choice = getIntent().getStringExtra("choice_gown");
        String neckline_choice = getIntent().getStringExtra("choice_neckline");
        String train_choice = getIntent().getStringExtra("choice_train");

        final TextView result_body = findViewById(R.id.textView2);
        final TextView result_gown = findViewById(R.id.textView3);
        final TextView result_neckline = findViewById(R.id.textView4);
        final TextView result_train = findViewById(R.id.textView5);

        final ImageView changing_image1 = findViewById(R.id.results_image1);
        final ImageView changing_image2 = findViewById(R.id.results_image2);
        final ImageView changing_image3 = findViewById(R.id.results_image3);
        final ImageView changing_image4 = findViewById(R.id.results_image4);

        switch (body_choice) {
            case "first":
                result_body.setText(getString(R.string.body_option1));
                changing_image1.setImageResource(R.drawable.body_rectangle);
                switch (gown_choice) {
                    case "first":
                        result_gown.setText(getString(R.string.rectangle_results_gown_option1));
                        changing_image2.setImageResource(R.drawable.gown_aline);
                        break;
                    case "second":
                        result_gown.setText(getString(R.string.rectangle_results_gown_option2));
                        changing_image2.setImageResource(R.drawable.gown_empire);
                        break;
                    case "third":
                        result_gown.setText(getString(R.string.rectangle_results_gown_option3));
                        changing_image2.setImageResource(R.drawable.gown_mermaid);
                        break;
                    case "fourth":
                        result_gown.setText(getString(R.string.rectangle_results_gown_option4));
                        changing_image2.setImageResource(R.drawable.gown_sheath);
                        break;
                    case "fifth":
                        result_gown.setText(getString(R.string.rectangle_results_gown_option5));
                        changing_image2.setImageResource(R.drawable.gown_ballgown);
                        break;
                }
                break;
            case "second":
                result_body.setText(getString(R.string.body_option2));
                changing_image1.setImageResource(R.drawable.body_triangle);
                switch (gown_choice) {
                    case "first":
                        result_gown.setText(getString(R.string.triangle_results_gown_option1));
                        changing_image2.setImageResource(R.drawable.gown_aline);
                        break;
                    case "second":
                        result_gown.setText(getString(R.string.triangle_results_gown_option2));
                        changing_image2.setImageResource(R.drawable.gown_empire);
                        break;
                    case "third":
                        result_gown.setText(getString(R.string.triangle_results_gown_option3));
                        changing_image2.setImageResource(R.drawable.gown_ballgown);
                        break;
                    case "fourth":
                        result_gown.setText(getString(R.string.triangle_results_gown_option4));
                        changing_image2.setImageResource(R.drawable.gown_mermaid);
                        break;
                    case "fifth":
                        result_gown.setText(getString(R.string.triangle_results_gown_option5));
                        changing_image2.setImageResource(R.drawable.gown_sheath);
                        break;
                }
                break;
            case "third":
                result_body.setText(getString(R.string.body_option3));
                changing_image1.setImageResource(R.drawable.body_round);
                switch (gown_choice) {
                    case "first":
                        result_gown.setText(getString(R.string.round_results_gown_option1));
                        changing_image2.setImageResource(R.drawable.gown_sheath);
                        break;
                    case "second":
                        result_gown.setText(getString(R.string.round_results_gown_option2));
                        changing_image2.setImageResource(R.drawable.gown_sheath);
                        break;
                    case "third":
                        result_gown.setText(getString(R.string.round_results_gown_option3));
                        changing_image2.setImageResource(R.drawable.gown_sheath);
                        break;
                    case "fourth":
                        result_gown.setText(getString(R.string.round_results_gown_option4));
                        changing_image2.setImageResource(R.drawable.gown_sheath);
                        break;
                    case "fifth":
                        result_gown.setText(getString(R.string.round_results_gown_option5));
                        changing_image2.setImageResource(R.drawable.gown_sheath);
                        break;
                }
                break;
            case "fourth":
                result_body.setText(getString(R.string.body_option4));
                changing_image1.setImageResource(R.drawable.body_inverted);
                switch (gown_choice) {
                    case "first":
                        result_gown.setText(getString(R.string.inverted_results_gown_option1));
                        changing_image2.setImageResource(R.drawable.gown_sheath);
                        break;
                    case "second":
                        result_gown.setText(getString(R.string.inverted_results_gown_option2));
                        changing_image2.setImageResource(R.drawable.gown_sheath);
                        break;
                    case "third":
                        result_gown.setText(getString(R.string.inverted_results_gown_option3));
                        changing_image2.setImageResource(R.drawable.gown_sheath);
                        break;
                    case "fourth":
                        result_gown.setText(getString(R.string.inverted_results_gown_option4));
                        changing_image2.setImageResource(R.drawable.gown_sheath);
                        break;
                    case "fifth":
                        result_gown.setText(getString(R.string.inverted_results_gown_option5));
                        changing_image2.setImageResource(R.drawable.gown_sheath);
                        break;
                }
                break;
            case "fifth":
                result_body.setText(getString(R.string.body_option5));
                changing_image1.setImageResource(R.drawable.body_hourglass);
                switch (gown_choice) {
                    case "first":
                        result_gown.setText(getString(R.string.hourglass_results_gown_option1));
                        changing_image2.setImageResource(R.drawable.gown_sheath);
                        break;
                    case "second":
                        result_gown.setText(getString(R.string.hourglass_results_gown_option2));
                        changing_image2.setImageResource(R.drawable.gown_sheath);
                        break;
                    case "third":
                        result_gown.setText(getString(R.string.hourglass_results_gown_option3));
                        changing_image2.setImageResource(R.drawable.gown_sheath);
                        break;
                    case "fourth":
                        result_gown.setText(getString(R.string.hourglass_results_gown_option4));
                        changing_image2.setImageResource(R.drawable.gown_sheath);
                        break;
                    case "fifth":
                        result_gown.setText(getString(R.string.hourglass_results_gown_option5));
                        changing_image2.setImageResource(R.drawable.gown_sheath);
                        break;
                }
                break;
        }

        switch (neckline_choice) {
            case "first":
                result_neckline.setText(getString(R.string.neckline_option1));
                changing_image3.setImageResource(R.drawable.neckline_sweetheart);
                break;
            case "second":
                result_neckline.setText(getString(R.string.neckline_option2));
                changing_image3.setImageResource(R.drawable.neckline_straightacross);
                break;
            case "third":
                result_neckline.setText(getString(R.string.neckline_option3));
                changing_image3.setImageResource(R.drawable.neckline_assymetric);
                break;
            case "fourth":
                result_neckline.setText(getString(R.string.neckline_option4));
                changing_image3.setImageResource(R.drawable.neckline_semisweetheart);
                break;
            case "fifth":
                result_neckline.setText(getString(R.string.neckline_option5));
                changing_image3.setImageResource(R.drawable.neckline_queenann);
                break;
            case "sixth":
                result_neckline.setText(getString(R.string.neckline_option6));
                changing_image3.setImageResource(R.drawable.neckline_offshoulder);
                break;
            case "seventh":
                result_neckline.setText(getString(R.string.neckline_option7));
                changing_image3.setImageResource(R.drawable.neckline_jewel);
                break;
            case "eighth":
                result_neckline.setText(getString(R.string.neckline_option8));
                changing_image3.setImageResource(R.drawable.neckline_boatneck);
                break;
            case "ninth":
                result_neckline.setText(getString(R.string.neckline_option9));
                changing_image3.setImageResource(R.drawable.neckline_halter);
                break;
            case "tenth":
                result_neckline.setText(getString(R.string.neckline_option10));
                changing_image3.setImageResource(R.drawable.neckline_highneck);
                break;
        }

        switch (train_choice) {
            case "first":
                result_train.setText(getString(R.string.train_option1));
                changing_image4.setImageResource(R.drawable.train_royal);
                break;
            case "second":
                result_train.setText(getString(R.string.train_option2));
                changing_image4.setImageResource(R.drawable.train_cathedral);
                break;
            case "third":
                result_train.setText(getString(R.string.train_option3));
                changing_image4.setImageResource(R.drawable.train_chapel);
                break;
            case "fourth":
                result_train.setText(getString(R.string.train_option4));
                changing_image4.setImageResource(R.drawable.train_court);
                break;
        }
    }
}