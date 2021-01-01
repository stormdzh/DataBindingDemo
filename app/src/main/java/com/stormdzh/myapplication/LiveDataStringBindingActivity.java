package com.stormdzh.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;

import com.stormdzh.myapplication.databinding.ActivityStringLiveDatabindingBinding;


/**
 * @Description: 描述
 * @Author: dzh
 * @CreateDate: 2021-01-01 13:49
 */
public class LiveDataStringBindingActivity extends AppCompatActivity {

    MutableLiveData<String> mutableLiveData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStringLiveDatabindingBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_string_live_databinding);
        viewDataBinding.setLifecycleOwner(this);

        mutableLiveData =new MutableLiveData<>();

        //设置点击事件
        viewDataBinding.setEventHandler(new OnEventHandler());
        viewDataBinding.setLiveData(mutableLiveData);

        mutableLiveData.setValue("首次设置");

    }


    public class OnEventHandler {
        public void onClick(View v) {
            Toast.makeText(LiveDataStringBindingActivity.this, "响应了点击事件", Toast.LENGTH_SHORT).show();
            mutableLiveData.setValue("点击设置数据");
        }
    }


}
