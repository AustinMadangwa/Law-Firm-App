package com.example.lawfirmapp.BottomNavigationBarFragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lawfirmapp.Activities.PaymentSuccessActivity;
import com.example.lawfirmapp.R;
import com.google.android.material.textfield.TextInputEditText;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;


public class PaymentFragment extends Fragment {

    TextInputEditText paymentName, paymentEmail, phoneNumber;
    Button btnPayment;
    Spinner paymentCaseTypeSP,paymentMethodSP;

    public PaymentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.paymentName = view.findViewById(R.id.paymentName);
        this.paymentEmail = view.findViewById(R.id.paymentEmail);
        this.phoneNumber = view.findViewById(R.id.phoneNumber);
        this.btnPayment = view.findViewById(R.id.btnPayment);
        this.paymentCaseTypeSP = view.findViewById(R.id.paymentCaseTypeSP);
        this.paymentMethodSP = view.findViewById(R.id.paymentMethodSP);


        this.btnPayment.setOnClickListener(v -> {
            String name = Objects.requireNonNull(paymentName.getText()).toString().trim();
            String email = Objects.requireNonNull(paymentEmail.getText()).toString().trim();
            String number = Objects.requireNonNull(phoneNumber.getText()).toString().trim();
            String caseType = (String) paymentCaseTypeSP.getSelectedItem();
            String payMethod = (String) paymentMethodSP.getSelectedItem();

            if(name.isEmpty() || email.isEmpty() || number.isEmpty()){
                Toast.makeText(getActivity(), "Please enter all fields!", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(getActivity(), PaymentSuccessActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("email",email);
                intent.putExtra("number",number);
                intent.putExtra("caseType",caseType);
                intent.putExtra("paymentMethod",payMethod);
                startActivity(intent);
            }
        });


    }
}