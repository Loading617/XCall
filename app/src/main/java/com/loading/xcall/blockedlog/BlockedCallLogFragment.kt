package com.loading.xcall.ui.blockedlog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.loading.xcall.databinding.FragmentBlockedCallLogBinding

class BlockedCallLogFragment : Fragment() {

    private var _binding: FragmentBlockedCallLogBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: BlockedCallLogAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlockedCallLogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = BlockedCallLogAdapter()
        binding.blockedCallLogRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.blockedCallLogRecyclerView.adapter = adapter

        // TODO: Load real blocked calls from your database or log source
        adapter.submitList(getDummyBlockedCalls())
    }

    private fun getDummyBlockedCalls(): List<BlockedCall> {
        return listOf(
            BlockedCall("Unknown", "+1234567890", "Yesterday"),
            BlockedCall("Spam Caller", "+1987654321", "Today"),
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

