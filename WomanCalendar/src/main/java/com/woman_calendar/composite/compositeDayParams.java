package com.woman_calendar.composite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.gson.JsonObject;
import com.woman_calendar.R;
import com.woman_calendar.activity.SymptomActivity;
import com.woman_calendar.activity.TemperatureActivity;
import com.woman_calendar.activity.WeightActivity;
import com.woman_calendar.utils.jsonCompositeElement;
import com.woman_calendar.utils.jsonStructure;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Alexander on 30.08.13.
 */
public class compositeDayParams extends jsonCompositeElement implements View.OnClickListener {
    private Button menstruation_start,menstruation_end,clear_params,go_back;
    private LinearLayout weight,temperature,pill,symptoms;
    private SimpleDateFormat date_format;

    public compositeDayParams(Context context) {
        super(context);
    }

    @Override
    protected void SetEventListeners() {
        menstruation_start.setOnClickListener(this);
        menstruation_end.setOnClickListener(this);
        clear_params.setOnClickListener(this);
        go_back.setOnClickListener(this);
        weight.setOnClickListener(this);
        temperature.setOnClickListener(this);
        pill.setOnClickListener(this);
        symptoms.setOnClickListener(this);
    }
    @Override
    protected void InitializeComponent(Context pContext) {
        super.InitializeComponent(pContext);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.composite_day_params, this);
        menstruation_start = (Button) findViewById(R.id.menstruation_start);
        menstruation_end = (Button) findViewById(R.id.menstruation_end);
        clear_params = (Button) findViewById(R.id.delete_param);
        go_back = (Button) findViewById(R.id.back_to_calendar);
        weight = (LinearLayout) findViewById(R.id.composite_day_params_weight);
        temperature = (LinearLayout) findViewById(R.id.composite_day_params_temperature);
        pill = (LinearLayout) findViewById(R.id.composite_day_params_pill);
        symptoms = (LinearLayout) findViewById(R.id.composite_day_params_symptoms);
    }
    @Override
    public void Set(Calendar calendar,JsonObject jo) {
        super.Set(calendar,jo);
        //SOME ACTION
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.back_to_calendar:
                 pActivity.setResult(Activity.RESULT_CANCELED);
                 pActivity.finish();
                break;
            case R.id.delete_param:
                BuildDialog();
                break;
            case R.id.composite_day_params_weight:
                i = new Intent(pActivity, WeightActivity.class);
                i.putExtras(pActivity.GenerateExtras(calendar,jo));
                pActivity.startActivityForResult(i, 1);
                break;
            case R.id.composite_day_params_temperature:
                i = new Intent(pActivity, TemperatureActivity.class);
                i.putExtras(pActivity.GenerateExtras(calendar,jo));
                pActivity.startActivityForResult(i, 1);
                break;
            case R.id.composite_day_params_pill:
                TogglePill();
                i = new Intent();
                i.putExtras(pActivity.GenerateExtras(calendar,jo));
                pActivity.setResult(Activity.RESULT_OK,i);
                pActivity.finish();
                break;
            case R.id.composite_day_params_symptoms:
                i = new Intent(pActivity, SymptomActivity.class);
                i.putExtras(pActivity.GenerateExtras(calendar,jo));
                pActivity.startActivityForResult(i, 1);
                break;
        }
    }

    private void TogglePill() {
        String pill = jsonStructure.PILL.name();
        if(jo == null) {
            jo = new JsonObject(); }
        if(jo.has(pill) && jo.get(pill).getAsInt() == 1) {
            jo.remove(pill);
        } else {
            jo.addProperty(pill,1);
        }
    }

    private void BuildDialog() {

    }
}
