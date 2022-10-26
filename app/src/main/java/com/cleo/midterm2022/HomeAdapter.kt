package com.cleo.midterm2022


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cleo.midterm2022.databinding.FragmentArticleBinding
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.internal.artificialFrame


data class PostArticle(

    val title: String = "123",
    val category: String,
    val content: String,
    val createdTime: String,
    val authorName: String,
)


class HomeAdapter() : ListAdapter<PostArticle, HomeAdapter.HomeViewHolder>(HomeDiffCallBack()) {


    class HomeViewHolder(private var binding: FragmentArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: PostArticle) {

            binding.articleTitle.text = data.title
            binding.authorName.text = data.authorName
            binding.category.text = data.category
            binding.createdTime.text = data.createdTime
            binding.articleContent.text = data.content

//            firebase = FirebaseFirestore.getInstance()
//            firebase.collection("articles").document().get().addOnSuccessListener {
//                val articles = FirebaseFirestore.getInstance().collection("articles")
//                val document = articles.document()
//                val data = hashMapOf(
//                    "author" to hashMapOf(
//                        "email" to "wayne@school.appworks.tw",
//                        "id" to "waynechen323",
//                        "name" to "AKA小安老師"
//                    ),
//                    "title" to binding.articleTitle.text.toString(),
//                    "content" to binding.articleContent.text.toString(),
//                    "createdTime" to  Timestamp.now(),
//                    "id" to document.id,
//                    "category" to binding.category.text.toString())
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(FragmentArticleBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val currentData = getItem(position)
        holder.bind(currentData)
    }


    class HomeDiffCallBack : DiffUtil.ItemCallback<PostArticle>() {
        override fun areItemsTheSame(oldItem: PostArticle, newItem: PostArticle): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: PostArticle, newItem: PostArticle): Boolean {
            return oldItem == newItem
        }
    }
}

