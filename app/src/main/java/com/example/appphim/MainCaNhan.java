package com.example.appphim;

import android.os.Bundle;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainCaNhan extends AppCompatActivity {
    private ViewPager pager;
    private TabLayout mTabLayout;
    private PagerAdapterCaNhan adapter;
    TabItem firstItem,secondItem,thirdItem;
    Spinner spinnerkhuvuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_ca_nhan);


        initView();
    }

    private void initView() {

        pager= findViewById(R.id.viewpg);
        mTabLayout = findViewById(R.id.Tabl);

        firstItem = findViewById(R.id.ThongtinTaiKhoan);
        secondItem = findViewById(R.id.ThongTinGiaoDich);

        adapter = new PagerAdapterCaNhan(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,mTabLayout.getTabCount());
        pager.setAdapter(adapter);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    }
}