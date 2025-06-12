package com.loading.xcall.ui.blockedlog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.loading.xcall.databinding.FragmentBlockedCallLogBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BlockedCallLogFragment : Fragment() {

    private var _binding: FragmentBlockedCallLogBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BlockedCallLogViewModel by viewModels()
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

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.blockedCalls.collectLatest { calls ->
                adapter.submitList(calls)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

