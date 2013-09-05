package com.menst_verstka.activity;

import android.content.Intent;
import android.view.View;
import com.menst_verstka.R;
import com.menst_verstka.composite.compositeCalendar;
import com.menst_verstka.utils.frameActivity;

/**
 * Created by Alexander on 27.08.13.
 */
public class CalendarActivity extends frameActivity implements View.OnClickListener {
    private compositeCalendar cmpCalendar;

    @Override
    protected void InitializeComponent() {
        super.InitializeComponent();
        cmpCalendar = new compositeCalendar(this);
    }

    @Override
    protected void SetCompositeElements() {
        HideNavBar();
        SetHeaderText(getString(R.string.calendar_title));
        content.addView(cmpCalendar);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
}
