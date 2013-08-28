package com.menst_verstka.composite;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.menst_verstka.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by turbo_lover on 22.08.13.
 */
public class symptomView extends LinearLayout {

    List<symptomElement> symptoms;
    LinearLayout container;
    public symptomView(Context context) {
        super(context);

        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.symptom_view,this);

        container = (LinearLayout) findViewById(R.id.symptom_view_container);
        symptoms = new ArrayList<symptomElement>();

        setSympomElements();
    }

    public List<symptomElement> getSymptoms() {
        return symptoms;
    }

    //maybe you should reorganize this shit
    private void setSympomElements() {
        Resources resources = getResources();
        TypedArray images_array = resources.obtainTypedArray(R.array.symptoms_icon);
        int width = resources.getDimensionPixelSize(R.dimen.including_symptom_element);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width,0);
        lp.weight =1;
        for(int i = 0, c =0;i<container.getChildCount();i++)
        {
            LinearLayout column = (LinearLayout) container.getChildAt(i);
            for(int j=0; j< 5; j++, c++)
            {
                symptomElement s = new symptomElement(getContext());

                s.setCurrentValue(1);
                s.setText(resources.getTextArray(R.array.symptoms_text)[c]);
                s.setLayoutParams(lp);
                s.setImage(images_array.getDrawable(c));

                if (column != null) {
                    column.addView(s);
                    symptoms.add(s);
                }
            }
        }
    }
}
