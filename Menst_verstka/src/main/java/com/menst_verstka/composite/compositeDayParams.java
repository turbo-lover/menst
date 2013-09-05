package com.menst_verstka.composite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.menst_verstka.R;
import com.menst_verstka.activity.DayParamActivity;
import com.menst_verstka.activity.TemperatureActivity;
import com.menst_verstka.activity.WeightActivity;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Alexander on 30.08.13.
 */
public class compositeDayParams extends RelativeLayout implements View.OnClickListener {
    private Button menstruation_start,menstruation_end,clear_params,go_back;
    private Activity pActivity;
    private LinearLayout weight,temperature;

    private JsonObject jsonObject;
    private Calendar calendar;
    private SimpleDateFormat date_format;


    public compositeDayParams(Context context,JsonObject jo) {
        super(context);
        InitializeComponent(context,jo);
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

    private void InitializeComponent(Context pContext,JsonObject jo) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.composite_day_params, this);
        pActivity = (Activity)pContext;
        menstruation_start = (Button) findViewById(R.id.menstruation_start);
        menstruation_end = (Button) findViewById(R.id.menstruation_end);
        clear_params = (Button) findViewById(R.id.delete_param);
        go_back = (Button) findViewById(R.id.back_to_calendar);
        weight = (LinearLayout) findViewById(R.id.composite_day_params_weight);
        temperature = (LinearLayout) findViewById(R.id.composite_day_params_temperature);
    }

    public void Set(JsonObject jo) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_to_calendar:
          //      Intent i = new   SET DATA TO PASS ONACTIVITYRESLUT
                 pActivity.setResult(Activity.RESULT_CANCELED);
                 pActivity.finish();
                break;
            case R.id.delete_param:
                BuildDialog();
                break;
            case R.id.composite_day_params_weight:
                 pActivity.startActivityForResult(new Intent(pActivity, WeightActivity.class), 1);
                break;
            case R.id.composite_day_params_temperature:
                 pActivity.startActivityForResult(new Intent(pActivity, TemperatureActivity.class), 1);
            break;
        }
    }

    private void BuildDialog() {

    }
}
