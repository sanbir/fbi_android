package com.manish.customgridview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StudyActivity extends Activity
{

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.menu_activity);

        TextView text0 = (TextView) findViewById(R.id.text0);
        text0.setText("    Учеба >");
    }

}
