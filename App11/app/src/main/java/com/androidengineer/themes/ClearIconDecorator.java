package com.androidengineer.themes;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.View;

/**
 * Created by Alex on 26.05.2014.
 */
public class ClearIconDecorator extends AbstractIconDecorator{

    /**
     * Creates an undo decorator.
     * @param context the app's context
     * @param views the views that has been decorated to be undone.
     */
    public ClearIconDecorator(Context context,View[] views){
        super(context,views);
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void decorate() {
        for (View view : views) {
            view.setBackground(null);
        }
    }
}
