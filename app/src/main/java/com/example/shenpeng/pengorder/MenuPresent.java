/**
package com.example.shenpeng.pengorder;


import android.app.Activity;

import android.os.Bundle;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.List;



public class MenuPresent extends Activity implements View.OnClickListener {
    private List<Menu> menuList = new ArrayList<Menu>();
    MenuAdapter adapter = new MenuAdapter(MenuPresent.this, R.layout.menu_item, menuList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1);
        initMenu();
        ListView listView = (ListView) findViewById(R.id.menu);
        listView.setAdapter(adapter);
        adapter.setOnAddNum(this);
        adapter.setOnSubNum(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Menu menu = menuList.get(position);
                Toast.makeText(MenuPresent.this, "您已选择" + menu.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void initMenu() {
        Menu daxia = new Menu("鲜炒大虾", R.drawable.daxia,"56元/份");
        menuList.add(daxia);
        Menu doufu = new Menu("麻婆豆腐", R.drawable.doufu, "18元/份");
        menuList.add(doufu);
        Menu huanggua = new Menu("刀拍黄瓜", R.drawable.huanggua, "16元/份");
        menuList.add(huanggua);
        Menu jidan = new Menu("开胃鸡蛋", R.drawable.jidan, "20元/份");
        menuList.add(jidan);
        Menu jiding = new Menu("宫保鸡丁", R.drawable.jiding, "26元/份");
        menuList.add(jiding);
        Menu jipai = new Menu("碳烤鸡排", R.drawable.jipai, "12元/份");
        menuList.add(jipai);
        Menu niurou = new Menu("小炒牛肉", R.drawable.niurou, "38元/份");
        menuList.add(niurou);
        Menu roupian = new Menu("水煮肉片", R.drawable.roupian, "24元/份");
        menuList.add(roupian);
        Menu shousiji = new Menu("手撕鸡", R.drawable.shousiji, "32元/份");
        menuList.add(shousiji);
        Menu tudousi = new Menu("酸辣土豆丝", R.drawable.tudousi, "15元/份");
        menuList.add(tudousi);
        Menu xiguazhi = new Menu("西瓜汁", R.drawable.xiguazhi, "8元/份");
        menuList.add(xiguazhi);
        Menu pingguozhi = new Menu("苹果汁", R.drawable.pingguo, "8元/份");
        menuList.add(pingguozhi);
        Menu ningmeng = new Menu("柠檬汁", R.drawable.ningmeng, "8元/份");
        menuList.add(ningmeng);
        Menu naicha = new Menu("奶茶", R.drawable.naicha, "8元/份");
        menuList.add(naicha);
        Menu kafei = new Menu("咖啡", R.drawable.kafei, "8元/份");
        menuList.add(kafei);
        Menu yangzhou = new Menu("扬州炒饭", R.drawable.yangzhou, "16元/份");
        menuList.add(yangzhou);
        Menu niurouchaofan = new Menu("牛肉炒饭", R.drawable.niurouchaofan, "16元/份");
        menuList.add(niurouchaofan);
    }




    public void onClick(View view) {
        //这行不懂
        Object tag = view.getTag();
        switch (view.getId()) {
            case R.id.menu_add:
                if (tag != null && tag instanceof Integer) {
                    int position = (Integer) tag;
                    int num = menuList.get(position).getnumber();
                    num++;
                    menuList.get(position).setNumber(num);
                    //这行语句不懂
                    adapter.notifyDataSetChanged();
                }
                break;
            case R.id.menu_sub: //点击减少数量按钮 ，执行相应的处理
                // 获取 Adapter 中设置的 Tag
                if (tag != null && tag instanceof Integer) {
                    int position = (Integer) tag;
                    //更改集合的数据
                    int num = menuList.get(position).getnumber();
                    if (num > 0) {
                        num--;
                        menuList.get(position).setNumber(num);
                        adapter.notifyDataSetChanged();
                    }
                }
                break;

        }
    }}

/**
public class MenuPresent extends  Activity{
    private List<Menu> menuList=new ArrayList<Menu>();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_present);
        initMenu();
        MenuAdapter adapter=new MenuAdapter(MenuPresent.this,R.layout.menu_item,menuList);
        ListView listView=(ListView) findViewById(R.id.menu_present);
        listView.setAdapter(adapter);
    }
    private void initMenu() {
        Menu daxia = new Menu("鲜炒大虾", R.drawable.daxia, 56);
        menuList.add(daxia);
        Menu doufu = new Menu("麻婆豆腐", R.drawable.doufu, 18);
        menuList.add(doufu);
        Menu huanggua = new Menu("刀拍黄瓜", R.drawable.huanggua, 16);
        menuList.add(huanggua);
        Menu jidan = new Menu("开胃鸡蛋", R.drawable.jidan, 20);
        menuList.add(jidan);
        Menu jiding = new Menu("宫保鸡丁", R.drawable.jiding, 26);
        menuList.add(jiding);
        Menu jipai = new Menu("碳烤鸡排", R.drawable.jipai, 12);
        menuList.add(jipai);
        Menu niurou = new Menu("小炒牛肉", R.drawable.niurou, 38);
        menuList.add(niurou);
        Menu roupian = new Menu("水煮肉片", R.drawable.roupian, 24);
        menuList.add(roupian);
        Menu shousiji = new Menu("手撕鸡", R.drawable.shousiji, 32);
        menuList.add(shousiji);
        Menu tudousi = new Menu("酸辣土豆丝", R.drawable.tudousi, 18);
        menuList.add(tudousi);
        Menu xiguazhi = new Menu("西瓜汁", R.drawable.xiguazhi, 8);
        menuList.add(xiguazhi);
        Menu yangzhou = new Menu("扬州炒饭", R.drawable.yangzhou, 16);
        menuList.add(yangzhou);
    }
}
**/
