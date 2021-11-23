package com.example.minigamesapp.classes

class Dice {
    var sides = 6
    var state:Int = 1

    fun roll():Int {
        state= (1..sides).random()
        return state
    }
}