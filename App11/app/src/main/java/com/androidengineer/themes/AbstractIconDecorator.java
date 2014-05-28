package com.androidengineer.themes;

/**
 * Created by Alex on 26.05.2014.
 */
import java.util.Arrays;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.View;

public abstract class abstracticondecorator implements Decorable{

    protected View view;
    protected View[] views;
    protected int drawableId;
    protected Context context;
    /**
     * Concrete classes must call this constructor to conform the decorator's contract.
     * @param context the app's context
     * @param view the view to be decorated
     * @param drawableId the drawable id dependency over <code>R.drawable.yourId</code> to be set
     * as background to the view of this constructor.
     */
    public AbstractIconDecorator(Context context, View view, int drawableId){
        super();
        this.view = view;
        this.context = context;
        this.drawableId = drawableId;
        decorate();
    }
    /**
     * Concrete classes must call this constructor to conform the undo decorator's contract.
     * @param context context the app's context
     * @param views the views to be undone.
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public AbstractIconDecorator(Context context,View[] views){
        super();
        this.context = context;
        this.views = Arrays.copyOf(views, views.length);
        decorate();
    }
}
