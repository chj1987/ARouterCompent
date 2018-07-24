package com.chj.commonsdk.mvp;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;

import com.orhanobut.logger.Logger;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<V extends IView> implements IPresenter {
    public static final String TAG = BasePresenter.class.getSimpleName();
    protected CompositeDisposable mCompositeDisposable;

    @Override
    public void onLifecycleChanged(@NonNull LifecycleOwner owner, @NonNull Lifecycle.Event event) {
    }
}
