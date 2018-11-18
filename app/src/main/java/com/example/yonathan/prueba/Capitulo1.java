package com.example.yonathan.prueba;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Capitulo1 extends AppCompatActivity {
   private Button mabian, mavian, mhabian;
    private EditText mpal1;
     private TextView mscore, mbadsocore;
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
         mabian=findViewById(R.id.btnabian);
         mavian=findViewById(R.id.btnavian);
         mhabian=findViewById(R.id.btnhabian);
         mpal1=findViewById(R.id.txtres1);
         mscore=findViewById(R.id.txtpuntos);
         mbadsocore=findViewById(R.id.txtfaltas);

         mabian.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 mpal1.setText("abian");
                 if(mpal1.getText().toString().equals("abian")){
               //     mal.show();
                     score = -5 - score;
                   mbadsocore.setText(String.valueOf(score));
                     Toast.makeText(getBaseContext(), "Your answer is correct!" , Toast.LENGTH_SHORT ).show();

                 }
             }
         });

         mavian.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 mpal1.setText("avian");
                 if(mpal1.getText().toString().equals("avian")){
                 //    mal.show();
                     score = -5 - score;
                     mbadsocore.setText(String.valueOf(score));
                 }
             }
         });
         mhabian.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 mpal1.setText("habian");
                 if(mpal1.getText().toString().equals("habian")){
             //        correct.show();
                     score = 5 + score;
                     mscore.setText(String.valueOf(score));
                 }
             }
         });




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
