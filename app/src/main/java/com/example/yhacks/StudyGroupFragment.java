package com.example.yhacks;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;


public class StudyGroupFragment extends android.support.v4.app.Fragment {
    public static final String TAG = "fragments";

    private Context context;
    private View rootView;
    private EditText courseName, department, location, time1, time2;
    private String totalTimes;
    private Button submit;
    private ToggleButton mondayButton, tuesdayButton, wednesdayButton, thursdayButton, fridayButton, saturdayButton, sundayButton;

    public StudyGroupFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_study, container, false);
        context = rootView.getContext();
        wireWidgets();
        return rootView;
    }

    private void wireWidgets() {
        courseName = rootView.findViewById(R.id.courseInput);
        department = rootView.findViewById(R.id.departmentInput);
        location = rootView.findViewById(R.id.locationInput);
        time1 = rootView.findViewById(R.id.time1);
        time2 = rootView.findViewById(R.id.time2);
        totalTimes = time1.getText().toString() + " - " + time2.getText().toString();
        submit = rootView.findViewById(R.id.addCourse);
        mondayButton = rootView.findViewById(R.id.mondayButton);
        tuesdayButton = rootView.findViewById(R.id.tuesdayButton);
        wednesdayButton = rootView.findViewById(R.id.wednesdayButton);
        thursdayButton = rootView.findViewById(R.id.thursdayButton);
        fridayButton = rootView.findViewById(R.id.fridayButton);
        saturdayButton = rootView.findViewById(R.id.saturdayButton);
        sundayButton = rootView.findViewById(R.id.sundayButton);

        mondayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToggleButton t = (ToggleButton) view;
                if(t.isChecked()){
                    t.setBackgroundDrawable(t.getResources().getDrawable(R.drawable.weekday_toggle_circle_on));
                } else {
                    t.setBackgroundDrawable(t.getResources().getDrawable(R.drawable.weekday_toggle_circle_off));
                }
            }
        });

        tuesdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToggleButton t = (ToggleButton) view;
                if(t.isChecked()){
                    t.setBackgroundDrawable(t.getResources().getDrawable(R.drawable.weekday_toggle_circle_on));
                } else {
                    t.setBackgroundDrawable(t.getResources().getDrawable(R.drawable.weekday_toggle_circle_off));
                }
            }
        });

        wednesdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToggleButton t = (ToggleButton) view;
                if(t.isChecked()){
                    t.setBackgroundDrawable(t.getResources().getDrawable(R.drawable.weekday_toggle_circle_on));
                } else {
                    t.setBackgroundDrawable(t.getResources().getDrawable(R.drawable.weekday_toggle_circle_off));
                }
            }
        });

        thursdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToggleButton t = (ToggleButton) view;
                if(t.isChecked()){
                    t.setBackgroundDrawable(t.getResources().getDrawable(R.drawable.weekday_toggle_circle_on));
                } else {
                    t.setBackgroundDrawable(t.getResources().getDrawable(R.drawable.weekday_toggle_circle_off));
                }
            }
        });

        fridayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToggleButton t = (ToggleButton) view;
                if(t.isChecked()){
                    t.setBackgroundDrawable(t.getResources().getDrawable(R.drawable.weekday_toggle_circle_on));
                } else {
                    t.setBackgroundDrawable(t.getResources().getDrawable(R.drawable.weekday_toggle_circle_off));
                }
            }
        });

        saturdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToggleButton t = (ToggleButton) view;
                if(t.isChecked()){
                    t.setBackgroundDrawable(t.getResources().getDrawable(R.drawable.weekday_toggle_circle_on));
                } else {
                    t.setBackgroundDrawable(t.getResources().getDrawable(R.drawable.weekday_toggle_circle_off));
                }
            }
        });

        sundayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToggleButton t = (ToggleButton) view;
                if(t.isChecked()){
                    t.setBackgroundDrawable(t.getResources().getDrawable(R.drawable.weekday_toggle_circle_on));
                } else {
                    t.setBackgroundDrawable(t.getResources().getDrawable(R.drawable.weekday_toggle_circle_off));
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo upload the data from the others to the api
                if(courseName == null || courseName.equals("")) {
                    Toast.makeText(context, "Enter a valid course name", Toast.LENGTH_SHORT).show();
                }
                if(department == null || department.equals("")) {
                    Toast.makeText(context, "Enter a valid department", Toast.LENGTH_SHORT).show();
                }
                if(location == null || location.equals("")) {
                    Toast.makeText(context, "Enter a valid location", Toast.LENGTH_SHORT).show();
                }
                if(time1 == null || time1.equals("")) {
                    Toast.makeText(context, "Enter a valid start time", Toast.LENGTH_SHORT).show();
                }   
                if(time2 == null || time2.equals("")) {
                    Toast.makeText(context, "Enter a valid end time", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //todo create onClick listeners for each button, change color when selected
        //todo what is member
        //todo display time as 3:00-4:00?

    }

}
