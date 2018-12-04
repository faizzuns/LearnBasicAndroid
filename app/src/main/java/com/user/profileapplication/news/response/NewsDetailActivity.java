package com.user.profileapplication.news.response;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.user.profileapplication.R;

public class NewsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String urlImg = getIntent().getStringExtra("url_img");
        String title = getIntent().getStringExtra("title");
        String author = getIntent().getStringExtra("author");
        String description = getIntent().getStringExtra("description");
        String content = getIntent().getStringExtra("content");

        ImageView imgNews = findViewById(R.id.img_news);
        TextView txtTitle = findViewById(R.id.txt_title);
        TextView txtAuthor = findViewById(R.id.txt_author);
        TextView txtDescription = findViewById(R.id.txt_description);
        TextView txtContent = findViewById(R.id.txt_content);

        Picasso.with(getApplicationContext()).load(urlImg).into(imgNews);
        txtTitle.setText(title);
        txtAuthor.setText(author);
        txtDescription.setText(description);
        txtContent.setText(content);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
