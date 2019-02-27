package com.workshop.aroundme.app.ui.detail.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.workshop.aroundme.R
import com.workshop.aroundme.data.model.PlaceDetailEntity

class TagsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tags = itemView.findViewById<TextView>(R.id.tags)

    fun bind(placeDetailEntity: PlaceDetailEntity) {
        tags.text = placeDetailEntity.tags
    }
}