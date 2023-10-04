package com.example.naturals.ui.faleconosco;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.naturals.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EditText editTextMessage;
    private Button buttonSend;
    private List<Message> messageList;
    private MessageAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.recycler_view);
        editTextMessage = findViewById(R.id.edit_text_message);
        buttonSend = findViewById(R.id.button_send);

        messageList = new ArrayList<>();
        messageAdapter = new MessageAdapter(messageList);
        recyclerView.setAdapter(messageAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String messageText = editTextMessage.getText().toString().trim();
        if (!messageText.isEmpty()) {
            messageList.add(new Message(messageText, true));
            messageAdapter.notifyDataSetChanged();
            editTextMessage.setText("");

            // Simule uma resposta automática para fins de exemplo
            simulateResponse();
        }
    }

    private void simulateResponse() {
        // Simule uma resposta automática após um pequeno atraso
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        messageList.add(new Message("Agradecemos pela sua mensagem, assim que possível responderemos!", false));
                        messageAdapter.notifyDataSetChanged();
                    }
                },
                1000
        );
    }
}
