package com.example.appphim;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapterDN_DK extends FragmentPagerAdapter {
    private int tabsNumber;

    public PagerAdapterDN_DK(@NonNull FragmentManager fm, int behavior,int tabs) {
        super(fm, behavior);
        this.tabsNumber = tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new tabDangNhap();
            case 1:
                return new tabDangKy();

            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabsNumber;
    }
}
