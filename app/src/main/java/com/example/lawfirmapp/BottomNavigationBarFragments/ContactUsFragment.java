package com.example.lawfirmapp.BottomNavigationBarFragments;

import android.content.Intent;
import android.net.Uri;
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

import com.example.lawfirmapp.Adapters.ContactUsRecyclerViewAdapter;
import com.example.lawfirmapp.LocalData.ContactUsData;
import com.example.lawfirmapp.R;

import org.jetbrains.annotations.NotNull;


public class ContactUsFragment extends Fragment {

    public ContactUsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView contactUsRV = view.findViewById(R.id.contactUsRecyclerView);

        //get the contact us data
        int dataLength =  ContactUsData.socialMediaData.length;
        String[] socialMediaNames = new String[dataLength];
        String[] socialMediaLinks =  new String[dataLength];
        int[] socialMediaImageIDs =  new int[dataLength];

        for (int i = 0; i < dataLength; i++) {
            socialMediaNames[i] = ContactUsData.socialMediaData[i].getSocialMediaName();
            socialMediaLinks[i] = ContactUsData.socialMediaData[i].getSocialMediaLink();
            socialMediaImageIDs[i] = ContactUsData.socialMediaData[i].getSocialMediaImageID();
        }

        //connect the data to the recyclerView and set the layout manager
        ContactUsRecyclerViewAdapter adapter = new ContactUsRecyclerViewAdapter(socialMediaNames,socialMediaImageIDs);
        contactUsRV.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        contactUsRV.setLayoutManager(layoutManager);

        //handle the clicks
        adapter.setListener(new ContactUsRecyclerViewAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse(socialMediaLinks[position]));
                startActivity(implicit);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_us, container, false);
    }
}