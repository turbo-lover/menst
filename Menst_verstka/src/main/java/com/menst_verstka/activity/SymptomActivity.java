package com.menst_verstka.activity;/**
 * Created by turbo_lover on 22.08.13.
 */

import android.app.AlertDialog;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.menst_verstka.composite.symptomView;
import com.menst_verstka.utils.DBHelper;
import com.menst_verstka.utils.frameActivity;
import com.menst_verstka.utils.navigate;

public class SymptomActivity extends frameActivity {
/*
    symptomView sv;
    navigate nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Initialize_Component();
        SetEventListeners();
    }

    private void SetEventListeners() {

    }

    private void Initialize_Component() {
        sv = new symptomView(this);
        setContainer(sv);

        Gson g = new Gson();

        JsonObject jo  = new JsonObject() ;
        jo.add("symptom",g.toJsonTree(sv.getSymptoms_value()));


        AlertDialog.Builder ad = new AlertDialog.Builder(this);
        ad.setMessage(jo.toString());

        DBHelper db = new DBHelper(this);





        ad.show();


    }

*/
}