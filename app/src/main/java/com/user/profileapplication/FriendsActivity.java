package com.user.profileapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.List;

public class FriendsActivity extends AppCompatActivity {

    List<Friend> listFriend = new ArrayList<>();
    Friend deletedFriend = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        final RelativeLayout boxPopUp = findViewById(R.id.box_popup);
        Button btnYa = findViewById(R.id.btn_ya);
        Button btnTidak = findViewById(R.id.btn_tidak);

        btnTidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boxPopUp.setVisibility(View.GONE);
            }
        });

        RecyclerView rvFriends = findViewById(R.id.rv_friends);
        rvFriends.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rvFriends.setLayoutManager(llm);

        final FriendsAdapter adapter = new FriendsAdapter(listFriend, new FriendListener() {
            @Override
            public void onFriendClicked(Friend friend) {
                Toast.makeText(getApplicationContext(), friend.getNama() + " Clicked", Toast.LENGTH_SHORT).show();
                boxPopUp.setVisibility(View.VISIBLE);
                deletedFriend = friend;
            }
        });
        rvFriends.setAdapter(adapter);

        btnYa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // refresh list
                listFriend.remove(deletedFriend);
                adapter.refreshData(listFriend);
                // delete dari dbnya
                deletedFriend.delete();
            }
        });

        listFriend = new Select()
                .from(Friend.class)
                .queryList();
        adapter.refreshData(listFriend);
    }
}
