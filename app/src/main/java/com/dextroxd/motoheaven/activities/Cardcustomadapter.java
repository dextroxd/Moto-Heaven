package com.dextroxd.motoheaven.activities;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.dextroxd.motoheaven.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Cardcustomadapter extends RecyclerView.Adapter<Cardcustomadapter.MyViewHolder>
{
    ArrayList<Model_card> list;
    Activity activity;
    public Cardcustomadapter (ArrayList<Model_card> list,Activity activity)
    {
        this.list = list;
        this.activity = activity;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView name,cost;
        RatingBar rb;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.imagecard);
            name = itemView.findViewById(R.id.name);
            cost = itemView.findViewById(R.id.cost);
            rb = itemView.findViewById(R.id.rating);
        }

    }

    @NonNull
    @Override
    public Cardcustomadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.card_view, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Cardcustomadapter.MyViewHolder myViewHolder, int i) {
        Model_card model = list.get(i);
        Picasso.get().load(model.getmImage()).into(myViewHolder.imageView);
        myViewHolder.name.setText(model.getmName());
        myViewHolder.cost.setText(model.getmCost());
        myViewHolder.rb.setRating(model.getmRating());
        }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
