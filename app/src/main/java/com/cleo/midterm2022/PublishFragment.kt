package com.cleo.midterm2022

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cleo.midterm2022.databinding.FragmentPublishBinding
import com.google.android.datatransport.runtime.logging.Logging.d
import com.google.firebase.Timestamp
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log
import com.google.firebase.firestore.FirebaseFirestore



class PublishFragment : Fragment() {

    companion object {
        const val TAG = "cleooo"
    }


    private lateinit var firebase: FirebaseFirestore
    private lateinit var binding: FragmentPublishBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPublishBinding.inflate(inflater, container, false)

        firebase =FirebaseFirestore.getInstance()


        //判斷是否有authorinfo
        binding.button.setOnClickListener {

            addData()

//                binding.inputTitle.text.toString(),
//                        binding.inputCategory.text.toString(),
//                        binding.inputContent.text.toString(),

//
//            val myInfo: MutableMap<String, Any> = HashMap()
//            myInfo["email"] = mEmail
//            myInfo["id"] = mID
//            myInfo["name"] = mName
//
//            firebase.collection("articles")
//                .document()
//                .set(myInfo)
//                .addOnSuccessListener {
//
//                    Log.d(TAG, "add success")
//
//                }
//                .addOnFailureListener { e ->
//                    Log.d(TAG, "add fail")
//                    Log.w(TAG, "Error adding document", e)
//                }
//
//
//            val title = binding.inputTitle.text.toString()
//            val category = binding.inputCategory.text.toString()
//            val content = binding.inputContent.text.toString()
//
////            firebase.collection("articles").document().get().addOnSuccessListener {  }
//            firebase.collection("author")

        }

        return binding.root
    }

    fun addData() {
        val articles = FirebaseFirestore.getInstance().collection("articles")
        val document = articles.document()
        val data = hashMapOf(
            "author" to hashMapOf(
                "email" to "wayne@school.appworks.tw",
                "id" to "waynechen323",
                "name" to "AKA小安老師"
            ),
            "title" to binding.inputTitle.text.toString(),
            "content" to binding.inputContent.text.toString(),
            "createdTime" to  Timestamp.now(),
            "id" to document.id,
            "category" to binding.inputCategory.text.toString()
        )
        document.set(data)
    }
}