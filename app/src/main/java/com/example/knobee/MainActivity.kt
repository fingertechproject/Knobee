package com.example.knobee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var progres:ProgressBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView:RecyclerView = findViewById(R.id.rv)
      progres = findViewById(R.id.progress)
        val linearLayoutManager:LinearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        val list: List<List<Gallery>>? = loadKnobeeData()?.let { it }
        if (list!=null){
            val adapter = KnobeeAdapter(this,list)
            recyclerView.adapter = adapter
        }
        recyclerView.visibility = View.VISIBLE


    }

    fun loadKnobeeData():List<List<Gallery>>?{
        var gallery:List<List<Gallery>>? = null
        val data:Call<Knobee> = KnobeeService.knobeeInstance.getData()
        data.enqueue(object : Callback<Knobee>{
            override fun onResponse(
                call: Call<Knobee>,
                response: Response<Knobee>
            ) {
               val data = response.body()
                if (data!=null) {
                    Log.d("DATA", data.toString())
                    progres?.visibility = View.GONE
                    gallery = data.data.Gallery
                }
            }

            override fun onFailure(call: Call<Knobee>, t: Throwable) {
                Log.d("DATA",t.toString())
            }

        })
return gallery
    }
}