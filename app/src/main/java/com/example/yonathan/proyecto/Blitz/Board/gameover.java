package com.example.yonathan.proyecto.Blitz.Board;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.yonathan.proyecto.MenuActivity;
import com.example.yonathan.proyecto.R;

public class gameover extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);
        Button b =findViewById(R.id.btngamneover);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(gameover.this, MenuActivity.class);
                startActivity(i);
            }
        });
    }

}
