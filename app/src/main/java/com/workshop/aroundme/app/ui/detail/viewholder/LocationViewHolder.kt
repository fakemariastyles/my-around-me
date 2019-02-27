package com.workshop.aroundme.app.ui.detail.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.workshop.aroundme.R
import com.workshop.aroundme.data.model.PlaceDetailEntity

class LocationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val location = itemView.findViewById<TextView>(R.id.location)

    fun bind(placeDetailEntity: PlaceDetailEntity) {
        location.text = placeDetailEntity.location
    }
}