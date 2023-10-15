package com.example.naturals.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.naturals.Domain.PopularDomain;
import com.example.naturals.Helper.ChangeNumberItemsListener;
import com.example.naturals.Helper.ManagmentCart;
import com.example.naturals.R;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {
    ArrayList<PopularDomain> listItemSelected;
    private ManagmentCart managmentCart;
    ChangeNumberItemsListener changeNumberItemsListener;


    public CartListAdapter(ArrayList<PopularDomain> listItemSelected, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.listItemSelected = listItemSelected;
        managmentCart = new ManagmentCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_carrinho, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nomeProdutoDescricao.setText(listItemSelected.get(position).getTitle());
        holder. price_item.setText("$" + listItemSelected.get(position).getPrice());
        holder.total_ItemCart.setText("$" + Math.round((listItemSelected.get(position).getNumberinCart() * listItemSelected.get(position).getPrice())));
        holder.num.setText(String.valueOf(listItemSelected.get(position).getNumberinCart()));

        int drawableResourceId = holder.itemView.getContext().getResources()
                .getIdentifier(listItemSelected.get(position).getPicUrl(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .transform(new GranularRoundedCorners(30, 30, 30, 30))
                .into(holder.pic);

        holder.maisCartBuy.setOnClickListener(v -> {
            managmentCart.plusNumberItem(listItemSelected, position, () -> {
                notifyDataSetChanged();
                changeNumberItemsListener.change();
            });

        });

        holder.menosCartBuy.setOnClickListener(v -> {
            managmentCart.minusNumberItem(listItemSelected, position, () -> {
                notifyDataSetChanged();
                changeNumberItemsListener.change();
            });

        });
    }

    @Override
    public int getItemCount() {
        return listItemSelected.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nomeProdutoDescricao, price_item, maisCartBuy, menosCartBuy;
        ImageView pic;
        TextView total_ItemCart, num;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeProdutoDescricao = itemView.findViewById(R.id.nomeProdutoDescricao);
            pic = itemView.findViewById(R.id.pic);
            price_item = itemView.findViewById(R.id.price_item);
            total_ItemCart = itemView.findViewById(R.id.total_ItemCart);
            maisCartBuy = itemView.findViewById(R.id.maisCartBuy);
            menosCartBuy = itemView.findViewById(R.id.menosCartBuy);
            num = itemView.findViewById(R.id.numeroItemCart);
        }
    }
}
