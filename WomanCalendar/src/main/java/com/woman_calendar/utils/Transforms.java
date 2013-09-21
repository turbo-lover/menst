package com.woman_calendar.utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by turbo_lover on 29.07.13.
 */
public class Transforms {
    static public int PxtDIP(float dp, Context cnt)
    {

        int value = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, cnt.getResources().getDisplayMetrics());
        return value;
    }

}
