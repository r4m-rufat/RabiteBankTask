package com.codingwithrufat.rabitebanktask.repositories;

import androidx.lifecycle.MutableLiveData;

import com.codingwithrufat.rabitebanktask.R;
import com.codingwithrufat.rabitebanktask.models.ChatsModel;

import java.util.ArrayList;
import java.util.List;

public class MessageActivityRepository {

    private static MessageActivityRepository INSTANCE;
    private ArrayList<ChatsModel> chatsData = new ArrayList<>();

    public static MessageActivityRepository getInstance(){
        if (INSTANCE == null){
            INSTANCE = new MessageActivityRepository();
        }
        return INSTANCE;
    }

    public MutableLiveData<List<ChatsModel>> getChatList(String _chat_type){
        chatsData.clear(); // clear() --> because item is changed to person or group then data must changed
        setChatsData(_chat_type);
        MutableLiveData<List<ChatsModel>> mutableChats = new MutableLiveData<>();
        mutableChats.setValue(chatsData);
        return mutableChats;
    }

    /**
     * type contains 2 parameters("person" and "group")
     * is checked item
     * @param type
     */
    public void setChatsData(String type){
        switch (type){
            case "person":
                chatsData.add(new ChatsModel("sender", "TEXT", "Hey, have you seen this amazing Flutter app?", 0, R.drawable.elon_musk));
                chatsData.add(new ChatsModel("receiver", "TEXT", "Yep, it has a done of features! Took us 6 months of development", 0, R.drawable.steve_jobs));
                chatsData.add(new ChatsModel("sender", "TEXT", "Looks great. Videos, photos, group chats etc. And everything is real time", 0, R.drawable.elon_musk));
                chatsData.add(new ChatsModel("sender", "IMAGE", "", R.drawable.steve_jobs, R.drawable.elon_musk));
                chatsData.add(new ChatsModel("receiver", "TEXT", "That's so cool!👍👍", 0, R.drawable.steve_jobs));
                chatsData.add(new ChatsModel("sender", "TEXT", "Too much energy though😂", 0, R.drawable.elon_musk));
                chatsData.add(new ChatsModel("receiver", "IMAGE", "", R.drawable.elon_musk, R.drawable.steve_jobs));
                chatsData.add(new ChatsModel("sender", "TEXT", "I am very beautiful and in this picture i seem so cool😂", 0, R.drawable.elon_musk));
                chatsData.add(new ChatsModel("receiver", "TEXT", "Yeah Elon, you are right😂", 0, R.drawable.steve_jobs));
                break;

            case "group":
                chatsData.add(new ChatsModel("sender", "TEXT", "Hey guys, I've created this group so we can stay in touch with team updates", 0, R.drawable.elon_musk));
                chatsData.add(new ChatsModel("sender", "TEXT", "That's great idea!", 0, R.drawable.mark));
                chatsData.add(new ChatsModel("receiver", "TEXT", "Sweet, glad to see everyone here!", 0, R.drawable.steve_jobs));
                chatsData.add(new ChatsModel("sender", "TEXT", "Here's what I have so far", 0, R.drawable.mark));
                chatsData.add(new ChatsModel("sender", "IMAGE", "", R.drawable.elon_musk, R.drawable.mark));
                chatsData.add(new ChatsModel("receiver", "TEXT", "Wow I, good job!", 0, R.drawable.steve_jobs));
                chatsData.add(new ChatsModel("sender", "TEXT", "Guys, do you like my inventions?", 0, R.drawable.elon_musk));
                chatsData.add(new ChatsModel("receiver", "TEXT", "Which one do you mean, Elon?", 0, R.drawable.steve_jobs));
                chatsData.add(new ChatsModel("receiver", "TEXT", "For instance, tesla", 0, R.drawable.elon_musk));
                chatsData.add(new ChatsModel("sender", "TEXT", "Yep, that is perfect", 0, R.drawable.steve_jobs));
                chatsData.add(new ChatsModel("sender", "TEXT", "It is unbelievable invention!", 0, R.drawable.mark));
                break;
        }
    }

}
