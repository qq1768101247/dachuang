package com.management.pp.core;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.management.pp.R;
import com.management.pp.activity.RegActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public abstract class BaseActivity   extends Activity {


    @BindView(R.id.titleTxt)
    TextView titleTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //设置布局
        setContentView(getLayout());
        ButterKnife.bind(this);
        //设置数据
        initData();


    }

    public void setTitleTxt(String titleStr){
        titleTxt.setText(titleStr);
    }
    /**
     * 设置数据
     */
    public abstract void initData();

    /**
     * 设置布局
     *
     * @return
     */
    public abstract int getLayout();

    // 点击事件
    @OnClick(R.id.backImg)
    public void onBackClick() {
        finish();
    }

    public  void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
