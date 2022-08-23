package com.example.newsapp.ui.onboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentBoardBinding
import com.example.newsapp.databinding.PagerBoardBinding

class BoardAdapter(private var navController: NavController,private var _binding: FragmentBoardBinding): RecyclerView.Adapter<BoardAdapter.ViewHolder>() {
    private val boards= arrayListOf<Board>()
    inner class ViewHolder(
        private var binding: PagerBoardBinding
    )
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(board: Board) {
            binding.imageview.setImageResource(board.image)
            binding.textDescription.text = board.description
            binding.textTitle.text = board.title
            _binding.btnSkip.setOnClickListener {
                navController.navigate(R.id.navigation_home)
            }
            binding.btnStart.setOnClickListener {
                navController.navigateUp()
            }
            if (boards.lastIndexOf(board) == boards.lastIndex){
                _binding.btnSkip.visibility = View.INVISIBLE
                binding.btnStart.visibility = View.VISIBLE
            } else{
                _binding.btnSkip.visibility = View.VISIBLE
                binding.btnStart.visibility = View.INVISIBLE
            }
        }

    }
    fun add(board: Board) {
        boards.add(board)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardAdapter.ViewHolder {
        return ViewHolder(PagerBoardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: BoardAdapter.ViewHolder, position: Int) {
        holder.bind(boards[position])
    }

    override fun getItemCount()=boards.size
}