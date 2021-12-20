package com.example.lawfirmapp.Activities;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.Toast;
import com.example.lawfirmapp.Adapters.CustomExpandableListAdapter;
import com.example.lawfirmapp.BottomNavigationBarFragments.ChatBotFragment;
import com.example.lawfirmapp.BottomNavigationBarFragments.ContactUsFragment;
import com.example.lawfirmapp.BottomNavigationBarFragments.FAQFragment;
import com.example.lawfirmapp.BottomNavigationBarFragments.HomeFragment;
import com.example.lawfirmapp.BottomNavigationBarFragments.PaymentFragment;
import com.example.lawfirmapp.LocalData.Questions;
import com.example.lawfirmapp.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;
import java.util.Objects;

import io.alterac.blurkit.BlurLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //the bottom navigation bar
    BottomNavigationView bottomNavigationView;
    AppBarConfiguration appBarConfiguration;
    int startingPosition = 0; //for the bottom navigation bar
    MaterialToolbar customAppBar;
    DrawerLayout drawerLayout;
    NavigationView navigationViewMain;


    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing the bottom navigation bar
        this.bottomNavigationView = findViewById(R.id.bottomNavBar);
        //loading the default fragment
        loadingFragments(new HomeFragment(), 1);

        //setting up the custom app bar
        this.customAppBar = findViewById(R.id.customAppBarMain);
        setSupportActionBar(this.customAppBar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        this.customAppBar.setTitle("");
        this.customAppBar.setSubtitle("");
        //setting up the drawer layout
        this.drawerLayout = findViewById(R.id.drawerLayoutMain);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, this.drawerLayout, this.customAppBar, R.string.nav_open_drawer,
                R.string.nav_close_drawer);
        toggle.setDrawerSlideAnimationEnabled(true);
        this.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //action item color
        Objects.requireNonNull(this.customAppBar.getOverflowIcon()).setColorFilter(Color.BLACK , PorterDuff.Mode.SRC_ATOP);

        ///setting up the navigation view
        this.navigationViewMain = findViewById(R.id.navigationViewMain);
        this.navigationViewMain.setNavigationItemSelectedListener(this);

//        //making notification bar transparent
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//        //making the notification bar transparent
//        changeStatusBarColor();

//        //pass the ID of different destinations
//        this.appBarConfiguration = new AppBarConfiguration.Builder(R.id.homeFragment2,
//                R.id.contactUsFragment, R.id.chatBotFragment, R.id.paymentFragment,
//                R.id.FAQFragment).build();
//
//        //Initialize NavController.
//        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, this.appBarConfiguration);
//        NavigationUI.setupWithNavController(this.bottomNavigationView, navController);

        //handle bottom navigation item clicks
        this.bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment = null;
            int newPosition = 0;

            switch (item.getItemId()) {
                case R.id.b_menu_home:
                    //home page
                    fragment = new HomeFragment();
                    newPosition = 1;
                    break;
                case R.id.b_menu_contact:
                    //contact page
                    fragment = new ContactUsFragment();
                    newPosition = 2;
                    break;
                case R.id.b_menu_chatbot:
                    //chat bot page
                    fragment = new ChatBotFragment();
                    newPosition = 3;
                    break;
                case R.id.b_menu_pay:
                    //payment page
                    fragment = new PaymentFragment();
                    newPosition = 4;
                    break;
                case R.id.b_menu_faq:
                    //FAQ page
                    fragment = new FAQFragment();
                    newPosition = 5;
                    break;
            }
            return loadingFragments(fragment, newPosition);
        });
    }


    //Loading fragments
    private boolean loadingFragments(Fragment fragment, int newPosition) {
        //Switching fragments
        // .setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right,R.anim.enter_from_right,R.anim.exit_to_left)
        if (fragment != null) {
            if (startingPosition > newPosition) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right)
                        .replace(R.id.fragment_container, fragment)
                        .commit();
            }
            if (startingPosition < newPosition) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left)
                        .replace(R.id.fragment_container, fragment)
                        .commit();
            }
            startingPosition = newPosition;
            return true;
        }
        return true;
    }

    //make the notification bar transparent
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }



    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent = null;

        switch (id) {
            case R.id.nav_drawer_admin:
                intent = new Intent(this, AdminActivity.class);
                break;
            case R.id.nav_drawer_settings:
                intent = new Intent(this, SettingsActivity.class);
                break;
            case R.id.nav_drawer_help:
                intent = new Intent(this, HelpActivity.class);
                break;
            case R.id.nav_drawer_exit:
                //ToDo: the Exit code
                //Todo: ask the user if he really wanna exit
                exitApp();

        }

        if (intent != null) {
            startActivity(intent);
        }

        this.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void exitApp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    //handle the drawer when back button is pressed
    @Override
    public void onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //adding the action button/icon to the toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //handle the action item button clicks
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}