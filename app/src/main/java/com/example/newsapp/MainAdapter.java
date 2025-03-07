package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.Viewholder> {

    Context context;
    ArrayList<articleModal> mylist;

    public MainAdapter(Context context, ArrayList<articleModal> mylist) {
        this.context = context;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public MainAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.front_layout,null,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.Viewholder holder, int position) {


        articleModal item = mylist.get(position);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,webView.class);
                intent.putExtra("url",item.getUrl());
                context.startActivity(intent);
            }
        });
        holder.mheading.setText(item.getTitle());
        holder.mcontent.setText(item.getDescription());
        holder.mtime.setText("Published At"+ item.getPublishedAt());
        holder.author.setText(item.getAuthor());
        Glide.with(context).load(item.getUrlToImage()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        TextView mheading,mcontent,mtime,author;
        CardView cardView;
        ImageView image;
        public Viewholder(@NonNull View itemView) {

            super(itemView);
            mheading=itemView.findViewById(R.id.mainHeading);
            mcontent=itemView.findViewById(R.id.description);
            cardView=itemView.findViewById(R.id.cardView);
            image=itemView.findViewById(R.id.image);
            mtime=itemView.findViewById(R.id.publishedAt);
            author=itemView.findViewById(R.id.aurthor);

        }
    }
}
