package com.kpfu.stripepay

import android.util.Log
import com.stripe.stripeterminal.external.callable.TerminalListener
import com.stripe.stripeterminal.external.models.ConnectionStatus
import com.stripe.stripeterminal.external.models.PaymentStatus
import com.stripe.stripeterminal.external.models.Reader

class TerminalEventListener : TerminalListener {

    override fun onUnexpectedReaderDisconnect(reader: Reader) {
        Log.i("UnexpectedDisconnect", reader.serialNumber ?: "reader's serialNumber is null!")
    }

    override fun onConnectionStatusChange(status: ConnectionStatus) {
        Log.i("ConnectionStatusChange", status.toString())
    }

    override fun onPaymentStatusChange(status: PaymentStatus) {
        Log.i("PaymentStatusChange", status.toString())
    }
}
