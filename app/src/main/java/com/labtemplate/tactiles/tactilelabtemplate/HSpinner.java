package com.labtemplate.tactiles.tactilelabtemplate;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
public class HSpinner  extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    TextView textView;

    public HSpinner() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static HSpinner newInstance(int sectionNumber) {
        HSpinner fragment = new HSpinner();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.hslider, container, false);
        textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));


        SeekBar bar = rootView.findViewById(R.id.view1_seekBar);

        bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                //This function is called whenever the slider is moved
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
