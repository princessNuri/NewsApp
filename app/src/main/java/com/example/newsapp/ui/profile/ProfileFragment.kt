package com.example.newsapp.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.example.newsapp.databinding.FragmentProfileBinding
import com.example.newsapp.ui.Prefs

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var prefs:Prefs
    private val mContent =
        registerForActivityResult(
            ActivityResultContracts.GetContent()
        ) {
            binding.picture.setImageURI(it)
            prefs.saveAvatar(it)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val prefs = Prefs(requireContext())
        val uri = prefs.getAvatar()
        binding.picture.setImageURI(uri)
        binding.picture.setOnClickListener(){
            mContent.launch("image/*")
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}