package com.labtemplate.tactiles.tactilelabtemplate;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TimePicker;

public class HTimePicker  extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    TextView textView;
    Vibrator vibr;

    public HTimePicker() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static HTimePicker newInstance(int sectionNumber) {
        HTimePicker fragment = new HTimePicker();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.hslider, container, false);
        textView = (TextView) rootView.findViewById(R.id.htimepicker_textView);
        textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

        vibr = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

        return rootView;
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment(v);
        //newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    @SuppressLint("ValidFragment")
    class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        View button;
        final long[] pattern1 = {100, 0, 1000};
        final long[] pattern2 = {100, 0, 1000};
        final long[] pattern3 = {100, 0, 1000};

        public TimePickerFragment(View v) {
            button = v;
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
            if (button.getId() == R.id.timepicker1) vibr.vibrate(pattern1, -1);
            else if (button.getId() == R.id.timepicker1) vibr.vibrate(pattern2, -1);
            else if (button.getId() == R.id.timepicker1) vibr.vibrate(pattern3, -1);
        }
    }
}
