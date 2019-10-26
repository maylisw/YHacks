package com.example.yhacks;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class GroupDisplayAdapter extends RecyclerView.Adapter<GroupDisplayAdapter.MyViewHolder>{
    private Context context;
    private ArrayList<StudyGroup> groupsList;

    public GroupDisplayAdapter(ArrayList<StudyGroup> passedGroupList, Context context) {
        groupsList = passedGroupList;
        //instance vars
    }

    @Override
    public GroupDisplayAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.study_group_display_item, parent,false);
        return new GroupDisplayAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        //holder.recipeTitle.setText(favoritesList.get(position).getName());
        //todo interact with view holder

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public void removeItem(int position) {
        groupsList.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(StudyGroup item, int position) {
        groupsList.add(position, item);
        notifyItemInserted(position);
    }

    public ArrayList<StudyGroup> getListOfIngredients() {
        return groupsList;
    }

    @Override
    public int getItemCount() {
        return groupsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        //instance vars

        public MyViewHolder(final View itemView) {
            super(itemView);
            //todo wire viewholder
            //wire using imageview.findviewbyid
        }
    }
}

