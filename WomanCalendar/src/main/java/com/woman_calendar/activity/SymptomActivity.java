package com.woman_calendar.activity;/**
 * Created by turbo_lover on 22.08.13.
 */

import com.woman_calendar.R;
import com.woman_calendar.composite.symptomView;
import com.woman_calendar.utils.jsonframeActivity;

public class SymptomActivity extends jsonframeActivity {

    private symptomView sView;
    @Override
    protected void InitializeComponent() {
        super.InitializeComponent();
        sView  = new symptomView(this);
    }

    @Override
    protected void SetCompositeElements() {
        SetNavBar(nav_bar_dateFormat.format(calendar.getTime()),R.drawable.arrow_left,R.drawable.arrow_right);
        SetHeaderText(getString(R.string.calendar_title));
        sView.Set(calendar,jo);
        content.addView(sView);
    }

    @Override
    protected void InitJsonComposite() {
        super.InitJsonComposite();
        sView.Set(calendar,jo);
    }
}