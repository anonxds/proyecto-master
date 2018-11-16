package com.example.yonathan.prueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Capitulo1 extends AppCompatActivity {
   String volteo = "volteo";
   String mira = "mira";

   private EditText mPal1, mPal2, mPal3;
   private TextView mScore,mBadscore;
   private Button mNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitulo1);
        mPal1=(EditText) findViewById(R.id.txtpal1);
        mPal2=(EditText) findViewById(R.id.txtpal2);
        mPal3=(EditText) findViewById(R.id.txtpal3);
        mScore=(TextView)findViewById(R.id.lblscore);
        mBadscore=(TextView)findViewById(R.id.scorebad);
    }
}
