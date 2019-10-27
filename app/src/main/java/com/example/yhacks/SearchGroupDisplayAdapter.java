package com.example.yhacks;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by maylisw on 1/23/18.
 */

public class SearchGroupDisplayAdapter extends RecyclerView.Adapter<SearchGroupDisplayAdapter.MyViewHolder> {
    private List<StudyGroup> studyGroups;
    private Context context;

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
        group.setTimeDate();
        String timeDateStr = "";
        Log.d("AG", "onBindViewHolder: "+group.getName());
        holder.name.setText(group.getName());
        holder.course.setText(group.getCourse());
        holder.subject.setText(group.getSubject());
        for(int j = 0; j<group.getDate().length; j++) {
            timeDateStr += group.getDate()[j] + " " + group.getTime()[j*2] + group.getTime()[(j*2) + 1];
        }
        holder.schedule.setText(timeDateStr);
        holder.location.setText(group.getLocation());
    }


    @Override
    public int getItemCount() {
        return studyGroups.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name, course, subject, schedule, location;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.friendName);
            course = itemView.findViewById(R.id.year);
            subject = itemView.findViewById(R.id.department);
            schedule = itemView.findViewById(R.id.major);
            location = itemView.findViewById(R.id.goodAt);
        }
    }
}
