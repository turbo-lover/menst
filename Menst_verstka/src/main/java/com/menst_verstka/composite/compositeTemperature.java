package com.menst_verstka.composite;

import android.content.Context;
import android.widget.RadioGroup;

import com.menst_verstka.R;

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

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if(i == R.id.composite_temperature_radio2) {
            number_picker.setValue((number_picker.getValue()*(9/5))+32);
        } else {
            number_picker.setValue((number_picker.getValue()-32) * (5/9));
        }
    }
}
