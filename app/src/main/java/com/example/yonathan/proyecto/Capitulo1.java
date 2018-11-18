package com.example.yonathan.proyecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Capitulo1 extends AppCompatActivity {


     int score = 0;
//     Context context = getApplicationContext();
//      CharSequence text = "equivocado";
//      CharSequence corr = "correcto";
//      int duracion = Toast.LENGTH_SHORT;
//      Toast mal = Toast.makeText(context, text, duracion);
//    Toast correct = Toast.makeText(context, corr, duracion);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitulo1);




    }
        private TextWatcher Cap1 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                  String text1 = mPal1.getText().toString().trim();
//                  String text2 = mPal2.getText().toString().trim();
//                  String text3 = mPal3.getText().toString().trim();
//                  mNext.setEnabled(!text1.isEmpty() && !text2.isEmpty() && !text3.isEmpty());
              //    mNext.setEnabled(text1.isEmpty() == text2.isEmpty() == text3.isEmpty() == true);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

}
