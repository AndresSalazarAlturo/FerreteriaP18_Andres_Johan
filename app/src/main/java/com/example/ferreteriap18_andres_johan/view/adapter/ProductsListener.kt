package com.example.ferreteriap18_andres_johan.view.adapter

import com.example.ferreteriap18_andres_johan.model.Products

interface ProductsListener {
    fun OnProductsClick(product:Products, position: Int)
}