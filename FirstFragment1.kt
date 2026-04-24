package com.example.chemipirveliaplikacia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chemipirveliaplikacia.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.gmBtnCalculate.setOnClickListener {

            val salary = binding.gmEditSalary.text.toString().toDoubleOrNull() ?: 0.0
            val rent = binding.gmEditRent.text.toString().toDoubleOrNull() ?: 0.0
            val food = binding.gmEditFood.text.toString().toDoubleOrNull() ?: 0.0

            val bundle = Bundle().apply {
                putDouble("salary", salary)
                putDouble("rent", rent)
                putDouble("food", food)
            }

            parentFragmentManager.setFragmentResult("data", bundle)

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, SecondFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}