package com.example.ferreteriap18_andres_johan.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ferreteriap18_andres_johan.model.Products
import com.example.ferreteriap18_andres_johan.network.Callback
import com.example.ferreteriap18_andres_johan.network.FirestoreService
import java.lang.Exception

class OrderViewModel: ViewModel() {
    val firestoreService = FirestoreService()
    val listProducts: MutableLiveData<List<Products>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getProductsFromFirebase()
    }

    private fun getProductsFromFirebase() {
        firestoreService.getProducts(object : Callback<List<Products>> {

            override fun onFailed(exception: Exception) {
                processFinished()
            }

            override fun onSuccess(result: List<Products>?) {
                listProducts.postValue(result)
                processFinished()
            }

        })
    }

    fun processFinished() {
        isLoading.value = true
    }
}