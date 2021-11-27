package com.example.cupcake.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel: ViewModel() {

    private val _orderQuantity = MutableLiveData(0)
    val orderQuantity: LiveData<Int> = _orderQuantity

    private val _cupcakeFlavor = MutableLiveData("")
    val cupcakeFlavor: LiveData<String> = _cupcakeFlavor

    private val _pickupDate = MutableLiveData("")
    val pickupDate: LiveData<String> = _pickupDate

    private val _price = MutableLiveData(0.0)
    val price: LiveData<Double> = _price


    fun setQuantity(numberCupcakes: Int) {
        _orderQuantity.value = numberCupcakes
    }
    fun setFlavor(desiredFlavor: String) {
        _cupcakeFlavor.value = desiredFlavor
    }
    fun setDate(pickupDate: String) {
        _pickupDate.value = pickupDate
    }
    fun hasNoFlavorSet(): Boolean {
        return _cupcakeFlavor.value.isNullOrEmpty()
    }
}