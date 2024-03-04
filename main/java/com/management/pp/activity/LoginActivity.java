package com.management.pp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.management.pp.MainActivity;
import com.management.pp.R;
import com.management.pp.bean.UserBean;
import com.management.pp.core.BaseActivity;

import org.litepal.LitePal;

import java.util.List;

import butterknife.BindView;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.userEdt)
    EditText userEdt;

    @BindView(R.id.pwdEdt)
    EditText  pwdEdt;

    @BindView(R.id.loginTxt)
    TextView loginTxt;

    @BindView(R.id.regTxt)
    TextView regTxt;



    @Override
    public void initData() {
        initView();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    private void initView(){

        loginTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=userEdt.getText().toString();
                String pwd=pwdEdt.getText().toString();

                if (user.equals("")||user==null){
                    Toast.makeText(LoginActivity.this,"请输入账号",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pwd.equals("")||pwd==null){
                    Toast.makeText(LoginActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
                    return;
                }

                List<UserBean> list= LitePal.where("name  = ? and pwd = ?  ",user,pwd).find(UserBean.class);
                if (list.size()>0){
                    Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    SharedPreferences sp = getSharedPreferences("user",0);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("phone", user) ;
                    editor.putString("name", list.get(0).getName()) ;
                    editor.putString("pwd", pwd) ;
                    editor.putString("type", list.get(0).getType()) ;
                    editor.putString("id", list.get(0).getId()+"") ;
                    editor.commit();

                    Log.e("tag","type=========="+list.get(0).getType());
                    if (list.get(0).getType().equals("1")){
                        Intent instant=new Intent(LoginActivity.this, IndexActivity.class);
                        startActivity(instant);
                    }else {
                        Intent instant=new Intent(LoginActivity.this,IndexAdminActivity.class);
                        startActivity(instant);
                    }
                    finish();

                }else {
                    Toast.makeText(LoginActivity.this,"账号或者密码错误，请重新输入",Toast.LENGTH_SHORT).show();

                }


            }
        });
        regTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent instant=new Intent(LoginActivity.this,RegActivity.class);
                startActivity(instant);
            }
        });

        setTitleTxt("登  陆");
    }
}
