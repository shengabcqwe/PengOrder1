package com.example.shenpeng.pengorder;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
      private EditText edname;
      private EditText edpassword;
      private Button btregister;
      private Button btlogin;
      private List<Menu> menuList=new ArrayList<Menu>();
      public static SQLiteDatabase db;
    @Override
    protected  void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edname=(EditText)findViewById(R.id.edname_01);
        edpassword=(EditText)findViewById(R.id.edpass_01);
        btregister=(Button)findViewById(R.id.register_01);
        btlogin=(Button)findViewById(R.id.login_01);
        db=SQLiteDatabase.openOrCreateDatabase(MainActivity.this.getFilesDir().toString()+"/login.dbs",null);
    //跳转到注册界面
        btregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btlogin.setOnClickListener(new LoginListener());
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        db.close();
    }
    class LoginListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            String name =edname.getText().toString();
            String password=edpassword.getText().toString();
            if (name.equals("")||password.equals("")){
                //弹出消息框
                new AlertDialog.Builder(MainActivity.this).setTitle("错误").setMessage("账号或密码不能为空").setPositiveButton("确定",null).show();
            }else{
                isUserinfo(name, password);

            }
        }
        public  Boolean isUserinfo(String name,String pwd){
            try{
                String str="select * from tb_user where name=? and password=?";
                Cursor cursor =db.rawQuery(str,new String[]{name,pwd});
                if(cursor.getCount()<=0){
                    new AlertDialog.Builder(MainActivity.this).setTitle("错误").setMessage("用户名或密码错误").setPositiveButton("确定",null).show();
                    return false;
                }else{
                    //开始点菜按钮事件的监听
                    DialogInterface.OnClickListener dc = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //跳转到登陆界面
                        Intent in = new Intent();
                        in.setClass(MainActivity.this, MainPage.class);
                        startActivity(in);
                    }};new AlertDialog.Builder(MainActivity.this).setTitle("正确").setMessage("登陆成功,欢迎您的光临").setPositiveButton("开始点菜",dc).show();


                    return true;

                }
            }catch (SQLiteException e){
                createDb();
            }
            return false;
        }

    }

    public  void createDb(){
        db.execSQL("create table tb_user(name varchar(30) primary key,password varchar(30))");
    }


}



