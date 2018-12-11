package com.example.yonathan.proyecto.Trivia;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yonathan.proyecto.MenuActivity;
import com.example.yonathan.proyecto.R;
import com.example.yonathan.proyecto.model.triviamodel;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ExtrasActivity extends AppCompatActivity {

    triviamodel selecttrivia;
    TextView info;
    ListView list_trivia;
    private List<triviamodel> listtrivia = new ArrayList<>();
    ArrayAdapter<triviamodel> arayadapter;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extras);
        info= findViewById(R.id.Plus);
        list_trivia=findViewById(R.id.listatrivia);
initializeFirebase();
        listData();

        list_trivia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selecttrivia = (triviamodel) adapterView.getItemAtPosition(i);
                info.setText(selecttrivia.getTrivia());
            }
        });
    }

    private void initializeFirebase() {
        FirebaseApp.initializeApp(this);
        mFirebaseDatabase=FirebaseDatabase.getInstance();
        //  mDatabaseReference=mFirebaseDatabase.getReference();
        mDatabaseReference=mFirebaseDatabase.getReference();
    }

    public void regresar(View view ){
        Intent i = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(i);
    }

    private void listData() {
        mDatabaseReference.child("trivia").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listtrivia.clear();
                for (DataSnapshot objSnapShot:dataSnapshot.getChildren()){
                    triviamodel p=objSnapShot.getValue(triviamodel.class);
                    listtrivia.add(p);
                    arayadapter = new ArrayAdapter<triviamodel>(ExtrasActivity.this,android.R.layout.simple_list_item_1,listtrivia);
                    list_trivia.setAdapter(arayadapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    }

