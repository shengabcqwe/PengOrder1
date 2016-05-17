package com.example.shenpeng.pengorder;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shenpeng on 3/31/16.
 */
public class fragment2 extends android.support.v4.app.Fragment implements View.OnClickListener {
    private List<Menu> shopcartList=new ArrayList<Menu>();
    private shopcartAdapter shopadapter;
    private  FoodDatabaseHelper helper2;
    int total;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.page2,container,false);
        initshopcart();
        TextView textView=(TextView)view.findViewById(R.id.shopcart_total_yuanjia);
        textView.setText(total+"");
        TextView textView1=(TextView)view.findViewById(R.id.shopcart_total);
        textView1.setText(total+"");
        Button submit=(Button)view.findViewById(R.id.shopcart_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getContext()).setTitle("下单成功").setMessage("您的订单已经提交").setPositiveButton("确定",null).show();
            }
        });
        ListView listView=(ListView)view.findViewById(R.id.shopcart_listview);
        shopadapter=new shopcartAdapter(getContext(),R.layout.shopcart_item,shopcartList);
        listView.setAdapter(shopadapter);
        shopadapter.setOnAddNum(this);
        shopadapter.setOnSubNum(this);
        shopadapter.setSubmit(this);
        return view;
    }

    private void initshopcart() {
        helper2=new FoodDatabaseHelper(this.getContext(),"food.db",null,1);
        SQLiteDatabase db2=helper2.getWritableDatabase();
        Cursor cursor=db2.query("food",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do {String name=cursor.getString(cursor.getColumnIndex("name"));
                String price=cursor.getString(cursor.getColumnIndex("price"));
                int imageId=cursor.getInt(cursor.getColumnIndex("imageId"));
                int num=cursor.getInt(cursor.getColumnIndex("number"));
                int score=cursor.getInt(cursor.getColumnIndex("score"));
                shopcartList.add(new Menu(name,imageId,price,score,num));
                price=price.trim();
                String str2="";
                if(price!= null && !"".equals(price)){
                    for(int i=0;i<price.length();i++){
                        if(price.charAt(i)>=48 && price.charAt(i)<=57){
                            str2+=price.charAt(i);
                        }}}
                int per=Integer.parseInt(str2);
                total+=num*per;
            }while(cursor.moveToNext());
        }cursor.close();
        db2.delete("food",null,null);
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        switch (view.getId()) {
            case R.id.shopcart_item_add:
                if (tag != null && tag instanceof Integer) {
                    int position = (Integer) tag;
                    int num = shopcartList.get(position).getnumber();
                    num++;
                    shopcartList.get(position).setNumber(num);
                    //更新adapter的数据
                    shopadapter.notifyDataSetChanged();
                }
                break;
            case R.id.shopcart_item_sub: //点击减少数量按钮 ，执行相应的处理
                // 获取 Adapter 中设置的 Tag
                if (tag != null && tag instanceof Integer) {
                    int position = (Integer) tag;
                    //更改集合的数据
                    int num =shopcartList.get(position).getnumber();
                    if (num > 0) {
                        num--;
                        shopcartList.get(position).setNumber(num);
                        shopadapter.notifyDataSetChanged();
                    }
                }
                break;
            case R.id.shopcart_submit:
                new AlertDialog.Builder(getContext()).setTitle("下单成功").setMessage("您的订单已经提交").setPositiveButton("确定",null).show();
                break;
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){initshopcart();}

    }

}
