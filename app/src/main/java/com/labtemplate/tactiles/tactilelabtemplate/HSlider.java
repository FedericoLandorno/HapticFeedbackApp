package com.labtemplate.tactiles.tactilelabtemplate;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class HSlider extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    Vibrator mVibrator;

    public HSlider() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static HSlider newInstance(int sectionNumber) {
        HSlider fragment = new HSlider();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.hslider, container, false);
        mVibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);


        SeekBar bar1 = rootView.findViewById(R.id.view1_seekBar1);
        SeekBar bar2 = rootView.findViewById(R.id.view1_seekBar2);
        SeekBar bar3 = rootView.findViewById(R.id.view1_seekBar3);
        SeekBar bar4 = rootView.findViewById(R.id.view1_seekBar4);

        bar1.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                //This function is called whenever the slider is moved
                //CONTROL: NO VIBRATION
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){
            }
        });

        bar2.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                //This function is called whenever the slider is moved
                mVibrator.vibrate(progress * 10);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){
            }
        });

        bar3.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                //This function is called whenever the slider is moved
                mVibrator.vibrate(progress * 10);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){
            }
        });

        bar4.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                //This function is called whenever the slider is moved
                mVibrator.vibrate(progress * 10);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){
            }
        });

        return rootView;
    }
}


