package com.menst_verstka.composite;

import android.content.Context;

/**
 * Created by Alexander on 02.09.13.
 */
public class compositeTemperature extends compositeWeight {

    public compositeTemperature(Context context) {
        super(context);
    }

    @Override
    protected void SetCompositeElements() {
        number_picker.setValue(30);
        rl.addView(number_picker);
    }
    @Override
    protected void SetEventListeners() {
        super.SetEventListeners();
        left2.setOnClickListener(this);
        right2.setOnClickListener(this);
    }
}
