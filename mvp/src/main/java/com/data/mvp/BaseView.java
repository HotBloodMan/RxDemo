package com.data.mvp;

public interface BaseView <T extends BasePresenter>{
    void showToast(String str);
    void setPresenter(T presenter);
}
