package com.example.yonathan.proyecto.StoryMode;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.yonathan.proyecto.R;

public class ReviewActivity extends AppCompatActivity {
TextView revisar;
ConstraintLayout Background;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        revisar=findViewById(R.id.txtreview);
        Background=findViewById(R.id.background);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        final Animation anim = AnimationUtils.loadAnimation(this,R.anim.alpha);
   String d = getIntent().getStringExtra("p1");
Background.setBackgroundResource(R.drawable.niebla2);
revisar.setMovementMethod(new ScrollingMovementMethod());
      revisar.append(String.valueOf(d));


        int w = dm.widthPixels;
        int h = dm.heightPixels;

        getWindow().setLayout((int)(w*0.9),(int)(h*0.9));

        WindowManager.LayoutParams p = getWindow().getAttributes();
        p.gravity = Gravity.CENTER;
        p.x = 0;
        p.y=-20;
        getWindow().setAttributes(p);
    }
}
