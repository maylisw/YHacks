package com.example.yhacks;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yhacks.University;

import java.util.List;

/**
 * Created by maylisw on 1/23/18.
 */

public class UniversityAdapter extends RecyclerView.Adapter<UniversityAdapter.MyViewHolder> {
    private List<University> universities;
    private Context context;

    public UniversityAdapter(List<University> people, Context context) {
        this.universities = people;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.univeristy_display, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UniversityAdapter.MyViewHolder holder, int i) {
        University uni = universities.get(i);
        holder.name.setText(uni.getName());
        holder.city.setText(uni.getCity());

    }


    @Override
    public int getItemCount() {
        return universities.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name, city;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.uni_name);
            city = itemView.findViewById(R.id.uni_city);

        }
    }
}
