package com.menst_verstka.utils;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Alexander on 10.09.13.
 */

//ALL COMPOSITE ELEMENTS MUST HAVE PARENTS ELEMENT - LINEAR LAYOUT
public class jsonCompositeElement extends LinearLayout implements jsonComposite {
    protected Calendar calendar;
    protected JsonObject jo;
    protected frameActivity pActivity;
    protected String JSON_TAG;

    public jsonCompositeElement(Context context) {
        super(context);
        InitializeComponent(context);
        SetCompositeElements();
        SetEventListeners();
    }

    protected void SetEventListeners() {

    }

    protected void SetCompositeElements() {

    }

    protected void InitializeComponent(Context context) {
        pActivity = (frameActivity) context;
    }

    @Override
    public void Set(Calendar calendar, JsonObject jo) {
        this.calendar = (Calendar) calendar.clone();
        this.jo = jo;
    }

    @Override
    public JsonObject GetJson() {
        return jo;
    }

    @Override
    public Calendar GetCalendar() {
        return (Calendar)calendar.clone();
    }
}
