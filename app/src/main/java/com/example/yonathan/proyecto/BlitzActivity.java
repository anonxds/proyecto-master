package com.example.yonathan.proyecto;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BlitzActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blitz);
        Nivel1Fragment n1 = new Nivel1Fragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.gamecontainer,n1);

        ScoreFragment score = new ScoreFragment();
        transaction.replace(R.id.scorecontainer,score);


        transaction.addToBackStack(null);
        transaction.commit();





    }
}
