package com.example.simpleapp2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

internal class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val newsList: ArrayList<News> = arrayListOf()

    private var onClickListener: ((news: News) -> Unit)? = null
    fun setOnClickListener(listener: (news: News) -> Unit) {
        onClickListener = listener
    }

    fun addList(list: ArrayList<News>) {
        newsList.clear()
        newsList.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = newsList[position]
        holder.tvTitle.text = news.newsTitle
        holder.tvSubTitle.text = news.newsSubtitle
        holder.constraintLayout.setOnClickListener { 
            onClickListener?.invoke(news)
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class ViewHolder constructor(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById<View>(R.id.tvTitle) as TextView
        val tvSubTitle: TextView = view.findViewById<View>(R.id.tvSubTitle) as TextView
        val constraintLayout: ConstraintLayout = view.findViewById<View>(R.id.content) as ConstraintLayout
    }

}