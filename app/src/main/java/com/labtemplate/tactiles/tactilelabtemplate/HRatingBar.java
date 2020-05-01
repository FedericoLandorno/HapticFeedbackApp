package com.labtemplate.tactiles.tactilelabtemplate;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class HRatingBar extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    Vibrator mVibrator;

    public HRatingBar() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static HRatingBar newInstance(int sectionNumber) {
        HRatingBar fragment = new HRatingBar();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.hratingbar, container, false);
        mVibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

        //Create rating bars
        RatingBar star1 = rootView.findViewById(R.id.ratingBar1);
        RatingBar star2 = rootView.findViewById(R.id.ratingBar2);
        RatingBar star3 = rootView.findViewById(R.id.ratingBar3);
        RatingBar star4 = rootView.findViewById(R.id.ratingBar4);

        star1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                //CONTROL NO VIBRATION
            }
        });
        star2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                long[] pattern = {0, (long)rating*10};
                mVibrator.vibrate(pattern, -1);
            }
        });
        star3.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                long[] pattern = {0, (long)rating*10};
                mVibrator.vibrate(pattern, -1);
            }
        });
        star4.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                long[] pattern = {0, (long)rating*10};
                mVibrator.vibrate(pattern, -1);
            }
        });

        return rootView;
    }
}