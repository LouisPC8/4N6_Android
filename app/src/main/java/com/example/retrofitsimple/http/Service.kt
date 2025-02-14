package com.example.retrofitsimple.http

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {
    @GET("https://fourn6-mobile-prof.onrender.com/exos/long/double/4")
    fun NombreDoublé(@Path("nombre") nombre : String): Call<String>
}