package com.menst_verstka.composite;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.menst_verstka.R;

/**
 * Created by turbo_lover on 21.08.13.
 */
public class symptomElement extends LinearLayout implements View.OnClickListener {
    /* Элемент который загружаем в таблицу симптомов */
    private ImageView image;
    ImageView [] circles;
    private ImageView circle1;
    private ImageView circle2;
    private ImageView circle3;
    private TextView text;
    private int currentValue;

    public symptomElement(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeVariables();
    }

    public symptomElement(Context context) {
        super(context);
        initializeVariables();
        setListeners();
    }

    private void setListeners() {
        this.setOnClickListener(this);
    }



    private void initializeVariables() {

        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.symptom_element,this);

        image = (ImageView) findViewById(R.id.elementImage);
        text = (TextView) findViewById(R.id.elementText);

        circle1 =(ImageView)this.findViewById(R.id.red_circles_1);
        circle2 =(ImageView)this.findViewById(R.id.red_circles_2);
        circle3 =(ImageView)this.findViewById(R.id.red_circles_3);
        circles = new ImageView[]{circle1,circle2,circle3};
    }
    /* setters starts here*/
    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }
    public void setText(TextView text) {
        this.text = text;
    }

    public void setImage(Bitmap image) {
        this.image.setImageBitmap(image);
    }
    /* setters ends*/

    /* override method starts here*/
    @Override
    public void onClick(View view) {
        switch (currentValue) {
            case 0:
                currentValue++;
                setCircles(currentValue);
                break;
            case 1:
                currentValue++;
                setCircles(currentValue);
                break;
            case 2:
                currentValue++;
                setCircles(currentValue);
                break;
            case 3:
                currentValue = 0;
                setCircles(currentValue);
                break;
        }
    }
    /* override method starts here*/

    /* my method */
    private void setCircles(int currentValue) {
        if(currentValue == 0)
            for (ImageView v: circles) {
                v.setBackgroundResource(R.color.Transparent);
            }

    }
}
