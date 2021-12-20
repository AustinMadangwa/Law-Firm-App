package com.example.lawfirmapp.Adapters;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lawfirmapp.R;


public class RecentPostsRecyclerViewAdapter extends RecyclerView.Adapter<RecentPostsRecyclerViewAdapter.ViewHolder> {

    private final String[] titles;
    private final String[] body;
    private final int[] imageIds;
    private Listener listener;

    public interface Listener {
        void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public RecentPostsRecyclerViewAdapter(String[] titles, String[] body, int[] imageIds) {
        this.imageIds = imageIds;
        this.body = body;
        this.titles = titles;
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecentPostsRecyclerViewAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recent_post_layout, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        CardView cardView = holder.cardView;
        String bodySubstring = this.body[position].substring(0,30) + "...";


        ImageView imageView = cardView.findViewById(R.id.recentPostImage);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(this.titles[position]);



        TextView title = cardView.findViewById(R.id.recentPostTitle);
        TextView body = cardView.findViewById(R.id.recentPostBody);


        //hide the body if the post title is too big
        if(this.titles[position].length() > 30){
            String titleSubString = this.titles[position].substring(0,15) + "..";
            title.setText(titleSubString);
        }else{
            title.setText(this.titles[position]);
        }
        body.setText(bodySubstring);

        cardView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onClick(position);
            }
        });
    }
}
