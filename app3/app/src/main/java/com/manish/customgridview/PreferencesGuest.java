package com.manish.customgridview;


import android.os.Bundle;
import android.preference.PreferenceActivity;

public class PreferencesGuest extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences_guest);
    }
}