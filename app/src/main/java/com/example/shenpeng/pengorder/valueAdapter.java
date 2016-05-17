package com.example.shenpeng.pengorder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shenpeng on 5/16/16.
 */
public class valueAdapter extends ArrayAdapter<Menu> {
    private int resourceId;
    private View.OnClickListener valueButton;
    public void setValueButton(View.OnClickListener valueButton){this.valueButton=valueButton;}


    public valueAdapter(Context context, int resource, List<Menu> objects) {
        super(context,resource, objects);
        resourceId=resource;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        Menu menu =getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view= LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder=new ViewHolder();
            viewHolder.menuImage=(ImageView)view.findViewById(R.id.value_item_img);
            viewHolder.menuName=(TextView)view.findViewById(R.id.value_item_name);
            viewHolder.menuNumber=(TextView)view.findViewById(R.id.value_item_num);
            viewHolder.menuScore=(TextView)view.findViewById(R.id.value_item_value);
            viewHolder.valueButton=(Button)view.findViewById(R.id.value_button);
            viewHolder.valueButton.setOnClickListener(valueButton);
            view.setTag(viewHolder);
        }
        else{view =convertView;
            viewHolder=(ViewHolder)view.getTag();}
        viewHolder.menuImage.setImageResource(menu.getImageId());
        viewHolder.menuName.setText(menu.getName());
        int num=menu.getnumber();
        viewHolder.menuNumber.setText(num + "");
        int score=menu.getScore();
        viewHolder.menuScore.setText(score+"");
        viewHolder.valueButton.setTag(getPosition(menu));
        return view;
    }
    class ViewHolder{
        ImageView menuImage;
        TextView menuName;
        TextView menuNumber;
        TextView menuScore;
        //增减商品数量
        Button valueButton;
    }
}
