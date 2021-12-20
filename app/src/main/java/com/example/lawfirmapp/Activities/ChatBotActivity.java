package com.example.lawfirmapp.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.lawfirmapp.BottomNavigationBarFragments.ChatBotFragment;
import com.example.lawfirmapp.ChatBotFragments.ActiveChatsFragment;
import com.example.lawfirmapp.ChatBotFragments.RecentChatsFragment;
import com.example.lawfirmapp.R;
import com.google.android.material.appbar.MaterialToolbar;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.Objects;

public class ChatBotActivity extends AppCompatActivity {

    MaterialToolbar chatBotActivityAppBar;
    Button btnRecentChats, btnActiveChats;
    FrameLayout chatBotActivityFragContainer;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot);


        //handle the app bar configurations
        this.chatBotActivityAppBar = findViewById(R.id.chatBotActivityAppBAr);
        setSupportActionBar(this.chatBotActivityAppBar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.chats);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //action item color
        Objects.requireNonNull(this.chatBotActivityAppBar.getOverflowIcon()).setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);

        //handle the button clicks and the fragment swapping
        this.btnActiveChats = findViewById(R.id.btnActiveChats);
        this.btnRecentChats = findViewById(R.id.btnRecentChats);
        this.chatBotActivityFragContainer = findViewById(R.id.chatBotActivityFragContainer);


        //active chat click
        this.btnActiveChats.setOnClickListener(v -> {
            Fragment fragment = new ActiveChatsFragment();
            ReplaceFragments(fragment,1);
        });

        //recent chat click
        this.btnRecentChats.setOnClickListener(v -> {
            Fragment fragment = new RecentChatsFragment();
            ReplaceFragments(fragment,0);
        });

        //set the default fragment -> recentChats
        Fragment fragment = new RecentChatsFragment();
        ReplaceFragments(fragment,0);
    }


    //handle back arrow clicks
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    //adding the action button/icon to the toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chat_bot_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //handle the action item button clicks
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    private void ReplaceFragments(Fragment fragment, int position) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.chatBotActivityFragContainer, fragment);

        if (position == 1) {
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
        } else {
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
        }
        fragmentTransaction.commit();
    }
}