package com.example.yonathan.proyecto;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BlitzActivity extends AppCompatActivity implements Nivel1Fragment.OnScoreListener {

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

    @Override
    public void setName(int score) {

        ScoreFragment scor = (ScoreFragment) getFragmentManager().findFragmentById(R.id.scorecontainer);
         scor.updateInfo(score);


    }

    @Override
    public void setMalopuntos(int score) {
        ScoreFragment bad = (ScoreFragment) getFragmentManager().findFragmentById(R.id.scorecontainer);
        bad.updatebadscore(score);


    }
}
