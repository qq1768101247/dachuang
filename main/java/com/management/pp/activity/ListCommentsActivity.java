package com.management.pp.activity;


import android.content.SharedPreferences;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.management.pp.R;
import com.management.pp.adapter.ComAdapter;
import com.management.pp.bean.CommentsBean;
import com.management.pp.core.BaseActivity;

import org.litepal.LitePal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ListCommentsActivity extends BaseActivity {


    @BindView(R.id.listview)
    ListView listview;

    @BindView(R.id.sendTxt)
    TextView sendTxt;

    @BindView(R.id.comEdt)
    EditText comEdt;
    String number="";
    String landId="";


    @Override
    public void initData() {
        number=getIntent().getStringExtra("name");
        landId=getIntent().getStringExtra("id");
        setTitleTxt(number);
      initDataList();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_list_comments;
    }

    @OnClick(R.id.sendTxt)
    public void onSendTxt() {
        String com=comEdt.getText().toString();
        if (com.isEmpty()){
            showToast("请输入评论内容");
            return;
        }
        CommentsBean mCommentsBean=new CommentsBean();
        mCommentsBean.setId(new Date().getTime());
        SharedPreferences sp = getSharedPreferences("user",0);
        String phone=sp.getString("phone","");
        String name=sp.getString("name","");
        mCommentsBean.setUserName(phone);
        if (!name.isEmpty()){
            mCommentsBean.setUserName(name);
        }
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        mCommentsBean.setLandId(landId);
        mCommentsBean.setCon(com);
        mCommentsBean.setTimeSting(formatter.format(date));
        mCommentsBean.save();
        comEdt.setText("");
        initDataList();
    }

    private void initDataList(){
        List<CommentsBean> list= LitePal.where("landId = ?",landId).find(CommentsBean.class);
        ComAdapter adapter=new ComAdapter(ListCommentsActivity.this,list);
        listview.setAdapter(adapter);
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences sp = getSharedPreferences("user",0);
                String id1=sp.getString("id","");
                if (list.get(position).getUserID().equals(id1)){
                    list.get(position).delete();
                    initDataList();
                }
                return true;
            }
        });
    }


}