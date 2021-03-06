package com.example.q.pocketmusic.module.home.net.type.study;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.q.pocketmusic.R;
import com.example.q.pocketmusic.config.constant.InstrumentConstant;
import com.example.q.pocketmusic.module.common.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

//包含简谱，五线谱，吉他谱学习
public class StudyActivity extends BaseActivity<StudyPresenter.IView, StudyPresenter>
        implements StudyPresenter.IView {
    public final static String PARAM_TYPE = "param_type";
    @BindView(R.id.web_view)
    WebView webView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;

    @Override
    protected StudyPresenter createPresenter() {
        return new StudyPresenter(this);
    }

    @Override
    public int setContentResource() {
        return R.layout.activity_study;
    }

    @Override
    public void initView() {
        initWebViewSettings();
        initToolbar(toolbar,"如何看谱");
        int type = getIntent().getIntExtra(PARAM_TYPE, 0);
        webView.loadUrl(InstrumentConstant.getStudyUrl(type));
    }

    //初始化WebSettings
    private void initWebViewSettings() {
        WebSettings settings = webView.getSettings();
        settings.setLoadsImagesAutomatically(true);
    }
}
