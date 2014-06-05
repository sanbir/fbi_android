package com.manish.customgridview;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class PreferencesTeacher extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences_teacher);
    }
}