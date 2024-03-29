package com.example.yhacks;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

/**
 * Created by maylisw on 1/23/18.
 */

public class SearchGroupDisplayAdapter extends RecyclerView.Adapter<SearchGroupDisplayAdapter.MyViewHolder> {
    private List<StudyGroup> studyGroups;
    private Context context;
    private static final String TAG = "HomeGroupDisplayAdapter";

    public SearchGroupDisplayAdapter(List<StudyGroup> group, Context context) {
        this.studyGroups = group;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.study_group_display_item, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchGroupDisplayAdapter.MyViewHolder holder, int i) {
        StudyGroup group = studyGroups.get(i);
        final MainActivity mainActivity = (MainActivity) context;
        if(mainActivity.inMyGroups(group)){
            holder.addCourseButton.setChecked(true);
        }
        group.setTimeDate();
        String timeDateStr = "";
        Log.d("AG", "onBindViewHolder: "+group.getName());
        holder.name.setText(group.getName());
        holder.course.setText("Course: " + group.getCourse());
        holder.subject.setText("Department " + group.getSubject());
//        for(int j = 0; j<group.getDate().length; j++) {
//            timeDateStr += group.getDate()[j] + " " + group.getTime()[j*2] + group.getTime()[(j*2) + 1];
//        }
        holder.schedule.setText("Schedule: " + timeDateStr);
        holder.location.setText("Location: " + group.getLocation());
        holder.userCount.setText(group.getUserCount() + " members have already joined");


        if(holder.addCourseButton.isChecked()){
            holder.addCourseButton.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.toggle_circle_off));
        }

        final int j = i;
        holder.addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToggleButton t = (ToggleButton) view;
                if(t.isChecked()){ //already in group
                    t.setBackgroundDrawable(t.getResources().getDrawable(R.drawable.toggle_circle_on));
                    mainActivity.removeGroup(studyGroups.get(j));
                } else {
                    t.setBackgroundDrawable(t.getResources().getDrawable(R.drawable.toggle_circle_off));
                    mainActivity.addGroup(studyGroups.get(j));
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return studyGroups.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name, course, subject, schedule, location, userCount;
        private ToggleButton addCourseButton;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            course = itemView.findViewById(R.id.course);
            subject = itemView.findViewById(R.id.department);
            schedule = itemView.findViewById(R.id.schedule);
            location = itemView.findViewById(R.id.location);
            userCount = itemView.findViewById(R.id.numPeople);
            addCourseButton = itemView.findViewById(R.id.add_study_group);
        }
    }
}
