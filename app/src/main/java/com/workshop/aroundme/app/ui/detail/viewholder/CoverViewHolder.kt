package com.workshop.aroundme.app.ui.detail.viewholder

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.workshop.aroundme.R
import com.workshop.aroundme.data.model.PlaceDetailEntity

class CoverViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val cover = itemView.findViewById<ImageView>(R.id.cover)

    fun bind(placeDetailEntity: PlaceDetailEntity) {
        Picasso.get().load(placeDetailEntity.coverUrl).into(cover)
    }
}
