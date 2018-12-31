package com.example.yonathan.proyecto.StoryMode.Capitulo1;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yonathan.proyecto.Blitz.ScoreFragment;
import com.example.yonathan.proyecto.R;
import com.example.yonathan.proyecto.StoryMode.ModelSt;
import com.example.yonathan.proyecto.StoryMode.ReviewActivity;
import com.example.yonathan.proyecto.StoryMode.ScoreStoryUIFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Page1Fragment extends Fragment {


    public Page1Fragment() {
        // Required empty public constructor
    }

Mod mod;
    ModelSt model;
    ConstraintLayout next;
    TextView parrafo1, parrafo2;
   Button opcion1,opcion2,opcion3;
LinearLayout opciones;

public interface Mod{
    public void hearts(int i);
    public void gettext(String i);
}


   private int index = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View v =inflater.inflate(R.layout.fragment_page1, container, false);;



opciones= v.findViewById(R.id.botones);
//opciones.setVisibility(View.GONE);
opcion1=v.findViewById(R.id.btnopcion1);
opcion2=v.findViewById(R.id.btnopcion2);
opcion3=v.findViewById(R.id.btnopcion3);
opcion1.setVisibility(View.GONE);
opcion2.setVisibility(View.GONE);
opcion3.setVisibility(View.GONE);
        final ModelSt [] mParrafos = new ModelSt[]{

                new ModelSt(getString(R.string.parrafo1Cap1),1),
                new ModelSt(getString(R.string.parrafo2Cap1),2),
                new ModelSt(getString(R.string.parrafo3Cap1),3),
                new ModelSt(getString(R.string.parrafo4Cap1),4),
                new ModelSt(getString(R.string.parrafo5Cap1Decision),5),
                new ModelSt(getString(R.string.resultadoOp3),6),
                //  new ModelSt(getResources().getString(R.string.parrafo2Cap1),2)
        };
          next=v.findViewById(R.id.siguiente);
     //     previ=v.findViewById(R.id.regresar);
           parrafo1=v.findViewById(R.id.txtparrafo1);


        update();

        opcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calma();
            }
        });
opcion3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        espada();
    }
});

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index =(index+1)%(mParrafos.length);
                update();
            }
        });
opcion1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        ruta1();
    }
});


        return v;
    }

    private void update(){
        ModelSt [] mParrafos = new ModelSt[]{

                new ModelSt(getString(R.string.parrafo1Cap1),1),
                new ModelSt(getString(R.string.parrafo2Cap1),2),
                new ModelSt(getString(R.string.parrafo3Cap1),3),
                new ModelSt(getString(R.string.parrafo4Cap1),4),
                new ModelSt(getString(R.string.parrafo5Cap1Decision),5),
                new ModelSt(getString(R.string.resultadoOp3),6),
                //  new ModelSt(getResources().getString(R.string.parrafo2Cap1),2)
        };

        final Animation anim = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
        parrafo1.startAnimation(anim);
        parrafo1.setText(mParrafos[index].getParrafo());

        mod.gettext(mParrafos[index].getParrafo());


        if(parrafo1.getText() == getString(R.string.parrafo5Cap1Decision)){
            next.setVisibility(View.GONE);
            bootner();
        }
    }

    public void espada(){
        parrafo1.setText(getString(R.string.resultadoOp3));
        //opciones.setVisibility(View.GONE);
        opcion3.setVisibility(View.GONE);
        mod.gettext(getString(R.string.resultadoOp3));
        opcion1.setVisibility(View.GONE);
        opcion2.setVisibility(View.GONE);
        final Animation anim = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                opcion1.startAnimation(anim);
                opcion1.setVisibility(View.VISIBLE);
            }
        },3000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                opcion2.startAnimation(anim);
                opcion2.setVisibility(View.VISIBLE);
            }
        },4000);
    }
    private void calma(){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Page2Fragment ruta2 = new Page2Fragment();
        transaction.replace(R.id.texto, ruta2);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void ruta1(){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Ruta1Fragment ruta1 = new Ruta1Fragment();
        transaction.replace(R.id.texto, ruta1);
        transaction.addToBackStack(null);
        transaction.commit();
    }


public void bootner(){
    final Animation anim = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);

    new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                opcion1.startAnimation(anim);
               opcion1.setVisibility(View.VISIBLE);
            }
        },5000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                opcion2.startAnimation(anim);
 opcion2.setVisibility(View.VISIBLE);
            }
        },6000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                opcion3.startAnimation(anim);
                opcion3.setVisibility(View.VISIBLE);
            }
        },7000);
}


    public void pagina1() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation anim = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
               if(parrafo1.getVisibility() == View.GONE){

                   parrafo1.startAnimation(anim);
               parrafo1.setVisibility(View.VISIBLE);

               }


                else if(parrafo1.getVisibility() == View.VISIBLE && parrafo2.getVisibility() == View.VISIBLE)
             //       parrafo1.setVisibility(View.GONE);
               //     demo.setVisibility(View.VISIBLE);
             pagina2();
            }
        });
    }
    public void pagina2(){



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
