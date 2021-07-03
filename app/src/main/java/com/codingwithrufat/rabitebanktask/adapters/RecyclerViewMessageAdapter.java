package com.codingwithrufat.rabitebanktask.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codingwithrufat.rabitebanktask.R;
import com.codingwithrufat.rabitebanktask.models.ChatsModel;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewMessageAdapter extends RecyclerView.Adapter<RecyclerViewMessageAdapter.ViewHolder> {

    private Context context;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private List<ChatsModel> list;

    public RecyclerViewMessageAdapter(Context context, List<ChatsModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerViewMessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == LEFT){
            View view_left = LayoutInflater.from(context).inflate(R.layout.recyclerview_item_for_left_message, parent, false);
            return new ViewHolder(view_left);
        }else{
            View view_right = LayoutInflater.from(context).inflate(R.layout.recyclerview_item_for_right_message, parent, false);
            return new ViewHolder(view_right);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewMessageAdapter.ViewHolder holder, int position) {
        if (list.get(position).getType_message().equals("TEXT")){

            holder._layout_image.setVisibility(View.GONE);
            holder._layout_message.setVisibility(View.VISIBLE);
            holder._txt_message.setText(list.get(position).getMessage());
            holder._profile_text_message.setImageDrawable(context.getResources().getDrawable(list.get(position).getImage_profile()));

        }else {

            holder._layout_image.setVisibility(View.VISIBLE);
            holder._layout_message.setVisibility(View.GONE);
            holder._profile_image_message.setImageDrawable(context.getResources().getDrawable(list.get(position).getImage_profile()));
            holder._image_message.setImageDrawable(context.getResources().getDrawable(list.get(position).getImage_message()));

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout _layout_message, _layout_image;
        CircleImageView _profile_image_message, _profile_text_message;
        TextView _txt_message;
        ImageView _image_message;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            _profile_text_message = itemView.findViewById(R.id.circleImageForMessage);
            _profile_image_message = itemView.findViewById(R.id.circleImageForImageMessage);
            _image_message = itemView.findViewById(R.id.imageForMessage);
            _txt_message = itemView.findViewById(R.id.txtMessage);
            _layout_message = itemView.findViewById(R.id.llayoutMessage);
            _layout_image = itemView.findViewById(R.id.llayoutImage);

        }
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getType_person().equals("sender")){
            return LEFT;
        }else{
            return RIGHT;
        }
    }

}
