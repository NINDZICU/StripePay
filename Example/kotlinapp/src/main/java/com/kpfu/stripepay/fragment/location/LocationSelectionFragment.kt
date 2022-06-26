package com.kpfu.stripepay.fragment.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.kpfu.stripepay.NavigationListener
import com.kpfu.stripepay.R
import com.kpfu.stripepay.databinding.FragmentLocationSelectionBinding
import com.kpfu.stripepay.recyclerview.InfiniteScrollListener
import com.kpfu.stripepay.viewmodel.LocationSelectionViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest

class LocationSelectionFragment : Fragment() {
    private lateinit var viewModel: LocationSelectionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[LocationSelectionViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val layoutManager = LinearLayoutManager(activity)
        val view = inflater.inflate(R.layout.fragment_location_selection, container, false)
        val binding = FragmentLocationSelectionBinding.bind(view)
        val adapter = LocationListAdapter(layoutInflater, activity as LocationSelectionController)

        binding.locationSelectionList.layoutManager = layoutManager
        binding.locationSelectionList.addOnScrollListener(InfiniteScrollListener(layoutManager, viewModel::loadMoreLocations))
        binding.locationSelectionList.adapter = adapter
        binding.locationSelectionToolbar.inflateMenu(R.menu.location_selection)
        binding.locationSelectionToolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_location_selection_add -> true.also {
                    (activity as NavigationListener).onRequestCreateLocation()
                }
                else -> false
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.listState.collectLatest {
                adapter.locationListState = it
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.error.collect {
                Toast.makeText(activity, it.errorMessage, Toast.LENGTH_LONG).show()
            }
        }

        return view
    }
    
    fun reload() {
        viewModel.reload()
    }

    companion object {
        const val TAG = "LocationSelectionFragment"

        fun newInstance() = LocationSelectionFragment()
    }
}
