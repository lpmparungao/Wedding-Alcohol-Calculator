package com.example.wac_wdp.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.wac_wdp.InputFilterMinMax;
import com.example.wac_wdp.R;

import java.text.DecimalFormat;

public class Beer_Fragment extends Fragment {

    private static String str_guest;
    private static String str_hours;
    String limit;
    CheckBox cb_drinkers;
    EditText et_beer_drinkers, et_cost_of_alcohol_1, et_beer_per_hour;
    TextView tv_number_of_bottle_beer, tv_estimated_cost_beer, tv_beer_drinkers;
    String  beer_drinkers_value, cost_of_alcohol_1_value, beer_per_hour_value;
    int int_guest,int_hours;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beer_fragment,container,false);
        cb_drinkers = view.findViewById(R.id.integer_checkbox1);
        tv_beer_drinkers = view.findViewById(R.id.tv_beer_drinkers);
        et_beer_drinkers = view.findViewById(R.id.et_beer_drinkers);
        et_cost_of_alcohol_1 = view.findViewById(R.id.et_cost_of_alcohol_1);
        et_cost_of_alcohol_1.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "1000000")});
        et_beer_per_hour = view.findViewById(R.id.et_bottle_per_person_beer);
        //et_beer_per_hour.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "10")});
        tv_number_of_bottle_beer = view.findViewById(R.id.tv_number_of_bottle_beer);
        tv_estimated_cost_beer = view.findViewById(R.id.tv_estimated_cost_beer);
        inputLimit();
        cb_drinkers.setOnClickListener(view1 -> {
            inputLimit();
            clearInput();
        });
        et_beer_drinkers.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                beer_drinkers_value = et_beer_drinkers.getText().toString();
                inputLimit();
                if(TextUtils.isEmpty(beer_drinkers_value)){
                    beer_drinkers_value = "0";
                    tv_number_of_bottle_beer.setText(R.string.bottle_default_value);
                    tv_estimated_cost_beer.setText(R.string.default_value);
                    calculateBeer();
                }
                else if(TextUtils.isEmpty(cost_of_alcohol_1_value)){
                    tv_estimated_cost_beer.setText(R.string.default_value);
                    calculateBeerBottle();
                }
                else {
                    calculateBeer();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        et_cost_of_alcohol_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cost_of_alcohol_1_value = et_cost_of_alcohol_1.getText().toString();
                if (TextUtils.isEmpty(beer_drinkers_value) && TextUtils.isEmpty(cost_of_alcohol_1_value)&& TextUtils.isEmpty(beer_per_hour_value)){
                    cost_of_alcohol_1_value = "0";
                    calculateBeer();
                }

                else if (TextUtils.isEmpty(cost_of_alcohol_1_value)){
                    cost_of_alcohol_1_value = "0";
                    calculateBeerBottle();
                    calculateBeer();
                }
                else {
                    calculateBeer();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        et_beer_per_hour.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                beer_per_hour_value = et_beer_per_hour.getText().toString();
                if (!TextUtils.isEmpty(beer_per_hour_value)&& Integer.parseInt(beer_per_hour_value) > 10){
                    et_beer_per_hour.setText(R.string.per_hour_limit);
                    et_beer_per_hour.setSelection(et_beer_per_hour.getText().length());
                    beer_per_hour_value = "10";
                }
                if (TextUtils.isEmpty(beer_drinkers_value) && TextUtils.isEmpty(cost_of_alcohol_1_value) && TextUtils.isEmpty(beer_per_hour_value)){
                    beer_per_hour_value = "0";
                    calculateBeer();
                }

                else if (TextUtils.isEmpty(cost_of_alcohol_1_value)){
                    cost_of_alcohol_1_value = "0";
                    calculateBeerBottle();
                    calculateBeer();
                }
                else if (TextUtils.isEmpty(beer_per_hour_value)){
                    beer_per_hour_value = "0";
                    calculateBeer();
                }
                else {
                    calculateBeer();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return view;
    }

    public void inputLimit(){
        if(cb_drinkers.isChecked()){
            tv_beer_drinkers.setText(getString(R.string.beer_drinkers2));
            if(str_guest == null || str_guest.equals("")){
                limit = "0";
            }
            else{
                limit = str_guest;
            }
        }
        else{
            tv_beer_drinkers.setText(getString(R.string.beer_drinkers1));
            if (str_guest == null || str_guest.equals("")){
                limit = "0";
            }
            else{
                limit = "100";
            }
        }
        if (!TextUtils.isEmpty(beer_drinkers_value)&& Integer.parseInt(beer_drinkers_value) > Integer.parseInt(limit)){
            et_beer_drinkers.setText(limit);
            et_beer_drinkers.setSelection(et_beer_drinkers.getText().length());
            beer_drinkers_value = limit;
        }
    }

    public void clearInput(){
        et_beer_drinkers.setText("");
    }

    public void calculateBeer() {
        if(beer_drinkers_value !=null && cost_of_alcohol_1_value !=null && str_guest !=null && str_hours !=null && beer_per_hour_value != null){
            if(!beer_per_hour_value.isEmpty() && !beer_drinkers_value.isEmpty() && !cost_of_alcohol_1_value.isEmpty() && !str_guest.isEmpty() && !str_hours.isEmpty()){
                int_guest = Integer.parseInt(str_guest);
                int_hours = Integer.parseInt(str_hours);
                int beer_drinkers = Integer.parseInt(beer_drinkers_value);
                int beer_cost = Integer.parseInt(cost_of_alcohol_1_value);
                int beer_per_hour = Integer.parseInt(beer_per_hour_value);
                double beerDrinkers;
                double beer_answer;
                double beer_to_buy;
                int int_beer;
                if (cb_drinkers.isChecked()){
                    beerDrinkers = beer_drinkers;
                }
                else{
                    beerDrinkers = (beer_drinkers / 100d) * int_guest;
                }
                beer_answer = (((beerDrinkers * int_hours) * beer_per_hour) * beer_cost);
                beer_to_buy = Math.ceil(beerDrinkers * beer_per_hour * int_hours);
                int_beer = (int) beer_to_buy;
                String estimated_beer_cost = String.valueOf(beer_answer);
                String beer_bottles = String.valueOf(int_beer);
                double result_double = Double.parseDouble(estimated_beer_cost);
                DecimalFormat df = new DecimalFormat("#,###");
                String result_beer = df.format(result_double);
                tv_number_of_bottle_beer.setText(beer_bottles);
                tv_estimated_cost_beer.setText("₱ " + result_beer);
                if (fragmentListener != null)fragmentListener.past_cost_of_alcohol_1_value(beer_answer);
            }
            else {
                tv_estimated_cost_beer.setText(R.string.default_value);
            }
        }
    }

    public void calculateBeerBottle() {
        if(beer_drinkers_value !=null && str_guest !=null && str_hours!=null && beer_per_hour_value != null){
            if(!beer_per_hour_value.isEmpty() && !beer_drinkers_value.isEmpty() && !str_guest.isEmpty() && !str_hours.isEmpty()){
                int_guest = Integer.parseInt(str_guest);
                int_hours = Integer.parseInt(str_hours);
                int beer_drinkers = Integer.parseInt(beer_drinkers_value);
                int beer_per_hour = Integer.parseInt(beer_per_hour_value);
                double beerDrinkers;
                double beer_to_buy;
                int int_beer;
                if (cb_drinkers.isChecked()){
                    beerDrinkers = beer_drinkers;
                }
                else{
                    beerDrinkers = (beer_drinkers / 100d) * int_guest;
                }
                beer_to_buy = Math.ceil(beerDrinkers * beer_per_hour * int_hours);
                int_beer = (int) beer_to_buy;
                String beer_bottles = String.valueOf(int_beer);
                tv_number_of_bottle_beer.setText(beer_bottles);
            }
            else {
                tv_estimated_cost_beer.setText(R.string.default_value);
                tv_number_of_bottle_beer.setText(R.string.bottle_default_value);
            }
        }
    }

    public static void passValues(String guest, String hours) {
        str_guest = guest;
        str_hours = hours;
    }

    private FragmentListener fragmentListener;

    public interface FragmentListener {
        void past_cost_of_alcohol_1_value(double beer_answer);
    }

    public void setFragmentListener(FragmentListener fragmentListener) {
        this.fragmentListener = fragmentListener;
    }
}