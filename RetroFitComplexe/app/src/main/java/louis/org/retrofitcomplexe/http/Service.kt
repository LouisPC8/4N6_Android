package louis.org.retrofitcomplexe.http

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Service {
    @GET("https://fourn6-mobile-prof.onrender.com/exos/truc/complexe")
    fun afficherNom(@Query("name") nom: String): Call<String>
}