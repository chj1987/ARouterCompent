package com.chj.module_custom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/custom/CustomActivity")
public class CustomActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R2.id.btn_zfb)
    Button mBtnZfb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        ButterKnife.bind(this);
        mBtnZfb.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_zfb) {
            startActivity(new Intent(CustomActivity.this, ZFBActivity.class));
        }
    }
}
