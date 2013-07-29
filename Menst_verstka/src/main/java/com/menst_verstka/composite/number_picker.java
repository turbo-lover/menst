package com.menst_verstka.composite;/**
 * Created by turbo_lover on 29.07.13.
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.menst_verstka.R;


public class number_picker extends LinearLayout  implements View.OnClickListener{

    TextView value;
    Button minus,plus;

    double STEP,MAX_VALUE,MIN_VALUE;

    public number_picker(Context context, double step , double min , double max) {
        super(context);
        Initialize_Component();
        SetEventListeners();

        STEP = step;
        MAX_VALUE = max;
        MIN_VALUE = min;
    }

    private void SetEventListeners() {
        minus.setOnClickListener(this);
        plus.setOnClickListener(this);
    }

    private void Initialize_Component() {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.number_picker, this); //TODO set layout, what you want, to inflate;
        value = (TextView) findViewById(R.id.number_picker_value);
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
        if(v<= MAX_VALUE) value.setText(""+v);
    }

    private void DecreaseValue() {
        double v = getValue();
        v-= STEP;
        if(v>= MIN_VALUE) value.setText(""+v);
    }

    public double getValue() {
        double v = Double.parseDouble(String.valueOf(value.getText()));
        return v;
    }
}