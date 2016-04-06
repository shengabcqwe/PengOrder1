package com.example.shenpeng.pengorder;


import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shenpeng on 3/31/16.
 */
public class Seclect extends FragmentActivity {
    private ViewPager viewPager;
    private PagerTitleStrip title;
    private List<String> titleList;
    private List<android.support.v4.app.Fragment> fragList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_present);


        fragList =new ArrayList<android.support.v4.app.Fragment>();
        fragList.add(new fragment1());
        fragList.add(new fragment2());
        fragList.add(new fragment3());

        titleList =new ArrayList<String>();
        titleList.add("开始点餐");
        titleList.add("已点餐品");
        titleList.add("消费历史");

        title=(PagerTitleStrip)findViewById(R.id.title);
        title.setBackgroundColor(Color.GREEN);
        title.setTextColor(Color.RED);

        viewPager=(ViewPager)findViewById(R.id.pager);

        MyFragmentPagerAdapter adapter=new MyFragmentPagerAdapter(getSupportFragmentManager(),fragList,titleList);
        viewPager.setAdapter(adapter);
    }


}
