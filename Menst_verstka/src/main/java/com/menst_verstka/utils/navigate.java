package com.menst_verstka.utils;/**
 * Created by turbo_lover on 29.08.13.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.menst_verstka.R;

public class navigate extends LinearLayout {

    private View left,right;
    private TextView date;
    public navigate(Context context) {
        super(context);
        Initialize_Component();
        //SetEventListeners();
    }

    public void setDate(String date) {
        this.date.setText(date);
    }

    private void SetEventListeners(OnClickListener listener) {
        left.setOnClickListener(listener);
        right.setOnClickListener(listener);
    }

    private void Initialize_Component() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.navigate, this); //TODO set layout, what you want, to inflate;
/*
        left = findViewById(R.id.navigate_left_arrow);
        right = findViewById(R.id.navigate_right_arrow);
        date = (TextView) findViewById(R.id.navigate_Date);*/
    }
}