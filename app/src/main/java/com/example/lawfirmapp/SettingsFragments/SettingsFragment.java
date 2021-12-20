package com.example.lawfirmapp.SettingsFragments;

import android.os.Bundle;
import com.example.lawfirmapp.R;
import androidx.preference.PreferenceFragmentCompat;
public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }
}