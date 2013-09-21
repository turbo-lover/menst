package com.woman_calendar.composite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.woman_calendar.R;
import com.woman_calendar.utils.jsonCompositeElement;
import com.woman_calendar.utils.jsonStructure;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by turbo_lover on 22.08.13.
 */
public class symptomView extends jsonCompositeElement implements View.OnClickListener {
    private Button delete,back,save;

    List<symptomElement> symptoms;
    LinearLayout container;
    public symptomView(Context context) {
        super(context);
    }

    @Override
    protected void InitializeComponent(Context context) {
        super.InitializeComponent(context);
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.symptom_view,this);
        container = (LinearLayout) findViewById(R.id.symptom_view_container);
        symptoms = new ArrayList<symptomElement>();
        JSON_TAG = jsonStructure.SYMPTOMS.name();
        back = (Button) findViewById(R.id.back_to_calendar);
        save = (Button) findViewById(R.id.save_param);
        delete = (Button) findViewById(R.id.delete_param);
    }

    @Override
    protected void SetEventListeners() {
        back.setOnClickListener(this);
        save.setOnClickListener(this);
        delete.setOnClickListener(this);
    }

    private List<symptomElement> getSymptoms() {
        return symptoms;
    }

    @Override
    protected void SetCompositeElements() {
        Resources resources = getResources();
        TypedArray images_array = resources.obtainTypedArray(R.array.symptoms_icon);
        int width = resources.getDimensionPixelSize(R.dimen.including_width_symptom_element);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width,0);
        lp.weight = 1;
        for(int i = 0, c =0;i<container.getChildCount();i++) {
            LinearLayout column = (LinearLayout) container.getChildAt(i);
            for(int j=0; j< 5; j++, c++) {
                symptomElement s = new symptomElement(getContext());
                s.setCurrentValue(0);
                s.setText(resources.getTextArray(R.array.symptoms_text)[c]);
                s.setLayoutParams(lp);
                s.setImage(images_array.getDrawable(c));
                column.addView(s);
                symptoms.add(s);
            }
        }
    }

    @Override
    public void Set(Calendar calendar, JsonObject jo) {
        super.Set(calendar,jo);
        SetSymptomsValues(jo != null && jo.has(JSON_TAG));
    }

    private void SetSymptomsValues(boolean from_jo) {
        JsonArray array = null;
        if(from_jo) {
            array = jo.getAsJsonArray(JSON_TAG);
        }
        for(int i = 0, c =0;i<container.getChildCount();i++) {
            LinearLayout column = (LinearLayout) container.getChildAt(i);
            for(int j=0; j< 5; j++, c++) {
                ((symptomElement) column.getChildAt(j)).setCurrentValue((from_jo)?array.get(c).getAsInt():0);
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_to_calendar:
                pActivity.setResult(Activity.RESULT_CANCELED);
                pActivity.finish();
                break;
            case R.id.save_param:
                ModifyJson();
                Intent i = new Intent();
                i.putExtras(pActivity.GenerateExtras(calendar,jo));
                pActivity.setResult(Activity.RESULT_OK,i);
                pActivity.finish();
                break;
            case R.id.delete_param:
                SetSymptomsValues(false);
                break;
        }
    }

    private void ModifyJson() {
        JsonArray array = new JsonArray();
        for(int i = 0, c =0;i<container.getChildCount();i++) {
            LinearLayout column = (LinearLayout) container.getChildAt(i);
            for(int j=0; j< 5; j++, c++) {
                array.add(new JsonPrimitive( ((symptomElement) column.getChildAt(j)).getValue()));
            }
        }
        if(jo == null) {
            jo = new JsonObject(); }
        jo.add(JSON_TAG,array);
    }
}
