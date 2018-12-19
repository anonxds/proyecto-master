 package com.example.yonathan.proyecto;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.yonathan.proyecto.Info.BlitzInfoActivity;
import com.example.yonathan.proyecto.Info.HisInfoActivity;
import com.example.yonathan.proyecto.Blitz.Trivia.ExtrasActivity;

public class MenuActivity extends AppCompatActivity {
    private Button mstory,mblitz,mextras;



    public void extras(View view){
        Intent i = new Intent(getApplicationContext(), ExtrasActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Typeface BLUNT = Typeface.createFromAsset(getAssets(), "BLUNT.TTF");


        final Animation anim = AnimationUtils.loadAnimation(this,R.anim.alpha);

        setContentView(R.layout.activity_menu);
        mblitz=findViewById(R.id.btnblitz);
        mstory=findViewById(R.id.btnstory);
        mextras=findViewById(R.id.btnextras);
        mextras.setTypeface(BLUNT);
        mblitz.setTypeface(BLUNT);

        mstory.setTypeface(BLUNT);
        mstory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(anim);
                Intent i = new Intent(getApplicationContext(), HisInfoActivity.class);
                startActivity(i);
            }
        });
        mblitz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(anim);

               // startActivity(new Intent(MenuActivity.this, BlitzActivity.class));
                Intent i = new Intent(getApplicationContext(), BlitzInfoActivity.class);
                startActivity(i);

            }
        });
    }

}
