package com.menst_verstka.activity;

import com.menst_verstka.R;
import com.menst_verstka.composite.compositeSettings;
import com.menst_verstka.utils.frameActivity;

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
