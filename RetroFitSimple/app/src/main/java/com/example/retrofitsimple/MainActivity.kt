package com.example.retrofitsimple

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.LayoutInflater
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
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSend.setOnClickListener{

            val service : Service = RetrofitUtil.get()
            val nombre : String = binding.nombreADoubs.text.toString()
            val call : Call<String> = service.nombreDouble(nombre)

            call.enqueue(object : Callback<String>{
                override fun onResponse(call : Call<String>, response : Response<String>){
                    if(response.isSuccessful){
                        binding.tv.text = response.body()
                    }
                    else{
                        binding.tv.text = "ERREUR" + response.code()
                    }
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    binding.tv.text = "PAS DE REPONSE" + t.message
                }
            })


        }

    }
}

