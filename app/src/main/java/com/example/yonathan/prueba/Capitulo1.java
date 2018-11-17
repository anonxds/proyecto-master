package com.example.yonathan.prueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Capitulo1 extends AppCompatActivity {
   String volteo = "volteo";
   String mira = "mira";
   int score = 0;

   private EditText mPal1, mPal2, mPal3;
   private TextView mScore,mBadscore,mword;
   private Button mNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitulo1);
        mPal1=(EditText)findViewById(R.id.txtpal1);
        mPal2=(EditText)findViewById(R.id.txtpal2);
        mPal3=(EditText)findViewById(R.id.txtpal3);
        mScore=(TextView)findViewById(R.id.lblscore);
        mBadscore=(TextView)findViewById(R.id.scorebad);
        mNext=findViewById(R.id.btnCont);
        mword=findViewById(R.id.btn_texto);

        mPal1.addTextChangedListener(Cap1);
        mPal2.addTextChangedListener(Cap1);
        mPal3.addTextChangedListener(Cap1);

        if(mPal1.getText().toString().equals(volteo)){
            mPal1.setEnabled(false);
            score = 1 + score;
            mScore.setText(score);

        }
        mword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPal2.setText("volteo");
                mScore.setText("5");
            }
        });


    }
        private TextWatcher Cap1 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                  String text1 = mPal1.getText().toString().trim();
                  String text2 = mPal2.getText().toString().trim();
                  String text3 = mPal3.getText().toString().trim();
                  mNext.setEnabled(!text1.isEmpty() && !text2.isEmpty() && !text3.isEmpty());
              //    mNext.setEnabled(text1.isEmpty() == text2.isEmpty() == text3.isEmpty() == true);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

}
