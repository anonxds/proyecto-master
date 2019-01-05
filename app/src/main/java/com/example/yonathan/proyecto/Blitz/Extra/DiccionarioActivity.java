package com.example.yonathan.proyecto.Blitz.Extra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.yonathan.proyecto.R;

import java.util.ArrayList;

public class DiccionarioActivity extends AppCompatActivity {

    ListView diccionario;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diccionario);
        diccionario=findViewById(R.id.palabras);
        b=findViewById(R.id.button2);
        final ArrayList<String> verbos = new ArrayList<String>();

        for(int i=1; i<=10;i++){
    verbos.add("?");
              }


        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, verbos );
        diccionario.setAdapter(arrayAdapter);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verbos.set(3, "has");
arrayAdapter.notifyDataSetChanged();

            }
        });




    }

}
