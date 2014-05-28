package com.androidengineer.themes;

/**
 * Created by Alex on 26.05.2014.
 */

public class MyTheme {

    private static MyTheme uniqueInstance;

    private MyTheme() { }

    public static MyTheme getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new MyTheme();
        }
        return uniqueInstance;
    }

}







