package com.example.yonathan.proyecto.Trivia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.yonathan.proyecto.R;
import com.example.yonathan.proyecto.model.triviamodel;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class trvia2Activity extends AppCompatActivity {


    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mDatabaseReference;
    TextView trival;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trvia2);
        TextView t =findViewById(R.id.triva);
    initializeFirebase();
    add();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int w = dm.widthPixels;
        int h = dm.heightPixels;

        getWindow().setLayout((int)(w*1),(int)(h*0.2));

        WindowManager.LayoutParams p = getWindow().getAttributes();
        p.gravity = Gravity.TOP;
        p.x = 0;
        p.y=-20;
        getWindow().setAttributes(p);


    }

    private void initializeFirebase() {
        FirebaseApp.initializeApp(this);
        mFirebaseDatabase=FirebaseDatabase.getInstance();
        //  mDatabaseReference=mFirebaseDatabase.getReference();
        mDatabaseReference=mFirebaseDatabase.getReference();
    }

    public void add(){
        String uno = "Adivinanza";
        trival=findViewById(R.id.triva);
        String t1 = trival.getText().toString();

        triviamodel p = new triviamodel();
        p.setTrivia(t1);
        p.setUid(uno);
        mDatabaseReference.child("trivia").child(p.getUid()).setValue(p);
    }
}
