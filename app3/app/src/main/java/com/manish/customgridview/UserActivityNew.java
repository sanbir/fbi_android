package com.manish.customgridview;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.*;

public class UserActivityNew extends Activity
{
    private UserItemNew feed;
    private UserItemNew custom;

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

        custom = (UserItemNew) this.getIntent().getSerializableExtra("custom");

        if (null != custom) {
            ImageView thumb = (ImageView) findViewById(R.id.image);
            if(custom.getUrlBig() == null || custom.getUrlBig().equals("")) {
                thumb.setVisibility(View.GONE);
            } else {
                if (thumb != null) {
                    thumb.setImageResource(Integer.parseInt(custom.getUrlBig()));
                }
            }

            TextView headlineText = (TextView) findViewById(R.id.headlineText);
            headlineText.setText(custom.getHeadline());

            TextView dateText = (TextView) findViewById(R.id.dateText);
            dateText.setText(custom.getDate());

            TextView bodyText = (TextView) findViewById(R.id.bodyText);
            bodyText.setText(custom.getBody());

            bodyText.setMovementMethod(LinkMovementMethod.getInstance());
        }


    }

/*    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK)
        {
            Uri imageUri = data.getData();
            try {
                Bitmap bitmap = getThumbnail(imageUri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Bitmap getThumbnail(Uri uri) throws FileNotFoundException, IOException{
        InputStream input = this.getContentResolver().openInputStream(uri);

        BitmapFactory.Options onlyBoundsOptions = new BitmapFactory.Options();
        onlyBoundsOptions.inJustDecodeBounds = true;
        onlyBoundsOptions.inDither=true;//optional
        onlyBoundsOptions.inPreferredConfig=Bitmap.Config.ARGB_8888;//optional
        BitmapFactory.decodeStream(input, null, onlyBoundsOptions);
        input.close();
        if ((onlyBoundsOptions.outWidth == -1) || (onlyBoundsOptions.outHeight == -1))
            return null;

        int originalSize = (onlyBoundsOptions.outHeight > onlyBoundsOptions.outWidth) ? onlyBoundsOptions.outHeight : onlyBoundsOptions.outWidth;

        double ratio = (originalSize > 230) ? (originalSize / 230) : 1.0;

        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inSampleSize = getPowerOfTwoForSampleRatio(ratio);
        bitmapOptions.inDither=true;//optional
        bitmapOptions.inPreferredConfig=Bitmap.Config.ARGB_8888;//optional
        input = this.getContentResolver().openInputStream(uri);
        Bitmap bitmap = BitmapFactory.decodeStream(input, null, bitmapOptions);
        input.close();
        return bitmap;
    }

    private static int getPowerOfTwoForSampleRatio(double ratio){
        int k = Integer.highestOneBit((int)Math.floor(ratio));
        if(k==0) return 1;
        else return k;
    }*/

}