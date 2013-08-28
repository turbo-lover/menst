package com.menst_verstka.activity;/**
 * Created by turbo_lover on 22.08.13.
 */

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.LinearLayout;
import com.menst_verstka.R;
import com.menst_verstka.composite.symptomElement;

public class SymptomActivity extends Activity {


    LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.symptom_view);
        Initialize_Component();
        SetEventListeners();
    }

    private void SetEventListeners() {

    }

    private void Initialize_Component() {

        container = (LinearLayout) findViewById(R.id.symptom_view_container);
        TypedArray images_array = getResources().obtainTypedArray(R.array.symptoms_icon);
        for(int i = 0, c =0;i<container.getChildCount();i++)
        {
            LinearLayout column = (LinearLayout) container.getChildAt(i);
            for(int j=0; j< 5; j++, c++)
            {
                symptomElement s = new symptomElement(this);
                s.setCurrentValue(1);
                s.setText(getResources().getTextArray(R.array.symptoms_text)[c]);

                int width = getResources().getDimensionPixelSize(R.dimen.including_symptom_element);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width,0);
                lp.weight =1;

                s.setLayoutParams(lp);

                TypedValue typedValue = images_array.peekValue(c);
                int resourceId = typedValue.resourceId;

                s.setImage(resourceId);

                if (column != null) {
                    column.addView(s);
                }
            }
        }
    }
}