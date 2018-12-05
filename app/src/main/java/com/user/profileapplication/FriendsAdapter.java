package com.user.profileapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.ViewHolder> {

    List<Friend> friends;
    FriendListener listener;

    public FriendsAdapter(List<Friend> friends, FriendListener listener) {
        this.friends = friends;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtNama;
        TextView txtUmur;
        TextView txtTingkatan;

        public ViewHolder(View v){
            super(v);
            txtNama = v.findViewById(R.id.txt_nama);
            txtUmur = v.findViewById(R.id.txt_umur);
            txtTingkatan = v.findViewById(R.id.txt_tingkatan);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_friend,viewGroup,false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Friend friend = friends.get(i);

        viewHolder.txtNama.setText(friend.getNama());
        viewHolder.txtUmur.setText(String.valueOf(friend.getUmur()) + " Tahun");
        viewHolder.txtTingkatan.setText(friend.getTingkatan());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onFriendClicked(friend);
            }
        });
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    public void refreshData(List<Friend> friends){
        this.friends = friends;
        notifyDataSetChanged();
    }
}
