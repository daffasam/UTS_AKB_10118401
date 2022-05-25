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

public class FLAdapter extends RecyclerView.Adapter<FLAdapter.ViewHolder> {

    private List<FLModel> items;

    public FLAdapter(List<FLModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public FLAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fl_item, parent, false);
        return new FLAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final FLModel data = items.get(position);
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
            imgMainData = itemView.findViewById(R.id.foto_fl);
            tvNama = itemView.findViewById(R.id.nama_fl);
        }
    }
}
