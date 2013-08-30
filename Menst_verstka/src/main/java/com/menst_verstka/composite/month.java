package com.menst_verstka.composite;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.menst_verstka.R;
import com.menst_verstka.utils.rotateTextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Alexander on 28.08.13.
 */
public class month extends RelativeLayout {
    public rotateTextView month,year;
    private LinearLayout[] month_parts;
    private LinearLayout month_and_year;
    private Context pContext;
    private Calendar calendar;
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
    }

    public void SetMonth(Calendar calendar) {
        this.calendar = calendar;
        int days_in_month = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 0;i < 3; i++) {
            for (int j = 0;j < 11;j++) {
                calendarItem calendarItem = new calendarItem(pContext);
                if(((i*11) + j + 1) <= days_in_month) {
                    calendarItem.setElement(Integer.toString((i*11) + j + 1),0,0,"",0,"","",0); }
                calendarItem.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,1f));
                month_parts[i].addView(calendarItem);
            }
        }
        Date d = new Date(calendar.getTimeInMillis());
        this.month.setText(new SimpleDateFormat("MMMM").format(d));
        this.year.setText(new SimpleDateFormat("yyyy").format(d));
    }

    public Calendar GetCalendar() {
        return calendar;
    }

}
