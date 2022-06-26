package com.kpfu.stripepay.fragment.location

import com.stripe.stripeterminal.external.models.Location

data class LocationListState(
    val locations: List<Location> = emptyList(),
    val isLoading: Boolean = true,
    val hasMore: Boolean = true,
) {
    val headerVisible = locations.isNotEmpty() || !isLoading
}
