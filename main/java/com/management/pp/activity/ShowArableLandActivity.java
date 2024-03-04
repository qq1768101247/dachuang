package com.management.pp.activity;


import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

import com.management.pp.R;
import com.management.pp.bean.ArableLandBean;
import com.management.pp.core.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class ShowArableLandActivity extends BaseActivity {
    public static ArableLandBean bean;

    @BindView(R.id.areaEdt)
    TextView areaEdt;


    @BindView(R.id.soilEdt)
    TextView soilEdt;

    @BindView(R.id.unmberEdt)
    TextView unmberEdt;

    @BindView(R.id.addressEdt)
    TextView addressEdt;

    @BindView(R.id.typeEdt)
    TextView typeEdt;

    @BindView(R.id.conEdt)
    TextView conEdt;

    @BindView(R.id.saveTxt)
    TextView saveTxt;



    @Override
    public void initData() {
        typeEdt.setText("是否已种植:"+bean.getType());//是否已种植
        areaEdt.setText("面积:"+bean.getArea());//面积
        soilEdt.setText("土壤:"+bean.getSoil());//土壤
        unmberEdt.setText("编号:"+bean.getUnmber());//编号
        conEdt.setText("描述:"+bean.getCon());//描述
        addressEdt.setText("地址:"+bean.getAddress());//地址
        setTitleTxt("耕地详情");
    }

    @Override
    public int getLayout() {
        return R.layout.activity_show_land;
    }

    // 点击事件
    @OnClick(R.id.saveTxt)
    public void onSaveTxt() {
        Intent intent=new Intent(ShowArableLandActivity.this,ListCommentsActivity.class);
        intent.putExtra("name",bean.getUnmber());
        intent.putExtra("id",bean.getId()+"");
        startActivity(intent);

    }

}