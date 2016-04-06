package com.example.shenpeng.pengorder;


import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by shenpeng on 3/31/16.
 */
public class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment>fragList;
    private List<String> titleList;

    public MyFragmentPagerAdapter(android.support.v4.app.FragmentManager fm,List<Fragment>fragList,List<String>titleList){
        super(fm);
        this.fragList=fragList;
        this.titleList=titleList;
    }

    @Override
    public Fragment getItem(int arg0) {
        return fragList.get(arg0);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    @Override
    public int getCount() {
        return fragList.size();
    }
}
