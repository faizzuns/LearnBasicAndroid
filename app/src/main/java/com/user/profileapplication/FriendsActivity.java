package com.user.profileapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FriendsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);



        RecyclerView rvFriends = findViewById(R.id.rv_friends);
        rvFriends.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rvFriends.setLayoutManager(llm);
        List<Friend> listFriend = new ArrayList<>();
        FriendsAdapter adapter = new FriendsAdapter(listFriend, new FriendListener() {
            @Override
            public void onFriendClicked(Friend friend) {
                Toast.makeText(getApplicationContext(), friend.getNama() + " Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        rvFriends.setAdapter(adapter);

        listFriend.add(new Friend("Ahmad", 22, "SD"));
        listFriend.add(new Friend("Faiz", 28, "SMP"));
        listFriend.add(new Friend("Joko", 21, "SMA"));
        listFriend.add(new Friend("Anwar", 23, "Mahasiswa"));
        listFriend.add(new Friend("Surapati", 25, "Tetangga"));
        adapter.refreshData(listFriend);
    }
}
