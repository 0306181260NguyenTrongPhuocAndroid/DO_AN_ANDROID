package com.example.appphim;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class PagerAdapterCaNhan extends FragmentStatePagerAdapter {

    private int tabsNumber;

    public PagerAdapterCaNhan(@NonNull FragmentManager fm, int behavior, int tabs) {
        super(fm, behavior);
        this.tabsNumber = tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentTrangCaNhan();
            case 1:
                return new FragmentTrangGiaoDich();

            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabsNumber;
    }
}
