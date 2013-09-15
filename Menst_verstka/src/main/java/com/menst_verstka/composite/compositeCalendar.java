package com.menst_verstka.composite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.gson.JsonObject;
import com.menst_verstka.R;
import com.menst_verstka.utils.Transforms;

import java.util.Calendar;

/**
 * Created by Alexander on 30.08.13.
 */
public class compositeCalendar extends RelativeLayout implements View.OnClickListener {
    private LinearLayout months;
    private ImageView back,fwd;
    private LinearLayout.LayoutParams p,p_margin;
    private Context pContext;

    public compositeCalendar(Context context) {
        super(context);
        InitializeComponent(context);
        SetCompositeElements();
        SetEventListeners();
    }

    private void SetMonths() {
        Calendar c  = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH,1);
        compositeMonth m1 = new compositeMonth(pContext);
        compositeMonth m2 = new compositeMonth(pContext);
        compositeMonth m3 = new compositeMonth(pContext);
        c.add(Calendar.MONTH,-1);
        m1.Set(c,null);
        c.add(Calendar.MONTH, 1);
        m2.Set(c,null);
        c.add(Calendar.MONTH,1);
        m3.Set(c,null);
        months.addView(m1);
        months.addView(m2);
        months.addView(m3);
        SetLayoutParams();
    }

    private void SetEventListeners() {
        back.setOnClickListener(this);
        fwd.setOnClickListener(this);
    }

    private void SetCompositeElements() { }

    private void InitializeComponent(Context pContext) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.calendar, this);
        this.pContext = pContext;
        months = (LinearLayout) findViewById(R.id.months_holder);
        back = (ImageView) findViewById(R.id.BackCalendarButton);
        fwd = (ImageView) findViewById(R.id.FwdCalendarButton);
        p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0,1f);
        p_margin = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0,1f);
        p_margin.setMargins(0,Transforms.PxtDIP(4,pContext), 0,0);
        SetMonths();
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.FwdCalendarButton:
                GoToMonth(true);
                break;
            case R.id.BackCalendarButton:
                GoToMonth(false);
                break;
        }
    }

    private void SetLayoutParams() {
        for (int i = 0;i < months.getChildCount();i++) {
            months.getChildAt(i).setLayoutParams((i == 0)?p:p_margin);
        }
    }

    private void GoToMonth(boolean direction) {
        compositeMonth m = (compositeMonth) months.getChildAt((direction)?months.getChildCount() - 1:0);
        Calendar c = m.GetCalendar();
        c.set(Calendar.DAY_OF_MONTH,1);
        c.add(Calendar.MONTH,(direction)?1:-1);
        m = (compositeMonth) months.getChildAt((direction)?0:months.getChildCount() - 1);
        months.removeView(m);
        m.Set(c,null);
        months.addView(m,(direction)?months.getChildCount():0);
        SetLayoutParams();
    }

    public void UpdateDay(Calendar calendar, JsonObject jo) {
        for (int i = 0;i < months.getChildCount();i++) {
           compositeMonth m = (compositeMonth) months.getChildAt(i);
           if(m.GetCalendar().get(Calendar.MONTH) == calendar.get(Calendar.MONTH)) {
               m.UpdateDay(calendar,jo);
           }
        }
    }

    public void UpdateText() {
        for (int i = 0;i < months.getChildCount();i++) {
            ((compositeMonth) months.getChildAt(i)).UpdateText();
        }
    }
}
