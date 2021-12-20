package com.example.lawfirmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.lawfirmapp.R;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.Objects;

public class AdminActivity extends AppCompatActivity {

    MaterialToolbar adminActivityAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        this.adminActivityAppBar = findViewById(R.id.adminActivityAppBar);
        setSupportActionBar(this.adminActivityAppBar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.admin_section);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    //handle the back arrow click
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}