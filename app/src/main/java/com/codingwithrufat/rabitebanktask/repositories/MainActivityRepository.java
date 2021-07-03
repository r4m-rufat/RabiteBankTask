package com.codingwithrufat.rabitebanktask.repositories;

import androidx.lifecycle.MutableLiveData;

import com.codingwithrufat.rabitebanktask.R;
import com.codingwithrufat.rabitebanktask.models.MessagesModel;
import com.codingwithrufat.rabitebanktask.models.StatusModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton pattern
 */
public class MainActivityRepository {

    private static MainActivityRepository INSTANCE;
    private ArrayList<MessagesModel> messagesData = new ArrayList<>();
    private ArrayList<StatusModel> statusData = new ArrayList<>();

    // we create instance of this class
    public static MainActivityRepository getInstance(){
        if (INSTANCE == null){
            INSTANCE = new MainActivityRepository();
        }
        return INSTANCE;
    }

    public MutableLiveData<List<MessagesModel>> getMessagesList(){
        setMessagesData();
        MutableLiveData<List<MessagesModel>> mutableMessage = new MutableLiveData<>();
        mutableMessage.setValue(messagesData);
        return mutableMessage;
    }

    public MutableLiveData<List<StatusModel>> getStatusList(){
        setStatusData();
        MutableLiveData<List<StatusModel>> mutableStatus = new MutableLiveData<>();
        mutableStatus.setValue(statusData);
        return mutableStatus;
    }

    // set message data to the list
    public void setMessagesData(){
        messagesData.add(new MessagesModel("private", "Elon Musk", "Flutter is app rocks😍😍😍", "11:13 AM", R.drawable.elon_musk, 0));
        messagesData.add(new MessagesModel("group", "InstaMobile Team", "Group cahts, photo and videos, wow✨", "", R.drawable.steve_jobs, R.drawable.elon_musk));
        messagesData.add(new MessagesModel("private", "Steve Jobs", "It saved me 4 months of development😎", "09:10 AM", R.drawable.steve_jobs, 0));
        messagesData.add(new MessagesModel("private", "Mark Zuckerberg", "There are so many features here😍", "11:12 PM", R.drawable.mark, 0));
        messagesData.add(new MessagesModel("private", "Json Statham", "Wow this is amazing", "11:11 AM", R.drawable.statham, 0));
        messagesData.add(new MessagesModel("private", "Elon Musk", "Mark sent a video", "05:33 AM", R.drawable.elon_musk, 0));
        messagesData.add(new MessagesModel("private", "Steve Jobs", "Asd", "09:15 PM", R.drawable.steve_jobs, 0));
        messagesData.add(new MessagesModel("group", "The group chat", "Hola amigos", "02:18 PM", R.drawable.statham, R.drawable.elon_musk));
        messagesData.add(new MessagesModel("private", "Mark Zuckerberg", "Flutter is app rocks", "11:12 AM", R.drawable.mark, 0));
        messagesData.add(new MessagesModel("private", "Json Statham", "Flutter is app rocks", "11:12 AM", R.drawable.statham, 0));
    }

    // set status data to the list which is setted in MainActivity
    public void setStatusData(){
        statusData.add(new StatusModel(R.drawable.elon_musk, "Elon"));
        statusData.add(new StatusModel(R.drawable.steve_jobs, "Steve"));
        statusData.add(new StatusModel(R.drawable.statham, "Json"));
        statusData.add(new StatusModel(R.drawable.mark, "Mark"));
        statusData.add(new StatusModel(R.drawable.elon_musk, "Elon"));
        statusData.add(new StatusModel(R.drawable.steve_jobs, "Steve"));
        statusData.add(new StatusModel(R.drawable.statham, "Json"));
        statusData.add(new StatusModel(R.drawable.mark, "Mark"));
    }

}
