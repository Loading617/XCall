package com.loading.xcall.ui.whitelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.loading.xcall.databinding.FragmentWhitelistBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WhitelistFragment : Fragment() {

    private var _binding: FragmentWhitelistBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WhitelistViewModel by viewModels()
    private lateinit var adapter: WhitelistAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWhitelistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = WhitelistAdapter(
            onDeleteClick = { entry ->
                viewModel.removeNumber(entry)
            }
        )

        binding.whitelistRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.whitelistRecyclerView.adapter = adapter

        binding.addNumberButton.setOnClickListener {
            showAddNumberDialog()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.whitelistedNumbers.collectLatest { numbers ->
                adapter.submitList(numbers)
            }
        }
    }

    private fun showAddNumberDialog() {
        val editText = EditText(requireContext())
        editText.hint = "Enter number"

        AlertDialog.Builder(requireContext())
            .setTitle("Add to Whitelist")
            .setView(editText)
            .setPositiveButton("Add") { _, _ ->
                val number = editText.text.toString()
                if (number.isNotBlank()) {
                    viewModel.addNumber(number)
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
