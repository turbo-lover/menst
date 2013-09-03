package com.menst_verstka.activity;

import com.menst_verstka.R;
import com.menst_verstka.composite.compositeDayParams;
import com.menst_verstka.utils.frameActivity;

/**
 * Created by Alexander on 30.08.13.
 */
public class DayParamActivity extends frameActivity {
    private compositeDayParams dayParams;

    @Override
    protected void InitializeComponent() {
        super.InitializeComponent();
        dayParams = new compositeDayParams(this);
    }
    @Override
    protected void SetCompositeElements() {
        HideHeaderSetting();
        SetNavBar("",R.drawable.arrow_left,R.drawable.arrow_right);
        content.addView(dayParams);
    }
}
