package com.example.fitness_app.ui.dashboard

import android.database.Cursor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitness_app.MainActivity
import com.example.fitness_app.R
import com.example.fitness_app.database.MyDbHelper
import com.example.fitness_app.database.Recipe
import com.example.fitness_app.database.RecipeViewModel
import com.example.fitness_app.databinding.FragmentRecipesBinding
import com.example.roomapp.fragments.list.ListAdapter
import com.google.android.material.snackbar.Snackbar

class RecipesFragment : Fragment() {
    private var _binding: FragmentRecipesBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private lateinit var myRecipeViewModel : RecipeViewModel

    lateinit var myDB : MyDbHelper
    val recipe_id : MutableList<String> = mutableListOf()
    val recipe_name : MutableList<String> = mutableListOf()
    val recipe_calories : MutableList<String> = mutableListOf()
    val recipe_variant : MutableList<String> = mutableListOf()
    val recipe_ingredients : MutableList<String> = mutableListOf()
    val recipe_amount : MutableList<String> = mutableListOf()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentRecipesBinding.inflate(inflater, container, false)

        myRecipeViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)
        insertDataToDatabase()

        // Recyclerview
//        val adapter = ListAdapter()
//        val recyclerView = view.recyclerview
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())

//        myDB = MyDbHelper(this.context)
//        storeDataInArrays()

        val inputText = binding.outlinedTextField.editText?.text.toString()
        binding.outlinedTextField.editText?.doOnTextChanged { inputText, _, _, _ ->
            view?.let { Snackbar.make(it, "text geaendert", Snackbar.LENGTH_LONG).show() }
        }
        return binding.root
    }

//    fun storeDataInArrays(){
//        var cursor : Cursor = myDB.readAllData()
//        if(cursor.count == 0){
//            Toast.makeText(this.context, "No Data.", Toast.LENGTH_SHORT).show();
//        } else {
//            while(cursor.moveToNext()){
//                recipe_id.add(cursor.getString(0))
//                recipe_name.add(cursor.getString(1))
//                recipe_calories.add(cursor.getString(2))
//                recipe_variant.add(cursor.getString(3))
//                recipe_ingredients.add(cursor.getString(4))
//                recipe_amount.add(cursor.getString(5))
//            }
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun insertDataToDatabase() {
        myRecipeViewModel.addRecipe(Recipe(0, "chicken", "300", "dinner", "chicken", "280g"))
    }

}