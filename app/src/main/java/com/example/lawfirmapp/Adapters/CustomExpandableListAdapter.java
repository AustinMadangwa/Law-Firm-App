package com.example.lawfirmapp.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.lawfirmapp.LocalData.Questions;
import com.example.lawfirmapp.R;

import java.util.ArrayList;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {
    private Context c;
    private ArrayList<Questions> questions;
    LayoutInflater inflater;

    public CustomExpandableListAdapter(Context c, ArrayList<Questions> questions) {
        this.c = c;
        this.questions = questions;
        this.inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getGroupCount() {
        return questions.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return questions.get(groupPosition).answers.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return questions.get(groupPosition);
    }

    //get a single question and answer
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return questions.get(groupPosition).answers.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    //get answer Id
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = this.inflater.inflate(R.layout.expandable_list_questions, null);
        }

        //get the question

        Questions questions = (Questions) getGroup(groupPosition);

        //set the question to the textview
        TextView tvQuestion = (TextView) convertView.findViewById(R.id.tvQuestion);

        String this_question = questions.questions;
        tvQuestion.setText(this_question);

        //set the background color
//        convertView.setBackgroundColor(Color.LTGRAY);
        //ToDo: change the background color
        return convertView;
    }

    //get the answer now
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = this.inflater.inflate(R.layout.expandable_list_answers,null);
        }

        //get the answer
        String this_answer = (String) getChild(groupPosition,childPosition);

        //Set the answer to the textview
        TextView tvAnswer = (TextView) convertView.findViewById(R.id.tvAnswer);
        tvAnswer.setText(this_answer);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
