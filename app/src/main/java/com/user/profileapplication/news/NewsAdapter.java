package com.user.profileapplication.news;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.user.profileapplication.R;
import com.user.profileapplication.news.response.Article;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    List<Article> articles;
    NewsListener listener;

    public NewsAdapter(List<Article> articles, NewsListener listener) {
        this.articles = articles;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtTitle;
        TextView txtAuthor;
        TextView txtDescription;

        public ViewHolder(View v){
            super(v);
            txtTitle = v.findViewById(R.id.txt_title);
            txtAuthor = v.findViewById(R.id.txt_author);
            txtDescription = v.findViewById(R.id.txt_description);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_news,viewGroup,false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Article article= articles.get(i);

        viewHolder.txtTitle.setText(article.getTitle());
        viewHolder.txtAuthor.setText(article.getAuthor());
        viewHolder.txtDescription.setText(article.getDescription());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onNewsClicked(article);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    public void refreshData(List<Article> articles){
        this.articles = articles;
        notifyDataSetChanged();
    }
}
