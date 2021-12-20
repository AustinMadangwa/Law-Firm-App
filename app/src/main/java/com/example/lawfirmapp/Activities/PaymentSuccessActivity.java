package com.example.lawfirmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lawfirmapp.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class PaymentSuccessActivity extends AppCompatActivity {

    String NAME = "name", EMAIL = "email", NUMBER = "number", CASE_TYPE = "caseType", PAYMENT_METHOD = "paymentMethod";
    String name, email, number, caseType, paymentMethod;


    MaterialButton btnPaymentDetailsPayNow, btnPaymentDetailsEdit;
    TextView p_detail_name, p_detail_email, p_detail_number, p_detail_case_type, p_detail_payment_method, p_detail_total_amount;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success);

        //get the payment data from the intent
        this.name = getIntent().getStringExtra(this.NAME);
        this.email = getIntent().getStringExtra(this.EMAIL);
        this.number = getIntent().getStringExtra(this.NUMBER);
        this.caseType = getIntent().getStringExtra(this.CASE_TYPE);
        this.paymentMethod = getIntent().getStringExtra(this.PAYMENT_METHOD);


        //set the supporting app bar
        MaterialToolbar customAppBar = findViewById(R.id.paymentSuccessAppBar);
        setSupportActionBar(customAppBar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.payment_details_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //initialize the buttons
        this.btnPaymentDetailsEdit = findViewById(R.id.btnPaymentDetailsEdit);
        this.btnPaymentDetailsPayNow = findViewById(R.id.btnPaymentDetailsPayNow);
        //handle the edit button click
        this.btnPaymentDetailsEdit.setOnClickListener(v -> {
            onBackPressed();
        });
        //handle the pay now button click
        this.btnPaymentDetailsPayNow.setOnClickListener(v -> {
            Toast.makeText(this, "Payment Initiated", Toast.LENGTH_SHORT).show();
        });


        //handle the textViews
        this.p_detail_name = findViewById(R.id.p_detail_name);
        this.p_detail_email = findViewById(R.id.p_detail_email);
        this.p_detail_number = findViewById(R.id.p_detail_number);
        this.p_detail_case_type = findViewById(R.id.p_detail_case_type);
        this.p_detail_payment_method = findViewById(R.id.p_detail_payment_method);
        this.p_detail_total_amount = findViewById(R.id.p_detail_total_amount);

        //assign the texts
        this.p_detail_name.setText(this.name);
        String temp;
        if(this.email.length() > 15){
            temp = this.email.substring(0,12) + " ...";
        }else{
            temp = this.email;
        }
        this.p_detail_email.setText(temp);
        this.p_detail_number.setText(this.number);
        this.p_detail_case_type.setText(this.caseType);
        this.p_detail_payment_method.setText(this.paymentMethod);
        this.p_detail_total_amount.setText("$250");
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}