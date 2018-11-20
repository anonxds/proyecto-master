package com.example.yonathan.proyecto;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {


    public ScoreFragment() {
        // Required empty public constructor
    }
    private TextView time,score,badscore;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_score, container, false);

        // Inflate the layout for this fragment
        time = v.findViewById(R.id.timer);
        score= v.findViewById(R.id.txtpuntos);
        badscore=v.findViewById(R.id.badscore);


        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                time.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                time.setText("done!");
                Intent intent = new Intent(getActivity(), MenuActivity.class);
                startActivity(intent);

            }
        }.start();
        return v;
    }
    public void updateInfo(int Score){
         score.setText(String.valueOf(Score));

    }

    public void updatebadscore(int Score){
        badscore.setText(String.valueOf(Score));
    }
}
