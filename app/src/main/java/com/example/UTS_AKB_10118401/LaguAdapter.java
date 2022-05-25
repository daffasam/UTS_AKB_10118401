package com.example.UTS_AKB_10118401;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Tanggal Pengerjaan : 23 Mei 2022
// Nama : Daffa Sacofi Mutawakkil
// NIM : 10118401
// Kelas : IF-6

public class LaguAdapter extends RecyclerView.Adapter<LaguAdapter.ViewHolder> {
    private List<LaguModel> items;

    public LaguAdapter(List<LaguModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public LaguAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lagu_item, parent, false);
        return new LaguAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final LaguModel data = items.get(position);
        holder.tvJudul.setText(data.getJudul());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvJudul;

        public ViewHolder(View itemView) {
            super(itemView);
            tvJudul = itemView.findViewById(R.id.txtLagu);
        }
    }
}
