package com.kpfu.stripepay.fragment.discovery

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kpfu.stripepay.R
import com.kpfu.stripepay.databinding.ListItemCardBinding
import com.stripe.stripeterminal.external.models.Location
import com.stripe.stripeterminal.external.models.Reader


class ReaderHolder(
    parent: View,
    private val clickListener: ReaderClickListener,
) : RecyclerView.ViewHolder(parent) {
    private val binding = ListItemCardBinding.bind(parent)
    private val resources = parent.resources

    fun bind(reader: Reader, locationSelection: Location?) {
        binding.listItemCardTitle.text = reader.serialNumber
            ?: reader.id
            ?: resources.getString(R.string.discovery_reader_unknown)
        binding.listItemCardDescription.text = when {
            locationSelection == null && reader.location == null -> resources.getString(
                R.string.discovery_reader_location_unavailable
            )
            locationSelection == null -> resources.getString(
                R.string.discovery_reader_location_last,
                reader.location!!.displayName
            )
            else -> resources.getString(
                R.string.discovery_reader_location,
                locationSelection.displayName
            )
        }
        binding.listItemCard.setOnClickListener {
            clickListener.onClick(reader)
        }
    }
}
