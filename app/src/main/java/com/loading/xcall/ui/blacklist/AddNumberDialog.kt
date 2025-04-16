package com.loading.xcall.ui.blacklist

import android.app.Dialog
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.loading.xcall.databinding.DialogAddNumberBinding

class AddNumberDialog : DialogFragment() {

    private var _binding: DialogAddNumberBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BlacklistViewModel by activityViewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogAddNumberBinding.inflate(LayoutInflater.from(context))

        return AlertDialog.Builder(requireContext())
            .setTitle("Add to Blacklist")
            .setView(binding.root)
            .setPositiveButton("Add") { _, _ ->
                val name = binding.nameInput.text.toString().trim()
                val number = binding.numberInput.text.toString().trim()

                if (number.isNotEmpty()) {
                    viewModel.addBlacklistedNumber(name, number)
                    Toast.makeText(requireContext(), "Number added", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "Please enter a number", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancel", null)
            .create()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

