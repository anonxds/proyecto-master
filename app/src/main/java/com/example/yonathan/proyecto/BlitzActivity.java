package com.example.yonathan.proyecto;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Random;

public class BlitzActivity extends AppCompatActivity implements Nivel1Fragment.OnScoreListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blitz);

   //     Random random = new Random();
     //   choose = random.nextInt(2);



             //   transaction.addToBackStack(null);
               // transaction.commit();*/
    //        Toast toast = Toast.makeText(context, text, duration);
      //      toast.show();

               // Nivel2Fragment n2 = new Nivel2Fragment();
               // transaction.replace(R.id.gamecontainer,n2);




              /*  Nivel3Fragment n3 = new Nivel3Fragment();
                transaction.replace(R.id.gamecontainer,n3);
                transaction.addToBackStack(null);
                transaction.commit();*/
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        ScoreFragment score = new ScoreFragment();
        transaction.replace(R.id.scorecontainer, score);

              Random random = new Random();
           int num = random.nextInt(3);
           switch (num) {
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
           }







    }

    @Override
    public void setName(int score) {

        ScoreFragment scor = (ScoreFragment) getFragmentManager().findFragmentById(R.id.scorecontainer);
         scor.updateInfo(score);


    }

    @Override
    public void onBackPressed() {


        BlitzActivity.this.finish();

    }

    @Override
    public void setMalopuntos(int score) {
        ScoreFragment bad = (ScoreFragment) getFragmentManager().findFragmentById(R.id.scorecontainer);
        bad.updatebadscore(score);


    }
}
