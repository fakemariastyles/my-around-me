package com.workshop.aroundme.app.ui.starred

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.workshop.aroundme.R
import com.workshop.aroundme.data.model.PlaceEntity

class StarredAdapter(private val items: List<PlaceEntity>) : RecyclerView.Adapter<StarredViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarredViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_starred_place_item, parent, false)
        return StarredViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: StarredViewHolder, position: Int) {
        holder.bind(items[position])
    }

}