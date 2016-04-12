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

public class MenuAdapter extends ArrayAdapter<Menu> {
    private int resourceId;
    private  View.OnClickListener onAddNum;
    private  View.OnClickListener onSubNum;
    private  View.OnClickListener order;

    public void setOnAddNum(View.OnClickListener onAddNum){
        this.onAddNum = onAddNum;
    }
    public void setOnSubNum(View.OnClickListener onSubNum){
        this.onSubNum = onSubNum;
    }
    public void setOrder(View.OnClickListener order){this.order=order;}


    public MenuAdapter(Context context,int resource, List<Menu> objects) {
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
            viewHolder.menuImage=(ImageView)view.findViewById(R.id.menu_image);
            viewHolder.menuName=(TextView)view.findViewById(R.id.menu_name);
            viewHolder.menuNumber=(TextView)view.findViewById(R.id.menu_num);
            viewHolder.menuPrice=(TextView)view.findViewById(R.id.menu_price);
            viewHolder.menuAdd=(ImageButton)view.findViewById(R.id.menu_add);
            viewHolder.menuAdd.setOnClickListener(onAddNum);
            viewHolder.menuSub=(ImageButton) view.findViewById(R.id.menu_sub);
            viewHolder.menuSub.setOnClickListener(onSubNum);
            viewHolder.order=(Button)view.findViewById(R.id.order);
            viewHolder.order.setOnClickListener(order);
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
        viewHolder.order.setTag(getPosition(menu));
        return view;
    }
    class ViewHolder{
        ImageView menuImage;
        TextView menuName;
        TextView menuNumber;
        TextView menuPrice;
      //增减商品数量
        ImageButton menuAdd;
        ImageButton menuSub;
        Button order;
     }
}
/**
public class MenuAdapter extends ArrayAdapter<Menu> {
    private int resoutrceId;
    public MenuAdapter(Context context,int textViewResourceId,List<Menu> objects){
        super(context,textViewResourceId,objects);
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        Menu menu=getItem(position);
        View view=LayoutInflater.from(getContext()).inflate(resoutrceId, null);
        ImageView menuImage=(ImageView)view.findViewById(R.id.menu_image);
        //ImageButton menuAdd=(ImageButton)view.findViewById(R.id.menu_add);
        //ImageButton menuSub=(ImageButton)view.findViewById(R.id.menu_sub);
        TextView menuName=(TextView)view.findViewById(R.id.menu_name);
        TextView menuPrice=(TextView)view.findViewById(R.id.menu_price);
        TextView menuNum=(TextView)view.findViewById(R.id.menu_num);
        menuImage.setImageResource(menu.getImageId());
        menuName.setText(menu.getName());
        menuPrice.setText(menu.getPrice()+"");
        return view;
    }
} **/