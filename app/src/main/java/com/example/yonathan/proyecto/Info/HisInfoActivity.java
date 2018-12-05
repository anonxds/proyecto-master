package com.example.yonathan.proyecto.Info;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.yonathan.proyecto.R;

public class HisInfoActivity extends AppCompatActivity {
TextView hi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_his_info);
        Button playH =findViewById(R.id.btnjugar);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        final Animation anim = AnimationUtils.loadAnimation(this,R.anim.alpha);
hi=findViewById(R.id.his_desp);
hi.setText(Html.fromHtml(getString(R.string.historia)));
        int w = dm.widthPixels;
        int h = dm.heightPixels;

        getWindow().setLayout((int)(w*0.5),(int)(h*0.5));

        WindowManager.LayoutParams p = getWindow().getAttributes();
        p.gravity = Gravity.CENTER;
        p.x = 0;
        p.y=-20;
        getWindow().setAttributes(p);
    }
    public void messaje(){

    }
}
