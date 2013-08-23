package com.menst_verstka.activity;/**
 * Created by turbo_lover on 29.07.13.
 */

import android.app.Activity;
import android.os.Bundle;

import com.menst_verstka.R;
import com.menst_verstka.composite.Number_picker;

public class LauncherActivity extends Activity {
    private Number_picker cycle_duration,menstration_duration;
    //menstruation duratio 2-20
    //cycle_duration 15-365

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitializeComponent();
        SetCompositeElements();
        SetEventListeners();
    }

    private void SetCompositeElements() {
       // cycl
    }


    private void InitializeComponent() {
        setContentView(R.layout.activity_main);
        cycle_duration = new Number_picker(this,1,15,365,"");
        menstration_duration = new Number_picker(this,1,2,20,"");
    }
    private void SetEventListeners() {

    }


}