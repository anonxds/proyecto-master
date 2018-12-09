package com.example.yonathan.proyecto;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Fragment;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yonathan.proyecto.Board.BadActivity;
import com.example.yonathan.proyecto.Board.GoodActivity;
import com.example.yonathan.proyecto.Board.NeutralActivity;
import com.example.yonathan.proyecto.Board.gameover;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {




    public ScoreFragment() {
        // Required empty public constructor
    }
    private TextView time,score,badscore,namescore,nameintentos;
    long addtime;
   public int total,intentos;

    CountDownTimer timers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_score, container, false);
        Typeface ANGEL = Typeface.createFromAsset(getActivity().getAssets(), "ANGEL.ttf");


        // Inflate the layout for this fragment
        time = v.findViewById(R.id.timer);
        score= v.findViewById(R.id.txtpuntos);
        badscore=v.findViewById(R.id.badscore);
        namescore=v.findViewById(R.id.txtscore);
        nameintentos=v.findViewById(R.id.txtfail);
        namescore.setTypeface(ANGEL);
        nameintentos.setTypeface(ANGEL);




      timers = new CountDownTimer(20000, 1000) {

            public void onTick(long millisUntilFinished) {

                time.setText("Tiempo: " + (millisUntilFinished) / 1000);
                if(badscore.getText().toString().equals("3") || badscore.getText().toString().equals("5")){

                    Intent intent = new Intent(getActivity(), gameover.class);
                    startActivity(intent);

                }

            }

            public void onFinish() {
                time.setText("done!");


                    if(total <=10){

                      //  Intent intent = new Intent(getActivity(), BadActivity.class);
                        //startActivity(intent);
                        sendData1();
                    }
                    else if(total <= 40){
                      //  Intent intent = new Intent(getActivity(), NeutralActivity.class);
                        //startActivity(intent);
                        sendData2();
                    }
                    else if(total <=100){
                     //   Intent intent = new Intent(getActivity(), GoodActivity.class);
                       // startActivity(intent);
                        // Intent intent = new Intent(getActivity(), MenuActivity.class);
                        sendData3();
                    }

                //startActivity(intent);

            }




        }.start();

        return v;
    }

    public void updateInfo(int Score){
       // total = 41;
        total = total + Score;

        score.setText(String.valueOf(total));



        //score.setText(String.valueOf(Score));

    }

    public void updatebadscore(int Score){

            intentos = intentos + Score;

       // badscore.setText(String.valueOf(Score));
        badscore.setText(String.valueOf(intentos));
    }
    public void onStop(){
        ScoreFragment.super.onStop();
        timers.cancel();
    }

    private void sendData1(){
        Intent i = new Intent(getActivity().getBaseContext(),BadActivity.class);
        i.putExtra("NAME_KEY",score.getText().toString());
        getActivity().startActivity(i);
    }
    private void sendData2(){
        Intent i = new Intent(getActivity().getBaseContext(),NeutralActivity.class);
        i.putExtra("NAME_KEY",score.getText().toString());
        getActivity().startActivity(i);
    }
    private void sendData3(){
        Intent i = new Intent(getActivity().getBaseContext(),GoodActivity.class);
        i.putExtra("NAME_KEY",score.getText().toString());
        getActivity().startActivity(i);
    }




}
