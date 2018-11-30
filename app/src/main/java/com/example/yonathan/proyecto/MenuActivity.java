package com.example.yonathan.proyecto;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    private Button mstory,mblitz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Typeface Architex = Typeface.createFromAsset(getAssets(), "Architex.ttf");
        Typeface TheShaker = Typeface.createFromAsset(getAssets(), "TheShaker.ttf");
        Typeface BLUNT = Typeface.createFromAsset(getAssets(), "BLUNT.TTF");


        final Animation anim = AnimationUtils.loadAnimation(this,R.anim.alpha);

        setContentView(R.layout.activity_menu);
        mblitz=findViewById(R.id.btnblitz);
        mstory=findViewById(R.id.btnstory);
        mblitz.setTypeface(BLUNT);
        mstory.setTypeface(BLUNT);
        mstory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(anim);
            }
        });
        mblitz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(anim);

                startActivity(new Intent(MenuActivity.this, BlitzActivity.class));

            }
        });
    }

}
