package com.example.yonathan.proyecto.StoryMode.Capitulo1;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.yonathan.proyecto.R;

public class CapituloIActivity extends AppCompatActivity {

    TextView paf1;
    Animation a1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_capitulo_i);
        ConstraintLayout constraintLayout= findViewById(R.id.texto);
      paf1=findViewById(R.id.txtparrafo1);
      paf1.setVisibility(View.GONE);
      a1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim_rotate);
      constraintLayout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              paf1.setVisibility(View.VISIBLE);
              paf1.startAnimation(a1);
          }
      });
    }
}
