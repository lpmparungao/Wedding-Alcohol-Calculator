package com.example.wac_wdp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.wac_wdp.fragments.Beer_Fragment;
import com.example.wac_wdp.fragments.Liquor_Fragment;
import com.example.wac_wdp.fragments.Wine_Fragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.text.DecimalFormat;

public class CalculatorActivity extends AppCompatActivity {
    Calc_Adapter calc_Adapter;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    Beer_Fragment beer_fragment = new Beer_Fragment();
    Liquor_Fragment liquor_fragment = new Liquor_Fragment();
    Wine_Fragment wine_fragment = new Wine_Fragment();

    private final String[] titles= new String[]{"BEER","WINE","LIQUOR"};

    EditText guest_num,dur_hours;
    TextView tv_bartender_tip,tv_estimated_cost,tv_bartender_tip_result,tv_estimated_cost_result;
    String guest,hours,answer,alcohol_1,alcohol_2,alcohol_3;
    double activity_cost_of_alcohol_1_value,activity_cost_of_alcohol_2_value,activity_cost_of_alcohol_3_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alcohol_calculator);

        guest_num = findViewById(R.id.et_guest_num);
        dur_hours = findViewById(R.id.et_hours);
        tv_estimated_cost = findViewById(R.id.tv_estimated_cost);
        tv_bartender_tip = findViewById(R.id.tv_bartender_tip);
        tv_estimated_cost_result = findViewById(R.id.tv_estimated_cost_result);
        tv_bartender_tip_result = findViewById(R.id.tv_bartender_tip_result);

        viewPager2 = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        calc_Adapter = new Calc_Adapter(this,beer_fragment,liquor_fragment,wine_fragment);

        viewPager2.setAdapter(calc_Adapter);
        new TabLayoutMediator(tabLayout,viewPager2,((tab, position) -> tab.setText(titles[position]))).attach();

        guest_num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                guest = guest_num.getText().toString();
                transferValue();
                updateCalculation();
                calculateTotal();
                if (beer_fragment.isVisible()){
                    beer_fragment.clearInput();
                }
                else if (wine_fragment.isVisible()){
                    wine_fragment.clearInput();
                }
                else if (liquor_fragment.isVisible()){
                    liquor_fragment.clearInput();
                }
                if (guest.isEmpty()){
                    tv_estimated_cost_result.setText(R.string.default_value);
                    tv_bartender_tip_result.setText(R.string.default_value);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        dur_hours.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                hours = dur_hours.getText().toString();
                transferValue();
                updateCalculation();
                calculateTotal();
                if (hours.isEmpty()){
                    tv_estimated_cost_result.setText(R.string.default_value);
                    tv_bartender_tip_result.setText(R.string.default_value);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        beer_fragment.setFragmentListener(beer_answer -> {
            activity_cost_of_alcohol_1_value = beer_answer;
            calculateTotal();
        });

        wine_fragment.setFragmentListener(wine_answer -> {
            activity_cost_of_alcohol_2_value = wine_answer;
            calculateTotal();
        });

        liquor_fragment.setFragmentListener(liquor_answer -> {
            activity_cost_of_alcohol_3_value = liquor_answer;
            calculateTotal();
        });


    }

    public void calculateTotal() {
        alcohol_1 = String.valueOf(activity_cost_of_alcohol_1_value);
        alcohol_2 = String.valueOf(activity_cost_of_alcohol_2_value);
        alcohol_3 = String.valueOf(activity_cost_of_alcohol_3_value);
        if (alcohol_1 !=null && alcohol_2 !=null && alcohol_3 !=null){
            if (!alcohol_1.isEmpty() && !alcohol_2.isEmpty() && !alcohol_3.isEmpty()) {
                int beer_cost = (int) activity_cost_of_alcohol_1_value;
                int wine_cost = (int) activity_cost_of_alcohol_2_value;
                int liquor_cost = (int) activity_cost_of_alcohol_3_value;
                int final_answer = beer_cost + wine_cost + liquor_cost;
                if (final_answer > 0) {
                    answer = String.valueOf(final_answer);
                    double result_double = Double.parseDouble(answer);
                    DecimalFormat df = new DecimalFormat("#,###");
                    String result_final = df.format(result_double);
                    String result = ("₱ " + result_final);
                    tv_estimated_cost_result.setText(result);
                    double bartender_tip = (final_answer * 0.2d);
                    String tip_final = df.format(bartender_tip);
                    String bar_tip = ("₱ " + tip_final);
                    tv_bartender_tip_result.setText(bar_tip);
                }
                else {
                    tv_estimated_cost_result.setText(R.string.default_value);
                    tv_bartender_tip_result.setText(R.string.default_value);
                }
            }
        }
    }

    private void transferValue() {
        Beer_Fragment.passValues(guest,hours);
        Wine_Fragment.passValues(guest,hours);
        Liquor_Fragment.passValues(guest,hours);
    }

    private void updateCalculation() {
        beer_fragment.calculateBeer();
        beer_fragment.calculateBeerBottle();
        wine_fragment.calculateWine();
        wine_fragment.calculateWineBottle();
        liquor_fragment.calculateLiquor();
        liquor_fragment.calculateLiquorBottle();
    }

}
