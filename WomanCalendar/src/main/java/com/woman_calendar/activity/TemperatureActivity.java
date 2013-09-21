package com.woman_calendar.activity;

import com.woman_calendar.composite.compositeTemperature;

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
