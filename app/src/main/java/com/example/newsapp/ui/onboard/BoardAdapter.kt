package com.example.newsapp.ui.onboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentBoardBinding
import com.example.newsapp.databinding.PagerBoardBinding
import com.example.newsapp.ui.Prefs

class BoardAdapter(var context: Context,private var navController: NavController,private var _binding: FragmentBoardBinding)
    : RecyclerView.Adapter<BoardAdapter.ViewHolder>() {
    private val boards= arrayListOf<Board>()
    init {
        boards.add(Board(R.drawable.board_picture_first,"Hello","Board 1"))
        boards.add(Board(R.drawable.board_picture_forth,"Salam","Board 2"))
        boards.add(Board(R.drawable.board_picture_fifth,"Privet","Board 3"))

    }
    inner class ViewHolder(
        private var binding: PagerBoardBinding
    )
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(board: Board) {
            binding.imageview.setImageResource(board.image)
            binding.textDescription.text = board.description
            binding.textTitle.text = board.title
            _binding.btnSkip.setOnClickListener {
                val prefs=Prefs(context)
                prefs.saveState()
                navController.navigateUp()
            }
            binding.btnStart.setOnClickListener {
                val prefs=Prefs(context)
                prefs.saveState()
                navController.navigateUp()
            }
            if (boards.lastIndexOf(board) == boards.lastIndex){
                binding.btnStart.visibility = View.VISIBLE
            } else{
                binding.btnStart.visibility = View.INVISIBLE
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardAdapter.ViewHolder {
        return ViewHolder(PagerBoardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: BoardAdapter.ViewHolder, position: Int) {
        holder.bind(boards[position])
    }

    override fun getItemCount()=boards.size
}