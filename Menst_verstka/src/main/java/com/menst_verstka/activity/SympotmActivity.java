package com.menst_verstka.activity;/**
 * Created by turbo_lover on 22.08.13.
 */

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.menst_verstka.R;
import com.menst_verstka.composite.symptomElement;

public class SympotmActivity extends Activity {


    LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        Initialize_Component();
        SetEventListeners();
    }

    private void SetEventListeners() {

    }

    private void Initialize_Component() {

        container = (LinearLayout) findViewById(R.id.symptom_element_container);
        for(int i = 0, c =0;i<container.getChildCount();i++)
        {
            for(int j=0; j< 5; j++, c++)
            {
                symptomElement s = new symptomElement(this);
                s.setCurrentValue(1);
                s.setText(getResources().getTextArray(R.array.symptoms)[c]);

                int width = getResources().getDimensionPixelSize(R.dimen.including_symptom_element);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width,0);

                s.setLayoutParams(lp);
                Bitmap b = BitmapFactory.decodeResource(getResources(),R.drawable.appetite);
                s.setImage(b);
                LinearLayout column = (LinearLayout) container.getChildAt(i);
                if (column != null) {
                    column.addView(s);
                }
            }
        }




    }
}