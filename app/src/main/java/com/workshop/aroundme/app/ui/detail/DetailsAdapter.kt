package com.workshop.aroundme.app.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.workshop.aroundme.R
import com.workshop.aroundme.app.ui.detail.viewholder.CoverViewHolder
import com.workshop.aroundme.app.ui.detail.viewholder.LocationViewHolder
import com.workshop.aroundme.app.ui.detail.viewholder.PlaceInfoViewHolder
import com.workshop.aroundme.app.ui.detail.viewholder.TagsViewHolder
import com.workshop.aroundme.data.model.PlaceDetailEntity

class DetailsAdapter(private val placeDetailEntity: PlaceDetailEntity) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            ITEM_TYPE_COVER -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_detail_cover_item, parent, false)
                return CoverViewHolder(view)
            }
            ITEM_TYPE_PLACE_INFO -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_detail_place_info_item, parent, false)
                return PlaceInfoViewHolder(view)
            }
            ITEM_TYPE_LOCATION -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_detail_location_item, parent, false)
                return LocationViewHolder(view)
            }
            ITEM_TYPE_TAGS -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_detail_tags_item, parent, false)
                return TagsViewHolder(view)
            }
            else -> {
                throw Exception("Invalid view type")
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> ITEM_TYPE_COVER
            1 -> ITEM_TYPE_PLACE_INFO
            2 -> ITEM_TYPE_LOCATION
            3 -> ITEM_TYPE_TAGS
            else -> throw Exception("Invalid position")
        }
    }

    override fun getItemCount() = 4

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType = getItemViewType(position)
        when (viewType) {
            ITEM_TYPE_COVER -> (holder as CoverViewHolder).bind(placeDetailEntity)
            ITEM_TYPE_PLACE_INFO -> (holder as PlaceInfoViewHolder).bind(placeDetailEntity)
            ITEM_TYPE_LOCATION -> (holder as LocationViewHolder).bind(placeDetailEntity)
            ITEM_TYPE_TAGS -> (holder as TagsViewHolder).bind(placeDetailEntity)
        }
    }

    companion object {
        const val ITEM_TYPE_COVER = 100
        const val ITEM_TYPE_PLACE_INFO = 200
        const val ITEM_TYPE_LOCATION = 300
        const val ITEM_TYPE_TAGS = 400
    }

}