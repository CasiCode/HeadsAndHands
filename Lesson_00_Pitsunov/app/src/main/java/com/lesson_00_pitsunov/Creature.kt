package com.lesson_00_pitsunov


fun IntRange.getRandomElement() : Int {
    return this.random()
}

const val ATTACK_DICE_SIDES : Int = 6;
const val ATTACK_POINTS_MIN : Int = 1;
const val ATTACK_POINTS_MAX : Int = 30;
const val DEFENCE_POINTS_MIN : Int = 1;
const val DEFENCE_POINTS_MAX : Int = 30;

open class Creature(
    maxHP : Int = 1,
    hp : Int = 1,
    atk : Int = 1,
    def : Int = 1,
    dmg : IntRange = (0..0)
) {
    protected var maxHealthPoints : Int = maxHP
        set(value) {
            field = if (value < 0) { 0 } else { value }
            if (healthPoints > maxHealthPoints) {
                healthPoints = maxHealthPoints
            }
        }
    protected var healthPoints : Int = hp
        set(value) {
            field = if (value < 0) { 0 } else {value}
        }
    protected var attackPoints : Int = atk
        set(value) {
            require(value in (ATTACK_POINTS_MIN..ATTACK_POINTS_MAX)) {
                "cannot set creatures attack points to number less than " +
                        ATTACK_POINTS_MIN.toString() +
                        " or greater than " +
                        ATTACK_POINTS_MAX.toString()
            }
            field = value
        }
    protected var defencePoints : Int = def
        set(value) {
            require(value in (DEFENCE_POINTS_MIN..DEFENCE_POINTS_MAX)) {
                "cannot set creatures defence points to number less than " +
                        DEFENCE_POINTS_MIN.toString() +
                        " or greater than " +
                        DEFENCE_POINTS_MAX.toString()
            }
            field = value
        }
    protected var damageRange : IntRange = dmg
        set(value) {
            require(value.first >= 0) { "cannot set damage range borders to negative values" }
            field = value
        }

    fun getDamage(dmg : Int) : Unit {
        require(dmg >= 0) { "cannot damage creature with less than 0 points of damage"}
        healthPoints -= dmg
    }

    fun attack(target : Creature) : Unit {
        var attackModifier : Int = attackPoints - target.defencePoints + 1
        val dice : Dice = Dice(ATTACK_DICE_SIDES)
        var successful : Boolean = false
        do {
            val roll : Int = dice.roll()
            if ((roll == 5) or (roll == 6)) {
                successful = true
                break
            }
            attackModifier--
        } while (attackModifier > 0)
        if (successful) {
            target.getDamage(damageRange.getRandomElement())
        }
    }
}