package com.example.shopbilling.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.shopbilling.R;


public class SignUp extends Fragment {

    private EditText emailEt, passwordEt, confPassEt;
    private Button signUpButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_sign_up, container, false);
        init(root);
        return root;
    }

    public void init(View root) {
        emailEt = root.findViewById(R.id.email_et);
        passwordEt = root.findViewById(R.id.password_et);
        confPassEt = root.findViewById(R.id.conf_password_et);
        signUpButton = root.findViewById(R.id.login_button);
    }
}