package com.example.recylerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ZakupyAdapter extends RecyclerView.Adapter<ZakupyAdapter.ProduktViewHolder>{

    private ArrayList<Produkt> produkty;
    private LayoutInflater inflater;


    public ZakupyAdapter(Context context, ArrayList<Produkt> produkty) {
        this.produkty = produkty;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ProduktViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.produkt_layout, parent, false);
        return new ProduktViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ProduktViewHolder holder, int position) {
        holder.checkBoxView.setText(produkty.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return produkty.size();
    }

    public class ProduktViewHolder extends RecyclerView.ViewHolder{
        public CheckBox checkBoxView;
        public ZakupyAdapter zakupyAdapter; // final????

        public ProduktViewHolder(@NonNull View itemView, ZakupyAdapter adapter) {
            super(itemView);
            checkBoxView = itemView.findViewById(R.id.checkBox);
            zakupyAdapter = adapter;
        }
    }
}
