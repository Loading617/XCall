package com.loading.xcall.ui.blockedlog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.loading.xcall.databinding.ItemBlockedCallLogBinding
import com.loading.xcall.data.BlockedCallLogEntry

class BlockedCallLogAdapter : ListAdapter<BlockedCallLogEntry, BlockedCallLogAdapter.BlockedCallLogViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlockedCallLogViewHolder {
        val binding = ItemBlockedCallLogBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return BlockedCallLogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BlockedCallLogViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class BlockedCallLogViewHolder(
        private val binding: ItemBlockedCallLogBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(entry: BlockedCallLogEntry) {
            binding.nameTextView.text = entry.name ?: "Unknown"
            binding.numberTextView.text = entry.phoneNumber
            binding.dateTextView.text = entry.date
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<BlockedCallLogEntry>() {
        override fun areItemsTheSame(oldItem: BlockedCallLogEntry, newItem: BlockedCallLogEntry): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: BlockedCallLogEntry, newItem: BlockedCallLogEntry): Boolean = oldItem == newItem
    }
} 