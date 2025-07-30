package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Sportfragment extends Fragment {

    String apikey = "751da5da5ba84a3bbf3fa8d246f41612";
    private RecyclerView sportsRecyc;
    ArrayList<articleModal> mylist = new ArrayList<>();;
    MainAdapter adapter;

    private String country="us";
    private String category = "Sports";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sportfragment,null);

        sportsRecyc=v.findViewById(R.id.sportRecyclerV);
        sportsRecyc.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new MainAdapter(getContext(),mylist);
        sportsRecyc.setAdapter(adapter);

        findNews();

        return v;
    }
    private void findNews() {
        ApiUtilities.getApi_interface().getcategorynews(country,100,category,apikey).enqueue(new Callback<mainNewsModal>() {
            @Override
            public void onResponse(Call<mainNewsModal> call, Response<mainNewsModal> response) {
                if (response.isSuccessful()) {
                    mylist.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<mainNewsModal> call, Throwable t) {

            }
        });
    }
}
