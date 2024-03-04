package com.management.pp.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;

import com.management.pp.R;
import com.management.pp.core.BaseActivity;


public class SplashActivity extends BaseActivity {


    @Override
    public int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void initData() {
        new Handler().postDelayed(new Runnable(){
            public void run() {
                SharedPreferences sp = getSharedPreferences("user",0);
                String phone=sp.getString("phone","");
                String type=sp.getString("type","");
                if (!"".equals(phone)){
                    if (type.equals("1")){
                        startActivity(new Intent(SplashActivity.this,IndexActivity.class));
                    }else {
                        startActivity(new Intent(SplashActivity.this,IndexAdminActivity.class));
                    }

                }else {
                    startActivity(new Intent(SplashActivity.this,LoginActivity.class));


                }
                //  startActivity(new Intent(SplashActivity.this,CommentActivity.class));
             //getMyApplication().putSetting(Constant.KEY_CAR_NUMBER,"");
                finish();
            }
        }, 2000);
    }

}
