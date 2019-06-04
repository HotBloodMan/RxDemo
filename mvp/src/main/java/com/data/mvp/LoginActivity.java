package com.data.mvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity
implements  LoginContract.LoginView{

private LoginContract.LoginPresenter mPresenter;

@BindView(R.id.btn_mvp)
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @OnClick(R.id.btn_mvp)
    public void doPlay(View v){
        mPresenter.login();

    }

    @Override
    public void gotoMain() {
        startActivity(new Intent(this,LoginActivity.class));
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this.getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(LoginContract.LoginPresenter presenter) {
     mPresenter=presenter;
    }
}
