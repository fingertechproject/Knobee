package com.example.knobee

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class KnobeeAdapter(private val context: Context,private val list:List<List<Gallery>>): RecyclerView.Adapter<KnobeeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KnobeeViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false)
        return KnobeeViewHolder(view)

    }

    override fun onBindViewHolder(holder: KnobeeViewHolder, position: Int) {
        val myList = list[position]
         Glide.with(context).load(list[position][0].filename).into(holder.images)
        Log.d("FILE",list[position][0].filename)
    }

    override fun getItemCount(): Int {
       return list.size
    }
}
class KnobeeViewHolder(item: View):RecyclerView.ViewHolder(item){
     val images: ImageView = item.findViewById(R.id.images)
}
