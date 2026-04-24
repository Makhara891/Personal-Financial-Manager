package com.example.chemipirveliaplikacia

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chemipirveliaplikacia.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.setFragmentResultListener("data", this) { _, bundle ->

            val salary = bundle.getDouble("salary")
            val rent = bundle.getDouble("rent")
            val food = bundle.getDouble("food")

            val model = FinanceModel(salary, rent, food)
            val manager = FinanceManager()

            val remaining = manager.calculateRemaining(model)

            binding.gmTextResult.text = "Remaining: $remaining"

            if (salary < (rent + food)) {
                binding.gmTextResult.setTextColor(Color.RED)
            } else {
                binding.gmTextResult.setTextColor(Color.GREEN)
            }

            binding.gmTextIdentity.text = "Guga Makharadze, 2007"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}