package com.example.yonathan.proyecto;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yonathan.proyecto.Niveles.Nivel1Fragment;
import com.example.yonathan.proyecto.Niveles.Nivel2Fragment;
import com.example.yonathan.proyecto.Niveles.Nivel3Fragment;
import com.example.yonathan.proyecto.Niveles.Nivel4Fragment;
import com.example.yonathan.proyecto.Niveles.Nivel5Fragment;
import com.example.yonathan.proyecto.Niveles.randomizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BlitzActivity extends AppCompatActivity implements Nivel1Fragment.OnScoreListener {

    ArrayList<Integer> n = new ArrayList<>();
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blitz);


        for (int i =1; i<=5;i++){
            n.add(new randomizer(i).getIndex());
            Collections.shuffle(n);
        }

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        ScoreFragment score = new ScoreFragment();
        transaction.replace(R.id.scorecontainer, score);
        transaction.addToBackStack(null);
        transaction.commit();


        changefragment();

    }

    @Override
    public void setName(int score) {

        ScoreFragment scor = (ScoreFragment) getFragmentManager().findFragmentById(R.id.scorecontainer);
         scor.updateInfo(score);

    }

    @Override
    public void onBackPressed() {


      //  BlitzActivity.this.finish();

    }

    @Override
    public void setMalopuntos(int score) {
        ScoreFragment bad = (ScoreFragment) getFragmentManager().findFragmentById(R.id.scorecontainer);
        bad.updatebadscore(score);


    }


    public void changefragment(){

        counter = (counter+1) % (n.size());
        int dato = Integer.valueOf(n.indexOf(counter));
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        switch (dato) {
            case 0: {
                Nivel1Fragment n1 = new Nivel1Fragment();

                transaction.replace(R.id.gamecontainer, n1);

                transaction.addToBackStack(null);
                transaction.commit();
                break;
            }
            case 1: {
                Nivel2Fragment n2 = new Nivel2Fragment();

                transaction.replace(R.id.gamecontainer, n2);

                transaction.addToBackStack(null);
                transaction.commit();
                break;
            }
            case 2:{
                Nivel3Fragment n3 = new Nivel3Fragment();

                transaction.replace(R.id.gamecontainer, n3);

                transaction.addToBackStack(null);
                transaction.commit();
                break;
            }
            case 3:{
                Nivel4Fragment n4 = new Nivel4Fragment();

                transaction.replace(R.id.gamecontainer, n4);

                transaction.addToBackStack(null);
                transaction.commit();
                break;
            }
            case 4:{
                Nivel5Fragment n5 = new Nivel5Fragment();

                transaction.replace(R.id.gamecontainer, n5);

                transaction.addToBackStack(null);
                transaction.commit();
                break;
            }

        }
    }

}
