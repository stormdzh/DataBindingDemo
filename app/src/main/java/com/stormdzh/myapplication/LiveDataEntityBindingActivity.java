package com.stormdzh.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;

import com.stormdzh.myapplication.databinding.ActivityEntityLiveDatabindingBinding;


/**
 * @Description: 描述
 * @Author: dzh
 * @CreateDate: 2021-01-01 13:49
 */
public class LiveDataEntityBindingActivity extends AppCompatActivity {

    MutableLiveData<Person> mutableLiveData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityEntityLiveDatabindingBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_entity_live_databinding);
        viewDataBinding.setLifecycleOwner(this);

        mutableLiveData =new MutableLiveData<>();

        //设置点击事件
        viewDataBinding.setEventHandler(new OnEventHandler());
        viewDataBinding.setLiveData(mutableLiveData);
        Person p =new Person();
        p.name= "首次";
        mutableLiveData.setValue(p);

    }


    public class OnEventHandler {
        public void onClick(View v) {
            Toast.makeText(LiveDataEntityBindingActivity.this, "响应了点击事件", Toast.LENGTH_SHORT).show();
            Person p =new Person();
            p.name= "更新";
            mutableLiveData.setValue(p);
        }
    }


}
