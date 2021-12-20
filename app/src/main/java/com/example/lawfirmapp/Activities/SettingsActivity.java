package com.example.lawfirmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.lawfirmapp.R;
import com.example.lawfirmapp.SettingsFragments.SettingsFragment;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.Objects;

public class SettingsActivity extends AppCompatActivity {

    MaterialToolbar settingsAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        this.settingsAppBar = findViewById(R.id.settingsAppBar);
        setSupportActionBar(this.settingsAppBar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.settings);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        if (findViewById(R.id.settingFragmentContainer) != null) {
            if (savedInstanceState != null) {
                return;
            }
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.settingFragmentContainer, new SettingsFragment());
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
            fragmentTransaction.commit();
        }
    }

    //handle the back arrow click
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}