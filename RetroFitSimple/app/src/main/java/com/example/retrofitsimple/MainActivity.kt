package com.example.retrofitsimple

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.retrofitsimple.databinding.ActivityMainBinding
import com.example.retrofitsimple.http.RetrofitUtil
import com.example.retrofitsimple.http.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSend.setOnClickListener({
            val service : Service = RetrofitUtil.get()
            val nombre : String = binding.nombreADoubs.text.toString()
            val call : Call<String> = service.NombreDoublé(nombre)

            call.enqueue(object : Callback<String> {

                override fun onResponse(call: Call<String>, response: Response<String>) {

                    if (response.isSuccessful) {
                        // http 200 http tout s'est bien passé
                        val  resultat = response.body()
                        val duration = Toast.LENGTH_LONG

                        val toast = Toast.makeText(applicationContext, resultat, duration)
                        toast.show()

                    } else {
                        // cas d'erreur http 400 404 etc.
                    }
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                }
            })
        })

    }
}

