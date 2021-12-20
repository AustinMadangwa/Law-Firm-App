package com.example.lawfirmapp.BottomNavigationBarFragments;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.Toast;
import com.example.lawfirmapp.Activities.MainActivity;
import com.example.lawfirmapp.Adapters.CustomExpandableListAdapter;
import com.example.lawfirmapp.LocalData.Questions;
import com.example.lawfirmapp.R;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;


public class FAQFragment extends Fragment {

    //expandableListView
    ExpandableListView expandableListView;
    CustomExpandableListAdapter customExpandableListAdapter;

    public FAQFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_f_a_q, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //configuring the expandable list view
        this.expandableListView = (ExpandableListView) view.findViewById(R.id.expandableListView);
        final ArrayList<Questions> questions = getQuestionsData();
        this.customExpandableListAdapter = new CustomExpandableListAdapter(getActivity(), questions);
        this.expandableListView.setAdapter(this.customExpandableListAdapter);
        this.expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            Toast.makeText(getActivity(), questions.get(groupPosition).answers.get(childPosition), Toast.LENGTH_SHORT).show();
            return false;
        });
    }

    private ArrayList<Questions> getQuestionsData() {

        Questions q1 = new Questions("What should I do before buying an immovable?");
        q1.answers.add("Engage a lawyer to conduct a due diligence for you and check the sale agreement before signing some.");

        Questions q2 = new Questions("If the seller or owner of an immovable property has shown me the original title deeds which has no endorsements, do I still need a lawyer to conduct a due diligence?");
        q2.answers.add("Yes. The needs office copy of the title deed may have endorsement.");

        Questions q3 = new Questions("Where there has been a double sale of an immovable property, who between the two purchasers entitled to the property?");
        q3.answers.add("In the absence of special circumstances the first purchaser in time is entitled to the property");

        Questions q4 = new Questions("I lost my title deeds. Can I get a replacement copy?");
        q4.answers.add("Yes");

        Questions q5 = new Questions("If I am buying  an immovable property on installments, how do I have my interests protected?");
        q5.answers.add("Have the title deeds endorsed with details of the sale.");

        Questions q6 = new Questions("Do you do property transfers/conveyancing?");
        q6.answers.add("Yes");

        Questions q7 = new Questions("If I buy an immovable property, pay the purchase price in full and take occupation but delay in taking transfers, am I exposed to risks?");
        q7.answers.add("Yes. The property may be attached and sold in execution at the instance of your sellers creditors");

        Questions q8 = new Questions("There are some mistakes on my title deed, can they be corrected?");
        q8.answers.add("Yes");

        Questions q9 = new Questions("Who chooses the conveyancer?");
        q9.answers.add("Unless the parties agree otherwise, the choice of a conveyancer is the seller’s prerogative ");

        Questions q10 = new Questions("I am outside the country. Can my divorce be proceeded in my absence?");
        q10.answers.add("Yes. If you and your spouse are agreeing on all issues");

        Questions q11 = new Questions("Can you help me get a certificate of no marriage?");
        q11.answers.add("Yes");

        Questions q12 = new Questions("Can you help me get a certificate of no marriage?");
        q12.answers.add("Yes");

        Questions q13 = new Questions("I have documents which must be notarized and legalized. Do you do that?");
        q13.answers.add("Yes");

        Questions q14 = new Questions("Do you do name changes?");
        q14.answers.add("Yes");

        Questions q15 = new Questions("I am buying a property which has title deeds. Can you help me with the change of ownership?");
        q15.answers.add("Yes. We do property transfers");



        ArrayList<Questions> allQuestions = new ArrayList<>();
        allQuestions.add(q1);
        allQuestions.add(q2);
        allQuestions.add(q3);
        allQuestions.add(q4);
        allQuestions.add(q5);
        allQuestions.add(q6);
        allQuestions.add(q7);
        allQuestions.add(q8);
        allQuestions.add(q9);
        allQuestions.add(q10);
        allQuestions.add(q11);
        allQuestions.add(q12);
        allQuestions.add(q13);
        allQuestions.add(q14);
        allQuestions.add(q15);

        return allQuestions;
    }

}