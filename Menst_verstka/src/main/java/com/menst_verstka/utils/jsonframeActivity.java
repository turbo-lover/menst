package com.menst_verstka.utils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.menst_verstka.R;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Alexander on 09.09.13.
 */
public class jsonframeActivity extends frameActivity {

    protected Calendar calendar;
    protected JsonObject jo;

    protected SimpleDateFormat nav_bar_dateFormat;
    protected DateFormatSymbols dateFormatSymbols;

    @Override
    protected void InitializeComponent() {
        super.InitializeComponent();
        dateFormatSymbols = new DateFormatSymbols();
        dateFormatSymbols.setMonths(getResources().getStringArray(R.array.months));
        nav_bar_dateFormat = new SimpleDateFormat("dd MMMM yyyy",dateFormatSymbols);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        if(b != null) {
            if(!b.isEmpty()){
                if(b.containsKey("year")) {
                    calendar = new GregorianCalendar(b.getInt("year"),b.getInt("month"),b.getInt("day"));
                } else {
                    calendar = Calendar.getInstance();
                }
                if(b.containsKey("json")) {
                    jo = new JsonParser().parse(b.getString("json")).getAsJsonObject();
                }
            }
        }
    }

    @Override
    public  void onClick(View view) {
        super.onClick(view);
        final int id = view.getId();
        switch (id) {
            case R.id.nav_bar_back_btn  :
                Backward();
                break;
            case R.id.nav_bar_fwd_btn  :
                Forward();
                break;
        }
    }

    protected void Forward(){
        calendar.add(Calendar.DAY_OF_MONTH,1);
        jo = db_helper.getRawJsonByDate(save_dateFormat.format(calendar.getTime()));
        InitJsonComposite();
    }

    protected void Backward(){
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        jo = db_helper.getRawJsonByDate(save_dateFormat.format(calendar.getTime()));
        InitJsonComposite();
    }

    protected void InitJsonComposite() {}
}
