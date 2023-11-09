package com.example.shopbilling.networkutils;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.shopbilling.models.FirebaseAut;
import com.example.shopbilling.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FirebaseAuthUtils {
    private static final FirebaseAut auth = FirebaseAut.getInstance();

    public static void loginAuth(final User user) {
        FirebaseAuth loginAuth = auth.getFirebaseAuth();
        loginAuth.signInWithEmailAndPassword(user.getEmail(), user.getPassword())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user=loginAuth.getCurrentUser();
                            //log
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //log for failure
                    }
                });
    }

    public static void signUpAuth(final User user) {
        FirebaseAuth signUpAuth = auth.getFirebaseAuth();
        signUpAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //create a firebase user
                            FirebaseUser newUser = signUpAuth.getCurrentUser();
                            Log.i("Firebase user created", "at signUp auth");
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("Firebase user could not be created", "At signup auth");
                    }
                });
    }
}
