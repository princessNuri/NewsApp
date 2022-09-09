package com.example.newsapp.ui.news

import android.R
import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.ItemNewsBinding
import com.example.newsapp.models.News
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class NewsAdapter :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    private var list = arrayListOf<News>()
    var onLongClickListener: ((News) -> Unit?)? = null

    inner class NewsViewHolder(
        private var binding: ItemNewsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            binding.newsId.text = news.id.toString()
            binding.newsTitle.text = news.title
            //binding.newsCreatedAt.text=news.createdAt.toString()
            val simpleDateFormat = SimpleDateFormat("hh:mm, dd MMM yyyy")
            val dateString = simpleDateFormat.format(news.createdAt)
            binding.newsCreatedAt.text = String.format("%s", dateString)
            itemView.setOnLongClickListener {
                onLongClickListener?.invoke(news)
                return@setOnLongClickListener true
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    /*fun addItems(list: List<News>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }*/

    fun setList(listt: List<News>) {
        this.list = listt as ArrayList<News>
        notifyDataSetChanged()
    }

    fun delete(it: News) {
        list.remove(it)
    }
}

