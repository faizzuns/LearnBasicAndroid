package com.user.profileapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddFriendActivity extends AppCompatActivity {

    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);

        Spinner spinner = findViewById(R.id.spinner_tingkatan);
        // Spinner Drop down elements
        final List<String> tingkatan = new ArrayList<String>();
        tingkatan.add("SD");
        tingkatan.add("SMP");
        tingkatan.add("SMA");
        tingkatan.add("Mahasiswa");
        tingkatan.add("Kantor");
        tingkatan.add("Tetangga");
        tingkatan.add("Lainnya");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, tingkatan);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), tingkatan.get(i) + " clicked", Toast.LENGTH_SHORT).show();
                index = i;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(), "Nothing Selected", Toast.LENGTH_SHORT).show();
            }
        });

        final EditText edtNama = findViewById(R.id.edt_nama);
        final EditText edtUmur = findViewById(R.id.edt_umur);
        Button btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtNama.getText().toString().length() == 0 || edtUmur.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "All field must have value", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), ResultAddFriendActivity.class);
                    intent.putExtra("nama", edtNama.getText().toString());
                    intent.putExtra("umur", Integer.parseInt(edtUmur.getText().toString()));
                    intent.putExtra("tingkat",tingkatan.get(index));
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
