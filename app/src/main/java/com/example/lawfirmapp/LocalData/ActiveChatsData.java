package com.example.lawfirmapp.LocalData;

import com.example.lawfirmapp.R;

public class ActiveChatsData {

    private final String chatUsername, chatMessage, chatTime;
    private final int chatImageID;


    public static final RecentChatsData[] recentChats = {
            new RecentChatsData("Austin Miles", "Hello there", "active", R.drawable.cat),
            new RecentChatsData("Travis Scott", "I'll be at the office at 10", "active", R.drawable.iphone),
            new RecentChatsData("Mike", "I'll the the premium one", "active", R.drawable.cat),
            new RecentChatsData("Jake", "The court hearing is there this afternoon", "active", R.drawable.iphone),
            new RecentChatsData("Kanye West", "I'll be free this afternoon", "active", R.drawable.gold_iphone),
            new RecentChatsData("Tanya", "Done!", "active", R.drawable.future_iphone),
            new RecentChatsData("Mark Z", "Facebook is interested", "active", R.drawable.facebook_icon),
            new RecentChatsData("Jane Fox", "Thank you for your service", "active", R.drawable.linkedin_icon),
    };

    public ActiveChatsData(String chatUsername, String chatMessage, String chatTime, int chatImageID) {
        this.chatUsername = chatUsername;
        this.chatMessage = chatMessage;
        this.chatTime = chatTime;
        this.chatImageID = chatImageID;
    }

    public String getChatUsername() {
        return chatUsername;
    }

    public String getChatMessage() {
        return chatMessage;
    }

    public String getChatTime() {
        return chatTime;
    }

    public int getChatImageID() {
        return chatImageID;
    }

    @Override
    public String toString() {
        return this.chatUsername;
    }
}
