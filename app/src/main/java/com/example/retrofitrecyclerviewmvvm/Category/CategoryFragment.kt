package com.example.retrofitrecyclerviewmvvm.Category

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitrecyclerviewmvvm.Utils.Companion.CATEGORY
import com.example.retrofitrecyclerviewmvvm.databinding.FragmentCategoryBinding
import com.example.retrofitrecyclerviewmvvm.food.FoodActivity


class CategoryFragment : Fragment() {

    private lateinit var categoryViewModel: CategoryViewmodel

    private lateinit var categoryAdapter: CategoryAdapter
    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        categoryAdapter = CategoryAdapter()
        categoryViewModel= ViewModelProvider(this)[CategoryViewmodel::class.java]

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
        observeCategories()
        setOnClickMaterialCardView()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpRecyclerView() {

        binding.mRecyclerView.apply {

            adapter = categoryAdapter
        }

    }

    private fun observeCategories() {

        categoryViewModel.observeCategories().observe(viewLifecycleOwner) {
            categoryAdapter.setCategories(it!!.categories)
        }

    }



    private fun setOnClickMaterialCardView() {

        categoryAdapter.setOnClickMaterialCardView(object : CategoryAdapter.OnClickMaterialCardView {

            override fun onClick(category: Category) {


                val intent = Intent(context, FoodActivity::class.java)
                intent.putExtra(CATEGORY, category.name)
                startActivity(intent)



            }

        })

    }

}