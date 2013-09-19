package com.menst_verstka.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;

/**
 * Created by Alexander on 21.08.13.
 */
public class myPreferencesWorker {
    private SharedPreferences sPref;
    private Context context;

    final private String location = "calendarPref";
    final private String preferenceStartOfTheWeek = "startOfTheWeek";
    final private String preferenceLanguage = "language";
    final private String preferenceCycleDuration = "cycleDuration";
    final private String preferenceDurationOfMenstruation = "durationOfMenstruation";

    public myPreferencesWorker(Context in) {
        context = in;
    }

    public void setStartOfTheWeek(String startOfTheWeek) {
        ContextWrapper cw = new ContextWrapper(context);
        sPref = cw.getSharedPreferences(location, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(preferenceStartOfTheWeek ,startOfTheWeek);
        ed.commit();
    }

    public void setCycleDuration(String cycleDuration) {
        ContextWrapper cw = new ContextWrapper(context);
        sPref = cw.getSharedPreferences(location, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(preferenceCycleDuration ,cycleDuration);
        ed.commit();
    }

    public void setDurationOfMenstruation(String durationOfMenstruation) {
        ContextWrapper cw = new ContextWrapper(context);
        sPref = cw.getSharedPreferences(location, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(preferenceDurationOfMenstruation ,durationOfMenstruation);
        ed.commit();
    }

    public void setLanguage(String language) {
        ContextWrapper cw = new ContextWrapper(context);
        sPref = cw.getSharedPreferences(location, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(preferenceLanguage ,language);
        ed.commit();
    }

    public String getStartOfTheWeek() {
        ContextWrapper cw = new ContextWrapper(context);
        sPref = cw.getSharedPreferences(location, Context.MODE_PRIVATE);
        return sPref.getString(preferenceStartOfTheWeek,"");
    }

    public String getCycleDuration() {
        ContextWrapper cw = new ContextWrapper(context);
        sPref = cw.getSharedPreferences(location, Context.MODE_PRIVATE);
        return sPref.getString(preferenceCycleDuration,"");
    }

    public String getDurationOfMenstruation() {
        ContextWrapper cw = new ContextWrapper(context);
        sPref = cw.getSharedPreferences(location, Context.MODE_PRIVATE);
        return sPref.getString(preferenceDurationOfMenstruation,"");
    }

    public String getLanguage() {
        ContextWrapper cw = new ContextWrapper(context);
        sPref = cw.getSharedPreferences(location, Context.MODE_PRIVATE);
        return sPref.getString(preferenceLanguage,"0");
    }

    public boolean isEmpty() {
        return (getLanguage().isEmpty() || getCycleDuration().isEmpty() || getDurationOfMenstruation().isEmpty() || getStartOfTheWeek().isEmpty());
    }
}
