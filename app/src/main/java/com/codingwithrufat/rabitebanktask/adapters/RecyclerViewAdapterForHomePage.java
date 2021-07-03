package com.codingwithrufat.rabitebanktask.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codingwithrufat.rabitebanktask.MessageActivity;
import com.codingwithrufat.rabitebanktask.R;
import com.codingwithrufat.rabitebanktask.models.MessagesModel;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapterForHomePage extends RecyclerView.Adapter<RecyclerViewAdapterForHomePage.ViewHolder> {

    Context context;
    List<MessagesModel> list;

    public RecyclerViewAdapterForHomePage(Context context, List<MessagesModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterForHomePage.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item_for_home, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterForHomePage.ViewHolder holder, int position) {

        if (list.get(position).getType().equals("private")) {
            holder._rel_group.setVisibility(View.GONE);
            holder._rel_person.setVisibility(View.VISIBLE);
            holder._image_single.setImageDrawable(context.getResources().getDrawable(list.get(position).getImage1()));
            holder._person_name.setText(list.get(position).getUsername());
            holder._person_message.setText(list.get(position).getLast_message() + " •");
            holder._time.setText(list.get(position).getTime());
        } else {
            holder._rel_group.setVisibility(View.VISIBLE);
            holder._rel_person.setVisibility(View.GONE);
            holder._group_name.setText(list.get(position).getUsername());
            holder._group_description.setText(list.get(position).getLast_message());
            holder._image_group_1.setImageDrawable(context.getResources().getDrawable(list.get(position).getImage1()));
            holder._image_group_2.setImageDrawable(context.getResources().getDrawable(list.get(position).getImage2()));
        }

        holder._rel_person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, MessageActivity.class)
                        .putExtra("type", "person")
                        .putExtra("username", list.get(position).getUsername()));
            }
        });

        holder._rel_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, MessageActivity.class)
                        .putExtra("type", "group")
                        .putExtra("username", list.get(position).getUsername()));
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout _rel_person, _rel_group;
        CircleImageView _image_single, _image_group_1, _image_group_2;
        TextView _group_name, _person_name, _person_message, _group_description, _time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            _rel_person = itemView.findViewById(R.id.rellayoutPerson);
            _rel_group = itemView.findViewById(R.id.rellayoutGroup);
            _image_single = itemView.findViewById(R.id.circleImageForHomeSingle);
            _image_group_1 = itemView.findViewById(R.id.circleImageGroup1);
            _image_group_2 = itemView.findViewById(R.id.circleImageGroup2);
            _group_name = itemView.findViewById(R.id.txtGroupName);
            _group_description = itemView.findViewById(R.id.txtGroupDescription);
            _person_name = itemView.findViewById(R.id.txtPersonName);
            _person_message = itemView.findViewById(R.id.txt_person_message);
            _time = itemView.findViewById(R.id.txtTime);

        }
    }
}
