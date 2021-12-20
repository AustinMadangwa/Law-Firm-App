package com.example.lawfirmapp.ChatBotFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lawfirmapp.Adapters.ChatRecyclerViewAdapter;
import com.example.lawfirmapp.LocalData.ActiveChatsData;
import com.example.lawfirmapp.R;

import org.jetbrains.annotations.NotNull;


public class ActiveChatsFragment extends Fragment {

    public ActiveChatsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_active_chats, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.activeChatsRV);

        //get the data
        int dataLength = ActiveChatsData.recentChats.length;
        String[] messages = new String[dataLength],
                names = new String[dataLength],
                times = new String[dataLength];
        int[] chatImages = new int[dataLength];

        //create the alternating color array
        boolean[] colors = new boolean[dataLength];
        boolean flag = true;

        for (int i = 0; i < dataLength; i++) {
            messages[i] = ActiveChatsData.recentChats[i].getChatMessage();
            names[i] = ActiveChatsData.recentChats[i].getChatUsername();
            times[i] = ActiveChatsData.recentChats[i].getChatTime();
            chatImages[i] = ActiveChatsData.recentChats[i].getChatImageID();
            colors[i] = flag;
            flag = !flag;
        }
        //call the recyclerview adapter to populate the recyclerview
        ChatRecyclerViewAdapter adapter = new ChatRecyclerViewAdapter(names,messages,times,chatImages,colors);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        adapter.setListener(position -> {
            Toast.makeText(getActivity(), "chat clicked", Toast.LENGTH_SHORT).show();
        });
    }
}