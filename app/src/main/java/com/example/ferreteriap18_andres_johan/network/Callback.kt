package com.example.ferreteriap18_andres_johan.network

import java.lang.Exception

interface Callback <T>{
    fun onSuccess(result: T?)

    fun onFailed(exception: Exception)
}