package com.example.yhacks;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class StudyGroupInfo extends AppCompatActivity {
    private Context context;
    private View rootView;
    private TextView groupName, schedule, location, department, course, numPeople, owner, friendsInGroups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_group_info);
        wireWidgets();
    }

    private void wireWidgets() {
        groupName = findViewById(R.id.groupName);
        schedule = findViewById(R.id.schedule);
        location = findViewById(R.id.location);
        department = findViewById(R.id.department);
        course = findViewById(R.id.course);
        numPeople = findViewById(R.id.numPeople);
        owner = findViewById(R.id.owner);
        friendsInGroups = findViewById(R.id.friendsInGroups);
    }
}
