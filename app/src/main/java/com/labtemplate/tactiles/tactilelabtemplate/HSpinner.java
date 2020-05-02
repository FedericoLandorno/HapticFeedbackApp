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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HSpinner  extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    static int check = 0;
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

        List<String> spinnerArray1 =  new ArrayList();
        List<String> spinnerArray2 =  new ArrayList();
        List<String> spinnerArray3 =  new ArrayList();
        List<String> spinnerArray4 =  new ArrayList();
        List[] spinnerArrays = {spinnerArray1, spinnerArray2, spinnerArray3, spinnerArray4};
        int i;
        int j;
        for(j=0; j<spinnerArrays.length; j++){
            for(i=0; i<3; i++){
                        spinnerArrays[j].add("Spinner "+j+": item"+i);
            }
        }

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
                this.getContext(), android.R.layout.simple_spinner_item, spinnerArray1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                this.getContext(), android.R.layout.simple_spinner_item, spinnerArray2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(
                this.getContext(), android.R.layout.simple_spinner_item, spinnerArray3);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(
                this.getContext(), android.R.layout.simple_spinner_item, spinnerArray4);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);
        spinner4.setAdapter(adapter4);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {}
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(++check>3) {
                    vibr.vibrate((position+1)*20);
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(++check>3) {
                    vibr.vibrate(50);
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(++check>3) {
                    switch (position) {
                        case 0:
                            vibr.vibrate(60);
                            break;
                        case 1:
                            vibr.vibrate(40);
                            break;
                        case 2:
                            vibr.vibrate(20);
                            break;
                    }
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {}
        });


        return rootView;
    }
}
