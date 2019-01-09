package com.example.yonathan.proyecto.Blitz.Trivia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yonathan.proyecto.Blitz.model.triviamodel;
import com.example.yonathan.proyecto.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class trivia3Activity extends AppCompatActivity {
FirebaseDatabase mFirebaseDatabase;
DatabaseReference mDatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia3);

    initializeFirebase();
    add();

    }

    private void initializeFirebase() {
        FirebaseApp.initializeApp(this);
        mFirebaseDatabase=FirebaseDatabase.getInstance();
        //  mDatabaseReference=mFirebaseDatabase.getReference();
        mDatabaseReference=mFirebaseDatabase.getReference();
    }

    public void add(){
        String uno = "datos relevado";
       // trival=findViewById(R.id.triva);
       // String t1 = trival.getText().toString();
        triviamodel p = new triviamodel();
        p.setTrivia(uno);
        p.setUid("no1");
        mDatabaseReference.child("trivia").child(p.getUid()).setValue(p);
    }
}
