package com.labtemplate.tactiles.tactilelabtemplate;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class HSpinner  extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    Vibrator vibr;

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

        View rootView = inflater.inflate(R.layout.hspinner, container, false);
        vibr = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

        Spinner spinner1 = rootView.findViewById(R.id.hspinner1);
        Spinner spinner2 = rootView.findViewById(R.id.hspinner2);
        Spinner spinner3 = rootView.findViewById(R.id.hspinner3);
        Spinner spinner4 = rootView.findViewById(R.id.hspinner4);

        List<String> spinnerArray =  new ArrayList();
        int i;
        for(i=0; i<100; i++){
            spinnerArray.add("item"+(i+1));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this.getContext(), android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);
        spinner4.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString(); //this is your selected item
                long[] pattern = {0, 100, 50, 250, 50, 100};
                vibr.vibrate(pattern, -1);
            }
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString(); //this is your selected item
                long[] pattern = {0, 100, 50, 250, 50, 100};
                vibr.vibrate(pattern, -1);
            }
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString(); //this is your selected item
                long[] pattern = {0, 100, 50, 250, 50, 100};
                vibr.vibrate(pattern, -1);
            }
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString(); //this is your selected item
                long[] pattern = {0, 100, 50, 250, 50, 100};
                vibr.vibrate(pattern, -1);
            }
            public void onNothingSelected(AdapterView<?> parent) {}
        });


        return rootView;
    }
}
