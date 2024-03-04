package com.management.pp.activity;


import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.management.pp.R;
import com.management.pp.bean.ArableLandBean;
import com.management.pp.core.BaseActivity;


import butterknife.BindView;
import butterknife.OnClick;

public class EdtArableLandActivity extends BaseActivity {
    public static ArableLandBean bean;

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
        typeEdt.setText(bean.getType());//是否已种植
        areaEdt.setText(bean.getArea());//面积
        soilEdt.setText(bean.getSoil());//土壤
        unmberEdt.setText(bean.getUnmber());//编号
        conEdt.setText(bean.getCon());//描述
        addressEdt.setText(bean.getAddress());//地址
        setTitleTxt("修改耕地");
        Log.e("tag","id========"+bean.getId());
    }

    @Override
    public int getLayout() {
        return R.layout.activity_edt_land;
    }


    // 点击事件
    @OnClick(R.id.saveTxt)
    public void onSaveTxt() {

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
        bean.setAddress(address);
        bean.setType(type);
        bean.setArea(area);
        bean.setCon(con);
        bean.setSoil(soil);
        bean.setUnmber(unmber);
        bean.update(bean.getId());
        showToast("注册修改成功");
        finish();

    }

}