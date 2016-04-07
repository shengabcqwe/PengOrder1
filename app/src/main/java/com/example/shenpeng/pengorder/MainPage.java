package com.example.shenpeng.pengorder;

import android.app.Fragment;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shenpeng on 4/7/16.
 */
public class MainPage extends FragmentActivity implements View.OnClickListener {
    private ViewPager mviewPager;
    private FragmentPagerAdapter mAdapter;
    private List<android.support.v4.app.Fragment> mFragmentList;

    private LinearLayout mTab1;
    private LinearLayout mTab2;
    private LinearLayout mTab3;

    private ImageButton mImgBt1;
    private ImageButton mImgBt2;
    private ImageButton mImgBt3;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_present);
        initView();
        initEvent();


    }

    private void initEvent() {
        mTab1.setOnClickListener(this);
        mTab2.setOnClickListener(this);
        mTab3.setOnClickListener(this);
    }
    //初始化(很重要的 掌握适配器)
    private void initView() {
        mviewPager=(ViewPager)findViewById(R.id.pager);

        mTab1=(LinearLayout)findViewById(R.id.diancan);
        mTab1=(LinearLayout)findViewById(R.id.yidian);
        mTab1=(LinearLayout)findViewById(R.id.pingjia);

        mImgBt1=(ImageButton)findViewById(R.id.bt_diancan);
        mImgBt1=(ImageButton)findViewById(R.id.bt_yidian);
        mImgBt1=(ImageButton)findViewById(R.id.bt_pingjia);

        mFragmentList=new ArrayList<android.support.v4.app.Fragment>();
        android.support.v4.app.Fragment mFrg1=new fragment1();
        android.support.v4.app.Fragment mFrg2=new fragment2();
        android.support.v4.app.Fragment mFrg3=new fragment3();
        mFragmentList.add(mFrg1);
        mFragmentList.add(mFrg2);
        mFragmentList.add(mFrg3);

        mAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int arg0) {
                return mFragmentList.get(arg0);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        };
        mviewPager.setAdapter(mAdapter);

        mviewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int currentItem=mviewPager.getCurrentItem();
                setTab(currentItem);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        } );
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.diancan:
             setSelect(0);
             break;
            case R.id.yidian:
                setSelect(1);
                break;
            case R.id.pingjia:
                setSelect(2);
                break;
            default:break;
        }
    }

    private void setSelect(int i) {
        setTab(i);
        mviewPager.setCurrentItem(i);
    }

    private void setTab(int i) {
       resetImgs();
        switch (i){
            case 0:mImgBt1.setImageResource(R.drawable.title1_click);
                break;
            case 1:mImgBt2.setImageResource(R.drawable.title2_click);
                break;
            case 2:mImgBt3.setImageResource(R.drawable.title3_click);
                break;
        }
    }

    private void resetImgs() {
        mImgBt1.setImageResource(R.drawable.title1);
        mImgBt2.setImageResource(R.drawable.title2);
        mImgBt3.setImageResource(R.drawable.title3);
    }
}

