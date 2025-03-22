package com.loading.xcall.ui.calllogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import android.content.ContentResolver
import com.loading.xcall.databinding.FragmentCallLogsBinding

class CallLogsFragment : Fragment() {

    private var _binding: FragmentCallLogsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val callLogsViewModel =
            ViewModelProvider(this).get(CallLogsViewModel::class.java)

        _binding = FragmentCallLogsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textCallLogs
        callLogsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}