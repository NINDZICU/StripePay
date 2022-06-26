package com.kpfu.stripepay.recyclerview

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class InfiniteScrollListener(
    private val layoutManager: LinearLayoutManager,
    private val loadAction: () -> Unit,
    private val threshold: Int = 5,
) : RecyclerView.OnScrollListener() {
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val position = layoutManager.findLastVisibleItemPosition()
        val size = layoutManager.itemCount
        if (position < size - threshold) return

        recyclerView.post {
            loadAction()
        }
    }
}
