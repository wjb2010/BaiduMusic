package com.example.dllo.baidumusic.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());

        initView();
        initData();
    }

    //设置布局的
    protected abstract  int setLayout();

    //初始化组件
    public abstract void initView();

    //初始化数据
    protected   abstract  void initData();




    public  <T extends View> T bindView(int id){
        return (T)findViewById(id);

    }

}
