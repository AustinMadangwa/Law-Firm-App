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
import com.example.lawfirmapp.LocalData.RecentChatsData;
import com.example.lawfirmapp.R;

public class RecentChatsFragment extends Fragment {

    public RecentChatsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recent_chats, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recentChatsRV);

        //get the data
        int dataLength = RecentChatsData.recentChats.length;
        String[] messages = new String[dataLength],
                names = new String[dataLength],
                times = new String[dataLength];
        int[] chatImages = new int[dataLength];

        //create the alternating color array
        boolean[] colors = new boolean[dataLength];
        boolean flag = true;

        for (int i = 0; i < dataLength; i++) {
            messages[i] = RecentChatsData.recentChats[i].getChatMessage();
            names[i] = RecentChatsData.recentChats[i].getChatUsername();
            times[i] = RecentChatsData.recentChats[i].getChatTime();
            chatImages[i] = RecentChatsData.recentChats[i].getChatImageID();
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