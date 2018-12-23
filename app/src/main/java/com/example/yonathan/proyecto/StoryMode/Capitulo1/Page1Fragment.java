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

Button prueba,btnmotiva,btnmotivar,btnaceptar,btnreset;
Mod mod;
TextView parrafo1,ttemblando,ttemblaba,parrafo2,replace,oracion;


public interface Mod{
    public void hearts(int i);
}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_page1, container, false);;
      //textviews
        parrafo1=v.findViewById(R.id.txtparrafo1);
      parrafo2=v.findViewById(R.id.txtparrafo2);
      parrafo2.setVisibility(View.GONE);
      parrafo1.setVisibility(View.GONE);
      ttemblaba=v.findViewById(R.id.dtemblaba);
      ttemblando=v.findViewById(R.id.dtemblando);
      ttemblaba.setVisibility(View.GONE);
      ttemblando.setVisibility(View.GONE);
      oracion=v.findViewById(R.id.or1);
      oracion.setVisibility(View.GONE);
      replace=v.findViewById(R.id.or1_22);
      replace.setVisibility(View.GONE);
      //botones
        btnmotiva=v.findViewById(R.id.btnmotiva);
        btnmotivar=v.findViewById(R.id.btnmotivar);
        btnmotivar.setVisibility(View.GONE);
        btnmotiva.setVisibility(View.GONE);
        btnaceptar=v.findViewById(R.id.btnaceptar);
        btnreset=v.findViewById(R.id.btnreset);
        btnaceptar.setVisibility(View.GONE);
        btnreset.setVisibility(View.GONE);

        prueba=v.findViewById(R.id.perder);



        final Animation anim = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
       ConstraintLayout constraintLayout= v.findViewById(R.id.texto);

        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (parrafo1.getVisibility() == View.GONE){
                    parrafo1.setVisibility(View.VISIBLE);
                    parrafo1.startAnimation(anim);
                }
                else {

                }

            }
        });

        //matar un corazon
        prueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int intento = 1;
                mod.hearts(intento);
            }
        });


        btnaceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(replace.getText().toString().equals("temblaba")){

                }
            }
        });



        ttemblando.setOnTouchListener(new ChoiceTouchListener());
        ttemblando.setOnDragListener(dragListener);
        ttemblaba.setOnDragListener((dragListener));
        ttemblaba.setOnTouchListener(new ChoiceTouchListener());
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
                    if (vData.getId() == R.id.dtemblaba);
                {
                         ttemblaba.setVisibility(View.GONE);
                         replace.setText(ttemblaba.toString());

                }
                if (vData.getId() == R.id.dtemblando){

                    ttemblando.setVisibility(View.GONE);
                     replace.setText(ttemblando.toString());

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
