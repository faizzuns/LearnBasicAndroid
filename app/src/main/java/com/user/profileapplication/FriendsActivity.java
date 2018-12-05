package com.user.profileapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.raizlabs.android.dbflow.sql.language.Select;

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
        final FriendsAdapter adapter = new FriendsAdapter(listFriend, new FriendListener() {
            @Override
            public void onFriendClicked(Friend friend) {
                Toast.makeText(getApplicationContext(), friend.getNama() + " Deleted", Toast.LENGTH_SHORT).show();
            }
        });
        rvFriends.setAdapter(adapter);

        listFriend = new Select()
                .from(Friend.class)
                .queryList();
        adapter.refreshData(listFriend);
    }
}
