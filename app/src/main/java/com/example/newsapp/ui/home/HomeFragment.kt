package com.example.newsapp.ui.home

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.newsapp.App
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentHomeBinding
import com.example.newsapp.ui.news.NewsAdapter


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var adapter = NewsAdapter()

    //    val list = App.dataBase.newsDao().getAll()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val list = App.dataBase.newsDao().getAll()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var list = App.dataBase.newsDao().getAll()
        binding.recycler.adapter = adapter
        adapter.setList(list)
        adapter.onLongClickListener = {
            val alert = AlertDialog.Builder(requireContext())
            alert.setTitle("Delete Item")
            alert.setMessage("Delete Item")
            alert.setPositiveButton("yes", DialogInterface.OnClickListener { dialogInterface, i ->
                App.dataBase.newsDao().delete(it)
                adapter.delete(it)
                adapter.notifyDataSetChanged()
            }).setNegativeButton("no", DialogInterface.OnClickListener { dialogInterface, i ->

            })
            alert.create().show()
        }
        binding.btnFab.setOnClickListener {
            findNavController().navigate(R.id.newsFragment)
        }
        /*App.dataBase.newsDao().getAllLive().observe(viewLifecycleOwner) {
            adapter.addItems(it)
        }*/

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}