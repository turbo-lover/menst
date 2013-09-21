package com.woman_calendar.activity;

import com.woman_calendar.R;
import com.woman_calendar.composite.compositeSettings;
import com.woman_calendar.utils.frameActivity;

/**
 * Created by Alexander on 30.08.13.
 */
public class SettingsActivity extends frameActivity {
    protected compositeSettings cmpSetting;

    @Override
    protected void InitializeComponent() {
        super.InitializeComponent();
        cmpSetting = new compositeSettings(this);
    }

    @Override
    protected void SetCompositeElements() {
        HideNavBar();
        HideHeaderSetting();
        SetHeaderText(getString(R.string.settings));
        cmpSetting.Hideaddition();
        cmpSetting.SetButtonText(getString(R.string.save_settings));
        content.addView(cmpSetting);
    }



}
