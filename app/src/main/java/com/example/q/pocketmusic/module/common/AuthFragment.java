package com.example.q.pocketmusic.module.common;

import android.content.Intent;

import com.dell.fortune.tools.toast.ToastUtil;
import com.example.q.pocketmusic.config.constant.Constant;
import com.example.q.pocketmusic.util.UserUtil;

/**
 * Created by 鹏君 on 2017/1/26.
 */

public abstract class AuthFragment<V extends IBaseView, T extends BasePresenter<V>> extends BaseFragment<V, T> {
    @Override
    public void initView() {
        if (!UserUtil.checkLocalUser(this)) {
            ToastUtil.showToast("请登录");
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.REQUEST_LOGIN) {//请求登录
            UserUtil.onActivityResult(resultCode, data);
        }
    }
}
