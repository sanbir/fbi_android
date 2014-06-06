package com.manish.customgridview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.*;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class LoginActivity extends Activity
{
    PopupWindow popUp;
    LinearLayout layout;
    TextView tv;
    LayoutParams params;
    LinearLayout mainLayout;
    Button but;
    boolean click = true;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.login_activity);

        ImageView okBtn = (ImageView) findViewById(R.id.okBtn);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String value = "";
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    value = extras.getString("accountType");
                }

                TextView txtUserName = (TextView) findViewById(R.id.txtUserName);
                TextView txtPassword = (TextView) findViewById(R.id.txtPassword);

                if (value.equals("student")) {

                    if (txtUserName.getText().toString().equals("stu")
                            && txtPassword.getText().toString().equals("123")) {

                        startActivity(new Intent(getApplicationContext(), StudentActivity.class));
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Неверная пара логин-пароль",
						Toast.LENGTH_LONG).show();
                    }

                } else if (value.equals("teacher")) {

                    if (txtUserName.getText().toString().equals("stu")
                            && txtPassword.getText().toString().equals("123")) {
                        startActivity (new Intent(getApplicationContext(), TeacherActivity.class));
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Неверная пара логин-пароль",
                                Toast.LENGTH_LONG).show();
                    }

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
