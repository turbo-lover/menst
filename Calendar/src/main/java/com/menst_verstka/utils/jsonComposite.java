package com.menst_verstka.utils;

import com.google.gson.JsonObject;

import java.util.Calendar;

/**
 * Created by Alexander on 10.09.13.
 */
public interface jsonComposite {
    public void Set(Calendar calendar,JsonObject jo);
    public JsonObject GetJson();
    public Calendar GetCalendar();
}
