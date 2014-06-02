package com.javatechig.customizedlist;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.example.customizedlist.R;

public class UserActivity extends Activity
{

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.user_activity);


        NewsItem newsItem = (NewsItem) this.getIntent().getSerializableExtra("selectedItem");

        if (null != newsItem) {
            TextView headlineText = (TextView) findViewById(R.id.headlineText);
            String s = newsItem.getHeadline();
            if (s != null) {
                headlineText.setText(s);
            }

            TextView dateText = (TextView) findViewById(R.id.dateText);
            s = newsItem.getDate();
            if (s != null) {
                dateText.setText(s);
            }

            TextView bodyText = (TextView) findViewById(R.id.bodyText);
            s = newsItem.getBodyText();
            if (s != null) {
                bodyText.setText(s);
            }

            ImageView image = (ImageView) findViewById(R.id.image);
            if (image != null) {
                new ImageDownloaderTask(image).execute(newsItem.getUrl());
            }
        }


    }

}