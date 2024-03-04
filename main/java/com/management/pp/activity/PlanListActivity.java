package com.management.pp.activity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.management.pp.R;
import com.management.pp.adapter.QueryLandAdapter;
import com.management.pp.bean.ArableLandBean;
import com.management.pp.bean.PlanBean;
import com.management.pp.core.BaseActivity;

import org.litepal.LitePal;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class PlanListActivity extends BaseActivity {

    @BindView(R.id.rightImg)
    ImageView rightImg;

    @BindView(R.id.listview)
    ListView listview;

    @Override
    public void initData() {

        rightImg.setImageResource(R.mipmap.tianjiajiahaowubiankuang);
        setTitleTxt("问题咨询");
        initviewListview();
    }

    private void initviewListview(){
        List<PlanBean> list= LitePal.findAll(PlanBean.class);
        QueryLandAdapter adapter=new QueryLandAdapter(PlanListActivity.this,list);
        listview.setAdapter(adapter);
        SharedPreferences sp = getSharedPreferences("user",0);
        String userId=sp.getString("id","");
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (userId.equals(list.get(position).getUserId())){
                    list.get(position).delete();
                    initviewListview();
                }
                return true;
            }
        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(PlanListActivity.this,ListCommentsActivity.class);
                intent.putExtra("name",list.get(position).getName());
                intent.putExtra("id",list.get(position).getId()+"");
                startActivity(intent);
            }
        });

    }

    @Override
    public int getLayout() {
        return R.layout.activity_query_land_list;
    }

    // 点击事件
    @OnClick(R.id.rightImg)
    public void onAdd() {
        Intent intent=new Intent(PlanListActivity.this,AddQueryLandActivity.class);
        startActivityForResult(intent,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        initviewListview();
    }
}