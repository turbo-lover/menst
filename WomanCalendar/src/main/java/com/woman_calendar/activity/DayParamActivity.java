package com.woman_calendar.activity;


import com.woman_calendar.R;
import com.woman_calendar.composite.compositeDayParams;
import com.woman_calendar.utils.jsonframeActivity;

/**
 * Created by Alexander on 30.08.13.
 */
public class DayParamActivity extends jsonframeActivity {
    private compositeDayParams dayParams;

    @Override
    protected void InitializeComponent() {
        super.InitializeComponent();
        dayParams = new compositeDayParams(this);
    }

    @Override
    protected void SetCompositeElements() {
        SetNavBar(nav_bar_dateFormat.format(calendar.getTime()),R.drawable.arrow_left,R.drawable.arrow_right);
        InitJsonComposite();
        content.addView(dayParams);
    }
    @Override
    protected void InitJsonComposite() {
        SetNavBarText(nav_bar_dateFormat.format(calendar.getTime()));
        dayParams.Set(calendar,jo);
    }

}
