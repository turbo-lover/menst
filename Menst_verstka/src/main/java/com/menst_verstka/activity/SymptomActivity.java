package com.menst_verstka.activity;/**
 * Created by turbo_lover on 22.08.13.
 */

import android.os.Bundle;
import com.menst_verstka.composite.symptomView;
import com.menst_verstka.utils.frameActivity;
import com.menst_verstka.utils.navigate;

public class SymptomActivity extends frameActivity {

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
        nav = new navigate(this);
        nav.setDate("25 Ã¿ﬂ 2013");
        setContainer(nav);
        setContainer(sv);

    }


}