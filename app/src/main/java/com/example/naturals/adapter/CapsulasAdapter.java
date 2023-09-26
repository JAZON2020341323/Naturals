package com.example.naturals.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.naturals.databinding.CapsulasItemBinding;
import com.example.naturals.modelo_de_dados.Capsulas;

import java.util.ArrayList;

public class CapsulasAdapter extends RecyclerView.Adapter<CapsulasAdapter.CapsulasViewHolder> {

    private final ArrayList<Capsulas> capsulasList;
    private  final Context context;

    public CapsulasAdapter(ArrayList<Capsulas> capsulasList, Context context) {
        this.capsulasList = capsulasList;
        this.context = context;
    }

    @NonNull
    @Override
    public CapsulasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CapsulasItemBinding listItem;
        listItem = CapsulasItemBinding.inflate(LayoutInflater.from(context),parent,false);
        return new CapsulasViewHolder(listItem);

        //Cria a visualizção pra lista
    }

    @Override
    public void onBindViewHolder(@NonNull CapsulasViewHolder holder, int position) {
        holder.binding.imageView4.setBackgroundResource(capsulasList.get(position).getImgCapsulas());
        holder.binding.txtCapsulasName.setText(capsulasList.get(position).getCapsulasName());
        holder.binding.txtCapsulaDescription.setText(capsulasList.get(position).getCapsulasDescription());
        holder.binding.txtPrice.setText(capsulasList.get(position).getPrice());

    }

    @Override
    public int getItemCount() {

        return capsulasList.size();
    }

    public static class CapsulasViewHolder extends  RecyclerView.ViewHolder{

        CapsulasItemBinding binding;

        public CapsulasViewHolder(CapsulasItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
