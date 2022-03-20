package com.cariad.test.domain

import java.io.Serializable


data class POIDomainModel(
    val title: String,
    val numberOfChargingPoint: Int,
    val address: String
) : Serializable
