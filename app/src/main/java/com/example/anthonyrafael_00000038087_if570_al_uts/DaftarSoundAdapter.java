package com.example.anthonyrafael_00000038087_if570_al_uts;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DaftarSoundAdapter extends RecyclerView.Adapter<DaftarSoundAdapter.ViewHolder>{
    private static final String TAG = "DaftarSoundAdapter";

    private ArrayList<Integer> mSoundImage = new ArrayList<>();
    private ArrayList<Integer> mSound = new ArrayList<>();
    private ArrayList<String> mJudul = new ArrayList<>();
    private ArrayList<String> mKategori = new ArrayList<>();
    private Context mContext;

    public DaftarSoundAdapter(ArrayList<Integer> mSoundImage, ArrayList<Integer> mSound, ArrayList<String> mJudul, ArrayList<String> mKategori, Context context) {
        this.mSoundImage = mSoundImage;
        this.mSound = mSound;
        this.mJudul = mJudul;
        this.mKategori = mKategori;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        Glide.with(mContext)
                .asBitmap()
                .load(mSoundImage.get(position))
                .into(holder.soundImage);

        holder.tvJudul.setText(mJudul.get(position));
        holder.tvKategori.setText(mKategori.get(position));

        holder.delBtn.setOnClickListener((view) -> {
            mSound.remove(position);
            mSoundImage.remove(position);
            mJudul.remove(position);
            mKategori.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, mJudul.size());
            Toast.makeText(view.getContext(), "Item Removed", Toast.LENGTH_SHORT).show();
        });

        holder.parent_layout.setOnClickListener((view) -> {
            Log.d(TAG, "onClick: called.");
            Intent intent = new Intent(mContext, DetailSoundActivity.class);
            intent.putExtra("judul", mJudul.get(position));
            intent.putExtra("kategori", mKategori.get(position));
            intent.putExtra("sound",mSound.get(position));
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mJudul.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView soundImage;
        ImageButton delBtn;
        TextView tvJudul, tvKategori;
        RelativeLayout parent_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            soundImage = itemView.findViewById(R.id.soundImage);
            tvJudul = itemView.findViewById(R.id.tvJudul);
            tvKategori = itemView.findViewById(R.id.tvKategori);
            delBtn = itemView.findViewById(R.id.delBtn);
            parent_layout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
