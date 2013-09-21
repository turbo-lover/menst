package com.woman_calendar.utils;

/**
 * Created by Alexander on 15.09.13.
 */
public enum jsonStructure {
    WEIGHT,             //ARRAY [type{0,1};value{double}]
    TEMPERATURE,        //ARRAY [type{0,1};value{double}]
    SYMPTOMS,           //ARRAY [n,n,n,n,n,n,n,....]  n = {0,1,2,3}
    MOOD,               //OBJECT n
    PILL,               //OBJECT {0,1}
    ABSTINENCE,         //OBJECT {0,1}
    MENSTRUATION_DAY,   //OBJECT n
    NOTE                //OBJECT TEXT
}
