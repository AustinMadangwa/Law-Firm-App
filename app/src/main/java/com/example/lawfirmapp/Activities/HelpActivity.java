package com.example.lawfirmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lawfirmapp.R;
import com.google.android.material.appbar.MaterialToolbar;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.Objects;

public class HelpActivity extends AppCompatActivity {

    MaterialToolbar helpActivityAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        this.helpActivityAppBar = findViewById(R.id.helpActivityAppBar);
        setSupportActionBar(this.helpActivityAppBar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.help_center);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.BLUE);
//        }

    }

//    Call Us on
//                       +263242756681, +263 (242) 756 681, +263242781439, (242) 781 439
//    Between 0800hrs to 1645hrs Mon-Fri (+2GMT)


    //handle the back arrow click
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    //make the user call the company contact
    public void callUs(View view) {
        Intent implicit = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:+263242756681"));
        startActivity(implicit);
    }

    //make the user call the company contact
    public void callUs1(View view) {
        Intent implicit = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:+263242781439"));
        startActivity(implicit);
    }

    //make the user call the company contact
    public void callUs2(View view) {
        Intent implicit = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:+263(242)756 681"));
        startActivity(implicit);
    }

    //make the user call the company contact
    public void callUs3(View view) {
        Intent implicit = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:+263(242)781439"));
        startActivity(implicit);
    }

    //make the user send the email to the company
    public void sendEmail(View view) {
        Intent mailIntent = new Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:kanokangasc@live.com"));
        startActivity(mailIntent);
    }

    //make the user send the feedback
    public void sendFeedback(View view) {
        //todo: make sure you send the feedback
    }

    //make the user visit the company's website
    public void visitWeb(View view) {
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kanokangalawfirm.net"));
        startActivity(implicit);
    }
}