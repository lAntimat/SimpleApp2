package com.example.simpleapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<News> newsList;

    NewsAdapter(Context context, List<News> newsList) {
        this.newsList = newsList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recycler_item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsAdapter.ViewHolder holder, int position) {
        News news = newsList.get(position);

        holder.tvTitle.setText(news.getNewsTitle());
        holder.tvSubTitle.setText(news.getNewsSubtitle());

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final TextView tvSubTitle;
        ViewHolder(View view){
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            tvSubTitle = (TextView) view.findViewById(R.id.tvSubTitle);
        }
    }
}
