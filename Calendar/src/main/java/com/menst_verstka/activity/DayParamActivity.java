package com.menst_verstka.activity;


import com.menst_verstka.R;
import com.menst_verstka.composite.compositeDayParams;
import com.menst_verstka.utils.jsonframeActivity;

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
