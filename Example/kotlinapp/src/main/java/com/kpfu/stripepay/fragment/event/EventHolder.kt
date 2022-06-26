package com.kpfu.stripepay.fragment.event

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kpfu.stripepay.R
import com.kpfu.stripepay.databinding.ListItemEventBinding
import com.kpfu.stripepay.model.Event

class EventHolder(
    parent: ViewGroup,
    private val binding: ListItemEventBinding = DataBindingUtil.inflate(
        LayoutInflater.from(parent.context), R.layout.list_item_event, parent, false
    )
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(event: Event) {
        binding.event = event
    }
}
