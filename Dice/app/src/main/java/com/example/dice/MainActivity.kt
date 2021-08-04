package com.example.dice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // Create 2 new dice object with 6 faces
    private val die1 = Dice(6)
    private val die2 = Dice(6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // Roll the dice when app starts...
        rollDice()
    }

    private fun rollDice() {
        // Roll the dice and print value to the textView
        val resultImageView: ImageView = findViewById(R.id.imageView)
        val resultImageView2: ImageView = findViewById(R.id.imageView2)
        val die1roll = die1.roll()
        val die2roll = die2.roll()
        resultImageView.setImageResource(getDrawableDice(die1roll))
        resultImageView.contentDescription = die1roll.toString()
        resultImageView2.setImageResource(getDrawableDice(die2roll))
        resultImageView2.contentDescription = die2roll.toString()
    }

    private fun getDrawableDice(diceRoll: Int): Int {
        return when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
