package com.example.shopbilling.models.viewmodels;

import static com.example.shopbilling.networkutils.FirebaseAuthUtils.loginAuth;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.shopbilling.BR;
import com.example.shopbilling.models.User;

public class LoginModel extends BaseObservable {
    private User user;
    private static final String CLASS_NAME=LoginModel.class.getSimpleName();

    public LoginModel(){
        user=new User();
    }

    @Bindable
    public String getUserEmail(){return user.getEmail();}
    @Bindable
    public String getUserPassword(){return user.getPassword();}

    public void setUserEmail(final String email){
        user.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }
    public void setUserPassword(final String password){
        user.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    public void login(){
        final String email=user.getEmail();
        final String password=user.getPassword();
        if(email==null || email.isEmpty() || password==null || password.isEmpty()){
            //show toast or return
            return ;
        }
        loginAuth(user);
    }
}
