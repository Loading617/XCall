package com.loading.xcall.ui.whitelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.loading.xcall.databinding.ItemWhitelistNumberBinding

class WhitelistAdapter(
    private val onDeleteClick: (String) -> Unit
) : ListAdapter<String, WhitelistAdapter.WhitelistViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WhitelistViewHolder {
        val binding = ItemWhitelistNumberBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return WhitelistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WhitelistViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class WhitelistViewHolder(
        private val binding: ItemWhitelistNumberBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(number: String) {
            binding.numberTextView.text = number
            binding.deleteButton.setOnClickListener {
                onDeleteClick(number)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
    }
}
