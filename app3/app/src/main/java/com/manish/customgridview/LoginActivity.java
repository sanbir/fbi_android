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
                // add password check!!!

                String value = "";
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    value = extras.getString("accountType");
                }

                TextView txtUserName = (TextView) findViewById(R.id.txtUserName);
                TextView txtPassword = (TextView) findViewById(R.id.txtPassword);

                if (value.equals("student")) {
                    /*f (txtUserName.getText()==("qwe")
                            && txtPassword.getText()==("123")) {*/

                    Intent i = new Intent(getApplicationContext(), StudentActivity.class);
                    i.putExtra("accountType","teacher");
                    //i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    finish();
                    /*} else {
                        *//*popUp = new PopupWindow(LoginActivity.this);
                        layout = new LinearLayout(LoginActivity.this);
                        mainLayout = new LinearLayout(LoginActivity.this);
                        tv = new TextView(LoginActivity.this);
                        but = new Button(LoginActivity.this);
                        but.setText("Click Me");
                        but.setOnClickListener(new View.OnClickListener() {

                            public void onClick(View v) {
                                if (click) {
                                    popUp.showAtLocation(mainLayout, Gravity.BOTTOM, 10, 10);
                                    popUp.update(50, 50, 300, 80);
                                    click = false;
                                } else {
                                    popUp.dismiss();
                                    click = true;
                                }
                            }

                        });
                        params = new LayoutParams(LayoutParams.WRAP_CONTENT,
                                LayoutParams.WRAP_CONTENT);
                        layout.setOrientation(LinearLayout.VERTICAL);
                        tv.setText("Hi this is a sample text for popup window");
                        layout.addView(tv, params);
                        popUp.setContentView(layout);
                        // popUp.showAtLocation(layout, Gravity.BOTTOM, 10, 10);
                        mainLayout.addView(but, params);
                        setContentView(mainLayout);*//*

                        Toast.makeText(LoginActivity.this, "Неверная пара логин-пароль",
						Toast.LENGTH_LONG).show();

                    }*/


                } else if (value.equals("teacher")) {
/*                    if (txtUserName.getText().equals("qwe")
                            && txtPassword.getText().equals("123")) {*/
                        startActivity (new Intent(getApplicationContext(), TeacherActivity.class));
                    finish();
/*                    } else {

                        Toast.makeText(LoginActivity.this, "Неверная пара логин-пароль",
                                Toast.LENGTH_LONG).show();

                    }*/

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
