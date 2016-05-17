package com.example.shenpeng.pengorder;


import android.content.Context;
import android.media.Image;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shenpeng on 3/1/16.
 */

public class shopcartAdapter extends ArrayAdapter<Menu> {
    private int resourceId;
    private  View.OnClickListener onAddNum;
    private  View.OnClickListener onSubNum;
    private  View.OnClickListener submit;

    public void setOnAddNum(View.OnClickListener onAddNum){
        this.onAddNum = onAddNum;
    }
    public void setOnSubNum(View.OnClickListener onSubNum){
        this.onSubNum = onSubNum;
    }
    public void setSubmit(View.OnClickListener order){this.submit=submit;}


    public shopcartAdapter(Context context,int resource, List<Menu> objects) {
        super(context,resource, objects);
        resourceId=resource;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        Menu menu =getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view=LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder=new ViewHolder();
            viewHolder.menuImage=(ImageView)view.findViewById(R.id.shopcart_item_img);
            viewHolder.menuName=(TextView)view.findViewById(R.id.shopcart_item_name);
            viewHolder.menuNumber=(TextView)view.findViewById(R.id.shopcart_item_num);
            viewHolder.menuPrice=(TextView)view.findViewById(R.id.shopcart_item_price);
            viewHolder.menuScore=(TextView)view.findViewById(R.id.shopcart_item_pingfen);
            viewHolder.menuAdd=(ImageButton)view.findViewById(R.id.shopcart_item_add);
            viewHolder.menuAdd.setOnClickListener(onAddNum);
            viewHolder.menuSub=(ImageButton) view.findViewById(R.id.shopcart_item_sub);
            viewHolder.menuSub.setOnClickListener(onSubNum);
            //viewHolder.submit=(Button)view.findViewById(R.id.shopcart_submit);
            //viewHolder.submit.setOnClickListener(submit);
            view.setTag(viewHolder);
        }
        else{view =convertView;
            viewHolder=(ViewHolder)view.getTag();}
        viewHolder.menuImage.setImageResource(menu.getImageId());
        viewHolder.menuName.setText(menu.getName());
        viewHolder.menuPrice.setText(menu.getPrice());
        int num=menu.getnumber();
        viewHolder.menuNumber.setText(num + "");
        viewHolder.menuAdd.setTag(getPosition(menu));
        viewHolder.menuSub.setTag(getPosition(menu));
        return view;
    }
    class ViewHolder{
        ImageView menuImage;
        TextView menuName;
        TextView menuNumber;
        TextView menuPrice;
        TextView menuScore;
        //增减商品数量
        ImageButton menuAdd;
        ImageButton menuSub;
        Button submit;
    }
}