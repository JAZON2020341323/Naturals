package com.example.naturals.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.naturals.databinding.CapsulasItemBinding;
import com.example.naturals.modelo_de_dados.Graos;

import java.util.ArrayList;

public class GraosAdapter extends RecyclerView.Adapter<GraosAdapter.GraosViewHolder> {

    private final ArrayList<Graos> graosList;
    private final Context context;

    public GraosAdapter(ArrayList<Graos> graosList, Context context) {
        this.graosList = graosList;
        this.context = context;
    }

    @NonNull
    @Override
    public GraosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CapsulasItemBinding listItem;
        listItem = CapsulasItemBinding.inflate(LayoutInflater.from(context),parent,false);
        return new GraosViewHolder(listItem);

        //Cria a visualizção pra lista
    }

    @Override
    public void onBindViewHolder(@NonNull GraosViewHolder holder, int position) {
        holder.binding.imageView4.setBackgroundResource(graosList.get(position).getImgCapsulas());
        holder.binding.txtCapsulasName.setText(graosList.get(position).getCapsulasName());
        holder.binding.txtCapsulaDescription.setText(graosList.get(position).getCapsulasDescription());
        holder.binding.txtPrice.setText(graosList.get(position).getPrice());

        //Exibe visualização para o usuario

    }

    @Override
    public int getItemCount() {

        return graosList.size();
    }

    public static class GraosViewHolder extends RecyclerView.ViewHolder{

        CapsulasItemBinding binding;

        public GraosViewHolder(CapsulasItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
