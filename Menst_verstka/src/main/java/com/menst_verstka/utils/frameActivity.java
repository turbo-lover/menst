package com.menst_verstka.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.menst_verstka.R;
import com.menst_verstka.activity.SettingsActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Turbo on 28.08.13.
 */
public class frameActivity extends Activity implements View.OnClickListener{

    private RelativeLayout header,nav_bar;
    protected LinearLayout content;
    private TextView header_text,nav_bar_text;
    private ImageView header_setting_img,nav_bar_back,nav_bar_fwd;

    protected myPreferencesWorker preferencesWorker;
    protected DBHelper db_helper;
    protected SimpleDateFormat save_dateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitializeComponent();
        SetLocale();
        SetEventListeners();
        SetCompositeElements();
    }

    protected void SetLocale() {
        Locale l;
        switch (Integer.parseInt(preferencesWorker.getLanguage())) {
            case 1:
                l = new Locale("en");
                break;
            case 2:
                l = new Locale("ar");
                break;
            default:
                l = new Locale("ru");
                break;
        }
        Locale.setDefault(l);
        Configuration config = new Configuration();
        config.locale = l;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
    }

    protected void SetCompositeElements() { }

    protected void SetEventListeners() {
        header_setting_img.setOnClickListener(this);
        nav_bar_fwd.setOnClickListener(this);
        nav_bar_back.setOnClickListener(this);
    }

    protected void InitializeComponent() {
        preferencesWorker = new myPreferencesWorker(this);
        db_helper = new DBHelper(this);
        save_dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        setContentView(R.layout.frame_activity);
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

    public Bundle GenerateExtras(Calendar calendar,JsonObject jo) {
        Bundle b = new Bundle();
        b.putInt("year",calendar.get(Calendar.YEAR));
        b.putInt("month",calendar.get(Calendar.MONTH));
        b.putInt("day",calendar.get(Calendar.DAY_OF_MONTH));
        if(jo != null) {
            b.putString("json",jo.toString());
        }
        return b;
    }

    /**
     * Обязательно вызывать )
     */
    protected void SetNavBar(String txt,int backImgRes,int fwdImgRes) {
        SetNavBarText(txt);
        nav_bar_back.setImageResource(backImgRes);
        nav_bar_fwd.setImageResource(fwdImgRes);
    }

    protected void SetNavBarText(String txt) {
        nav_bar_text.setText(txt);
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
            startActivityForResult(new Intent(this,SettingsActivity.class),1);
        }
    }
}
