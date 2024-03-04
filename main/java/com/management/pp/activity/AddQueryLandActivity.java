package com.management.pp.activity;


import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.management.pp.R;
import com.management.pp.bean.ArableLandBean;
import com.management.pp.bean.PlanBean;
import com.management.pp.core.BaseActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

public class AddQueryLandActivity extends BaseActivity {
    @BindView(R.id.nameEdt)
    EditText nameEdt;



    @BindView(R.id.conEdt)
    EditText conEdt;

    @BindView(R.id.rightImg)
    ImageView rightImg;



    @Override
    public void initData() {
        setTitleTxt("添加问题");
        rightImg.setImageResource(R.mipmap.baocun);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_add_plan;
    }

    // 点击事件
    @OnClick(R.id.rightImg)
    public void rightImg() {

        SharedPreferences sp = getSharedPreferences("user",0);
        String userId=sp.getString("id","");
        String name=nameEdt.getText().toString();//问题
        String con=conEdt.getText().toString();//描述

        if (name.isEmpty())
        {
            showToast("请输入问题");
            return;
        }
        if (con.isEmpty())
        {
            showToast("请输入内容");
            return;
        }

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());


        PlanBean bean=new  PlanBean();
        bean.setCon(con);
        bean.setId(new Date().getTime());
        bean.setName(name);
        bean.setUserId(userId);
        bean.setTimeString(formatter.format(date));
        bean.save();
        showToast("添加问题成功");
        finish();

    }

}