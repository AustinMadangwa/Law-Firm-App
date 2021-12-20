package com.example.lawfirmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lawfirmapp.R;
import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowPostActivity extends AppCompatActivity {

    PorterShapeImageView postImageIV;
    TextView postTitleTV, postBodyTV;
    TextView postTime, postDate, postAuthor;

    String TITLE = "postTitle", BODY = "postBody", IMAGE = "postImage", author = "postAuthor", date = "postDate", time = "postTime";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_show_post);

        this.postImageIV = findViewById(R.id.postImageIV);
        this.postTitleTV = findViewById(R.id.postTitleTV);
        this.postBodyTV = findViewById(R.id.postBodyTV);
        this.postAuthor = findViewById(R.id.postAuthor);
        this.postDate = findViewById(R.id.postDate);
        this.postTime = findViewById(R.id.postTime);


        this.postTitleTV.setText(getIntent().getStringExtra(this.TITLE));
        this.postImageIV.setImageResource(getIntent().getIntExtra(this.IMAGE, R.drawable.law));
        this.postImageIV.setClipToOutline(true);
        this.postBodyTV.setText(getIntent().getStringExtra(this.BODY));
        this.postAuthor.setText(getIntent().getStringExtra(this.author));
        this.postDate.setText(getIntent().getStringExtra(this.date));
        this.postTime.setText(getIntent().getStringExtra(this.time));


        //make the notification bar transparent
        changeStatusBarColor();
    }

    //make the notification bar transparent
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}