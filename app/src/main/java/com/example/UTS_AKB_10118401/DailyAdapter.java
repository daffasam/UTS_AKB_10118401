package com.example.UTS_AKB_10118401;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Tanggal Pengerjaan : 23 Mei 2022
// Nama : Daffa Sacofi Mutawakkil
// NIM : 10118401
// Kelas : IF-6

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.ViewHolder>{

    private List<DailyModel> items;

    public DailyAdapter(List<DailyModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public DailyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.da_item, parent, false);
        return new DailyAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DailyModel data = items.get(position);
        holder.imgMainData.setImageResource(data.getImgSrc());
        holder.tvNama.setText(data.getNama());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgMainData;
        public TextView tvNama;

        public ViewHolder(View itemView) {
            super(itemView);
            imgMainData = itemView.findViewById(R.id.imgDA);
            tvNama = itemView.findViewById(R.id.txtDA);
        }
    }
}
