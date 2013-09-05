package com.menst_verstka.activity;/**
 * Created by turbo_lover on 22.08.13.
 */

import android.app.AlertDialog;
import com.menst_verstka.R;
import com.menst_verstka.composite.symptomView;
import com.menst_verstka.utils.frameActivity;

public class SymptomActivity extends frameActivity {

    private symptomView sView;
    @Override
    protected void InitializeComponent() {
        super.InitializeComponent();
        sView  = new symptomView(this);
    }

    @Override
    protected void SetCompositeElements() {
        SetNavBar("Some day",R.drawable.arrow_left,R.drawable.arrow_right);
        SetHeaderText(getString(R.string.calendar_title));
        content.addView(sView);
    }



    @Override
    protected void Forward() {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setMessage("forward").show();
    }

    @Override
    protected void Backward() {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setMessage("backward").show();
    }
}