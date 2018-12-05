package com.example.yonathan.proyecto.Trivia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;
import android.os.CountDownTimer;
import com.example.yonathan.proyecto.R;

public class trivia1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia1);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int w = dm.widthPixels;
        int h = dm.heightPixels;

        getWindow().setLayout((int)(w*1),(int)(h*0.2));

        WindowManager.LayoutParams p = getWindow().getAttributes();
        p.gravity = Gravity.TOP;
        p.x = 0;
        p.y=-20;
        getWindow().setAttributes(p);
    }
}
