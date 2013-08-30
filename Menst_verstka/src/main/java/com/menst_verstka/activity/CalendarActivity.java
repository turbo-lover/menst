package com.menst_verstka.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.menst_verstka.R;
import com.menst_verstka.composite.compositeCalendar;
import com.menst_verstka.composite.compositeSettings;
import com.menst_verstka.composite.month;
import com.menst_verstka.utils.frameActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Alexander on 27.08.13.
 */
public class CalendarActivity extends frameActivity implements View.OnClickListener {
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

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
}
