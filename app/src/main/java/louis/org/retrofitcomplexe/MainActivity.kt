package louis.org.retrofitcomplexe

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import louis.org.retrofitcomplexe.databinding.ActivityMainBinding
import louis.org.retrofitcomplexe.http.RetrofitUtil
import louis.org.retrofitcomplexe.http.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()

            binding.btnSearch.setOnClickListener{

                val service : Service = RetrofitUtil.get()
                val nom : String = binding.et.text.toString()
                val call : Call<String> = service.afficherNom(nom)

                call.enqueue(object : Callback<String> {
                    override fun onResponse(call: Call<String>, response: Response<String>) {
                        if(response.isSuccessful){

                            binding.tv.text = response.body()
                        }else{
                            binding.tv.text = "Erreur" + response.code()
                        }
                    }

                    override fun onFailure(call: Call<String>, t: Throwable) {
                        binding.tv.text = "Erreur" + t.message
                    }
                })


            }

        }
    }
