package com.lesson_00_pitsunov

import kotlin.math.roundToInt


const val HEALTH_POTION_MULTIPLIER : Double = 0.3

class Player(
    maxHP : Int = 10,
    hp : Int = 10,
    atk : Int = 10,
    def : Int = 4,
    dmg : IntRange = (3..6),
    potions : Int = 4
) : Creature(maxHP, hp, atk, def, dmg) {
    private var healthPotionsAmount : Int = potions
        set(value) {
            require(value >= 0) { "cannot set health potions amount to negative value" }
            field = value
        }

    fun heal() : Unit {
        require(healthPotionsAmount > 0) { "cannot heal: healthPotionsAmount <= 0" }
        healthPoints += (healthPoints * HEALTH_POTION_MULTIPLIER).roundToInt()
        healthPotionsAmount -= 1
    }
}