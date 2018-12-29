package com.example.yonathan.proyecto.StoryMode.Capitulo1;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
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

import com.example.yonathan.proyecto.R;
import com.example.yonathan.proyecto.StoryMode.ModelSt;

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
    ConstraintLayout next,previ;
    TextView parrafo1, parrafo2;
   Button demo;


public interface Mod{
    public void hearts(int i);
}


   private int index = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View v =inflater.inflate(R.layout.fragment_page1, container, false);;


        final ModelSt [] mParrafos = new ModelSt[]{

                new ModelSt(getString(R.string.parrafo1Cap1),1),
                new ModelSt(getString(R.string.parrafo2Cap1),2),
                new ModelSt(getString(R.string.parrafo3Cap1),3),
                new ModelSt(getString(R.string.parrafo4Cap1),4)
                //  new ModelSt(getResources().getString(R.string.parrafo2Cap1),2)
        };


          next=v.findViewById(R.id.siguiente);
          previ=v.findViewById(R.id.regresar);
           parrafo1=v.findViewById(R.id.txtparrafo1);
           parrafo2=v.findViewById(R.id.txtparrafo2);
        update();


//           parrafo2.setVisibility(View.GONE);
//           parrafo1.setVisibility(View.GONE);
//demo=v.findViewById(R.id.button6);

//        btnaceptar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(replace.getText().toString().equals("temblaba")){
//
//                }
//            }
//        });


//demo.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        parrafo2.setText(getString(R.string.parrafo4Cap1));
//    }
//});
//
//
//pagina1();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index =(index+1)%(mParrafos.length);
                update();
            }
        });

        return v;
    }
    private void update(){
        ModelSt [] mParrafos = new ModelSt[]{

                new ModelSt(getString(R.string.parrafo1Cap1),1),
                new ModelSt(getString(R.string.parrafo2Cap1),2),
                new ModelSt(getString(R.string.parrafo3Cap1),3),
                new ModelSt(getString(R.string.parrafo4Cap1),4)
                //  new ModelSt(getResources().getString(R.string.parrafo2Cap1),2)
        };
        final Animation anim = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
        parrafo1.startAnimation(anim);
        parrafo1.setText(mParrafos[index].getParrafo());

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
              else if(parrafo2.getVisibility()==View.GONE){
                    parrafo2.startAnimation(anim);
                    parrafo2.setVisibility(View.VISIBLE);
                }

                else if(parrafo1.getVisibility() == View.VISIBLE && parrafo2.getVisibility() == View.VISIBLE)
             //       parrafo1.setVisibility(View.GONE);
               //     demo.setVisibility(View.VISIBLE);
             pagina2();
            }
        });
    }
    public void pagina2(){


            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
      //              parrafo2.setVisibility(View.GONE);
                    if(parrafo1.getText() == parrafo1.getText()){
                        parrafo1.setText(getString(R.string.parrafo3Cap1));
                    }
                   else if(parrafo2.getText() == parrafo2.getText()){

                    }
                }
            });


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
