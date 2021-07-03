package com.codingwithrufat.rabitebanktask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.codingwithrufat.rabitebanktask.adapters.RecyclerViewAdapterForHomePage;
import com.codingwithrufat.rabitebanktask.adapters.RecyclerViewStatus;
import com.codingwithrufat.rabitebanktask.models.MessagesModel;
import com.codingwithrufat.rabitebanktask.models.StatusModel;
import com.codingwithrufat.rabitebanktask.viewmodels.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView, recyclerViewStatus;
    private List<MessagesModel> list;
    private RecyclerViewAdapterForHomePage adapter;
    private List<StatusModel> statusList;
    private RecyclerViewStatus statusAdapter;
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mainActivityViewModel.initMessagesList();
        mainActivityViewModel.initStatusList();

        mainActivityViewModel.getMessagesList().observe(this, new Observer<List<MessagesModel>>() {
            @Override
            public void onChanged(List<MessagesModel> messagesModels) {
                adapter.notifyDataSetChanged();
            }
        });

        mainActivityViewModel.getStatusList().observe(this, new Observer<List<StatusModel>>() {
            @Override
            public void onChanged(List<StatusModel> statusModels) {
                statusAdapter.notifyDataSetChanged();
            }
        });

        initializeRecyclerView();

    }

    // recyclerview(message and status) setup
    private void initializeRecyclerView(){

        list = mainActivityViewModel.getMessagesList().getValue();
        statusList = mainActivityViewModel.getStatusList().getValue();

        recyclerView = findViewById(R.id.recylerViewForHome);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(false);
        adapter = new RecyclerViewAdapterForHomePage(this, list);
        recyclerView.setAdapter(adapter);

        recyclerViewStatus = findViewById(R.id.recylerViewStatusForHome);
        recyclerViewStatus.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewStatus.setHasFixedSize(false);
        statusAdapter = new RecyclerViewStatus(this, statusList);
        recyclerViewStatus.setAdapter(statusAdapter);

    }

}