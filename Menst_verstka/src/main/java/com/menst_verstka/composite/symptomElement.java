package com.menst_verstka.composite;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.menst_verstka.R;

/**
 * Created by turbo_lover on 21.08.13.
 */
public class symptomElement extends LinearLayout {

    ImageView image;
    TextView text;

    public symptomElement(Context context) {
        super(context);
        initializeVariables();
    }

    private void initializeVariables() {

        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.symptom_element,this);

        image = (ImageView) findViewById(R.id.elementImage);
        text = (TextView) findViewById(R.id.elementText);
    }

    public void setText(TextView text) {
        this.text = text;
    }

    public void setImage(Bitmap image) {
        this.image.setImageBitmap(image);
    }
}
