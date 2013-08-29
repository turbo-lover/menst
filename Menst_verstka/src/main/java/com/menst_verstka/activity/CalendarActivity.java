package com.menst_verstka.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.menst_verstka.R;
import com.menst_verstka.composite.month;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Alexander on 27.08.13.
 */
public class CalendarActivity extends Activity {
    private LinearLayout months;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitializeComponent();
        SetCompositeElements();
        SetEventListeners();
    }

    private void SetEventListeners() {

    }

    private void SetCompositeElements() {

    }

    private void InitializeComponent() {
        setContentView(R.layout.calendar);
        months = (LinearLayout) findViewById(R.id.months_holder);
        month m1 = new month(this);
        month m2 = new month(this);
        month m3 = new month(this);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0,1f);
        m1.SetMonth(2013,7);
        m2.SetMonth(2013,8);
        m3.SetMonth(2013,9);
        months.addView(m1,p);
        months.addView(m2,p);
        months.addView(m3,p);
    }


}
