package com.example.yonathan.proyecto;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Nivel1Fragment extends Fragment {

    private Button mabian, mavian, mhabian;
    private EditText mpal1;
    private TextView time;
    private CountDownTimer count;
    private long millosencond = 10000;
    private Boolean timerunning;


    public Nivel1Fragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_nivel1, container, false);
        // Inflate the layout for this fragment
        time = v.findViewById(R.id.timer);
        mabian=v.findViewById(R.id.btnabian);
        mavian=v.findViewById(R.id.btnavian);
        mhabian=v.findViewById(R.id.btnhabian);
        mpal1=v.findViewById(R.id.txtres1);



        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                time.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                time.setText("done!");
            }
        }.start();


        mabian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpal1.setText("abian");
                if(mpal1.getText().toString().equals("abian")){
                      //   mal.show();

                    Toast.makeText(getActivity(), "mal", Toast.LENGTH_SHORT).show();

                }
            }
        });

        mavian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpal1.setText("avian");
                if(mpal1.getText().toString().equals("avian")){
                    //    mal.show();

                }
            }
        });
        mhabian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpal1.setText("habian");
                if(mpal1.getText().toString().equals("habian")){
                    //        correct.show();

                }
            }
        });

        return v;
    }

}