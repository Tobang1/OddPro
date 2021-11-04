package com.example.oddpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    Context context;
    ArrayList<FreeOdd> freeOddArrayList;

    public MyAdapter(Context context, ArrayList<FreeOdd> freeOddArrayList) {
        this.context = context;
        this.freeOddArrayList = freeOddArrayList;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        FreeOdd freeOdd   = freeOddArrayList.get(position);

        holder.freeHome.setText(freeOdd.freeHome);
        holder.freeAway.setText(freeOdd.freeAway);
        holder.freeLeague.setText(freeOdd.freeLeague);
        holder.freeStake.setText(freeOdd.freeStake);
        holder.freeDate.setText(freeOdd.freeDate);

    }

    @Override
    public int getItemCount() {
        return freeOddArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView freeHome, freeAway, freeLeague, freeStake, freeDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            freeHome = itemView.findViewById(R.id.freeHome);
            freeAway = itemView.findViewById(R.id.freeAway);
            freeLeague = itemView.findViewById(R.id.freeLeague);
            freeStake = itemView.findViewById(R.id.freeStake);
            freeDate = itemView.findViewById(R.id.freeDate);
        }

    }
}
