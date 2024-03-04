package com.management.pp.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.management.pp.R;
import com.management.pp.bean.UserBean;
import com.management.pp.core.BaseActivity;

import org.litepal.LitePal;

import java.util.List;

import butterknife.BindView;

public class RegActivity extends BaseActivity {
    @BindView(R.id.userEdt)
    EditText userEdt;

    @BindView(R.id.pwdEdt)
    EditText  pwdEdt;


    @BindView(R.id.regTxt)
    TextView regTxt;

    @BindView(R.id.regAdminTxt)
    TextView regAdminTxt;



    @Override
    public void initData() {
        initView();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_reg;
    }

    private void initView(){

        regTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=userEdt.getText().toString();
                String pwd=pwdEdt.getText().toString();

                if (user.equals("")||user==null){
                    Toast.makeText(RegActivity.this,"请输入账号",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pwd.equals("")||user==null){
                    Toast.makeText(RegActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
                    return;
                }

                onReg("1");

            }
        });
        regAdminTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=userEdt.getText().toString();
                String pwd=pwdEdt.getText().toString();

                if (user.equals("")||user==null){
                    Toast.makeText(RegActivity.this,"请输入账号",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pwd.equals("")||user==null){
                    Toast.makeText(RegActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
                    return;
                }

                onReg("2");

            }
        });
        setTitleTxt("注  册");

    }

    private void onReg(String type){
        String user=userEdt.getText().toString();
        String pwd=pwdEdt.getText().toString();
        List<UserBean> list= LitePal.where("name  = ? ",user).find(UserBean.class);
        if (list.size()>0){
            Toast.makeText(RegActivity.this,"该账号已被注册，请从新输入账号",Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(RegActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
        UserBean mUserBean=new UserBean();
        mUserBean.setName(user);
        mUserBean.setPwd(pwd);
        mUserBean.setType(type);
        mUserBean.save();
        finish();
    }
}