package com.example.lawfirmapp.Adapters;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lawfirmapp.R;


public class ChatRecyclerViewAdapter extends RecyclerView.Adapter<ChatRecyclerViewAdapter.ViewHolder> {
    String[] usernames;
    String[] messages, chatTimes;
    int[] chatImages;
    boolean[] colors;
    Listener listener;


    //the interface to handle the button clicks
    public interface Listener {
        void onClick(int position);
    }

    public ChatRecyclerViewAdapter(String[] usernames, String[] messages, String[] chatTimes, int[] chatImages, boolean[] colors) {
        this.usernames = usernames;
        this.messages = messages;
        this.chatTimes = chatTimes;
        this.chatImages = chatImages;
        this.colors = colors;
    }

    //the viewHolder class
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ConstraintLayout constraintLayout;

        public ViewHolder(ConstraintLayout constraintLayout) {
            super(constraintLayout);
            this.constraintLayout = constraintLayout;
        }
    }


    //create the ViewHolder
    @NonNull
    @Override
    public ChatRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ConstraintLayout constraintLayout = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.single_chat_layout, parent, false);
        return new ViewHolder(constraintLayout);
    }

    //bind the data into the recyclerView components
//    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ChatRecyclerViewAdapter.ViewHolder holder, int position) {
        ConstraintLayout cl = holder.constraintLayout;

        //change the background color of the layout
        int color1 = R.color.chatColor;
        int color2 = R.color.whiteDark;
        if (colors[position]) {
            cl.setBackgroundResource(color1);
        } else {
            cl.setBackgroundResource(color2);
        }

        //get the references to the components to add data
        ImageView chatImage = cl.findViewById(R.id.chatImage);
        TextView chatUsername = cl.findViewById(R.id.chatUserName);
        TextView chatMessage = cl.findViewById(R.id.chatMessage);
        TextView chatTime = cl.findViewById(R.id.chatTime);

        //set the data to the components
        Drawable drawable = ContextCompat.getDrawable(cl.getContext(), chatImages[position]);
        chatImage.setImageDrawable(drawable);
        chatImage.setClipToOutline(true); //make the image round
        chatUsername.setText(usernames[position]);
        chatMessage.setText(messages[position]);
        chatTime.setText(chatTimes[position]);

        //handle the chat clicks
        cl.setOnClickListener(v -> {
            if (listener != null) {
                listener.onClick(position);
            }
        });
    }


    //get the number of elements to be displayed on the recyclerView
    @Override
    public int getItemCount() {
        return this.usernames.length;
    }

    //set the Listener
    public void setListener(Listener listener) {
        this.listener = listener;
    }
}
