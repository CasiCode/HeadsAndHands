package com.lesson_00_pitsunov

class Monster(
    maxHP : Int = 10,
    hp : Int = 10,
    atk : Int = 10,
    def : Int = 4,
    dmg : IntRange = (3..6)
) : Creature(maxHP, hp, atk, def, dmg)