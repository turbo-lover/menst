package com.menst_verstka.composite;

import android.content.Context;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.menst_verstka.R;
import com.menst_verstka.utils.jsonStructure;

/**
 * Created by Alexander on 02.09.13.
 */
public class compositeTemperature extends compositeWeight {


    public compositeTemperature(Context context) {
        super(context);
    }

    @Override
    protected void InitializeComponent(Context context) {
        super.InitializeComponent(context);
        JSON_TAG = jsonStructure.TEMPERATURE.name();
        labelText.setText(pActivity.getString(R.string.temperature));
        radioButton1.setText(pActivity.getString(R.string.temperature_celsius));
        radioButton2.setText(pActivity.getString(R.string.temperature_fahrenheit));
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if(i == R.id.composite_temperature_radio2) {
            number_picker.setValue((number_picker.getValue()*(9.0/5.0))+32);
        } else {
            number_picker.setValue((number_picker.getValue()-32) * (5.0/9.0));
        }
    }
}
