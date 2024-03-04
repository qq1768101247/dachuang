package com.management.pp.activity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.management.pp.R;
import com.management.pp.adapter.LandAdapter;
import com.management.pp.bean.ArableLandBean;
import com.management.pp.core.BaseActivity;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ListArableLandActivity extends BaseActivity {
    @BindView(R.id.titleEdt)
    EditText titleEdt;

    @BindView(R.id.listview)
    ListView listview;


    @Override
    public void initData() {

        initDataView("");

        titleEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                initDataView(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    List<ArableLandBean> list=new ArrayList<>();
    private void initDataView(String key){
        list= LitePal.findAll(ArableLandBean.class);
        if (key!=null&&!key.equals("")){
            list= LitePal.where("unmber like ?","%"+key+"%").find(ArableLandBean.class);
        }
        LandAdapter adapter=new LandAdapter(this,list);
        listview.setAdapter(adapter);

        SharedPreferences sp = getSharedPreferences("user",0);
        String userId=sp.getString("id","");
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (userId.equals(list.get(position).getUserId())){
                    Intent intent=new Intent(ListArableLandActivity.this,EdtArableLandActivity.class);
                    EdtArableLandActivity.bean=list.get(position);
                    startActivityForResult(intent,1);
                }else {
                    Intent intent=new Intent(ListArableLandActivity.this,ShowArableLandActivity.class);
                    ShowArableLandActivity.bean=list.get(position);
                    startActivityForResult(intent,1);
                }
            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.activity_list_land;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        initDataView("");
    }
}