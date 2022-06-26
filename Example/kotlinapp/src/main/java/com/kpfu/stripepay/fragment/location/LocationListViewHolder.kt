package com.kpfu.stripepay.fragment.location

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kpfu.stripepay.databinding.ListItemCardBinding
import com.stripe.stripeterminal.external.models.Location

class LocationListViewHolder(
    parent: View,
    private val locationSelectionController: LocationSelectionController,
) : RecyclerView.ViewHolder(parent) {
    val binding = ListItemCardBinding.bind(parent)

    fun bind(location: Location) {
        binding.listItemCardTitle.text = location.displayName
        binding.listItemCardDescription.text = location.id
        binding.listItemCard.setOnClickListener {
            locationSelectionController.onLocationSelected(location)
        }
    }
}
