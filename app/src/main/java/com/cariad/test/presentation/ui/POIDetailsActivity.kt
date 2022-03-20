package com.cariad.test.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cariad.test.databinding.ActivityPoidetailsBinding
import com.cariad.test.domain.POIDomainModel

class POIDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPoidetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPoidetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val poiDomainModel = intent.getSerializableExtra(KEY_MARKER) as POIDomainModel
        setupViews(poiDomainModel)
    }

    private fun setupViews(poiDomainModel: POIDomainModel?) {

        poiDomainModel?.let {
            binding.poiDetailTitle.text = it.title
            binding.poiDetailNumberOfPoints.text = it.numberOfChargingPoint.toString()
            binding.poiDetailAddress.text = it.address
        }
    }


    companion object {
        private const val KEY_MARKER = "keymarker"
        fun launchActivity(activity: AppCompatActivity, poiDomainModel: POIDomainModel) {
            val intent = Intent(activity, POIDetailsActivity::class.java).apply {
                putExtra(KEY_MARKER, poiDomainModel)
            }
            activity.startActivity(intent)
        }
    }
}