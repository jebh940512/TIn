package com.example.tabs.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.tabs.Fragments.FirstFragment;
import com.example.tabs.Fragments.SecondFragment;
import com.example.tabs.Fragments.ThirdFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {


    private int numberOfTabs;

    public PagerAdapter(FragmentManager fm,int numberOfTabs) {
        super(fm);
        this.numberOfTabs=numberOfTabs;

    }

    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
            case 2:
                return new ThirdFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
