package com.example.lawfirmapp.LocalData;

import java.util.ArrayList;

public class Questions {
    public String questions;
    public ArrayList<String> answers = new ArrayList<>();

    public Questions(String questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return questions;
    }
}
