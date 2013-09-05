package com.menst_verstka.activity;

import android.content.Intent;
import android.os.Bundle;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.menst_verstka.R;
import com.menst_verstka.composite.compositeDayParams;
import com.menst_verstka.utils.frameActivity;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Alexander on 30.08.13.
 */
public class DayParamActivity extends frameActivity {
    private compositeDayParams dayParams;
    private Calendar calendar;
    private static String[] months;
    private SimpleDateFormat dateFormat;

    @Override
    protected void InitializeComponent() {
        super.InitializeComponent();
        months = getResources().getStringArray(R.array.months);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        JsonObject jsonObject = null;
        dateFormat = new SimpleDateFormat("dd MMMM yyyy",myDateFormatSymbols);
        
        calendar = new GregorianCalendar(b.getInt("year"),b.getInt("month"),b.getInt("day"));
        if(b.containsKey("json")) {
            jsonObject = new JsonParser().parse(b.getString("json")).getAsJsonObject();
        }
        dayParams = new compositeDayParams(this,jsonObject);
    }

    private static DateFormatSymbols myDateFormatSymbols = new DateFormatSymbols(){
        @Override
        public String[] getMonths() {
            return months;
        }

    };
    @Override
    protected void SetCompositeElements() {
        HideHeaderSetting();
        String str = dateFormat.format(new Date(calendar.getTimeInMillis()));
        SetNavBar(str,R.drawable.arrow_left,R.drawable.arrow_right);
        content.addView(dayParams);
    }
}
