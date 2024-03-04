package com.management.pp.activity;


import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.TextView;

import com.management.pp.R;
import com.management.pp.bean.ArableLandBean;
import com.management.pp.core.BaseActivity;

import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

public class AddArableLandActivity extends BaseActivity {
    @BindView(R.id.areaEdt)
    EditText areaEdt;


    @BindView(R.id.soilEdt)
    EditText soilEdt;


    @BindView(R.id.unmberEdt)
    EditText unmberEdt;

    @BindView(R.id.addressEdt)
    EditText addressEdt;

    @BindView(R.id.typeEdt)
    EditText typeEdt;

    @BindView(R.id.conEdt)
    EditText conEdt;

    @BindView(R.id.saveTxt)
    TextView saveTxt;



    @Override
    public void initData() {
        setTitleTxt("注册耕地");
    }

    @Override
    public int getLayout() {
        return R.layout.activity_add_land;
    }

    // 点击事件
    @OnClick(R.id.saveTxt)
    public void onSaveTxt() {

        SharedPreferences sp = getSharedPreferences("user",0);
        String userId=sp.getString("id","");
        long id=new Date().getTime();
        String type=typeEdt.getText().toString();//是否已种植
        String area=areaEdt.getText().toString();//面积
        String soil=soilEdt.getText().toString();//土壤


        String unmber=unmberEdt.getText().toString();//编号
        String con=conEdt.getText().toString();//描述
        String address=addressEdt.getText().toString();//地址

        if (area.isEmpty())
        {
            showToast("请输入面积");
            return;
        }

        if (soil.isEmpty())
        {
            showToast("请输入土壤");
            return;
        }


        if (unmber.isEmpty())
        {
            showToast("请输入编号");
            return;
        }
        if (con.isEmpty())
        {
            showToast("请输入描述");
            return;
        }
        if (address.isEmpty())
        {
            showToast("请输入地址");
            return;
        }

        ArableLandBean bean=new  ArableLandBean();
        bean.setId(id);
        bean.setType(type);
        bean.setArea(area);
        bean.setSoil(soil);
        bean.setUserId(userId);
        bean.setUnmber(unmber);
        bean.setCon(con);
        bean.setAddress(address);
        bean.save();
        showToast("注册耕地成功");
        finish();

    }

}