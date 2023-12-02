<<<<<<< HEAD
package com.lesson_00_pitsunov


class Dice(diceSides : Int = 6) {
    private var sides : Int = diceSides
        set(value) {
            require(value >= 1) { "cannot set dice sides to number lower than 1" }
            field = value
        }

    fun roll() : Int {
        return (1..sides).random()
    }
=======
package com.lesson_00_pitsunov


class Dice(diceSides : Int = 6) {
    private var sides : Int = diceSides
        set(value) {
            require(value >= 1) { "cannot set dice sides to number lower than 1" }
            field = value
        }

    fun roll() : Int {
        return (1..sides).random()
    }
>>>>>>> 855f3571098986938cf7f2ea51174b925e10a1f3
}