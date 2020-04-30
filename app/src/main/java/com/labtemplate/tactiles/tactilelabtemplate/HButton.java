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

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This code runs when the button is clicked
                //COMMAND: PATTERN 1
                long[] pattern = {0, 100, 50, 250, 50, 100};
                vibr.vibrate(pattern, -1);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This code runs when the button is clicked
                //COMMAND: PATTERN 2
                long[] pattern = {0, 100, 50, 250, 50, 100};
                vibr.vibrate(pattern, -1);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This code runs when the button is clicked
                //COMMAND: PATTERN 3
                long[] pattern = {0, 100, 50, 250, 50, 100};
                vibr.vibrate(pattern, -1);
            }
        });

        return rootView;
    }
}