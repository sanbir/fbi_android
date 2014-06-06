package com.manish.customgridview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.aboutMenu).setVisible(true);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.about_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent settingsActivity = new Intent(StartActivity.this,
                AboutActivity.class);
        startActivity(settingsActivity);
        return true;
    }
    
}
