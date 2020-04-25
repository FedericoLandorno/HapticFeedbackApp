package com.labtemplate.tactiles.tactilelabtemplate;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.media.AudioAttributes;

public class view3 extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    Vibrator vibr;

    AudioAttributes[] aAttributes = new AudioAttributes[4];

    public view3() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static view3 newInstance(int sectionNumber) {
        view3 fragment = new view3();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.view3, container, false);
        vibr = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
        initAudioAttributes();

        //Create a button
        Button button1 = rootView.findViewById(R.id.view3_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //This code runs when the first button is clicked

            }
        });

        //Create a button
        Button button2 = rootView.findViewById(R.id.view3_button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //This code runs when the second button is clicked

            }
        });

        //Create a button
        Button button3 = rootView.findViewById(R.id.view3_button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //This code runs when the third button is clicked

            }
        });

        //Create a button
        Button button4 = rootView.findViewById(R.id.view3_button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //This code runs when the fourth button is clicked

            }
        });

        return rootView;
    }

    private void initAudioAttributes(){

        //Create Audio Attributes
        aAttributes[0] = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_UNKNOWN)
                .build();

        aAttributes[1] = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_UNKNOWN)
                .build();

        aAttributes[2] = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_UNKNOWN)
                .build();

        aAttributes[3] = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_NOTIFICATION_RINGTONE)
                .setContentType(AudioAttributes.CONTENT_TYPE_UNKNOWN)
                .build();
    }
}