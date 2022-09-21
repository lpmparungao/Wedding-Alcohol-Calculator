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

public class Wine_Fragment extends Fragment {

    private static String str_guest;
    private static String str_hours;
    String limit;
    CheckBox cb_drinkers;
    EditText et_wine_drinkers, et_cost_of_alcohol_2, et_wine_per_hour;
    TextView tv_number_of_bottle_wine, tv_estimated_cost_wine, tv_wine_drinkers;
    String  wine_drinkers_value, cost_of_alcohol_2_value, wine_per_hour_value;
    int int_guest,int_hours;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wine_fragment,container,false);
        cb_drinkers = view.findViewById(R.id.integer_checkbox2);
        tv_wine_drinkers = view.findViewById(R.id.tv_wine_drinkers);
        et_wine_drinkers = view.findViewById(R.id.et_wine_drinkers);
        //et_wine_drinkers.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "100")});
        et_cost_of_alcohol_2 = view.findViewById(R.id.et_cost_of_alcohol_2);
        et_cost_of_alcohol_2.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "1000000")});
        et_wine_per_hour = view.findViewById(R.id.et_glass_per_person_wine);
        //et_wine_per_hour.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "10")});
        tv_number_of_bottle_wine = view.findViewById(R.id.tv_number_of_bottle_wine);
        tv_estimated_cost_wine = view.findViewById(R.id.tv_estimated_cost_wine);
        inputLimit();
        cb_drinkers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLimit();
                clearInput();
            }
        });
        et_wine_drinkers.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                wine_drinkers_value = et_wine_drinkers.getText().toString();
                inputLimit();
                if(TextUtils.isEmpty(wine_drinkers_value)){
                    wine_drinkers_value = "0";
                    tv_number_of_bottle_wine.setText(R.string.bottle_default_value);
                    tv_estimated_cost_wine.setText(R.string.default_value);
                    calculateWine();
                }
                else if(TextUtils.isEmpty(cost_of_alcohol_2_value)){
                    tv_estimated_cost_wine.setText(R.string.default_value);
                    calculateWineBottle();
                }
                else {
                    calculateWine();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        et_cost_of_alcohol_2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cost_of_alcohol_2_value = et_cost_of_alcohol_2.getText().toString();
                if (TextUtils.isEmpty(wine_drinkers_value) && TextUtils.isEmpty(cost_of_alcohol_2_value) && TextUtils.isEmpty(wine_per_hour_value)){
                    cost_of_alcohol_2_value = "0";
                    calculateWine();
                }

                else if (TextUtils.isEmpty(cost_of_alcohol_2_value)){
                    cost_of_alcohol_2_value = "0";
                    calculateWineBottle();
                    calculateWine();
                }
                else {
                    calculateWine();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        et_wine_per_hour.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                wine_per_hour_value = et_wine_per_hour.getText().toString();
                if (!TextUtils.isEmpty(wine_per_hour_value)&& Integer.parseInt(wine_per_hour_value) > 10){
                    et_wine_per_hour.setText(R.string.per_hour_limit);
                    et_wine_per_hour.setSelection(et_wine_per_hour.getText().length());
                    wine_per_hour_value = "10";
                }
                if (TextUtils.isEmpty(wine_drinkers_value) && TextUtils.isEmpty(cost_of_alcohol_2_value) && TextUtils.isEmpty(wine_per_hour_value)){
                    wine_per_hour_value = "0";
                    calculateWine();
                }

                else if (TextUtils.isEmpty(cost_of_alcohol_2_value)){
                    cost_of_alcohol_2_value = "0";
                    calculateWineBottle();
                    calculateWine();
                }
                else if (TextUtils.isEmpty(wine_per_hour_value)){
                    wine_per_hour_value = "0";
                    calculateWine();
                }
                else {
                    calculateWine();
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
            tv_wine_drinkers.setText(getString(R.string.wine_drinkers2));
            if(str_guest == null || str_guest.equals("")){
                limit = "0";
            }
            else{
                limit = str_guest;
            }
        }
        else{
            tv_wine_drinkers.setText(getString(R.string.wine_drinkers1));
            if (str_guest == null || str_guest.equals("")){
                limit = "0";
            }
            else{
                limit = "100";
            }
        }
        if (!TextUtils.isEmpty(wine_drinkers_value)&& Integer.parseInt(wine_drinkers_value) > Integer.parseInt(limit)){
            et_wine_drinkers.setText(limit);
            et_wine_drinkers.setSelection(et_wine_drinkers.getText().length());
            wine_drinkers_value = limit;
        }
    }

    public void clearInput(){
        et_wine_drinkers.setText("");
    }

    public void calculateWine() {
        if(wine_drinkers_value !=null && cost_of_alcohol_2_value !=null && str_guest !=null && str_hours !=null && wine_per_hour_value != null){
            if(!wine_per_hour_value.isEmpty() && !wine_drinkers_value.isEmpty() && !cost_of_alcohol_2_value.isEmpty() && !str_guest.isEmpty() && !str_hours.isEmpty()){
                int_guest = Integer.parseInt(str_guest);
                int_hours = Integer.parseInt(str_hours);
                int wine_drinkers = Integer.parseInt(wine_drinkers_value);
                int wine_cost = Integer.parseInt(cost_of_alcohol_2_value);
                int wine_per_hour = Integer.parseInt(wine_per_hour_value);
                double wineDrinkers;
                double wine_answer;
                double wine_to_buy;
                int int_wine;
                if (cb_drinkers.isChecked()){
                    wineDrinkers = wine_drinkers;
                }
                else{
                    wineDrinkers = (wine_drinkers / 100d) * int_guest;
                }
                wine_answer = ((((wineDrinkers * int_hours) * wine_per_hour)/5) * wine_cost);
                wine_to_buy = Math.ceil((wineDrinkers * wine_per_hour * int_hours)/5);
                int_wine = (int) wine_to_buy;
                String estimated_wine_cost = String.valueOf(wine_answer);
                String wine_bottles = String.valueOf(int_wine);
                double result_double = Double.parseDouble(estimated_wine_cost);
                DecimalFormat df = new DecimalFormat("#,###");
                String result_wine = df.format(result_double);
                tv_number_of_bottle_wine.setText(wine_bottles);
                tv_estimated_cost_wine.setText("₱ " + result_wine);
                if (fragmentListener != null)fragmentListener.past_cost_of_alcohol_2_value(wine_answer);
            }
            else {
                tv_estimated_cost_wine.setText(R.string.default_value);
            }
        }
    }

    public void calculateWineBottle() {
        if(wine_drinkers_value !=null && str_guest !=null && str_hours!=null && wine_per_hour_value != null){
            if(!wine_per_hour_value.isEmpty() && !wine_drinkers_value.isEmpty() && !str_guest.isEmpty() && !str_hours.isEmpty()){
                int_guest = Integer.parseInt(str_guest);
                int_hours = Integer.parseInt(str_hours);
                int wine_drinkers = Integer.parseInt(wine_drinkers_value);
                int wine_per_hour = Integer.parseInt(wine_per_hour_value);
                double wineDrinkers;
                double wine_to_buy;
                int int_wine;
                if (cb_drinkers.isChecked()){
                    wineDrinkers = wine_drinkers;
                }
                else{
                    wineDrinkers = (wine_drinkers / 100d) * int_guest;
                }
                wine_to_buy = Math.ceil((wineDrinkers * wine_per_hour * int_hours)/5);
                int_wine = (int) wine_to_buy;
                String wine_bottles = String.valueOf(int_wine);
                tv_number_of_bottle_wine.setText(wine_bottles);
            }
            else {
                tv_estimated_cost_wine.setText(R.string.default_value);
                tv_number_of_bottle_wine.setText(R.string.bottle_default_value);
            }
        }
    }

    public static void passValues(String guest, String hours) {
        str_guest = guest;
        str_hours = hours;
    }

    private Wine_Fragment.FragmentListener fragmentListener;

    public interface FragmentListener {
        void past_cost_of_alcohol_2_value(double wine_answer);
    }

    public void setFragmentListener(Wine_Fragment.FragmentListener fragmentListener) {
        this.fragmentListener = fragmentListener;
    }
}