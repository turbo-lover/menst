package com.menst_verstka.activity;

import android.content.Intent;
import android.os.Bundle;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.menst_verstka.R;
import com.menst_verstka.composite.compositeDayParams;
import com.menst_verstka.utils.frameActivity;
import com.menst_verstka.utils.jsonframeActivity;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Alexander on 30.08.13.
 */
public class DayParamActivity extends jsonframeActivity {
    private compositeDayParams dayParams;

    @Override
    protected void InitializeComponent() {
        super.InitializeComponent();
        dayParams = new compositeDayParams(this);
    }

    @Override
    protected void SetCompositeElements() {
        HideHeaderSetting();
        SetNavBar(nav_bar_dateFormat.format(calendar.getTime()),R.drawable.arrow_left,R.drawable.arrow_right);
        InitJsonComposite();
        content.addView(dayParams);
    }
    @Override
    protected void InitJsonComposite() {
        dayParams.Set(calendar,jo);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            db_helper.SetJsonByDate(save_dateFormat.format(new GregorianCalendar(extras.getInt("year"),extras.getInt("month"),extras.getInt("day")).getTime()),new JsonParser().parse(data.getStringExtra("json")).getAsJsonObject());
        }
    }
}
