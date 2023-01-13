package com.graphicless.demoretrofit2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.graphicless.demoretrofit2.R
import com.graphicless.demoretrofit2.model.MarsPhoto

class MarsPhotoAdapter(private val marsPhotoList: List<MarsPhoto>): RecyclerView.Adapter<MarsPhotoAdapter.MarsPhotoViewHolder>() {

    class MarsPhotoViewHolder(view:View): RecyclerView.ViewHolder(view){
        fun bind(item: MarsPhoto) {

            val image: ImageView = itemView.findViewById(R.id.mars_image)
//            image.setImageURI(Uri.parse(item.imgSrcUrl))
            Glide
                .with(itemView.context)
                .load(item.imgSrcUrl)
                .into(image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsPhotoViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MarsPhotoViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MarsPhotoViewHolder, position: Int) {
        val item = marsPhotoList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return marsPhotoList.size
    }
}