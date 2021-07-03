package com.codingwithrufat.rabitebanktask.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.codingwithrufat.rabitebanktask.models.ChatsModel;
import com.codingwithrufat.rabitebanktask.repositories.MessageActivityRepository;

import java.util.List;

public class MessageActivityViewModel extends ViewModel {

    private static MutableLiveData<List<ChatsModel>> listChats;

    public void init(String _chat_type){
        listChats = MessageActivityRepository.getInstance().getChatList(_chat_type);
    }

    public MutableLiveData<List<ChatsModel>> getListChats(){
        return listChats;
    }

}
