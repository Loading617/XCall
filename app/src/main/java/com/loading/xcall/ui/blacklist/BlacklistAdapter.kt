package com.loading.xcall.ui.blacklist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.loading.xcall.databinding.ItemBlacklistNumberBinding
import com.loading.xcall.data.BlacklistEntry

class BlacklistAdapter(
    private val onDeleteClick: (BlacklistEntry) -> Unit
) : ListAdapter<BlacklistEntry, BlacklistAdapter.BlacklistViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlacklistViewHolder {
        val binding = ItemBlacklistNumberBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return BlacklistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BlacklistViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class BlacklistViewHolder(
        private val binding: ItemBlacklistNumberBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(entry: BlacklistEntry) {
            binding.nameTextView.text = entry.name ?: "Unknown"
            binding.numberTextView.text = entry.phoneNumber
            binding.deleteButton.setOnClickListener {
                onDeleteClick(entry)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<BlacklistEntry>() {
        override fun areItemsTheSame(oldItem: BlacklistEntry, newItem: BlacklistEntry): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: BlacklistEntry, newItem: BlacklistEntry): Boolean = oldItem == newItem
    }
} 