package com.example.wordsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


class WordsAdapter(val callback: (String) -> Unit) :
    RecyclerView.Adapter<WordsAdapter.ViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem:  String, newItem: String): Boolean {
            return oldItem == newItem
           // return oldItem == newItem

        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitData(value: MutableList<String>) = differ.submitList(value)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       val tvMain = itemView.findViewById<TextView>(R.id.tv_main_word)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvMain.text=differ.currentList[position].toString()
        holder.itemView.setOnClickListener{
            callback(differ.currentList[position])
        }
    }

}







//class WordsAdapter:
//    RecyclerView.Adapter<WordsAdapter.ViewHolder>() {
//
//    private val diffCallback = object : DiffUtil.ItemCallback<Char>() {
//        override fun areItemsTheSame(oldItem: Char, newItem: Char): Boolean {
//            return oldItem == newItem
//        }
//
//        override fun areContentsTheSame(oldItem:  Char, newItem: Char): Boolean {
//            //return oldItem.hashCode() == newItem.hashCode()
//            return oldItem.hashCode() == newItem.hashCode()
//
//        }
//    }
//
//    private val differ = AsyncListDiffer(this, diffCallback)
//
//    fun submitData(value: MutableList<Char>) = differ.submitList(value)
//
//    class ViewHolder(val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(data: Words, callback: (Words) -> Unit) {
//            binding.tvMainWord.text = data.alphabet
//
//            binding.root.setOnClickListener {
//                callback(data)
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return differ.currentList.size
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(differ.currentList[position], callback)
//
//    }
//
//}
