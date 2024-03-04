package com.management.pp.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.management.pp.R;

public class IndexAdminActivity extends Activity {
    LinearLayout layoutb,layoutc,layoutd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        initView();
    }

    private void initView(){
        layoutb=findViewById(R.id.layoutb);
        layoutc=findViewById(R.id.layoutc);
        layoutd=findViewById(R.id.layoutd);

        layoutb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (initActivity()){
                    Intent intent=new Intent(IndexAdminActivity.this,ListArableLandActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent=new Intent(IndexAdminActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        layoutc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (initActivity()){
                    Intent intent=new Intent(IndexAdminActivity.this,PlanListActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent=new Intent(IndexAdminActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        layoutd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (initActivity()){
                    Intent intent=new Intent(IndexAdminActivity.this,UserActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent=new Intent(IndexAdminActivity.this,LoginActivity.class);
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