package com.example.shopbilling.models;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseAut {


    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore database;
    private static FirebaseAut auth;

    private FirebaseAut() {
        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseFirestore.getInstance();
    }

    public static FirebaseAut getInstance() {
        if (auth != null) return auth;
        auth = new FirebaseAut();
        return auth;
    }

    public FirebaseAuth getFirebaseAuth() {
        return firebaseAuth;
    }

    public FirebaseFirestore getDatabase() {
        return database;
    }
}
