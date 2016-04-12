package com.example.shenpeng.pengorder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class fragment1 extends Fragment implements View.OnClickListener {

    private List<Menu> menulist=new ArrayList<Menu>();
    private MenuAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.page1,container,false);
        initmenu();
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
                    int num = menulist.get(position).getnumber();
                    if(num==0)  {new AlertDialog.Builder(this.getContext()).setTitle("点餐失败").setMessage("请您选择餐品数量.").setPositiveButton("确定",null).show(); }
                    else if (num>0) {new AlertDialog.Builder(this.getContext()).setTitle("点餐成功").setMessage(menulist.get(position).getnumber()+"份"+menulist.get(position).getName()+"已加入菜单,请到已点餐品中查看.").
                        setPositiveButton("确定",null).show();}}
                break;
        }
    }


    private void initmenu() {
        Menu daxia = new Menu("鲜炒大虾", R.drawable.daxia,"56元/份");
        menulist.add(daxia);
        Menu doufu = new Menu("麻婆豆腐", R.drawable.doufu, "18元/份");
        menulist.add(doufu);
        Menu huanggua = new Menu("刀拍黄瓜", R.drawable.huanggua, "16元/份");
        menulist.add(huanggua);
        Menu jidan = new Menu("开胃鸡蛋", R.drawable.jidan, "20元/份");
        menulist.add(jidan);
        Menu jiding = new Menu("宫保鸡丁", R.drawable.jiding, "26元/份");
        menulist.add(jiding);
        Menu jipai = new Menu("碳烤鸡排", R.drawable.jipai, "12元/份");
        menulist.add(jipai);
        Menu niurou = new Menu("小炒牛肉", R.drawable.niurou, "38元/份");
        menulist.add(niurou);
        Menu roupian = new Menu("水煮肉片", R.drawable.roupian, "24元/份");
        menulist.add(roupian);
        Menu shousiji = new Menu("手撕鸡", R.drawable.shousiji, "32元/份");
        menulist.add(shousiji);
        Menu tudousi = new Menu("土豆丝", R.drawable.tudousi, "15元/份");
        menulist.add(tudousi);
        Menu xiguazhi = new Menu("西瓜汁", R.drawable.xiguazhi, "8元/份");
        menulist.add(xiguazhi);
        Menu pingguozhi = new Menu("苹果汁", R.drawable.pingguo, "8元/份");
        menulist.add(pingguozhi);
        Menu ningmeng = new Menu("柠檬汁", R.drawable.ningmeng, "8元/份");
        menulist.add(ningmeng);
        Menu naicha = new Menu("奶茶", R.drawable.naicha, "8元/份");
        menulist.add(naicha);
        Menu kafei = new Menu("咖啡", R.drawable.kafei, "8元/份");
        menulist.add(kafei);
        Menu yangzhou = new Menu("扬州炒饭", R.drawable.yangzhou, "16元/份");
        menulist.add(yangzhou);
        Menu niurouchaofan = new Menu("牛肉炒饭", R.drawable.niurouchaofan, "16元/份");
        menulist.add(niurouchaofan);
    }
}
