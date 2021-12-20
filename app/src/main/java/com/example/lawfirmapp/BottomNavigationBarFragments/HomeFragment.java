package com.example.lawfirmapp.BottomNavigationBarFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.lawfirmapp.Activities.ShowPostActivity;
import com.example.lawfirmapp.Adapters.RecentPostsRecyclerViewAdapter;
import com.example.lawfirmapp.LocalData.RecentPostsData;
import com.example.lawfirmapp.R;

import org.jetbrains.annotations.NotNull;

public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recentPostRV = view.findViewById(R.id.recentPostsRV);

        //get the data
        int dataLength = RecentPostsData.recentPosts.length;
        String[] postTitles = new String[dataLength];
        String[] postBodies = new String[dataLength];
        int[] postImageIDs = new int[dataLength];
        String[] postAuthors = new String[dataLength];
        String[] postDates = new String[dataLength];
        String[] postTimes = new String[dataLength];

        for (int i = 0; i < dataLength; i++) {
            postTitles[i] = RecentPostsData.recentPosts[i].getPostTitle();
            postBodies[i] = RecentPostsData.recentPosts[i].getPostBody();
            postImageIDs[i] = RecentPostsData.recentPosts[i].getPostImageID();
            postAuthors[i] = RecentPostsData.recentPosts[i].getPostAuthor();
            postDates[i] = RecentPostsData.recentPosts[i].getPostDate();
            postTimes[i] = RecentPostsData.recentPosts[i].getPostTime();
        }

        // Inflate the layout for this fragment
        RecentPostsRecyclerViewAdapter adapter = new RecentPostsRecyclerViewAdapter(postTitles, postBodies, postImageIDs);
        recentPostRV.setAdapter(adapter);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recentPostRV.setLayoutManager(layoutManager);

        //handle clicks and view the post
        adapter.setListener(new RecentPostsRecyclerViewAdapter.Listener() {
            @Override
            public void onClick(int position) {

                Intent intent = new Intent(getActivity(), ShowPostActivity.class);
                intent.putExtra("postTitle",postTitles[position]);
                intent.putExtra("postBody",postBodies[position]);
                intent.putExtra("postImage",postImageIDs[position]);
                intent.putExtra("postAuthor",postAuthors[position]);
                intent.putExtra("postDate",postDates[position]);
                intent.putExtra("postTime",postTimes[position]);
                startActivity(intent);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(
                R.layout.fragment_home, container, false);
    }
}