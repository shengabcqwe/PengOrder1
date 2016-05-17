package com.example.shenpeng.pengorder;

import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by shenpeng on 3/31/16.
 */
public class fragment3 extends android.support.v4.app.Fragment implements View.OnClickListener {
    private List<Menu> valueList=new ArrayList<Menu>();
    private valueAdapter valueAdapter;
    private  FoodDatabaseHelper helper2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.page3,container,false);
        initshopcart();
        ListView listView=(ListView)view.findViewById(R.id.value_listview);
        valueAdapter=new valueAdapter(getContext(),R.layout.value_item,valueList);
        listView.setAdapter(valueAdapter);
        valueAdapter.setValueButton(this);
        return view;
    }


    private void initshopcart() {
        Menu menu=new Menu("西瓜汁",R.drawable.xiguazhi,2);
        if (!valueList.contains(menu)){
        valueList.add(menu);}
        }

    @Override
    public void onClick(View view) {
        Object tag = view.getTag();
        switch (view.getId()) {case R.id.value_button:
            showToast();
            if (tag != null && tag instanceof Integer) {
                int position = (Integer) tag;

            }

        }

    }

    private void showToast() {
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.thumb);
        builder.setTitle("您的评价是对我们最大的支持!");
        builder.setView(R.layout.toast);
        builder.setPositiveButton("提交评价", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                View view=new View(getContext());
                Object tag=view.getTag();
                if (tag != null && tag instanceof Integer) {
                    int position = (Integer) tag;
                    LinearLayout layout=(LinearLayout)getLayoutInflater(new Bundle()).inflate(R.layout.toast,null);
                    EditText editText=(EditText)layout.findViewById(R.id.value_edit);
                    String point=editText.getText().toString();
                    int value=Integer.valueOf(point).intValue();
                    valueList.get(position).setScore(value);
                    //更新adapter的数据
                    valueAdapter.notifyDataSetChanged();
                }
            }
        });
        builder.setNegativeButton("暂不评价",null);
        builder.create().show();
        valueAdapter.notifyDataSetChanged();
    }
}
