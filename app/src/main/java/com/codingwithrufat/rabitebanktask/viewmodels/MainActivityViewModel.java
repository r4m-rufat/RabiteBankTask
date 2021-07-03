package com.codingwithrufat.rabitebanktask.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.codingwithrufat.rabitebanktask.models.MessagesModel;
import com.codingwithrufat.rabitebanktask.models.StatusModel;
import com.codingwithrufat.rabitebanktask.repositories.MainActivityRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<MessagesModel>> messagesList;
    private MutableLiveData<List<StatusModel>> statusList;

    public void initMessagesList(){
        if (messagesList != null){
            return;
        }
        messagesList = MainActivityRepository.getInstance().getMessagesList();

    }

    public void initStatusList(){
        if (statusList != null){
            return;
        }

        statusList = MainActivityRepository.getInstance().getStatusList();

    }

    public LiveData<List<MessagesModel>> getMessagesList(){
        return messagesList;
    }

    public LiveData<List<StatusModel>> getStatusList(){
        return statusList;
    }

}
