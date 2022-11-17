package com.example.retrofitrecyclerviewmvvm.network

import com.example.retrofitrecyclerviewmvvm.Category.CategoryList
import com.example.retrofitrecyclerviewmvvm.food.FoodList
import com.example.retrofitrecyclerviewmvvm.Utils.Companion.END_POINT_CATEGORIES
import com.example.retrofitrecyclerviewmvvm.Utils.Companion.END_POINT_FILTER
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {

    @GET(END_POINT_FILTER)
    fun getFoodsByCategory(@Query("c") categoryName: String): Call<FoodList>

    @GET(END_POINT_CATEGORIES)
    fun getCategories(): Call<CategoryList>


}