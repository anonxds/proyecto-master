package com.example.yonathan.proyecto.Info;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.yonathan.proyecto.BlitzActivity;
import com.example.yonathan.proyecto.MenuActivity;
import com.example.yonathan.proyecto.R;

public class BlitzInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button btnplay = findViewById(R.id.jugarw);

        setContentView(R.layout.activity_blitz_info);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int w = dm.widthPixels;
        int h = dm.heightPixels;

        getWindow().setLayout((int)(w*0.8),(int)(h*0.5));

        WindowManager.LayoutParams p = getWindow().getAttributes();
        p.gravity = Gravity.CENTER;
        p.x = 0;
        p.y=-20;
        getWindow().setAttributes(p);
    }
    public void change (View view){
        final Animation anim = AnimationUtils.loadAnimation(this,R.anim.alpha);


        view.startAnimation(anim);

       Intent i = new Intent(getApplicationContext(),BlitzActivity.class);
       startActivity(i);
    }
}
