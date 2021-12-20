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

public class ContactUsRecyclerViewAdapter extends RecyclerView.Adapter<ContactUsRecyclerViewAdapter.ViewHolder> {
    private String[] socialMedias;
    private int[] imageIds;
    private ContactUsRecyclerViewAdapter.Listener listener;

    public interface Listener {
        void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public ContactUsRecyclerViewAdapter(String[] socialMedias, int[] imageIds) {
        this.imageIds = imageIds;
        this.socialMedias = socialMedias;
    }

    @Override
    public int getItemCount() {
        return socialMedias.length;
    }

    public void setListener(ContactUsRecyclerViewAdapter.Listener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ContactUsRecyclerViewAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_us_card, parent, false);
        return new ContactUsRecyclerViewAdapter.ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ContactUsRecyclerViewAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        CardView cardView = holder.cardView;

        //change the image of the social media
        ImageView imageView = (ImageView) cardView.findViewById(R.id.contactUsSocialMediaImage);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(this.socialMedias[position]);

        //change the text of the social media name
        TextView title = (TextView) cardView.findViewById(R.id.contactUsSocialMediaName);
        title.setText(this.socialMedias[position]);

        //handle the card clicks to visit the page
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }
}
