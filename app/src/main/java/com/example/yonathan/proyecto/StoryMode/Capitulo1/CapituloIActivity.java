package com.example.yonathan.proyecto.StoryMode.Capitulo1;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.yonathan.proyecto.Niveles.Nivel1Fragment;
import com.example.yonathan.proyecto.R;
import com.example.yonathan.proyecto.ScoreFragment;
import com.example.yonathan.proyecto.StoryMode.ScoreStoryUIFragment;

public class CapituloIActivity extends AppCompatActivity implements Page1Fragment.Mod {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_capitulo_i);

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        ScoreStoryUIFragment scoreT = new ScoreStoryUIFragment();
        Page1Fragment page1 = new Page1Fragment();
        transaction.replace(R.id.UIScore, scoreT);
        transaction.replace(R.id.texto, page1);
        // transaction.replace(R.id.texto,page1);
        transaction.addToBackStack(null);
        transaction.commit();


    }


    @Override
    public void hearts(int i) {
        ScoreStoryUIFragment scor = (ScoreStoryUIFragment) getFragmentManager().findFragmentById(R.id.UIScore);
        scor.loseheart(i);
    }
}