package com.menst_verstka.activity;/**
 * Created by turbo_lover on 29.07.13.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.menst_verstka.R;
import com.menst_verstka.composite.Number_picker;
import com.menst_verstka.utils.myPreferencesWorker;

public class LauncherActivity extends Activity implements View.OnClickListener {
    private Number_picker cycle_duration,menstration_duration;
    private RelativeLayout cycle_duration_rl,menstruation_duration_rl;
    private Button start;
    private RadioGroup start_of_week,language;
    private myPreferencesWorker preferencesWorker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        preferencesWorker = new myPreferencesWorker(this);
        CheckParams();
        super.onCreate(savedInstanceState);
        InitializeComponent();
        SetCompositeElements();
        SetEventListeners();
    }

    private void CheckParams() {
        if(!preferencesWorker.isEmpty()) {
          GoToCalendar(); }
    }

    private void GoToCalendar() {
        Intent i = new Intent(this,CalendarActivity.class);
        startActivity(i);
    }
    private void SetCompositeElements() {
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        cycle_duration.setValue(20);
        menstration_duration.setValue(4);
        cycle_duration_rl.addView(cycle_duration,p);
        menstruation_duration_rl.addView(menstration_duration,p);
    }


    private void InitializeComponent() {
        setContentView(R.layout.activity_main);
        cycle_duration = new Number_picker(this,1,15,365,"%.0f");
        menstration_duration = new Number_picker(this,1,2,20,"%.0f");
        cycle_duration_rl = (RelativeLayout) findViewById(R.id.cycle_duration_holder);
        menstruation_duration_rl = (RelativeLayout) findViewById(R.id.menstruation_duration_holder);
        start = (Button) findViewById(R.id.start_calendar_btn);
        start_of_week = (RadioGroup) findViewById(R.id.choose_week_start_radiogroup);
        language = (RadioGroup) findViewById(R.id.choose_language_radiogroup);
    }

    private void SetEventListeners() {
        start.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        preferencesWorker.setCycleDuration(cycle_duration.getStringValue());
        preferencesWorker.setDurationOfMenstruation(menstration_duration.getStringValue());
        int r1 = 0 ,r2 = 0;
        if (start_of_week.getCheckedRadioButtonId() == R.id.choose_week_start_radio2) r1 = 1;
        if (start_of_week.getCheckedRadioButtonId() == R.id.choose_week_start_radio3) r1 = 2;
        if (language.getCheckedRadioButtonId() == R.id.choose_language_radio2) r2 = 1;
        if (language.getCheckedRadioButtonId() == R.id.choose_language_radio3) r2 = 2;
        preferencesWorker.setStartOfTheWeek(Integer.toString(r1));
        preferencesWorker.setLanguage(Integer.toString(r2));
        GoToCalendar();
    }
}