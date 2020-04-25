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
import android.widget.ImageButton;
import android.widget.TextView;
import android.graphics.Color;

public class view4 extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    //Public variables
    int i;
    static int hapticSignalMax = 20;
    long prevTime;
    Vibrator vibr;
    TextView textView;
    boolean isRecording = false;
    Button playButton, recordButton;
    long[] hapticSignal = new long[hapticSignalMax];

    public view4() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static view4 newInstance(int sectionNumber) {
        view4 fragment = new view4();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.view4, container, false);
        textView = (TextView) rootView.findViewById(R.id.textView);
        textView.setText("Push the record button, and then the empty area\nbeneath to record a tactile pattern.");

        //Initiate SeekBar
        ImageButton image = rootView.findViewById(R.id.view4_image);
        vibr = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

        //Hide the slider elements of the SeekBar
        image.setBackgroundColor(Color.argb(255, 220, 210, 255));
        image.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {

                //This function is called whenever a touch event has been registered on the element.

                int eventAction = arg1.getAction();

                //If the event is a "push down" or "let go":
                if (eventAction == MotionEvent.ACTION_DOWN || eventAction == MotionEvent.ACTION_UP) {



                    prevTime = System.currentTimeMillis();
                }

                return true;
            }

        });

        //Create the play button
        playButton = rootView.findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //This code runs when the first button is clicked
                vibr.vibrate(hapticSignal, -1);
            }
        });

        //Create the record button
        recordButton = rootView.findViewById(R.id.record_button);
        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isRecording == false){

                    //Reset saved haptic signal here


                    recordButton.setText("Stop");
                    isRecording = true;

                    prevTime = System.currentTimeMillis();
                }
                else if(isRecording == true){

                    recordButton.setText("Record");
                    isRecording = false;
                }
            }
        });
        return rootView;
    }
}