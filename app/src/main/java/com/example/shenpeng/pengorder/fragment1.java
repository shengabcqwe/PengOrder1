package com.example.shenpeng.pengorder;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by shenpeng on 4/8/16.
 */
public class fragment1 extends android.support.v4.app.Fragment implements View.OnClickListener {

    private List<Menu> menulist=new ArrayList<Menu>();
    private MenuAdapter adapter;
    private FoodDatabaseHelper helper1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.page1,container,false);
        initmenu();
        helper1=new FoodDatabaseHelper(this.getContext(),"food.db",null,1);
        ListView listView=(ListView)view.findViewById(R.id.menu);
        adapter=new MenuAdapter(getContext(),R.layout.menu_item,menulist);
        listView.setAdapter(adapter);
        adapter.setOnAddNum(this);
        adapter.setOnSubNum(this);
        adapter.setOrder(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        return view;
    }

    //重点分析学习点击事件
    public void onClick(View view) {
        //这行不懂
        Object tag = view.getTag();
        switch (view.getId()) {
            case R.id.menu_add:
                if (tag != null && tag instanceof Integer) {
                    int position = (Integer) tag;
                    int num = menulist.get(position).getnumber();
                    num++;
                    menulist.get(position).setNumber(num);
                    //更新adapter的数据
                    adapter.notifyDataSetChanged();
                }
                break;
            case R.id.menu_sub: //点击减少数量按钮 ，执行相应的处理
                // 获取 Adapter 中设置的 Tag
                if (tag != null && tag instanceof Integer) {
                    int position = (Integer) tag;
                    //更改集合的数据
                    int num = menulist.get(position).getnumber();
                    if (num > 0) {
                        num--;
                        menulist.get(position).setNumber(num);
                        adapter.notifyDataSetChanged();
                    }
                }
                break;
            case R.id.order:
                if (tag != null && tag instanceof Integer) {
                    int position = (Integer) tag;
                    String name=menulist.get(position).getName();
                    String price=menulist.get(position).getPrice();
                    int imageId=menulist.get(position).getImageId();
                    int score=menulist.get(position).getScore();
                    int num = menulist.get(position).getnumber();
                    if(num==0)  {new AlertDialog.Builder(this.getContext()).setTitle("点餐失败").setMessage("请您选择餐品数量").setPositiveButton("确定",null).show(); }
                    else if (num>0) {new AlertDialog.Builder(this.getContext()).setTitle("点餐成功").setMessage(menulist.get(position).getnumber()+"份"+menulist.get(position).getName()+"已加入菜单,请到已点餐品中查看").
                        setPositiveButton("确定",null).show();}
                    //插入到数据库中
                    SQLiteDatabase db1=helper1.getWritableDatabase();
                    ContentValues values=new ContentValues();
                    values.put("name",name);
                    values.put("price",price);
                    values.put("imageId",imageId);
                    values.put("score",score);
                    values.put("number",num);
                    db1.insert("food",null,values);
                    values.clear();

                }
                break;
        }
    }


    private void initmenu() {
        Menu daxia = new Menu("鲜炒大虾", R.drawable.daxia,"￥56/份",0);
        menulist.add(daxia);
        Menu doufu = new Menu("麻婆豆腐", R.drawable.doufu, "￥18/份",0);
        menulist.add(doufu);
        Menu huanggua = new Menu("刀拍黄瓜", R.drawable.huanggua, "￥16/份",0);
        menulist.add(huanggua);
        Menu jidan = new Menu("开胃鸡蛋", R.drawable.jidan, "￥20/份",0);
        menulist.add(jidan);
        Menu jiding = new Menu("宫保鸡丁", R.drawable.jiding, "￥26/份",0);
        menulist.add(jiding);
        Menu jipai = new Menu("碳烤鸡排", R.drawable.jipai, "￥12/份",0);
        menulist.add(jipai);
        Menu niurou = new Menu("小炒牛肉", R.drawable.niurou, "￥38/份",0);
        menulist.add(niurou);
        Menu roupian = new Menu("水煮肉片", R.drawable.roupian, "￥24/份",0);
        menulist.add(roupian);
        Menu shousiji = new Menu("手撕鸡", R.drawable.shousiji, "￥32/份",0);
        menulist.add(shousiji);
        Menu tudousi = new Menu("土豆丝", R.drawable.tudousi, "￥15/份",0);
        menulist.add(tudousi);
        Menu xiguazhi = new Menu("西瓜汁", R.drawable.xiguazhi, "¥8/份",0);
        menulist.add(xiguazhi);
        Menu pingguozhi = new Menu("苹果汁", R.drawable.pingguo, "¥8元/份",0);
        menulist.add(pingguozhi);
        Menu ningmeng = new Menu("柠檬汁", R.drawable.ningmeng, "¥8元/份",0);
        menulist.add(ningmeng);
        Menu naicha = new Menu("奶茶", R.drawable.naicha, "￥8/份",0);
        menulist.add(naicha);
        Menu kafei = new Menu("咖啡", R.drawable.kafei, "￥8/份",0);
        menulist.add(kafei);
        Menu yangzhou = new Menu("扬州炒饭", R.drawable.yangzhou, "￥16/份",0);
        menulist.add(yangzhou);
        Menu niurouchaofan = new Menu("牛肉炒饭", R.drawable.niurouchaofan, "￥16/份",0);
        menulist.add(niurouchaofan);
    }
}
