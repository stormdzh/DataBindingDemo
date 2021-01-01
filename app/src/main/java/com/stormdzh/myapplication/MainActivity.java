package com.stormdzh.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDraweeView mSimpleDraweeView;

    private TextView tvTestDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.INTERNET, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 200);
        }

        mSimpleDraweeView = findViewById(R.id.mSimpleDraweeView);

        String path = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1089874897,1268118658&fm=26&gp=0.jpg";
        loadPic(mSimpleDraweeView, path);


        tvTestDataBinding = findViewById(R.id.tvTestDataBinding);
        tvTestDataBinding.setOnClickListener(this);

        findViewById(R.id.tvLiveDataDataBinding).setOnClickListener(this);
        findViewById(R.id.tvEntityLiveDataDataBinding).setOnClickListener(this);
        findViewById(R.id.tvPicLiveDataDataBinding).setOnClickListener(this);
    }

    private void loadPic(SimpleDraweeView mSimpleDraweeView, String path) {

        Uri uri = Uri.parse(path);
        mSimpleDraweeView.setImageURI(uri);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvTestDataBinding:
                startActivity(new Intent(this,TestDataBindingActivity.class));
                break;
            case R.id.tvLiveDataDataBinding:
                startActivity(new Intent(this, LiveDataStringBindingActivity.class));
                break;
            case R.id.tvEntityLiveDataDataBinding:
                startActivity(new Intent(this, LiveDataEntityBindingActivity.class));
                break;
            case R.id.tvPicLiveDataDataBinding:
                startActivity(new Intent(this, PicDataBindingActivity.class));
                break;
        }
    }
}
