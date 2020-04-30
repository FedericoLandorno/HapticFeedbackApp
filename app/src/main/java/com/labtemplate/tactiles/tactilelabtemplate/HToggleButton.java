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
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.graphics.Color;

public class HToggleButton extends Fragment {
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

    public HToggleButton() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static HToggleButton newInstance(int sectionNumber) {
        HToggleButton fragment = new HToggleButton();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.htogglebutton, container, false);
        textView = (TextView) rootView.findViewById(R.id.hswitch_textView);
        textView.setText("Switch");

        vibr = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

        //Create switches
        Switch switch1 = rootView.findViewById(R.id.switch1);
        Switch switch2 = rootView.findViewById(R.id.switch2);
        Switch switch3 = rootView.findViewById(R.id.switch3);
        Switch switch4 = rootView.findViewById(R.id.switch4);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    //CONTROL NO VIBRATION
                } else {
                    // The toggle is disabled
                    //CONTROL NO VIBRATION
                }
            }
        });
        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    long[] pattern = {100, 0};
                    vibr.vibrate(pattern, -1);
                } else {
                    // The toggle is disabled
                }
            }
        });
        switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    long[] pattern = {100, 0};
                    vibr.vibrate(pattern, -1);
                } else {
                    // The toggle is disabled
                }
            }
        });
        switch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    long[] pattern = {100, 0};
                    vibr.vibrate(pattern, -1);
                } else {
                    // The toggle is disabled
                }
            }
        });

        return rootView;
    }
}