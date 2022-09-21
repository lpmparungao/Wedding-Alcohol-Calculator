package com.example.wac_wdp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.wac_wdp.fragments.Beer_Fragment;
import com.example.wac_wdp.fragments.Liquor_Fragment;
import com.example.wac_wdp.fragments.Wine_Fragment;

public class Calc_Adapter extends FragmentStateAdapter
{
    Beer_Fragment beer_fragment;
    Liquor_Fragment liquor_fragment;
    Wine_Fragment wine_fragment;
    public Calc_Adapter(@NonNull FragmentActivity fragmentActivity, Beer_Fragment beer_fragment, Liquor_Fragment liquor_fragment, Wine_Fragment wine_fragment) {
        super(fragmentActivity);
        this.beer_fragment = beer_fragment;
        this.liquor_fragment = liquor_fragment;
        this.wine_fragment = wine_fragment;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return beer_fragment;
            case 1:
                return wine_fragment;
            case 2:
                return liquor_fragment;
        }

        return beer_fragment;

    }

    @Override
    public int getItemCount() {return 3;}
}