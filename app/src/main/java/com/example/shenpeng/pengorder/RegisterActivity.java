package com.example.shenpeng.pengorder;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by shenpeng on 2/27/16.
 */
public class RegisterActivity extends Activity{
    private EditText edname1;
    private EditText edpassword1;
    private EditText edpassword2;
    private Button register1;
    SQLiteDatabase db;
    @Override
    public void onDestroy(){
        super.onDestroy();
        db.close();
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        edname1 =(EditText)findViewById(R.id.name_01);
        edpassword1=(EditText)findViewById(R.id.password_01);
        edpassword2=(EditText)findViewById(R.id.password_02);
        register1=(Button)findViewById(R.id.register_02);
        register1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edname1.getText().toString();
                String password1 = edpassword1.getText().toString();
                String password2 = edpassword2.getText().toString();
                if (!(password1.equals(password2))) {
                    new AlertDialog.Builder(RegisterActivity.this).setTitle("错误").setMessage("密码不一致").setPositiveButton("重新注册", null).show();
                } else if (!(name.equals("") && !(password1.equals("")))) {
                    if (addUser(name, password1)) {
                        //对弹出框的按钮点击事件进行监听
                        DialogInterface.OnClickListener ss = new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //跳转到登陆界面
                                Intent in = new Intent();
                                in.setClass(RegisterActivity.this, MainActivity.class);
                                startActivity(in);
                                RegisterActivity.this.onDestroy();
                            }
                        };
                        new AlertDialog.Builder(RegisterActivity.this).setTitle("成功").setMessage("注册成功").setPositiveButton("登陆", ss).show();
                        addUser(name,password1);
                    } else {
                        new AlertDialog.Builder(RegisterActivity.this).setTitle("错误").setMessage("请重新注册").setPositiveButton("重新注册", null).show();
                    }
                } else {
                    new AlertDialog.Builder(RegisterActivity.this).setTitle("错误").setMessage("账号密码不能为空").setPositiveButton("重新注册", null).show();
                }
            }
        });
    }

public boolean addUser(String name,String password){
    String str ="insert into tb_user values(?,?)";
        MainActivity main=new MainActivity();
        db=SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString()+"/login.dbs",null);
        MainActivity.db =db;
        try{
            db.execSQL(str,new String[]{name,password});
            return true;
        }catch (SQLException e){
            main.createDb();
        }return false;
    }


}
