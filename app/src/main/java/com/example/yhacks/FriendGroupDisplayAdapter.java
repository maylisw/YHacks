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

public class FriendGroupDisplayAdapter extends RecyclerView.Adapter<FriendGroupDisplayAdapter.MyViewHolder> {
    private List<User> friends;
    private Context context;

    public FriendGroupDisplayAdapter(List<User> friend, Context context) {
        this.friends= friend;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.friend_display_item, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendGroupDisplayAdapter.MyViewHolder holder, int i) {
        User friend = friends.get(i);
        holder.name.setText(friend.getName());
        holder.year.setText(friend.getYear());
        holder.major.setText(friend.getMajor());
        holder.goodAt.setText(friend.getGoodAt());
    }


    @Override
    public int getItemCount() {
        return friends.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name, goodAt, year, major;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.friendName);
            goodAt = itemView.findViewById(R.id.goodAt);
            year = itemView.findViewById(R.id.year);
            major = itemView.findViewById(R.id.major);
        }
    }
}
