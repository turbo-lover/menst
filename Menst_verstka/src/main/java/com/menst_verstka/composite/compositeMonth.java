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
import com.menst_verstka.utils.rotateTextView;

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
        this.month.setText(new SimpleDateFormat("MMMM").format(this.calendar.getTime()));
        this.year.setText(new SimpleDateFormat("yyyy").format(this.calendar.getTime()));
    }

    private void ClearDays() {
        for(int i = 0;i < month_parts.length;i++) {
            month_parts[i].removeAllViews();
        }
    }
    @Override
    public void onClick(View view) {
        compositeDay c = (compositeDay) view;
        Intent i = new Intent(pActivity,DayParamActivity.class);
        i.putExtras(pActivity.GenerateExtras(c.GetCalendar(),c.GetJson()));
        pActivity.startActivityForResult(i,1);
    }
}
