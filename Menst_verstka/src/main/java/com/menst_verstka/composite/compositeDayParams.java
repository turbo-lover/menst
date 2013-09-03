package com.menst_verstka.composite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.menst_verstka.R;
import com.menst_verstka.activity.DayParamActivity;
import com.menst_verstka.activity.TemperatureActivity;
import com.menst_verstka.activity.WeightActivity;

/**
 * Created by Alexander on 30.08.13.
 */
public class compositeDayParams extends RelativeLayout implements View.OnClickListener {
    private Button menstruation_start,menstruation_end,clear_params,go_back;
    private Context pContext;
    private LinearLayout weight,temperature;

    public compositeDayParams(Context context) {
        super(context);
        InitializeComponent(context);
        SetEventListeners();
    }

    private void SetEventListeners() {
        menstruation_start.setOnClickListener(this);
        menstruation_end.setOnClickListener(this);
        clear_params.setOnClickListener(this);
        go_back.setOnClickListener(this);
        weight.setOnClickListener(this);
        temperature.setOnClickListener(this);
    }

    private void InitializeComponent(Context pContext) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.composite_day_params, this);
        this.pContext = pContext;
        menstruation_start = (Button) findViewById(R.id.menstruation_start);
        menstruation_end = (Button) findViewById(R.id.menstruation_end);
        clear_params = (Button) findViewById(R.id.delete_param);
        go_back = (Button) findViewById(R.id.back_to_calendar);
        weight = (LinearLayout) findViewById(R.id.composite_day_params_weight);
        temperature = (LinearLayout) findViewById(R.id.composite_day_params_temperature);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_to_calendar:
          //      Intent i = new   SET DATA TO PASS ONACTIVITYRESLUT
                ((Activity) pContext).setResult(Activity.RESULT_CANCELED);
                ((Activity) pContext).finish();
                break;
            case R.id.delete_param:
                BuildDialog();
                break;
            case R.id.composite_day_params_weight:
                ((Activity)pContext).startActivityForResult(new Intent(pContext,WeightActivity.class),1);
                break;
            case R.id.composite_day_params_temperature:
                ((Activity)pContext).startActivityForResult(new Intent(pContext,TemperatureActivity.class),1);
                break;
        }
    }

    private void BuildDialog() {

    }
}
