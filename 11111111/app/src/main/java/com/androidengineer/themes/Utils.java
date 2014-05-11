package com.androidengineer.themes;

import android.app.Activity;
import android.content.Intent;

public class Utils
{
	private static int sTheme;

	public final static int THEME_DEFAULT = 0;
	public final static int THEME_WHITE = 1;
	public final static int THEME_BLUE = 2;
	public final static int THEME_BROWN = 3;

	/**
	 * Set the theme of the Activity, and restart it by creating a new Activity
	 * of the same type.
	 */
	public static void changeToTheme(Activity activity, int theme)
	{
		sTheme = theme;
		activity.finish();

		activity.startActivity(new Intent(activity, activity.getClass()));
	}

	/** Set the theme of the activity, according to the configuration. */
	public static void onActivityCreateSetTheme(Activity activity)
	{
		switch (sTheme)
		{
            default:
            case THEME_DEFAULT:
                break;
            case THEME_WHITE:
                activity.setTheme(android.R.style.Theme_Holo_Light);
                break;
            case THEME_BLUE:
                activity.setTheme(android.R.style.Theme_Holo_Wallpaper);
                break;
            case THEME_BROWN:
                activity.setTheme(R.style.CustomTheme_LightBrown);
                break;
		}
	}
}
