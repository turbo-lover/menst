package com.menst_verstka.composite;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.gson.JsonObject;
import com.menst_verstka.R;
import com.menst_verstka.activity.DayParamActivity;
import com.menst_verstka.utils.DBHelper;
import com.menst_verstka.utils.jsonCompositeElement;
import com.menst_verstka.utils.myPreferencesWorker;
import com.menst_verstka.utils.rotateTextView;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Alexander on 28.08.13.
 */
public class compositeMonth extends jsonCompositeElement implements View.OnClickListener {
    public rotateTextView month,year;
    private LinearLayout[] month_parts;
    private LinearLayout month_and_year;
    private static final int LANDSCAPE_TOTAL_CELLS = 33;
    private static final int LANDSCAPE_CELLS_IN_ROW = 11;
    private DBHelper db_helper;
    private SimpleDateFormat date_format;

    public compositeMonth(Context context) {
        super(context);
    }

    @Override
    protected void InitializeComponent(Context context) {
        super.InitializeComponent(context);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.month, this);
        month = (rotateTextView) findViewById(R.id.month_textview);
        year = (rotateTextView) findViewById(R.id.year_textview);
        month_parts = new LinearLayout[3];
        month_parts[0] = (LinearLayout) findViewById(R.id.part_1);
        month_parts[1] = (LinearLayout) findViewById(R.id.part_2);
        month_parts[2] = (LinearLayout) findViewById(R.id.part_3);
        month_and_year = (LinearLayout) findViewById(R.id.month_and_year);
        db_helper = new DBHelper(pActivity);
        date_format = new SimpleDateFormat("yyyy-MM-dd");
    }

    @Override
    public void Set(Calendar calendar,JsonObject jo) {
        super.Set(calendar,jo);
        ClearDays();
        int days_in_month = this.calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,1f);
        for(int i = 0;i < LANDSCAPE_TOTAL_CELLS;i++,this.calendar.add(Calendar.DAY_OF_MONTH,1)) {
            compositeDay compositeDay = new compositeDay(pActivity);
            if(i < days_in_month) {
                compositeDay.setOnClickListener(this);
                compositeDay.Set(this.calendar,db_helper.getRawJsonByDate(date_format.format(this.calendar.getTime())));
            }
            month_parts[i/LANDSCAPE_CELLS_IN_ROW].addView(compositeDay,p);
        }
        this.calendar.add(Calendar.MONTH,-1);
        UpdateText();
    }

    private void ClearDays() {
        for(int i = 0;i < month_parts.length;i++) {
            month_parts[i].removeAllViews();
        }
    }

    public void UpdateDay(Calendar calendar,JsonObject jo) {
        int n = calendar.get(Calendar.DAY_OF_MONTH)/LANDSCAPE_CELLS_IN_ROW;
        int t = calendar.get(Calendar.DAY_OF_MONTH) - (LANDSCAPE_CELLS_IN_ROW*n) - 1;
        compositeDay day = (compositeDay) month_parts[n].getChildAt(t);
        day.Set(calendar,jo);
    }
    @Override
    public void onClick(View view) {
        compositeDay c = (compositeDay) view;
        Intent i = new Intent(pActivity,DayParamActivity.class);
        i.putExtras(pActivity.GenerateExtras(c.GetCalendar(),c.GetJson()));
        pActivity.startActivityForResult(i,1);
    }

    public void UpdateText() {
        myPreferencesWorker prefe = new myPreferencesWorker(pActivity);
        SimpleDateFormat month_format;
        if(prefe.getLanguage() == "0") {
            DateFormatSymbols symbols = new DateFormatSymbols();
            symbols.setMonths(pActivity.getResources().getStringArray(R.array.months_normal));
            month_format = new SimpleDateFormat("MMMM",symbols);
        } else {
            month_format = new SimpleDateFormat("MMMM"); }
        this.month.setText(month_format.format(this.calendar.getTime()).toUpperCase());
        this.year.setText(new SimpleDateFormat("yyyy").format(this.calendar.getTime()).toUpperCase());
    }
}
