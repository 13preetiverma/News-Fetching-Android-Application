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

public class Techfragment extends Fragment {

    String apikey = "751da5da5ba84a3bbf3fa8d246f41612";
    private RecyclerView techRecyc;
    ArrayList<articleModal> mylist=new ArrayList<>();;
    MainAdapter adapter;

    private String country="us";
    private String category = "Technology";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.techfragment,null);

        techRecyc=v.findViewById(R.id.techRecyclerV);

        techRecyc.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new MainAdapter(getContext(),mylist);
        techRecyc.setAdapter(adapter);

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
