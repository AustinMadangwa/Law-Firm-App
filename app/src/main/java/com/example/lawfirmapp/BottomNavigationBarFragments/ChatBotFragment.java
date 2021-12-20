package com.example.lawfirmapp.BottomNavigationBarFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.lawfirmapp.Activities.ChatBotActivity;
import com.example.lawfirmapp.R;
import com.google.android.material.textfield.TextInputEditText;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;


public class ChatBotFragment extends Fragment {

    TextInputEditText userEmailOrUsername, userPassword;
    Button btnUserLogin, btnCreateAccount;

    public ChatBotFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.userEmailOrUsername = view.findViewById(R.id.userEmailOrUsername);
        this.userPassword = view.findViewById(R.id.userPassword);
//        this.btnCreateAccount = view.findViewById(R.id.btnCreateAccount);
        this.btnUserLogin = view.findViewById(R.id.btnUserLogin);

        //handle the user login button click
        this.btnUserLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernameOrEmail = Objects.requireNonNull(userEmailOrUsername.getText()).toString().trim();
                String password = Objects.requireNonNull(userPassword.getText()).toString().trim();

                if (password.isEmpty() || usernameOrEmail.isEmpty()) {
                    Toast.makeText(getActivity(), "Please enter all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getActivity(), ChatBotActivity.class);
                    intent.putExtra("username", usernameOrEmail);
                    intent.putExtra("password", password);
                    startActivity(intent);
                }
            }
        });

//        this.btnCreateAccount.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String usernameOrEmail = Objects.requireNonNull(userEmailOrUsername.getText()).toString().trim();
//                String password = Objects.requireNonNull(userPassword.getText()).toString().trim();
//
//                if (password.isEmpty() || usernameOrEmail.isEmpty()) {
//                    Toast.makeText(getActivity(), "Please enter all fields", Toast.LENGTH_SHORT).show();
//                } else {
//                    Intent intent = new Intent(getActivity(), ChatBotActivity.class);
//                    intent.putExtra("username", usernameOrEmail);
//                    intent.putExtra("password", password);
//                    startActivity(intent);
//                }
//            }
//        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat_bot, container, false);
    }

    private boolean validateForm(TextInputEditText textInputEditText) {

        return true;
    }
}