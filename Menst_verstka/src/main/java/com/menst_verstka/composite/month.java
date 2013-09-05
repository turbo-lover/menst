package com.menst_verstka.composite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.menst_verstka.R;
import com.menst_verstka.activity.DayParamActivity;
import com.menst_verstka.utils.DBHelper;
import com.menst_verstka.utils.rotateTextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Alexander on 28.08.13.
 */
public class month extends RelativeLayout implements View.OnClickListener {
    public rotateTextView month,year;
    private LinearLayout[] month_parts;
    private LinearLayout month_and_year;
    private Context pContext;
    private Calendar calendar;
    private static final int LANDSCAPE_TOTAL_CELLS = 33;
    private static final int LANDSCAPE_CELLS_IN_ROW = 11;
    private DBHelper db_helper;
    private SimpleDateFormat date_format;

    public month(Context context) {
        super(context);
        InitializeComponent(context);
    }

    public month(Context context, AttributeSet attrs) {
        super(context, attrs);
        InitializeComponent(context);
    }

    public month(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        InitializeComponent(context);
    }

    private void InitializeComponent(Context context) {
        pContext = context;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.month, this);
        month = (rotateTextView) findViewById(R.id.month_textview);
        year = (rotateTextView) findViewById(R.id.year_textview);
        month_parts = new LinearLayout[3];
        month_parts[0] = (LinearLayout) findViewById(R.id.part_1);
        month_parts[1] = (LinearLayout) findViewById(R.id.part_2);
        month_parts[2] = (LinearLayout) findViewById(R.id.part_3);
        month_and_year = (LinearLayout) findViewById(R.id.month_and_year);
        db_helper = new DBHelper(pContext);
        date_format = new SimpleDateFormat("yyyy-MM-dd");
    }

    public void SetMonth(Calendar calendar) {
        this.calendar = (Calendar) calendar.clone();
        int days_in_month = this.calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,1f);
        for(int i = 0;i < LANDSCAPE_TOTAL_CELLS;i++,this.calendar.add(Calendar.DAY_OF_MONTH,1)) {
            calendarItem calendarItem = new calendarItem(pContext);
            if(i < days_in_month) {
                calendarItem.setOnClickListener(this);
                calendarItem.setElement(this.calendar,db_helper.getRawJsonByDate(date_format.format(new Date(this.calendar.getTimeInMillis()))));
            }
            month_parts[i/LANDSCAPE_CELLS_IN_ROW].addView(calendarItem,p);
        }
        this.calendar.add(Calendar.MONTH,-1);
        Date d = new Date(this.calendar.getTimeInMillis());
        this.month.setText(new SimpleDateFormat("MMMM").format(d));
        this.year.setText(new SimpleDateFormat("yyyy").format(d));
    }

    public Calendar GetCalendar() {
        return calendar;
    }

    @Override
    public void onClick(View view) {
        calendarItem c = (calendarItem) view;
        Intent i = new Intent(pContext,DayParamActivity.class);
        JsonObject jo = c.getJsonObject();
        i.putExtra("year",calendar.get(Calendar.YEAR));
        i.putExtra("month",calendar.get(Calendar.MONTH));
        i.putExtra("day",calendar.get(Calendar.DAY_OF_MONTH));
        if(jo != null) {
            i.putExtra("json",jo.toString());
        }
        ((Activity)pContext).startActivityForResult(i,1);
    }

}
