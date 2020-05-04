package com.labtemplate.tactiles.tactilelabtemplate;

import android.content.Context;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.media.AudioAttributes;
import android.widget.CheckBox;

public class HCheckBox extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    Vibrator vibr;

    AudioAttributes[] aAttributes = new AudioAttributes[4];

    public HCheckBox() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static HCheckBox newInstance(int sectionNumber) {
        HCheckBox fragment = new HCheckBox();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.hcheckbox, container, false);
        vibr = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

        //Create checkboxes
        Button checkbox1 = rootView.findViewById(R.id.checkbox1);
        Button checkbox2 = rootView.findViewById(R.id.checkbox2);
        final Button checkbox3 = rootView.findViewById(R.id.checkbox3);
        Button checkbox4 = rootView.findViewById(R.id.checkbox4);

        checkbox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This code runs when the first checkbox is clicked
                //CONTROL WITHOUT VIBRATION
            }
        });
        checkbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This code runs when the second checkbox is clicked
                vibr.vibrate(10);
            }
        });
        checkbox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This code runs when the third checkbox is clicked
                if(((CheckBox)view).isChecked()){ //deselect
                    vibr.vibrate(30);
                } else {
                    vibr.vibrate(10);
                }
            }
        });
        checkbox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This code runs when the third checkbox is clicked
                if(((CheckBox)view).isChecked()){ //deselect
                    vibr.vibrate(10);
                } else {
                    vibr.vibrate(30);
                }
            }
        });

        return rootView;
    }
}