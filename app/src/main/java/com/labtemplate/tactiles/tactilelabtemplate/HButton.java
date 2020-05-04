package com.labtemplate.tactiles.tactilelabtemplate;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class HButton extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    Vibrator vibr;

    public HButton() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static HButton newInstance(int sectionNumber) {
        HButton fragment = new HButton();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.hbutton, container, false);
        vibr = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

        //Create a buttons
        Button button1 = rootView.findViewById(R.id.view2_button1);
        Button button2 = rootView.findViewById(R.id.view2_button2);
        Button button3 = rootView.findViewById(R.id.view2_button3);
        Button button4 = rootView.findViewById(R.id.view2_button4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This code runs when the button is clicked
                //COMMAND: DO NOTHING
            }
        });

        button2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    vibr.vibrate(10);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                }

                return true;
            }
        });

        button3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    vibr.vibrate(10);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    vibr.vibrate(10);
                }

                return true;
            }
        });

        button4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    vibr.vibrate(30);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    vibr.vibrate(10);
                }

                return true;
            }
        });

        return rootView;
    }
}