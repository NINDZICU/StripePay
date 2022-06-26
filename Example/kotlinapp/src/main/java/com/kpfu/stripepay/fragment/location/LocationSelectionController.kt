package com.kpfu.stripepay.fragment.location

import com.stripe.stripeterminal.external.models.Location

interface LocationSelectionController {

    fun onLocationSelected(location: Location)

    fun onLocationCleared()
}
