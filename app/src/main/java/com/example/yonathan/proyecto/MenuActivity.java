package com.example.yonathan.proyecto;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    private Button mstory,mblitz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mblitz=findViewById(R.id.btnblitz);
        mstory=findViewById(R.id.btnstory);
        mblitz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.container,new Nivel1Fragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}
