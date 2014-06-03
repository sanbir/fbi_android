package com.manish.customgridview;


import android.app.Activity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class UserActivityNew extends Activity
{
    private UserItemNew feed;
    //private UserItemNew custom;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.user_activity_new);


        feed = (UserItemNew) this.getIntent().getSerializableExtra("feed");

        if (null != feed) {
            ImageView thumb = (ImageView) findViewById(R.id.image);
            if(feed.getUrlBig() == null || feed.getUrlBig().equals("")) {
                thumb.setVisibility(View.GONE);
            } else {
                if (thumb != null) {
                    new ImageDownloaderTaskNew(thumb).execute(feed.getUrlBig());
                }
            }

            TextView headlineText = (TextView) findViewById(R.id.headlineText);
            headlineText.setText(feed.getHeadline());

            TextView dateText = (TextView) findViewById(R.id.dateText);
            dateText.setText(feed.getDate());

            TextView bodyText = (TextView) findViewById(R.id.bodyText);
            bodyText.setText(feed.getBody());

            bodyText.setMovementMethod(LinkMovementMethod.getInstance());
        }

/*        custom = (UserItemNew) this.getIntent().getSerializableExtra("custom");

        if (null != feed) {
            ImageView thumb = (ImageView) findViewById(R.id.image);
            if(feed.getUrlBig() == null || feed.getUrlBig().equals("")) {
                thumb.setVisibility(View.GONE);
            } else {
                if (thumb != null) {
                    new ImageDownloaderTaskNew(thumb).execute(feed.getUrlBig());
                }
            }

            TextView headlineText = (TextView) findViewById(R.id.headlineText);
            headlineText.setText(feed.getHeadline());

            TextView dateText = (TextView) findViewById(R.id.dateText);
            dateText.setText(feed.getDate());

            TextView bodyText = (TextView) findViewById(R.id.bodyText);
            bodyText.setText(feed.getBody());

            bodyText.setMovementMethod(LinkMovementMethod.getInstance());
        }*/


    }

}