package com.menst_verstka.composite;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.menst_verstka.R;
import com.menst_verstka.activity.CalendarActivity;
import com.menst_verstka.activity.LauncherActivity;
import com.menst_verstka.utils.myPreferencesWorker;

/**
 * Created by Alexander on 30.08.13.
 */
public class compositeSettings extends RelativeLayout implements View.OnClickListener {
    private Number_picker cycle_duration,menstration_duration;
    private RelativeLayout cycle_duration_rl,menstruation_duration_rl,additional_rl;
    private Button start;
    private RadioGroup start_of_week,language;
    private myPreferencesWorker preferencesWorker;
    private Context pContext;

    public compositeSettings(Context context) {
        super(context);
        InitializeComponent(context);
        SetCompositeElements();
        SetEventListeners();
    }

    public void SetButtonText(String str) {
        start.setText(str);
    }

    public void Hideaddition() {
        additional_rl.setVisibility(View.GONE);
    }

    private void InitializeComponent(Context pContext) {
        this.pContext = pContext;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_main, this);
        preferencesWorker = new myPreferencesWorker(pContext);
        cycle_duration = new Number_picker(pContext,1,15,365,"%.0f");
        menstration_duration = new Number_picker(pContext,1,2,20,"%.0f");
        cycle_duration_rl = (RelativeLayout) findViewById(R.id.cycle_duration_holder);
        menstruation_duration_rl = (RelativeLayout) findViewById(R.id.menstruation_duration_holder);
        start = (Button) findViewById(R.id.start_calendar_btn);
        start_of_week = (RadioGroup) findViewById(R.id.choose_week_start_radiogroup);
        language = (RadioGroup) findViewById(R.id.choose_language_radiogroup);
        additional_rl = (RelativeLayout) findViewById(R.id.main_activity_addition);
    }

    private void GoToCalendar() {
        Intent i = new Intent(pContext,CalendarActivity.class);
        if(pContext.getClass().equals(LauncherActivity.class)) {
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        }
        pContext.startActivity(i);
    }

    private void SetCompositeElements() {
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        if(preferencesWorker.isEmpty()) {
            cycle_duration.setValue(20);
            menstration_duration.setValue(4);
        } else {
            cycle_duration.setValue(Double.parseDouble(preferencesWorker.getCycleDuration()));
            menstration_duration.setValue(Double.parseDouble(preferencesWorker.getDurationOfMenstruation()));
            switch (Integer.parseInt(preferencesWorker.getStartOfTheWeek())) {
                case 0:
                    start_of_week.check(R.id.choose_week_start_radio1);
                    break;
                case 1:
                    start_of_week.check(R.id.choose_week_start_radio2);
                    break;
                default:
                   start_of_week.check(R.id.choose_week_start_radio3);
                    break;
            }
            switch (Integer.parseInt(preferencesWorker.getLanguage())) {
                case 0:
                    language.check(R.id.choose_language_radio1);
                    break;
                case 1:
                    language.check(R.id.choose_language_radio2);
                    break;
                default:
                    language.check(R.id.choose_language_radio3);
                    break;
            }
        }
        cycle_duration_rl.addView(cycle_duration,p);
        menstruation_duration_rl.addView(menstration_duration,p);
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

    private void SetEventListeners() {
        start.setOnClickListener(this);
    }
}
