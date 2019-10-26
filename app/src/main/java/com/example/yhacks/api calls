package com.example.maylisw.apipractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private PersonAdapter personAdapter;
    private List<People> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        people = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        personAdapter = new PersonAdapter(people, this);
        recyclerView.setAdapter(personAdapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UINames.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UINames api = retrofit.create(UINames.class);

        Call<List<People>> call = api.getNumberOfPeople(25, "France");
        call.enqueue(new Callback<List<People>>() {
            @Override
            public void onResponse(Call<List<People>> call, Response<List<People>> response) {
                people.clear();
                people.addAll(response.body());
                personAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<People>> call, Throwable t){
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG);
            }
        });
    }
}
