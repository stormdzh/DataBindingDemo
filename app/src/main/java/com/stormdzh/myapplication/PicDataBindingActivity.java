package com.stormdzh.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import com.facebook.drawee.view.SimpleDraweeView;
import com.stormdzh.myapplication.databinding.ActivityPicDatabindingBinding;


/**
 * @Description: 描述
 * @Author: dzh
 * @CreateDate: 2021-01-01 13:49
 */
public class PicDataBindingActivity extends AppCompatActivity {


    ActivityPicDatabindingBinding viewDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_pic_databinding);
//        setContentView(R.layout.activity_test_databinding);
        viewDataBinding.setLifecycleOwner(this);

        //设置点击事件
        viewDataBinding.setEventHandler(new OnEventHandler());

        String path = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1089874897,1268118658&fm=26&gp=0.jpg";
        viewDataBinding.setImageUrl(path);

    }


    public class OnEventHandler {
        public void onClick(View v) {
            Toast.makeText(PicDataBindingActivity.this, "响应了点击事件", Toast.LENGTH_SHORT).show();

            String path = "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1056193884,1712488622&fm=26&gp=0.jpg";
            viewDataBinding.setImageUrl(path);
        }
    }

    @BindingAdapter("imageUrl")
    public static void loadImage(SimpleDraweeView iv, String imageUrl) {
        Log.i("dzh", "加载图片了");
        loadPic(iv, imageUrl);
    }

    private static void loadPic(SimpleDraweeView mSimpleDraweeView, String path) {

        Uri uri = Uri.parse(path);
        mSimpleDraweeView.setImageURI(uri);
    }


}
