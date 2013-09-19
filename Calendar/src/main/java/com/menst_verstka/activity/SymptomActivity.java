package com.menst_verstka.activity;/**
 * Created by turbo_lover on 22.08.13.
 */

import android.app.AlertDialog;
import com.menst_verstka.R;
import com.menst_verstka.composite.symptomView;
import com.menst_verstka.utils.frameActivity;
import com.menst_verstka.utils.jsonframeActivity;

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