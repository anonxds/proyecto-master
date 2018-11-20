package com.example.yonathan.proyecto;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class Nivel3Fragment extends Fragment {

    Nivel1Fragment.OnScoreListener onScoreListener;
    public Nivel3Fragment() {
        // Required empty public constructor
    }
    public interface OnScoreListener{
        public void setName(int score);
        public void setMalopuntos(int score);
    }


        private Button mNextl;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_nivel3, container, false);

        // Inflate the layout for this fragment
           mNextl=v.findViewById(R.id.btncor1);
           mNextl.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

               }
           });
        return v;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onScoreListener= (Nivel1Fragment.OnScoreListener) activity;
        }
        catch (Exception e){}
    }
}


