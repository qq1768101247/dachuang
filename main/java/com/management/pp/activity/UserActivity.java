package com.management.pp.activity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.management.pp.R;
import com.management.pp.bean.ArableLandBean;
import com.management.pp.bean.UserBean;
import com.management.pp.core.BaseActivity;

import org.litepal.LitePal;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class UserActivity extends BaseActivity {


    @BindView(R.id.loginOutLayout)
    LinearLayout loginOutLayout;

    @BindView(R.id.nameTxt)
    TextView nameTxt;

    @BindView(R.id.sexTxt)
    TextView sexTxt;


    @Override
    public void initData() {
        setTitleTxt("用户中心");
        SharedPreferences sp = getSharedPreferences("user",0);
        String id=sp.getString("id","");
        List<UserBean> list= LitePal.where("id  = ? ",id).find(UserBean.class);
        if (list!=null&&list.size()>0){
            nameTxt.setText(list.get(0).getName());
            sexTxt.setText(list.get(0).getSex());
        }

    }

    @Override
    public int getLayout() {
        return R.layout.activity_user;
    }




    @OnClick(R.id.loginOutLayout)
    public void onLoginOutLayout() {
        SharedPreferences sp = getSharedPreferences("user",0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("phone", "") ;
        editor.putString("pwd", "") ;
        editor.putString("id", "") ;
        editor.commit();
        Intent intent=new Intent(UserActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.settingLayout)
    public void onSettingLayout() {
        Intent intent=new Intent(UserActivity.this,UserEdtActivity.class);
        startActivity(intent);
    }

}