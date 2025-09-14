package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Homefragment extends Fragment {

    String apikey = "751da5da5ba84a3bbf3fa8d246f41612";
    private RecyclerView homeRecyc;
    ArrayList<articleModal> mylist=new ArrayList<>();;
    MainAdapter adapter;

    private String country="us";
    //private String category = "science";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.homefragment,null);


        homeRecyc=v.findViewById(R.id.homeRecyclerV);
        homeRecyc.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new MainAdapter(getContext(),mylist);
        homeRecyc.setAdapter(adapter);

        //findNews();
        findEverythingNews();

        return v;

    }

//    private void findNews() {
//        ApiUtilities.getApi_interface().getnews(country,100,apikey).enqueue(new Callback<mainNewsModal>() {
//            @Override
//            public void onResponse(Call<mainNewsModal> call, Response<mainNewsModal> response) {
//                if (response.isSuccessful()) {
//                    mylist.addAll(response.body().getArticles());
//                    adapter.notifyDataSetChanged();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<mainNewsModal> call, Throwable t) {
//
//            }
//        });
//    }

    private void findEverythingNews() {
        ApiUtilities.getApi_interface().getEverythingNews("India", 100, apikey)
                .enqueue(new Callback<mainNewsModal>() {
                    @Override
                    public void onResponse(Call<mainNewsModal> call, Response<mainNewsModal> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            mylist.clear();
                            mylist.addAll(response.body().getArticles());
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<mainNewsModal> call, Throwable t) {
                        t.printStackTrace();
                        Toast.makeText(getContext(), "Failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
