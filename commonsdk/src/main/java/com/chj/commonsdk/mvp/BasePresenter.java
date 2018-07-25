package com.chj.commonsdk.mvp;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

import com.chj.commonsdk.utils.LogUtil;

import org.simple.eventbus.EventBus;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

import static com.chj.commonsdk.utils.Preconditions.checkNotNull;

public abstract class BasePresenter<V extends IView> implements IPresenter, LifecycleObserver {
    public static final String TAG = BasePresenter.class.getSimpleName();
    protected V mRootView;
    protected CompositeDisposable mCompositeDisposable;

    public BasePresenter(V mRootView) {
        this.mRootView = mRootView;
        onStart();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy(LifecycleOwner owner) {
        owner.getLifecycle().removeObserver(this);
    }

    @Override
    public void onStart() {
        LogUtil.d(TAG, "BasePresenter onCreat()");
        checkNotNull(mRootView, "%s cannot be null", IView.class.getName());
        if (mRootView != null && mRootView instanceof LifecycleOwner) {
            ((LifecycleOwner) mRootView).getLifecycle().addObserver(this);
        }

        if (useEventBus()) {
            EventBus.getDefault().register(this);
        }
    }

    protected boolean useEventBus() {
        return true;
    }

    @Override
    public void onDestroy() {
        LogUtil.d(TAG, "BasePresenter onDestroy()");
        if (useEventBus()) {
            EventBus.getDefault().unregister(this);
        }
        unDispose();
        mRootView = null;
        mCompositeDisposable = null;
    }

    protected void unDispose() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

    protected void addDispose(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }
}
