package com.example.yonathan.proyecto.StoryMode.Capitulo1;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.app.Fragment;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
    TextView paf1,resp1,resp2,op1,op2;
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
     //   prueba.setVisibility(View.GONE);
        resp1=v.findViewById(R.id.oracion1);
        resp2=v.findViewById(R.id.oracion2);
        op1=v.findViewById(R.id.respuesta);
        op2=v.findViewById(R.id.txtresp2);



prueba.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(op1.getText().toString().equals("correcto")){
            resp1.setText("hola");
        }
    }
});


     //   final Animation anim = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
       // ConstraintLayout constraintLayout= v.findViewById(R.id.texto);
/*
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
        */
        resp2.setOnTouchListener(new ChoiceTouchListener());
        op1.setOnDragListener(dragListener);

        return v;
    }
    private final class ChoiceTouchListener implements View.OnTouchListener {
        @SuppressLint("NewApi")
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                /*
                 * Drag details: we only need default behavior
                 * - clip data could be set to pass data as part of drag
                 * - shadow can be tailored
                 */

                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(view);
                view.startDrag(data,myShadow,view,0);
                return true;

            } else {
                return false;
            }
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mod= (Page1Fragment.Mod) activity;
        }
        catch (Exception e){}
    }

    //drag drop
    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View vData = (View)event.getLocalState();
            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    if (vData.getId() == R.id.oracion1);
                {
                //    resp1.setVisibility(View.GONE);
                    resp2.setVisibility(View.GONE);
                 op1.setText("correcto");
                }
                break;
                case DragEvent.ACTION_DRAG_ENDED:

                    break;
                case DragEvent.ACTION_DRAG_EXITED:

                    break;
            }
            return true;
        }
    };




}
