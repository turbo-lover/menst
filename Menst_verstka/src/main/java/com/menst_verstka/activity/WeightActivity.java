package com.menst_verstka.activity;

import com.menst_verstka.R;
import com.menst_verstka.composite.compositeSettings;
import com.menst_verstka.composite.compositeWeight;
import com.menst_verstka.utils.frameActivity;

/**
 * Created by Alexander on 03.09.13.
 */
public class WeightActivity extends frameActivity {
    protected compositeWeight cmpWeight;

    @Override
    protected void InitializeComponent() {
        super.InitializeComponent();
        cmpWeight = new compositeWeight(this);
    }

    @Override
    protected void SetCompositeElements() {
        SetNavBar("Some day",R.drawable.arrow_left,R.drawable.arrow_right);
        SetHeaderText(getString(R.string.settings));
        content.addView(cmpWeight);
    }
}
