package com.user.profileapplication.news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.user.profileapplication.R;
import com.user.profileapplication.news.response.Article;
import com.user.profileapplication.news.response.NewsDetailActivity;
import com.user.profileapplication.news.response.NewsResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        Button btnSearch = findViewById(R.id.btn_search);
        final EditText edtSearch = findViewById(R.id.edt_search);
        RecyclerView rvNews = findViewById(R.id.rv_news);
        rvNews.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rvNews.setLayoutManager(llm);
        List<Article> listArticle = new ArrayList<>();
        final NewsAdapter adapter = new NewsAdapter(listArticle, new NewsListener() {
            @Override
            public void onNewsClicked(Article article) {
                Intent intent = new Intent(getApplicationContext(), NewsDetailActivity.class);
                intent.putExtra("url_img", article.getUrlToImage());
                intent.putExtra("title", article.getTitle());
                intent.putExtra("author", article.getAuthor());
                intent.putExtra("description", article.getDescription());
                intent.putExtra("content", article.getContent());
                startActivity(intent);
            }
        });
        rvNews.setAdapter(adapter);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtSearch.getText().toString().length() == 0) {
                    Toast.makeText(NewsActivity.this, "Keyword tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    Call<NewsResponse> call = RetrofitService.sendRequest().callNews(edtSearch.getText().toString(), NewsService.apiKey);
                    call.enqueue(new Callback<NewsResponse>() {
                        @Override
                        public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                            Toast.makeText(NewsActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                            NewsResponse newsResponse = response.body();
                            adapter.refreshData(newsResponse.getArticles());
                        }

                        @Override
                        public void onFailure(Call<NewsResponse> call, Throwable t) {
                            Toast.makeText(NewsActivity.this, "Network Failed", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
