package com.woman_calendar.composite;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.woman_calendar.R;
import com.woman_calendar.utils.frameActivity;
import com.woman_calendar.utils.jsonCompositeElement;

/**
 * Created by Alexander on 22.09.13.
 */
public class compositeMood extends jsonCompositeElement implements View.OnClickListener {
    //LinearLayout ;
    Button back,delete;
    public compositeMood(Context context) {
        super(context);
    }

    @Override
    protected void InitializeComponent(Context context) {
        super.InitializeComponent(context);
        back = (Button) findViewById(R.id.back_to_calendar);
        delete = (Button) findViewById(R.id.delete_param);
    }

    @Override
    public void onClick(View view) {

    }
}
