package com.example.lawfirmapp.SharedPreferences;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context _context;

    //The mode of our shared preferences
    int PRIVATE_MODE  = 0;

    //The shared preferences file name that is saved
    private static final String PREF_NAME = "welcome_screens_data";

    private static final String IS_IT_THE_FIRST_TIME_LAUNCHING = "IsItTheFirstTimeLaunching";

    @SuppressLint("CommitPrefEdits")
    public PrefManager(Context _context) {
        this._context = _context;
        this.sharedPreferences = this._context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        this.editor  = this.sharedPreferences.edit();
    }

    @SuppressLint("CommitPrefEdits")
    public void setFirstTimeLaunching(boolean isFirstTime){
        this.editor.putBoolean(IS_IT_THE_FIRST_TIME_LAUNCHING, isFirstTime);
        this.editor = this.sharedPreferences.edit();
    }

    public boolean isFirstTimeLaunching(){
        return  this.sharedPreferences.getBoolean(IS_IT_THE_FIRST_TIME_LAUNCHING, true);
    }
}
