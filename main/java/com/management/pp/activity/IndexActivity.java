package com.management.pp.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.management.pp.R;
/**
 * 用户主页
 * */
public class IndexActivity extends Activity {
    LinearLayout layouta,layoutb,layoutc,layoutd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        layouta=findViewById(R.id.layouta);
        layoutb=findViewById(R.id.layoutb);
        layoutc=findViewById(R.id.layoutc);
        layoutd=findViewById(R.id.layoutd);

        layouta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (initActivity()){
                    Intent intent=new Intent(IndexActivity.this,AddArableLandActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent=new Intent(IndexActivity.this,LoginActivity.class);
                    startActivity(intent);
                }

            }
        });
        layoutb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (initActivity()){
                    Intent intent=new Intent(IndexActivity.this,ListArableLandActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent=new Intent(IndexActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        layoutc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (initActivity()){
                    Intent intent=new Intent(IndexActivity.this,PlanListActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent=new Intent(IndexActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        layoutd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (initActivity()){
                    Intent intent=new Intent(IndexActivity.this,UserActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent=new Intent(IndexActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    private boolean initActivity(){
        boolean isLogin=false;
        SharedPreferences sp = getSharedPreferences("user",0);
        String phone=sp.getString("phone","");
        if (phone==null||"".equals(phone)){

        }else {
            isLogin=true;
        }

        return isLogin;


    }
}