package com.woman_calendar.composite;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.woman_calendar.R;
import com.woman_calendar.utils.jsonCompositeElement;
import com.woman_calendar.utils.jsonStructure;

import java.util.Calendar;

/**
 * Created by Alexander on 28.08.13.
 */
public class compositeDay extends jsonCompositeElement {
    private TextView date,temperature_txt,abstinence, weight;
    private ImageView symptom,mood,temperature_img,pill;

    public compositeDay(Context context) {
        super(context);
    }

    @Override
    protected void InitializeComponent(Context pContext) {
        super.InitializeComponent(pContext);
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
    @Override
    public void Set(Calendar calendar,JsonObject jsonObject) {
        super.Set(calendar,jsonObject);
        this.date.setText(Integer.toString(this.calendar.get(Calendar.DAY_OF_MONTH)));
        if(jo != null) {
            if(jo.has(jsonStructure.PILL.name()) && jo.get(jsonStructure.PILL.name()).getAsInt() == 1) {
                pill.setImageResource(R.drawable.pill);
            }
            if(jo.has(jsonStructure.WEIGHT.name())) {
                JsonArray array = jo.get(jsonStructure.WEIGHT.name()).getAsJsonArray();
                weight.setText(array.get(1).getAsString()+ ((array.get(0).getAsInt() == 0)?pActivity.getString(R.string.kilograms_short):
                        pActivity.getString(R.string.pounds_short)));
            }
            if(jo.has(jsonStructure.ABSTINENCE.name()) && jo.get(jsonStructure.ABSTINENCE.name()).getAsInt() == 1) {
                abstinence.setText(pActivity.getString(R.string.abstinence_short));
            }
            if(jo.has(jsonStructure.TEMPERATURE.name())) {
                temperature_img.setImageResource(R.drawable.temperature);
                JsonArray array = jo.get(jsonStructure.TEMPERATURE.name()).getAsJsonArray();
                temperature_txt.setText(array.get(0).getAsString() + ((array.get(1).getAsInt() == 0)?"C":"F"));
            }
            if(jo.has(jsonStructure.SYMPTOMS.name())) {
                symptom.setImageResource(R.drawable.head);
            }
            if(jo.has(jsonStructure.MOOD.name())) {
                mood.setImageResource(pActivity.getResources().getIntArray(R.array.mood_icon)[jo.get(jsonStructure.MOOD.name()).getAsInt()]);
            }
        }
    }

}
