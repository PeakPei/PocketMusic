package com.example.q.pocketmusic.module.common;

import android.content.Intent;

import com.example.q.pocketmusic.config.constant.Constant;
import com.example.q.pocketmusic.util.UserUtil;

/**
 * Created by 鹏君 on 2017/1/13.
 */
//用于验证的Activity
public abstract class AuthActivity<V extends IBaseView, T extends BasePresenter<V>> extends BaseActivity<V, T> {

    public abstract void initUserView();

    @Override
    public void initView() {
        if (UserUtil.checkLocalUser(this)){
            initUserView();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.REQUEST_LOGIN) {//请求登录
            UserUtil.onActivityResult(resultCode,data);
            finish();//把登录跳转前的界面(即将进入的页面)finish掉
        }
    }
}
