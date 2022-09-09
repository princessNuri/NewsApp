package com.example.newsapp.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.newsapp.App
import com.example.newsapp.databinding.FragmentNewsBinding
import com.example.newsapp.models.News

class NewsFragment : Fragment() {
    private lateinit var binding: FragmentNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener{
            save()
        }

    }

    private fun save() {
        val title = binding.editText.text.toString().trim()
        val news = News(0,title,System.currentTimeMillis())
        App.dataBase.newsDao().insert(news)
        findNavController().navigateUp()
    }

}