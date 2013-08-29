package com.menst_verstka.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.menst_verstka.R;

/**
 * Created by Turbo on 28.08.13.
 */
public class frameActivity extends Activity implements View.OnClickListener{

    private RelativeLayout header,nav_bar;
    protected LinearLayout content;
    private TextView header_text,nav_bar_text;
    private ImageView header_setting_img,nav_bar_back,nav_bar_fwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitializeComponent();
        SetEventListeners();
    }

    protected void SetEventListeners() {
        header_setting_img.setOnClickListener(this);
        nav_bar_fwd.setOnClickListener(this);
        nav_bar_back.setOnClickListener(this);
    }

    protected void InitializeComponent() {
        header = (RelativeLayout) findViewById(R.id.header);
        nav_bar = (RelativeLayout) findViewById(R.id.nav_bar);
        content = (LinearLayout) findViewById(R.id.container);
        header_text = (TextView) findViewById(R.id.header_text);
        nav_bar_text = (TextView) findViewById(R.id.nav_bar_text);
        header_setting_img = (ImageView) findViewById(R.id.header_setting_img);
        nav_bar_back = (ImageView) findViewById(R.id.nav_bar_back_btn);
        nav_bar_fwd = (ImageView) findViewById(R.id.nav_bar_fwd_btn);
    }

    protected void HideNavBar() {
        nav_bar.setVisibility(View.GONE);
    }

    protected void SetNavBar(String txt,int backImgRes,int fwdImgRes) {
        nav_bar_text.setText(txt);
        nav_bar_back.setImageResource(backImgRes);
        nav_bar_fwd.setImageResource(fwdImgRes);
    }

    protected void HideHeaderSetting() {
        header_setting_img.setVisibility(View.GONE);
    }

    protected void SetHeaderText(String str) {
        header_text.setText(str);
    }
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.header_setting_img) {
           // startActivity(new Intent(this,SettingActiviy.class));
        }
    }
}
