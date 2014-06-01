package com.javatechig.feedreader;

import android.app.Application;
import android.content.Context;

/**
 * Created by Alex on 02.06.2014.
 */
public class MyApplication extends Application {

    private static Context context;

    public void onCreate(){
        super.onCreate();
        MyApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }
}