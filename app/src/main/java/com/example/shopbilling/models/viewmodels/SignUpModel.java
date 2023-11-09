package com.example.shopbilling.models.viewmodels;

import static com.example.shopbilling.networkutils.FirebaseAuthUtils.signUpAuth;

import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.shopbilling.BR;
import com.example.shopbilling.models.User;

public class SignUpModel extends BaseObservable {
    private User user;
    private static final String CLASS_NAME = SignUpModel.class.getSimpleName();

    @Bindable
    public String getUserEmail() {
        return user.getEmail();
    }

    @Bindable
    public String getUserPassword() {
        return user.getPassword();
    }

    public void setUserEmail(final String email) {
        user.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    public void setUserPassword(final String password) {
        user.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }
    public void signUp(){
            final String email=user.getEmail();
            final String password=user.getPassword();

            if(email==null || email.isEmpty() || password==null || password.isEmpty()){
                //show toast message and return
                return ;
            }
            signUpAuth(user);
    }

    public SignUpModel() {
        user = new User();
    }
}
