package com.mihir.googlesheetsasdb.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mihir.googlesheetsasdb.model.Request
import com.mihir.googlesheetsasdb.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder().baseUrl("https://script.googleusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(Request::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getContent()
            runOnUiThread{
                binding.rv.adapter = response.body()?.data?.let { Adapter(it) }
            }
        }

        binding.rv.layoutManager = LinearLayoutManager(this)
    }

}