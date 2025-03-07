package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    Toolbar mtoolbar;
    ViewPager viewPager;
    TabItem mhome,msports,mhealth,mtech,menternain;
    PagerAdapter pageradapter;
    String apikey = "751da5da5ba84a3bbf3fa8d246f41612";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtoolbar=findViewById(R.id.toolbar);
        mhome=findViewById(R.id.tabHome);
        msports=findViewById(R.id.tabSports);
        mhealth=findViewById(R.id.tabHealth);
        mtech=findViewById(R.id.tabTech);
        menternain=findViewById(R.id.tabEntertain);
        viewPager= findViewById(R.id.fragContain);
        tabLayout=findViewById(R.id.tablayout);

        pageradapter=new PagerAdapter(getSupportFragmentManager(),5);
        viewPager.setAdapter(pageradapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4){
                    pageradapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}