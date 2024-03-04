package com.management.pp.activity;


import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;

import com.management.pp.R;
import com.management.pp.bean.UserBean;
import com.management.pp.core.BaseActivity;

import org.litepal.LitePal;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class UserEdtActivity extends BaseActivity {


    @BindView(R.id.phoneEdt)
    EditText phoneEdt;

    @BindView(R.id.sexEdt)
    EditText sexEdt;

    @BindView(R.id.ageEdt)
    EditText ageEdt;

    @BindView(R.id.pwdEdt)
    EditText pwdEdt;

    @BindView(R.id.conEdt)
    EditText conEdt;

    UserBean mUserBean;




    @Override
    public void initData() {
        SharedPreferences sp = getSharedPreferences("user",0);
        String id=sp.getString("id","");
        List<UserBean> list= LitePal.where("id  = ? ",id).find(UserBean.class);
        if (list!=null&&list.size()>0){
            mUserBean=list.get(0);
            setTitleTxt(list.get(0).getName());
            phoneEdt.setText(list.get(0).getPhone());
            sexEdt.setText(list.get(0).getSex());
            ageEdt.setText(list.get(0).getAge());
            pwdEdt.setText(list.get(0).getPwd());
            conEdt.setText(list.get(0).getCon());
        }
    }

    @Override
    public int getLayout() {
        return R.layout.activity_edt_user;
    }

    // 点击事件
    @OnClick(R.id.saveTxt)
    public void onSaveTxt() {

        String phone= phoneEdt.getText().toString();
        String sex=  sexEdt.getText().toString();
        String age= ageEdt.getText().toString();
        String pwd= pwdEdt.getText().toString();
        String con= conEdt.getText().toString();
        if (phone.isEmpty()){
            Toast.makeText(UserEdtActivity.this,phoneEdt.getHint().toString(),Toast.LENGTH_SHORT).show();
            return;
        }
        if (sex.isEmpty()){
            Toast.makeText(UserEdtActivity.this,sexEdt.getHint().toString(),Toast.LENGTH_SHORT).show();
            return;
        }
        if (age.isEmpty()){
            Toast.makeText(UserEdtActivity.this,ageEdt.getHint().toString(),Toast.LENGTH_SHORT).show();
            return;
        }
        if (pwd.isEmpty()){
            Toast.makeText(UserEdtActivity.this,pwdEdt.getHint().toString(),Toast.LENGTH_SHORT).show();
            return;
        }
        if (con.isEmpty()){
            Toast.makeText(UserEdtActivity.this,conEdt.getHint().toString(),Toast.LENGTH_SHORT).show();
            return;
        }

        mUserBean.setPwd(pwd);
        mUserBean.setPhone(phone);
        mUserBean.setAge(age);
        mUserBean.setSex(sex);
        mUserBean.setCon(con);
        mUserBean.update(mUserBean.getId());
        Toast.makeText(UserEdtActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
        finish();

    }

}