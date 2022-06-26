package com.kpfu.stripepay.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.kpfu.stripepay.NavigationListener
import com.kpfu.stripepay.R
import java.text.NumberFormat
import java.util.Locale

class PaymentFragment : Fragment() {

    companion object {
        const val TAG = "com.kpfu.stripepay.fragment.PaymentFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_payment, container, false)
        val amountEditText = view.findViewById<TextView>(R.id.amount_edit_text)
        val chargeAmount = view.findViewById<TextView>(R.id.charge_amount)
        val currentEditText = view.findViewById<EditText>(R.id.currency_edit_text)

        amountEditText.doAfterTextChanged { editable ->
            if (editable.toString().isNotEmpty()) {
                chargeAmount.text = formatCentsToString(editable.toString().toInt())
            }
        }

        view.findViewById<View>(R.id.collect_payment_button).setOnClickListener {
            (activity as? NavigationListener)?.onRequestPayment(
                amountEditText.text.toString().toLong(),
                currentEditText.text.toString()
            )
        }

        view.findViewById<View>(R.id.home_button).setOnClickListener {
            (activity as? NavigationListener)?.onRequestExitWorkflow()
        }

        return view
    }

    private fun formatCentsToString(i: Int): String {
        return NumberFormat.getCurrencyInstance(Locale.US).format(i / 100.0)
    }
}
