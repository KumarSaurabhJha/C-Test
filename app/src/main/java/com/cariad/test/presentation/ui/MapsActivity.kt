package com.cariad.test.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cariad.test.R
import com.cariad.test.data.model.POIData
import com.cariad.test.databinding.ActivityMapsBinding
import com.cariad.test.presentation.viewmodel.POIViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.androidx.viewmodel.ext.android.viewModel

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private val poiViewModel: POIViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        poiViewModel.init()
        setupObservers()
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val initialCoordinates = LatLng(poiViewModel.latitude, poiViewModel.longitude)
        mMap.moveCamera(CameraUpdateFactory.newLatLng(initialCoordinates))
    }

    private fun setupObservers() {

        poiViewModel.poiDisplayList.observe(this) {
            it.getContentIfNotHandled()?.let { list ->
                updateMap(list)
            }
        }
    }

    private fun updateMap(list: POIData) {

        if (this::mMap.isInitialized) {
            list.forEach {
                val title = it.OperatorInfo.Title
                val coordinates = LatLng(it.AddressInfo.Latitude, it.AddressInfo.Longitude)
                mMap.addMarker(MarkerOptions().position(coordinates).title(title))
                mMap.setOnMarkerClickListener(this)
            }
        }
    }

    override fun onMarkerClick(marker: Marker): Boolean {

        val poiDomainModel = poiViewModel.getPOIDomainModelFromSelectedMarker(marker.title)
        poiDomainModel?.let {
            poiViewModel.cancelDataFetch()
            POIDetailsActivity.launchActivity(this, it)
        }

        return false
    }


    override fun onPause() {
        super.onPause()
        poiViewModel.cancelDataFetch()
    }

    override fun onStop() {
        super.onStop()
        poiViewModel.cancelDataFetch()
    }
}