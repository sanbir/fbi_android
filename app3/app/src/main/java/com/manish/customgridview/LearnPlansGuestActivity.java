package com.manish.customgridview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LearnPlansGuestActivity extends Activity
{

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.menu_activity);

        TextView text0 = (TextView) findViewById(R.id.text0);
        text0.setText("    Учебные планы >");
    }

}
