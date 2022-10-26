package com.cleo.midterm2022

import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.cleo.midterm2022.databinding.FragmentHomeBinding
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
import com.google.firebase.firestore.FirebaseFirestore


class HomeFragment : Fragment() {


    private lateinit var firebase : FirebaseFirestore
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val adapter =  HomeAdapter()
        binding.articleRecycler.adapter = adapter


        firebase = FirebaseFirestore.getInstance()

        firebase.collection("articles").document().get().addOnSuccessListener {

        }
//        firebase.collection("articles").document().addSnapshotListener { articles, e ->
//
//            if (articles == null) {
//                return@addSnapshotListener
//            }
//
//            binding.articleTitle.text = articles.get("title")
//            binding.authorName.text = articles.get("authorName")
//            binding.category.text = articles.get("category")
//            binding.createdTime.text = articles.get("createdTime")
//            binding.articleContent.text = articles.get("content")
//
//        }






        binding.publishBtn.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_publishFragment2)
        }

        return binding.root
    }
}