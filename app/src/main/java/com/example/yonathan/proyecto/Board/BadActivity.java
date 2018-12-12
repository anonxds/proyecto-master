package com.example.yonathan.proyecto.Board;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yonathan.proyecto.MenuActivity;
import com.example.yonathan.proyecto.R;
import com.example.yonathan.proyecto.model.NameScoreend;
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
    Button add,confirmar;
    TextView total,shite,name;
    ImageView medal;
    private List<NameScoreend> Listperson = new ArrayList<NameScoreend>();
 //   ArrayList<String> list = new ArrayList<>();
  ArrayAdapter <NameScoreend> arrayAdapters;
  FirebaseDatabase mFirebaseDatabase;
  DatabaseReference mdatabaseReference;
  NameScoreend select;
  int Score =0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bad);

        nombre = findViewById(R.id.nametxt);
        nombreEnd = findViewById(R.id.scoreboard);
        add=findViewById(R.id.btnconti);
        total=findViewById(R.id.totalscore);
        confirmar=findViewById(R.id.confirmar);
        shite=findViewById(R.id.txtbad);
        name=findViewById(R.id.Tunombre);
        medal=findViewById(R.id.imageView);

        Typeface ANGEL = Typeface.createFromAsset(getAssets(), "ANGEL.ttf");
        shite.setTypeface(ANGEL);

        //visibilidad
        shite.setVisibility(View.GONE);
        add.setVisibility(View.GONE);
        medal.setVisibility(View.GONE);
        nombreEnd.setVisibility(View.GONE);
        //
        nombre.requestFocus();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);

        initializeFirebase();
       listData();
        this.recieveData();


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
               Intent i = new Intent(BadActivity.this, MenuActivity.class);
               startActivity(i);
            }
        });
        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombres = nombre.getText().toString();
                if (nombres.equals("")) {
                    validation();
                } else {

                    String nombrel = nombre.getText().toString();
                    String toal = total.getText().toString();
                    NameScoreend p = new NameScoreend();
                    p.setUid(UUID.randomUUID().toString());
                    p.setName(nombrel);
                    p.setScore(toal);
                    mdatabaseReference.child("Datos").child(p.getUid()).setValue(p);
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(nombre.getWindowToken(), 0);
                    shite.setVisibility(View.VISIBLE);
                    add.setVisibility(View.VISIBLE);
                    medal.setVisibility(View.VISIBLE);
                    confirmar.setVisibility(View.GONE);
                    nombre.setVisibility(View.GONE);
                    name.setVisibility(View.GONE);
                    nombreEnd.setVisibility(View.VISIBLE);

                }
            }
        });

    }


    private void listData(){
        mdatabaseReference.child("Datos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Listperson.clear();
                for(DataSnapshot objSnapShot:dataSnapshot.getChildren()){
                    NameScoreend p = objSnapShot.getValue(NameScoreend.class);
                    Listperson.add(p);
                    arrayAdapters = new ArrayAdapter<>(BadActivity.this,android.R.layout.simple_list_item_1,Listperson);
                    nombreEnd.setAdapter(arrayAdapters);
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
private void recieveData(){
    Intent i =getIntent();
    String totals = i.getStringExtra("NAME_KEY");
    total.setText("Puntos "+ String.valueOf(totals));
}

    @Override
    public void onBackPressed() {
      //  super.onBackPressed();
    }
    public void validation(){
        String nombres = nombre.getText().toString();
        if (nombres.equals("")) {
            nombre.setError("Requerido");
        }
    }
}
