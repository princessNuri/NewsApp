package com.example.newsapp.ui.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentBoardBinding

class BoardFragment : Fragment() {
    private lateinit var binding:FragmentBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter=BoardAdapter(findNavController(),binding)
        binding.viewPager.adapter=adapter
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,object:OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }

        })
        adapter.add(Board(R.drawable.board_picture_first,"Hello","Board 1"))
        adapter.add(Board(R.drawable.board_picture_forth,"Salam","Board 2"))
        adapter.add(Board(R.drawable.board_picture_fifth,"Privet","Board 3"))
        binding.dotsIndicator.attachTo(binding.viewPager)

    }
}