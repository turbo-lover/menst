package com.woman_calendar.activity;

import android.content.Intent;
import android.os.Bundle;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.woman_calendar.R;
import com.woman_calendar.composite.compositeCalendar;
import com.woman_calendar.utils.frameActivity;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Alexander on 27.08.13.
 */
public class CalendarActivity extends frameActivity {
    private compositeCalendar cmpCalendar;


    @Override
    protected void InitializeComponent() {
        super.InitializeComponent();
        cmpCalendar = new compositeCalendar(this);
    }

    @Override
    protected void SetCompositeElements() {
        HideNavBar();
        SetHeaderText(getString(R.string.calendar_title));
        content.addView(cmpCalendar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SetLocale();
        UpdateText();
    }

    private void UpdateText() {
        SetHeaderText(getString(R.string.calendar_title));
        cmpCalendar.UpdateText();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK && data != null) {
            Bundle extras = data.getExtras();
            Calendar calendar = new GregorianCalendar(extras.getInt("year"),extras.getInt("month"),extras.getInt("day"));
            JsonObject jo = new JsonParser().parse(data.getStringExtra("json")).getAsJsonObject();
            db_helper.SetJsonByDate(save_dateFormat.format(calendar.getTime()),jo);
            cmpCalendar.UpdateDay(calendar,jo);
        }
    }
}
