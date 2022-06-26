package com.kpfu.stripepay

import com.stripe.stripeterminal.external.models.DiscoveryMethod

interface NavigationListener {
    fun onCancelCollectPaymentMethod()

    fun onRequestDiscovery(isSimulated: Boolean, discoveryMethod: DiscoveryMethod)

    fun onCancelDiscovery()

    fun onDisconnectReader()

    fun onRequestExitWorkflow()

    fun onRequestPayment(amount: Long, currency: String)

    fun onConnectReader()

    fun onSelectPaymentWorkflow()

    fun onSelectReadReusableCardWorkflow()

    fun onSelectUpdateWorkflow()

    fun onRequestChangeLocation()

    fun onRequestCreateLocation()

    fun onLocationCreated()
}
