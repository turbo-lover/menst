package com.menst_verstka.activity;

import com.menst_verstka.composite.compositeTemperature;

/**
 * Created by Alexander on 03.09.13.
 */
public class TemperatureActivity extends WeightActivity {

    @Override
    protected void InitializeComponent() {
        super.InitializeComponent();
        cmpWeight = new compositeTemperature(this);
    }

}
