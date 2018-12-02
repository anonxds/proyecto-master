package com.example.yonathan.proyecto.Board;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yonathan.proyecto.ScoreFragment;
import com.example.yonathan.proyecto.model.NameScoreend;
import com.example.yonathan.proyecto.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BadActivity extends AppCompatActivity {
    EditText nombre;
    ListView nombreEnd;
    Button add;
    TextView total;
    private List<NameScoreend> Listperson = new ArrayList<>();
  ArrayAdapter <NameScoreend> arrayAdapter;
  FirebaseDatabase mFirebaseDatabase;
  DatabaseReference mdatabaseReference;
  NameScoreend select;
  int Score =0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bad);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction t = manager.beginTransaction();
        ScoreFragment s = new ScoreFragment();
   //     t.add(R.id.linea1,s);
     //   t.commit();
        nombre = findViewById(R.id.nametxt);
        nombreEnd = findViewById(R.id.scoreboard);
        add=findViewById(R.id.btnconti);
        total=findViewById(R.id.totalscore);
        initializeFirebase();
        listData();

        nombreEnd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                select = (NameScoreend) adapterView.getItemAtPosition(i);
                nombre.setText(select.getName());

            }
        });

        //---

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombrel = nombre.getText().toString();
                NameScoreend p = new NameScoreend();
                p.setUid(UUID.randomUUID().toString());
                p.setName(nombrel);
                p.setScore(String.valueOf(Score));
                mdatabaseReference.child("Datos").child(p.getUid()).setValue(p);
            }
        });
        //--

    }
    public void fl(String n1){
        total.setText(n1);
    }

    private void listData(){
        mdatabaseReference.child("Datos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Listperson.clear();
                for(DataSnapshot objSnapShot:dataSnapshot.getChildren()){
                    NameScoreend p = objSnapShot.getValue(NameScoreend.class);
                    Listperson.add(p);
                    arrayAdapter = new ArrayAdapter<>(BadActivity.this,android.R.layout.simple_list_item_1,Listperson);
                    nombreEnd.setAdapter(arrayAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private void initializeFirebase(){
        FirebaseApp.initializeApp(this);
        mFirebaseDatabase=FirebaseDatabase.getInstance();
        mdatabaseReference=mFirebaseDatabase.getReference();
    }


}
