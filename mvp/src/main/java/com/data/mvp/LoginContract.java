package com.data.mvp;

public interface LoginContract {
    interface  LoginView extends  BaseView<LoginPresenter>{
        void gotoMain();
    }
    interface  LoginPresenter extends BasePresenter{
        void login();
    }
}
