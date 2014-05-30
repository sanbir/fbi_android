package com.manish.customgridview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LoginActivity extends Activity
{

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.login_activity);

        ImageView okBtn = (ImageView) findViewById(R.id.okBtn);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // add password check!!!

                String value = "";
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    value = extras.getString("accountType");
                }

                if (value.equals("student")) {
                    startActivity (new Intent(getApplicationContext(), StudentActivity.class));
                } else if (value.equals("teacher")) {
                    startActivity (new Intent(getApplicationContext(), TeacherActivity.class));
                }
            }
        });

        ImageView cancelBtn = (ImageView) findViewById(R.id.cancelBtn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
