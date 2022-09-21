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

public class Liquor_Fragment extends Fragment {

    private static String str_guest;
    private static String str_hours;
    String limit;
    CheckBox cb_drinkers;
    EditText et_liquor_drinkers, et_cost_of_alcohol_3, et_liquor_per_hour;
    TextView tv_number_of_bottle_liquor, tv_estimated_cost_liquor, tv_liquor_drinkers;
    String  liquor_drinkers_value, cost_of_alcohol_3_value, liquor_per_hour_value;
    int int_guest,int_hours;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_liquor_fragment,container,false);
        cb_drinkers = view.findViewById(R.id.integer_checkbox3);
        tv_liquor_drinkers = view.findViewById(R.id.tv_liquor_drinkers);
        et_liquor_drinkers = view.findViewById(R.id.et_liquor_drinkers);
        //et_liquor_drinkers.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "100")});
        et_cost_of_alcohol_3 = view.findViewById(R.id.et_cost_of_alcohol_3);
        et_cost_of_alcohol_3.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "1000000")});
        et_liquor_per_hour = view.findViewById(R.id.et_glass_per_person_liquor);
        //et_liquor_per_hour.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "10")});
        tv_number_of_bottle_liquor = view.findViewById(R.id.tv_number_of_bottle_liquor);
        tv_estimated_cost_liquor = view.findViewById(R.id.tv_estimated_cost_liquor);
        inputLimit();
        cb_drinkers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLimit();
                clearInput();
            }
        });
        et_liquor_drinkers.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                liquor_drinkers_value = et_liquor_drinkers.getText().toString();
                inputLimit();
                if(TextUtils.isEmpty(liquor_drinkers_value)){
                    liquor_drinkers_value = "0";
                    tv_number_of_bottle_liquor.setText(R.string.bottle_default_value);
                    tv_estimated_cost_liquor.setText(R.string.default_value);
                    calculateLiquor();
                }
                else if(TextUtils.isEmpty(cost_of_alcohol_3_value)){
                    tv_estimated_cost_liquor.setText(R.string.default_value);
                    calculateLiquorBottle();
                }
                else {
                    calculateLiquor();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        et_cost_of_alcohol_3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cost_of_alcohol_3_value = et_cost_of_alcohol_3.getText().toString();
                if (TextUtils.isEmpty(liquor_drinkers_value) && TextUtils.isEmpty(cost_of_alcohol_3_value)&& TextUtils.isEmpty(liquor_per_hour_value)){
                    cost_of_alcohol_3_value = "0";
                    calculateLiquor();
                }

                else if (TextUtils.isEmpty(cost_of_alcohol_3_value)){
                    cost_of_alcohol_3_value = "0";
                    calculateLiquorBottle();
                    calculateLiquor();
                }
                else {
                    calculateLiquor();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        et_liquor_per_hour.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                liquor_per_hour_value = et_liquor_per_hour.getText().toString();
                if (!TextUtils.isEmpty(liquor_per_hour_value)&& Integer.parseInt(liquor_per_hour_value) > 10){
                    et_liquor_per_hour.setText(R.string.per_hour_limit);
                    et_liquor_per_hour.setSelection(et_liquor_per_hour.getText().length());
                    liquor_per_hour_value = "10";
                }
                if (TextUtils.isEmpty(liquor_drinkers_value) && TextUtils.isEmpty(cost_of_alcohol_3_value) && TextUtils.isEmpty(liquor_per_hour_value)){
                    liquor_per_hour_value = "0";
                    calculateLiquor();
                }

                else if (TextUtils.isEmpty(cost_of_alcohol_3_value)){
                    cost_of_alcohol_3_value = "0";
                    calculateLiquorBottle();
                    calculateLiquor();
                }
                else if (TextUtils.isEmpty(liquor_per_hour_value)){
                    liquor_per_hour_value = "0";
                    calculateLiquor();
                }
                else {
                    calculateLiquor();
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
            tv_liquor_drinkers.setText(getString(R.string.liquor_drinkers2));
            if(str_guest == null || str_guest.equals("")){
                limit = "0";
            }
            else{
                limit = str_guest;
            }
        }
        else{
            tv_liquor_drinkers.setText(getString(R.string.liquor_drinkers1));
            if (str_guest == null || str_guest.equals("")){
                limit = "0";
            }
            else{
                limit = "100";
            }
        }
        if (!TextUtils.isEmpty(liquor_drinkers_value)&& Integer.parseInt(liquor_drinkers_value) > Integer.parseInt(limit)){
            et_liquor_drinkers.setText(limit);
            et_liquor_drinkers.setSelection(et_liquor_drinkers.getText().length());
            liquor_drinkers_value = limit;
        }
    }

    public void clearInput(){
        et_liquor_drinkers.setText("");
    }
    public void calculateLiquor() {
        if(liquor_drinkers_value !=null && cost_of_alcohol_3_value != null && str_guest !=null && str_hours !=null && liquor_per_hour_value != null){
            if(!liquor_per_hour_value.isEmpty() && !liquor_drinkers_value.isEmpty() && !cost_of_alcohol_3_value.isEmpty() && !str_guest.isEmpty() && !str_hours.isEmpty()){
                int_guest = Integer.parseInt(str_guest);
                int_hours = Integer.parseInt(str_hours);
                int liquor_drinkers = Integer.parseInt(liquor_drinkers_value);
                int liquor_cost = Integer.parseInt(cost_of_alcohol_3_value);
                int liquor_per_hour = Integer.parseInt(liquor_per_hour_value);
                double liquorDrinkers;
                double liquor_answer;
                double liquor_to_buy;
                int int_liquor;
                if (cb_drinkers.isChecked()){
                    liquorDrinkers = liquor_drinkers;
                }
                else{
                    liquorDrinkers = (liquor_drinkers / 100d) * int_guest;
                }
                liquor_answer = ((((liquorDrinkers * int_hours) * liquor_per_hour)/18) * liquor_cost);
                liquor_to_buy = Math.ceil((liquorDrinkers * liquor_per_hour * int_hours)/18);
                int_liquor = (int) liquor_to_buy;
                String estimated_liquor_cost = String.valueOf(liquor_answer);
                String liquor_bottles = String.valueOf(int_liquor);
                double result_double = Double.parseDouble(estimated_liquor_cost);
                DecimalFormat df = new DecimalFormat("#,###");
                String result_liquor = df.format(result_double);
                tv_number_of_bottle_liquor.setText(liquor_bottles);
                tv_estimated_cost_liquor.setText("₱ " + result_liquor);
                if (fragmentListener != null)fragmentListener.past_cost_of_alcohol_3_value(liquor_answer);
            }
            else {
                tv_estimated_cost_liquor.setText(R.string.default_value);
            }
        }
    }

    public void calculateLiquorBottle() {
        if(liquor_drinkers_value != null && str_guest !=null && str_hours!=null && liquor_per_hour_value != null){
            if (!liquor_per_hour_value.isEmpty() && !liquor_drinkers_value.isEmpty() && !str_guest.isEmpty() && !str_hours.isEmpty()){
                int_guest = Integer.parseInt(str_guest);
                int_hours = Integer.parseInt(str_hours);
                int liquor_drinkers = Integer.parseInt(liquor_drinkers_value);
                int liquor_per_hour = Integer.parseInt(liquor_per_hour_value);
                double liquorDrinkers;
                double liquor_to_buy;
                int int_liquor;
                if (cb_drinkers.isChecked()){
                    liquorDrinkers = liquor_drinkers;
                }
                else{
                    liquorDrinkers = (liquor_drinkers / 100d) * int_guest;
                }
                liquor_to_buy = Math.ceil((liquorDrinkers * liquor_per_hour * int_hours)/18);
                int_liquor = (int) liquor_to_buy;
                String liquor_bottles = String.valueOf(int_liquor);
                tv_number_of_bottle_liquor.setText(liquor_bottles);
            }
            else {
                tv_estimated_cost_liquor.setText(R.string.default_value);
                tv_number_of_bottle_liquor.setText(R.string.default_value);
            }
        }
    }

    public static void passValues(String guest, String hours) {
        str_guest = guest;
        str_hours = hours;
    }

    private Liquor_Fragment.FragmentListener fragmentListener;

    public interface FragmentListener {
        void past_cost_of_alcohol_3_value(double liquor_answer);
    }

    public void setFragmentListener(Liquor_Fragment.FragmentListener fragmentListener) {
        this.fragmentListener = fragmentListener;
    }
}