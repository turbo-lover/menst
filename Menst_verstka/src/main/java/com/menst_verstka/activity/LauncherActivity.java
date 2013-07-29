package com.menst_verstka.activity;/**
 * Created by turbo_lover on 29.07.13.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.menst_verstka.R;
import com.menst_verstka.composite.Number_picker;

public class LauncherActivity extends Activity {

    Number_picker cycle;
    LinearLayout cycle_linear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Initialize_Component();
        SetComposite();
        SetEventListeners();
    }



    private void Initialize_Component() {
        cycle_linear = (LinearLayout) findViewById(R.id.cycle_linear);

    }
    private void SetComposite() {
        cycle = new Number_picker(this,1,1,31,"%.0f");
        cycle.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        cycle_linear.addView(cycle);
    }
    private void SetEventListeners() {

    }


}