package com.example.androidtutorial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.InfoviewHolder> {

    public class InfoviewHolder extends RecyclerView.ViewHolder{
        TextView sample;
        public InfoviewHolder(View itemView, int viewType) {

            super(itemView);

            sample=(TextView) itemView.findViewById(R.id.card_databinding);
        }
    }

    @NonNull
    @Override
    public SampleAdapter.InfoviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        InfoviewHolder vh;
        v=LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main,parent,false);
        vh = new InfoviewHolder(v,viewType);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull SampleAdapter.InfoviewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
