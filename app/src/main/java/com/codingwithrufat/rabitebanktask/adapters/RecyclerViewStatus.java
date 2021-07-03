package com.codingwithrufat.rabitebanktask.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codingwithrufat.rabitebanktask.R;
import com.codingwithrufat.rabitebanktask.models.StatusModel;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * horizantal status adapter
 */
public class RecyclerViewStatus extends RecyclerView.Adapter<RecyclerViewStatus.ViewHolder> {

    private Context context;
    private List<StatusModel> list;

    public RecyclerViewStatus(Context context, List<StatusModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerViewStatus.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_for_horizantal_status, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewStatus.ViewHolder holder, int position) {
        holder._text_username.setText(list.get(position).getUsername());
        holder._status_image.setImageDrawable(context.getResources().getDrawable(list.get(position).getStatus_image()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView _text_username;
        CircleImageView _status_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            _text_username = itemView.findViewById(R.id.status_name);
            _status_image = itemView.findViewById(R.id.image_for_status);

        }
    }
}
