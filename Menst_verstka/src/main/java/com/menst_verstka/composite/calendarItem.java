package com.menst_verstka.composite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.menst_verstka.R;
import com.menst_verstka.activity.DayParamActivity;

import java.util.Calendar;

/**
 * Created by Alexander on 28.08.13.
 */
public class calendarItem extends RelativeLayout {

    private TextView date,temperature_txt,abstinence, weight;
    private ImageView symptom,mood,temperature_img,pill;

    private JsonObject jsonObject;
    private Calendar calendar;

    public calendarItem(Context context) {
        super(context);
        InitializeComponent(context);
    }

    private void InitializeComponent(Context pContext) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.calendar_item, this);
        date = (TextView) findViewById(R.id.calendar_item_date);
        symptom = (ImageView) findViewById(R.id.calendar_item_symptom_image);
        mood = (ImageView) findViewById(R.id.calendar_item_mood_image);
        temperature_img = (ImageView) findViewById(R.id.calendar_item_temperature_img);
        temperature_txt = (TextView) findViewById(R.id.calendar_item_temperature_text);
        weight = (TextView) findViewById(R.id.calendar_item_weight);
        pill = (ImageView) findViewById(R.id.calendar_item_pill_image);
        abstinence = (TextView) findViewById(R.id.calendar_item_abstinence);
    }

    public void setElement(Calendar calendar,JsonObject jsonObject) {
        this.calendar = calendar;
        this.jsonObject = jsonObject;
        this.date.setText(Integer.toString(this.calendar.get(Calendar.DAY_OF_MONTH)));
        /*
        this.symptom.setImageResource(symptom);
        this.mood.setImageResource(mood);
        this.temperature_txt.setText(temperature_txt);
        this.temperature_img.setImageResource(temperature_img);
        this.abstinence.setText(abstinence);
        this.weight.setText(weight);
        this.pill.setImageResource(pill);
        */
    }
}
