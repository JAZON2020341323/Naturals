package com.example.naturals.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.naturals.databinding.CapsulasItemBinding;
import com.example.naturals.modelo_de_dados.Temperos;

import java.util.ArrayList;

public class TemperosAdapter extends RecyclerView.Adapter<TemperosAdapter.TemperosViewHolder> {
    private final ArrayList<Temperos> temperosList;
    private final Context context;

    public TemperosAdapter(ArrayList<Temperos> temperosList, Context context) {
        this.temperosList = temperosList;
        this.context = context;
    }

    @NonNull
    @Override
    public TemperosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CapsulasItemBinding listItem;
        listItem = CapsulasItemBinding.inflate(LayoutInflater.from(context),parent,false);
        return new TemperosViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull TemperosViewHolder holder, int position) {
        holder.binding.imageView4.setBackgroundResource(temperosList.get(position).getImgCapsulas());
        holder.binding.txtCapsulasName.setText(temperosList.get(position).getCapsulasName());
        holder.binding.txtCapsulaDescription.setText(temperosList.get(position).getCapsulasDescription());
        holder.binding.txtPrice.setText(temperosList.get(position).getPrice());

        //Exibe visualização para o usuario
    }

    @Override
    public int getItemCount() {

        return temperosList.size();
    }

    public static class TemperosViewHolder extends RecyclerView.ViewHolder{

        CapsulasItemBinding binding;

        public TemperosViewHolder(CapsulasItemBinding binding) {

            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
