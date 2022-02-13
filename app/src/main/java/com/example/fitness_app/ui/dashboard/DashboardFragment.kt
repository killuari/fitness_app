package com.example.fitness_app.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.fitness_app.R
import com.example.fitness_app.databinding.FragmentRecipesBinding
import com.google.android.material.snackbar.Snackbar

class DashboardFragment : Fragment() {
    private var _binding: FragmentRecipesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentRecipesBinding.inflate(inflater, container, false)
        // Get input text
        val inputText = binding.outlinedTextField.editText?.text.toString()

        binding.outlinedTextField.editText?.doOnTextChanged { inputText, _, _, _ ->
            view?.let { Snackbar.make(it, "text geaendert", Snackbar.LENGTH_LONG).show() }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}