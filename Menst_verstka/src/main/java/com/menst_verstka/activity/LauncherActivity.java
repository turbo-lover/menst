package com.menst_verstka.activity;/**
 * Created by turbo_lover on 29.07.13.
 */

import android.content.Intent;
import android.os.Bundle;
import com.menst_verstka.R;
import com.menst_verstka.utils.myPreferencesWorker;

public class LauncherActivity extends SettingsActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //CheckParams();
        super.onCreate(savedInstanceState);
    }

    private void CheckParams() {
        myPreferencesWorker pf = new myPreferencesWorker(this);
        if(!pf.isEmpty()) {
            Intent i = new Intent(this,CalendarActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        }
    }
    @Override
    protected void SetCompositeElements() {
        HideNavBar();
        HideHeaderSetting();
        SetHeaderText(getString(R.string.main_header_text));
        cmpSetting.SetButtonText(getString(R.string.start_calendar));
        content.addView(cmpSetting);
    }
}