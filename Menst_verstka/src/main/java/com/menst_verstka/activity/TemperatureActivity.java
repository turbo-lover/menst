package com.menst_verstka.activity;

import com.menst_verstka.composite.compositeTemperature;
import com.menst_verstka.composite.compositeWeight;
import com.menst_verstka.utils.frameActivity;

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
