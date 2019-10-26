package com.example.yhacks;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class StudyGroupFragment extends android.support.v4.app.Fragment {
    public static final String TAG = "fragments";

    private Context context;
    private View rootView;
    private EditText courseName, department, location, time1, time2;
    private Button submit;

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
        submit = rootView.findViewById(R.id.addCourse);
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
