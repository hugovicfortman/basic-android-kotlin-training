package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val txtCostOfService = binding.costOfService.text.toString()
        val costOfService = txtCostOfService.toDoubleOrNull()

        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.radio_amazing -> 0.20
            R.id.radio_good -> 0.18
            else -> 0.15 // radio_okay
        }

        if(costOfService == null || costOfService == 0.0) {
            displayTip(0.0)
            return
        }
        var tip = costOfService * tipPercentage

        if(binding.roundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }

        displayTip(tip)
    }

    private fun displayTip(tip: Double) {
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount_text, formattedTip)
    }

}