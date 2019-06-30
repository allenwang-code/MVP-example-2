package com.mvp.example.base;

import android.support.annotation.NonNull;



public abstract class BasePresenter<BaseView> {

    protected BaseView view;

    public BasePresenter() {

    }

    public void onViewCreated(@NonNull BaseView view) {
        this.view = view;
    }

    public void onViewResumed(@NonNull BaseView view) {
        this.view = view;
    }

    public void onViewPaused() {
        view = null;
    }

}
