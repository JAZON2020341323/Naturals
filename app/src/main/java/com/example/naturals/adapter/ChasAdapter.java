package com.example.naturals.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.naturals.databinding.CapsulasItemBinding;
import com.example.naturals.modelo_de_dados.Chas;

import java.util.ArrayList;

public class ChasAdapter extends RecyclerView.Adapter<ChasAdapter.ChasViewHolder> {
    private final ArrayList<Chas> chasList;
    private final Context context;

    public ChasAdapter(ArrayList<Chas> chasList, Context context) {
        this.chasList = chasList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CapsulasItemBinding listItem;
        listItem = CapsulasItemBinding.inflate(LayoutInflater.from(context),parent,false);
        return new ChasViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ChasViewHolder holder, int position) {
        holder.binding.imageView4.setBackgroundResource(chasList.get(position).getImgCapsulas());
        holder.binding.txtCapsulasName.setText(chasList.get(position).getCapsulasName());
        holder.binding.txtCapsulaDescription.setText(chasList.get(position).getCapsulasDescription());
        holder.binding.txtPrice.setText(chasList.get(position).getPrice());

        //Exibe visualização para o usuario

    }

    @Override
    public int getItemCount() {

        return chasList.size();
    }

    public static class ChasViewHolder extends RecyclerView.ViewHolder{

        CapsulasItemBinding binding;

        public ChasViewHolder(CapsulasItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
