package com.example.retrofitrecyclerviewmvvm.food

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider

import com.example.retrofitrecyclerviewmvvm.Utils.Companion.CATEGORY
import com.example.retrofitrecyclerviewmvvm.databinding.ActivityFoodBinding


class FoodActivity : AppCompatActivity() {

    private lateinit var foodViewModel: FoodViewModel
    private lateinit var foodAdapter: FoodAdapter
    private lateinit var binding: ActivityFoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        foodViewModel = ViewModelProvider(this)[FoodViewModel::class.java]

        setUpRecyclerView()
        getFoodsByCategory()
        observeFoods()

        showProgressBar()

    }

    private fun setUpRecyclerView() {

        binding.mRecyclerView.apply {
            foodAdapter = FoodAdapter()
            adapter = foodAdapter
        }

    }

    private fun getFoodsByCategory() {

        foodViewModel.getFoodsByCategory(intent.getStringExtra(CATEGORY)!!)

    }

    private fun observeFoods() {

        foodViewModel.observeFoods().observe(this) {

            foodAdapter.setFoods(it!!.meals)
            hideProgressBar()

        }

    }



    private fun showProgressBar() {

        binding.mProgressBar.visibility = View.VISIBLE

    }

    private fun hideProgressBar() {

        binding.mProgressBar.visibility = View.GONE

    }

}