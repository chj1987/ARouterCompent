package com.chj.commonsdk.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.chj.commonsdk.listener.PermissionListener;
import com.chj.commonsdk.mvp.BasePresenter;
import com.jess.arms.integration.lifecycle.Lifecycleable;
import com.trello.rxlifecycle2.android.ActivityEvent;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements Lifecycleable<ActivityEvent> {
    public static final String TAG = BaseActivity.class.getSimpleName();

    private static final int CODE_REQUEST_PERMISSION = 1;

    private static PermissionListener mPermissionListener;

    private Unbinder mBind;

    @Inject
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (initBundle(getIntent().getExtras())) {
            this.setContentView(getLayoutID());

            mBind = ButterKnife.bind(this);

            init(savedInstanceState);

        } else {
            finish();
        }
    }

    protected void init(Bundle savedInstanceState) {

    }

    protected abstract int getLayoutID();

    protected boolean initBundle(Bundle bundle) {
        return true;
    }
}
