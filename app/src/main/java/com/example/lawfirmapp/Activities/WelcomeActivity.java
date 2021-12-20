package com.example.lawfirmapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.example.lawfirmapp.R;
import com.example.lawfirmapp.SharedPreferences.PrefManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.jetbrains.annotations.NotNull;

import io.alterac.blurkit.BlurLayout;

public class WelcomeActivity extends AppCompatActivity {

    private ViewPager welcomeViewpager;
    private MyWelcomeViewPagerAdapter myWelcomeViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;
    private Button btn_skip, btn_next;
    private PrefManager prefManager;
    BlurLayout blurLayout1;



//    @Override
//    protected void onStart() {
//        super.onStart();
//        this.blurLayout1.startBlur();
//    }

//    @Override
//    protected void onStop() {
//        this.blurLayout1.pauseBlur();
//        super.onStop();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //check whether its the first time for the user to launch the app or not
        this.prefManager = new PrefManager(this);
        if(!this.prefManager.isFirstTimeLaunching()){
            launchHomeScreen();
            finish();
        }

        //making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        setContentView(R.layout.activity_welcome);

        this.welcomeViewpager = findViewById(R.id.welcomeViewPager);
        this.dotsLayout = findViewById(R.id.layoutDots);
        this.btn_next = findViewById(R.id.btn_next);
        this.btn_skip = findViewById(R.id.btn_skip);

        //blur layout
//        this.blurLayout1 = findViewById(R.id.welcomeOneBlur);
//        this.blurLayout1.startBlur();

        //the welcome sliders layouts
        this.layouts = new int[]{
                R.layout.welcome_slide_1,
                R.layout.welcome_slide_2,
                R.layout.welcome_slide_3,
                R.layout.welcome_slide_4,
        };

        //adding dots to the bottom
        addBottomDots(0);

        //making the notification bar transparent
        changeStatusBarColor();

        //handling the viewPager configurations
        this.myWelcomeViewPagerAdapter = new MyWelcomeViewPagerAdapter();
        this.welcomeViewpager.setAdapter(this.myWelcomeViewPagerAdapter);
        this.welcomeViewpager.addOnPageChangeListener(viewPagerPageChangeListener);
        //View pager Animations
        this.welcomeViewpager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(@NonNull @NotNull View page, float position) {
                //Do transformations here
                final float normalizedPosition = Math.abs(Math.abs(position) - 1);
                page.setAlpha(normalizedPosition);
            }
        });

        //handle the buttons clicks
        this.btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking for last page
                // if last page home screen will be launched
                int current = getItem(1);
                if (current < layouts.length) {
                    // move to next screen
                    welcomeViewpager.setCurrentItem(current);
                } else {
                    launchHomeScreen();
                }
            }
        });

        this.btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                blurLayout1.pauseBlur();//todo: change it
                launchHomeScreen();
            }
        });


    }

    private int getItem(int i) {
        return this.welcomeViewpager.getCurrentItem() + i;
    }

    //make the notification bar transparent
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private void addBottomDots(int currentPage) {
        this.dots = new TextView[this.layouts.length];
        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);
        this.dotsLayout.removeAllViews();
        for (int i = 0; i < this.dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if(dots.length > 0){
            dots[currentPage].setTextColor(colorsActive[currentPage]);
        }

    }

    private void launchHomeScreen() {
        this.prefManager.setFirstTimeLaunching(false);
        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
        finish();
    }

    //The viewPager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
                btn_next.setText(getString(R.string.start));
                btn_skip.setVisibility(View.GONE);
            } else {
                // still pages are left
                btn_next.setText(getString(R.string.next));
                btn_skip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    //The ViewPager
    public class MyWelcomeViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyWelcomeViewPagerAdapter() {
        }

        @NonNull
        @NotNull
        @Override
        public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {
            this.layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view  = this.layoutInflater.inflate(layouts[position],container, false);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }

}