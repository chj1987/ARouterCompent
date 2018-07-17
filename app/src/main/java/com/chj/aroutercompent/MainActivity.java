package com.chj.aroutercompent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(getApplication());
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                Toast.makeText(MainActivity.this, "btn1", Toast.LENGTH_SHORT).show();
                ARouter.getInstance().build("/custom/CustomActivity").navigation(MainActivity.this);
                break;
            case R.id.btn2:
                Toast.makeText(MainActivity.this, "btn2", Toast.LENGTH_SHORT).show();
                ARouter.getInstance().build("/video/VideoActivity").navigation(MainActivity.this);
                break;
        }
    }
}
