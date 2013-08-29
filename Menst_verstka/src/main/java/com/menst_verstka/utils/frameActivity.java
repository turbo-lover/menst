package com.menst_verstka.utils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import android.widget.LinearLayout;
import com.menst_verstka.R;

/**
 * Created by Turbo on 28.08.13.
 */
public class frameActivity extends Activity {

    private FrameLayout header;
    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_activity);

        InitializeComponent();
        SetListeners();
    }

    /**
     * For override :)
     */
    protected void SetListeners() {

    }

    protected void InitializeComponent() {
       header = (FrameLayout) findViewById(R.id.header);
       container = (LinearLayout) findViewById(R.id.container);
    }

    protected void setHeader(View v) {
        header.addView(v);
    }

    public void setContainer(View v) {
        container.addView(v);
    }
}
