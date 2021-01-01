package com.stormdzh.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableInt;

import com.stormdzh.myapplication.databinding.ActivityTestDatabindingBinding;

/**
 * @Description: 描述
 * @Author: dzh
 * @CreateDate: 2021-01-01 13:49
 */
public class TestDataBindingActivity extends AppCompatActivity {

    private User user;
    ObservableInt observableAge = new ObservableInt(18);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTestDatabindingBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_test_databinding);
//        setContentView(R.layout.activity_test_databinding);
        viewDataBinding.setLifecycleOwner(this);
        viewDataBinding.setTitle("测试字符串");

        user = new User();
        user.name = "张三";
        user.age = observableAge;
        viewDataBinding.setUser(user);

        //设置点击事件
        viewDataBinding.setEventHandler(new OnEventHandler());

    }


    public class OnEventHandler {
        public void onClick(View v) {
            Toast.makeText(TestDataBindingActivity.this, "响应了点击事件", Toast.LENGTH_SHORT).show();
            user.name = "阿波罗";
            observableAge.set(90);
            observableAge.notifyChange();
        }
    }


}
