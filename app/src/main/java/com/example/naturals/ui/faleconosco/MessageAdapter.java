package com.example.naturals.ui.faleconosco;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.naturals.R;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    private List<Message> messageList;

    public MessageAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == 0) {
            // Mensagem recebida - alinhe à esquerda
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_received, parent, false);
        } else {
            // Mensagem enviada - alinhe à direita
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_sent, parent, false);
        }
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        Message message = messageList.get(position);
        holder.messageText.setText(message.getText());
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return messageList.get(position).isSentByUser() ? 1 : 0;
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView messageText;
        LinearLayout messageLayout; // Layout que envolve a mensagem

        public MessageViewHolder(View itemView) {
            super(itemView);
            messageText = itemView.findViewById(R.id.text_message);
            messageLayout = itemView.findViewById(R.id.message_layout); // Referência ao layout da mensagem
        }
    }
}
