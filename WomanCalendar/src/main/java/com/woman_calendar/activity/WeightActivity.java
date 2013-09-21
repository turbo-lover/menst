package com.woman_calendar.activity;

import com.woman_calendar.R;
import com.woman_calendar.composite.compositeWeight;
import com.woman_calendar.utils.jsonframeActivity;

/**
 * Created by Alexander on 03.09.13.
 */
public class WeightActivity extends jsonframeActivity {
    protected compositeWeight cmpWeight;

    @Override
    protected void InitializeComponent() {
        super.InitializeComponent();
        cmpWeight = new compositeWeight(this);
    }

    @Override
    protected void SetCompositeElements() {
        SetNavBar(nav_bar_dateFormat.format(calendar.getTime()),R.drawable.arrow_left,R.drawable.arrow_right);
        SetHeaderText(getString(R.string.calendar_title));
        cmpWeight.Set(calendar,jo);
        content.addView(cmpWeight);
    }

    @Override
    protected void InitJsonComposite() {
        super.InitJsonComposite();
        cmpWeight.Set(calendar,jo);
    }


}
