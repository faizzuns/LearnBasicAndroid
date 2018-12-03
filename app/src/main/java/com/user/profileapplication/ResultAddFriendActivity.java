package com.user.profileapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultAddFriendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_add_friend);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Result");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String nama = getIntent().getStringExtra("nama");
        int umur = getIntent().getIntExtra("umur", 0);
        String tingkatan = getIntent().getStringExtra("tingkat");

        TextView txtNama = findViewById(R.id.txt_nama);
        TextView txtUmur = findViewById(R.id.txt_umur);
        TextView txtTingkatan = findViewById(R.id.txt_tingkatan);

        txtNama.setText(nama);
        txtUmur.setText(String.valueOf(umur) + " Tahun");
        txtTingkatan.setText(tingkatan);

        Button btnKembali = findViewById(R.id.btn_kembali);
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
