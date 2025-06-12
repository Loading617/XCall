package com.loading.xcall.ui.blacklist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.loading.xcall.databinding.FragmentBlacklistBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BlacklistFragment : Fragment() {

    private var _binding: FragmentBlacklistBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BlacklistViewModel by viewModels()
    private lateinit var adapter: BlacklistAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlacklistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = BlacklistAdapter(
            onDeleteClick = { entry ->
                viewModel.removeNumber(entry)
            }
        )

        binding.blacklistRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.blacklistRecyclerView.adapter = adapter

        binding.addNumberButton.setOnClickListener {
            AddNumberDialog().show(parentFragmentManager, "AddNumberDialog")
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.blacklistedNumbers.collectLatest { numbers ->
                adapter.submitList(numbers)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
