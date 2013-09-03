package com.menst_verstka.composite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.menst_verstka.R;

/**
 * Created by Alexander on 02.09.13.
 */
public class compositeWeight extends LinearLayout implements RadioGroup.OnCheckedChangeListener,View.OnClickListener {
    protected RelativeLayout rl;
    protected Number_picker number_picker;
    protected Context pContext;
    protected double min = 0,max = 200;
    private RadioGroup radioGroup;
    private Button delete,back;
    protected JsonObject jsonObject;
    protected TextView left1,left2,right1,right2;

    public compositeWeight(Context context) {
        super(context);
        InitializeComponent(context);
        SetCompositeElements();
        SetEventListeners();
    }

    protected void SetEventListeners() {
        radioGroup.setOnCheckedChangeListener(this);
        back.setOnClickListener(this);
        left1.setOnClickListener(this);
        right1.setOnClickListener(this);
    }

    protected void SetCompositeElements() {
        left2.setVisibility(INVISIBLE);
        right2.setVisibility(INVISIBLE);
        left1.setText("+1");
        right1.setText("-1");
        number_picker.setValue(30);
        rl.addView(number_picker);
    }

    private void InitializeComponent(Context context) {
        pContext = context;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.composite_temperature, this);
        number_picker = new Number_picker(pContext,1.0,min,max,"%.0f");
        rl = (RelativeLayout) findViewById(R.id.temp_number_picker_rl);
        radioGroup = (RadioGroup) findViewById(R.id.composite_temperature_radiogroup);
        delete = (Button) findViewById(R.id.composite_temperature_delete);
        back = (Button) findViewById(R.id.composite_temperature_back);
        left1 = (TextView) findViewById(R.id.composite_temperature_left1);
        left2 = (TextView) findViewById(R.id.composite_temperature_left2);
        right1 = (TextView) findViewById(R.id.composite_temperature_right1);
        right2 = (TextView) findViewById(R.id.composite_temperature_right2);
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) { //convert

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.composite_temperature_back:
                ((Activity)pContext).setResult(Activity.RESULT_OK);
                ((Activity) pContext).finish();
                break;
            case R.id.composite_temperature_delete:

                break;
            case R.id.composite_temperature_left1:
            case R.id.composite_temperature_left2:
            case R.id.composite_temperature_right1:
            case R.id.composite_temperature_right2:
                TextView txt = (TextView) view;
                double d = Double.parseDouble(txt.getText().toString());
                if((int)d != d && number_picker.format != "%.1f") {
                    number_picker.format = "%.1f"; }
                number_picker.addValue(d);
                break;
        }
    }
}
