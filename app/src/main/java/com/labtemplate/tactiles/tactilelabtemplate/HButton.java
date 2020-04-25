package com.labtemplate.tactiles.tactilelabtemplate;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
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

        //Create a button
        Button button = rootView.findViewById(R.id.view2_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //This code runs when the button is clicked

            }
        });

        //Create a seekbar
        SeekBar seekBar = rootView.findViewById(R.id.view2_seekBar);
        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                //This function will be called whenever the slider is moved to a new value.

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //This function will be called whenever the user lets go of the bar.
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //This function will be called whenever the user starts touching the bar.
            }
        });
        return rootView;
    }
}