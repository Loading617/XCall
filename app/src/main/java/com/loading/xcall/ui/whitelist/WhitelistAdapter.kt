package com.loading.xcall.ui.whitelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.loading.xcall.databinding.ItemWhitelistNumberBinding
import com.loading.xcall.data.WhitelistEntry

class WhitelistAdapter(
    private val onDeleteClick: (WhitelistEntry) -> Unit
) : ListAdapter<WhitelistEntry, WhitelistAdapter.WhitelistViewHolder>(DiffCallback()) {

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

        fun bind(entry: WhitelistEntry) {
            binding.numberTextView.text = entry.phoneNumber
            binding.deleteButton.setOnClickListener {
                onDeleteClick(entry)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<WhitelistEntry>() {
        override fun areItemsTheSame(oldItem: WhitelistEntry, newItem: WhitelistEntry): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: WhitelistEntry, newItem: WhitelistEntry): Boolean = oldItem == newItem
    }
}
