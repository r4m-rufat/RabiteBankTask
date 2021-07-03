package com.codingwithrufat.rabitebanktask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingwithrufat.rabitebanktask.adapters.RecyclerViewMessageAdapter;
import com.codingwithrufat.rabitebanktask.models.ChatsModel;
import com.codingwithrufat.rabitebanktask.viewmodels.MainActivityViewModel;
import com.codingwithrufat.rabitebanktask.viewmodels.MessageActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity {

    private List<ChatsModel> list;
    private RecyclerViewMessageAdapter messageAdapter;
    private RecyclerView recyclerView;
    private TextView _txt_name, _txt_activity;
    private ImageView _ic_back;
    private MessageActivityViewModel messageActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Intent intent = getIntent();
        String _chat_name = intent.getStringExtra("username");

        messageActivityViewModel = new ViewModelProvider(this).get(MessageActivityViewModel.class);
        messageActivityViewModel.init(intent.getStringExtra("type"));

        messageActivityViewModel.getListChats().observe(this, new Observer<List<ChatsModel>>() {
            @Override
            public void onChanged(List<ChatsModel> chatsModels) {
                messageAdapter.notifyDataSetChanged();
            }
        });

        initWidgets();
        _txt_name.setText(_chat_name); // set chat name to textview in the top
        setActivityVision(intent);
        initRecyclerView();
        clickedBackButton(_ic_back);

    }

    private void setActivityVision(Intent intent){
        switch (intent.getStringExtra("type")){
            case "person":
                showUserActivity(_txt_activity);
                break;

            case "group":
                hideUserActivity(_txt_activity);
                break;

        }
    }

    private void initWidgets(){
        _txt_name = findViewById(R.id.chat_username);
        _txt_activity = findViewById(R.id.user_activity);
        _ic_back = findViewById(R.id.ic_back);
    }

    private void showUserActivity(TextView textView){
        textView.setVisibility(View.VISIBLE);
    }

    private void hideUserActivity(TextView textView){
        textView.setVisibility(View.GONE);
    }

    private void clickedBackButton(ImageView imageView){
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initRecyclerView(){
        list = messageActivityViewModel.getListChats().getValue();

        recyclerView = findViewById(R.id.recyclerViewMessage);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(false);
        messageAdapter = new RecyclerViewMessageAdapter(this, list);
        recyclerView.setAdapter(messageAdapter);
    }

}