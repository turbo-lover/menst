package com.menst_verstka.composite;/**
 * Created by turbo_lover on 29.07.13.
 */


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.menst_verstka.R;

import java.util.Formatter;
import java.util.Locale;


public class Number_picker extends LinearLayout  implements View.OnClickListener{

    TextView value;
    Button minus,plus;
    String format;

    double STEP,MAX_VALUE,MIN_VALUE;


    public Number_picker(Context context, AttributeSet attrs) {
        super(context, attrs);

            Initialize_Component();
            SetEventListeners();
    }

    /***
     *
     * @param context
     * @param step
     * @param min
     * @param max
     * @param format - "%.0f" - without float; "%.1f"
     */
    public Number_picker(Context context, double step, double min, double max, String format) {
        super(context);
        this.format = format;
        STEP = step;
        MAX_VALUE = max;
        MIN_VALUE = min;


       if(  isInEditMode()) {
            Initialize_Component();
            SetEventListeners();
       }
    }

    private void SetEventListeners() {
        minus.setOnClickListener(this);
        plus.setOnClickListener(this);
    }

    private void Initialize_Component() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.number_picker, this); //TODO set layout, what you want, to inflate;
        value = (TextView) findViewById(R.id.number_picker_value);
        try {
            setValue(MAX_VALUE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        minus = (Button) findViewById(R.id.button_minus);
        plus = (Button) findViewById(R.id.button_plus);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_minus:
                DecreaseValue();
                break;
            case R.id.button_plus:
                IncreaseValue();
                break;
        }
    }


    private void IncreaseValue() {
        double v = getValue();
        v+= STEP;

        try {
            if(v<= MAX_VALUE) {
                setValue(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setValue(double v) {
        try {
            Formatter f = new Formatter(Locale.ENGLISH);
            f.format(format,v);
            value.setText(f.toString());
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    private void DecreaseValue() {
        double v = getValue();
        v-= STEP;
        try {
            if(v>= MIN_VALUE) {
                setValue(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getValue() {
        return Double.parseDouble(String.valueOf(value.getText()));
    }
}
