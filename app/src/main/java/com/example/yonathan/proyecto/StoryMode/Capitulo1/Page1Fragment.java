package com.example.yonathan.proyecto.StoryMode.Capitulo1;


import android.app.Activity;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.yonathan.proyecto.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Page1Fragment extends Fragment {


    public Page1Fragment() {
        // Required empty public constructor
    }
    TextView paf1;
Button prueba;
Mod mod;

public interface Mod{
    public void hearts(int i);
}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_page1, container, false);;
        paf1=v.findViewById(R.id.txtparrafo1);
        paf1.setVisibility(View.GONE);
        prueba=v.findViewById(R.id.perder);
        prueba.setVisibility(View.GONE);


        final Animation anim = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
        ConstraintLayout constraintLayout= v.findViewById(R.id.texto);

        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (paf1.getVisibility() == View.GONE){
                    paf1.setVisibility(View.VISIBLE);
                    paf1.startAnimation(anim);
                    prueba.setVisibility(View.VISIBLE);
                }
                else {

                }
            }
        });

        prueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int intento = 1;
                mod.hearts(intento);
            }
        });

        return v;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mod= (Page1Fragment.Mod) activity;
        }
        catch (Exception e){}
    }




}
