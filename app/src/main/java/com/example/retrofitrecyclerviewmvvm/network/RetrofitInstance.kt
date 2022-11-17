package com.example.retrofitrecyclerviewmvvm.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.retrofitrecyclerviewmvvm.Utils.Companion.BASE_URL

object RetrofitInstance {

    val mealApi: MealApi by lazy{

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MealApi::class.java)

    }

}