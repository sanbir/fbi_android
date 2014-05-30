package com.manish.customgridview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class StartActivity extends Activity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.start_activity);

        LinearLayout studentBtn = (LinearLayout) findViewById(R.id.studentBtn);
        studentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                i.putExtra("accountType","student");
                startActivity(i);
            }
        });

        LinearLayout teacherBtn = (LinearLayout) findViewById(R.id.teacherBtn);
        teacherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                i.putExtra("accountType","teacher");
                startActivity(i);
            }
        });

        LinearLayout guestBtn = (LinearLayout) findViewById(R.id.guestBtn);
        guestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GuestActivity.class);
                startActivity(i);
            }
        });
    }
    
}
