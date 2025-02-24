package org.rsmod.api.config.builders

import org.rsmod.api.type.builders.stat.StatBuilder

object StatBuilds : StatBuilder() {
    init {
        build("attack")
        build("defence")
        build("strength")
        build("hitpoints")
        build("ranged")
        build("prayer")
        build("magic")
        build("cooking")
        build("woodcutting")
        build("fletching")
        build("fishing")
        build("firemaking")
        build("crafting")
        build("smithing")
        build("mining")
        build("herblore")
        build("agility")
        build("thieving")
        build("slayer")
        build("farming")
        build("runecrafting")
        build("hunter")
        build("construction")
        build("sailing") { unreleased = true }
        build("unreleased") { unreleased = true }
    }
}
