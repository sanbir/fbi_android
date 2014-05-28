package com.androidengineer.themes;

/**
 * Created by Alex on 26.05.2014.
 */
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.View;
/**
 * Use this class to decorate views with icons thru dependency injection passing R.drawable.yourId
 * @author Ricardo Ferreira
 * @version 1.0
 * @since 07/04/2014
 */
public class IconDecorator extends AbstractIconDecorator{

    /**
     * Creates an universal icon decorator to be used while dealing with view's decoration.
     * @param context the app's context
     * @param view the view to be decorated
     * @param drawableId the drawable id dependency over <code>R.drawable.yourId</code> to be set
     * as background to the view of this constructor.
     */
    public IconDecorator(Context context,View view, int drawableId){
        super(context, view, drawableId);
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void decorate() {
        view.setBackground(context.getResources().getDrawable(drawableId));
    }
}