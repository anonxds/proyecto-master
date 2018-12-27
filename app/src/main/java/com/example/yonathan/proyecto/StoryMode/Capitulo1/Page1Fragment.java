package com.example.yonathan.proyecto.StoryMode.Capitulo1;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.ClipData;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yonathan.proyecto.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Page1Fragment extends Fragment {


    public Page1Fragment() {
        // Required empty public constructor
    }

Button reset,btnmotiva2,btnmotivar2,btntiemblan,btnstemblaba;
Mod mod;
TextView parrafo1,ttemblando,ttemblaba,parrafo2,replace,oracion;
ConstraintLayout dragger,botone2,text,boton;

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


      //botones
        reset=v.findViewById(R.id.btnreset);
        btnmotiva2=v.findViewById(R.id.btnmotiva);
        btnmotivar2=v.findViewById(R.id.btnmotivar);
        btntiemblan=v.findViewById(R.id.btntembla);
        btnstemblaba=v.findViewById(R.id.btntemblaba);
     boton=v.findViewById(R.id.botones);
     boton.setVisibility(View.GONE);
     dragger=v.findViewById(R.id.layoutdrag);
     botone2=v.findViewById(R.id.layouttemblar);
     text=v.findViewById(R.id.layouttxt);
     dragger.setVisibility(View.GONE);
     botone2.setVisibility(View.GONE);
     text.setVisibility(View.GONE);




        final Animation anim = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha);
       ConstraintLayout constraintLayout= v.findViewById(R.id.texto);

        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (parrafo1.getVisibility() == View.GONE){
                    parrafo1.setVisibility(View.VISIBLE);
                    parrafo1.startAnimation(anim);

                   word();

                    btnmotiva2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                           SpannableStringBuilder spannable = new SpannableStringBuilder(parrafo1.getText().toString());
                            spannable.replace(56,69,"");
                            parrafo1.setText(spannable);
                        }
                    });


                }
                else if(parrafo2.getVisibility() == View.GONE ){
                    parrafo2.startAnimation(anim);
                    parrafo2.setVisibility(View.VISIBLE);
                }


            }
        });

        btntiemblan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SpannableStringBuilder spannable = new SpannableStringBuilder(parrafo1.getText().toString());
                spannable.replace(56,69,"tiemblan ");
                parrafo1.setText(spannable);
                word();
            }
        });
        btnstemblaba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SpannableStringBuilder spannable = new SpannableStringBuilder(parrafo1.getText().toString());
                spannable.replace(56,69,"temblaba ");
                parrafo1.setText(spannable);
                word();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String resets = getString(R.string.Parf1);
                parrafo1.setText(resets.toString());
                word();
            }
        });




//        btnaceptar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(replace.getText().toString().equals("temblaba")){
//
//                }
//            }
//        });



  //   ttemblando.setOnTouchListener(new ChoiceTouchListener());

    //    ttemblaba.setOnTouchListener(new ChoiceTouchListener());

      //  replace.setOnDragListener(dragListener);

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
                    if (vData.getId() == R.id.dtemblaba)
                {
                       //  ttemblaba.setVisibility(View.GONE);
                         replace.setText(ttemblaba.getText());

                }
                else if(vData.getId() == R.id.dtemblando){
                        replace.setText(ttemblando.getText());
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



public void word(){
    SpannableString ss = new SpannableString(parrafo1.getText().toString());

    ClickableSpan click1 = new ClickableSpan() {
        @Override
        public void onClick(View widget) {
            botone2.setVisibility(View.VISIBLE);
        }
    };
    ClickableSpan click2 = new ClickableSpan() {
        @Override
        public void onClick(View widget) {
            boton.setVisibility(View.VISIBLE);
        }
    };

    ss.setSpan(click1, 56,69, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    ss.setSpan(click2, 157, 165, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

    parrafo1.setText(ss);
    parrafo1.setMovementMethod(LinkMovementMethod.getInstance());

}



}
