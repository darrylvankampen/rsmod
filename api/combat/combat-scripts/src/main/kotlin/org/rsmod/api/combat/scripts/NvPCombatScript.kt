package org.rsmod.api.combat.scripts

import jakarta.inject.Inject
import org.rsmod.api.combat.ACTIVE_COMBAT_DELAY
import org.rsmod.api.combat.NvPCombat
import org.rsmod.api.combat.commons.CombatAttack
import org.rsmod.api.combat.commons.types.MeleeAttackType
import org.rsmod.api.combat.inMultiCombatArea
import org.rsmod.api.combat.player.aggressiveNpc
import org.rsmod.api.combat.player.lastCombat
import org.rsmod.api.combat.player.lastCombatPvp
import org.rsmod.api.npc.access.StandardNpcAccess
import org.rsmod.api.script.advanced.onDefaultAiOpPlayer2
import org.rsmod.game.entity.Player
import org.rsmod.plugin.scripts.PluginScript
import org.rsmod.plugin.scripts.ScriptContext

internal class NvPCombatScript @Inject constructor(private val combat: NvPCombat) : PluginScript() {
    override fun ScriptContext.startUp() {
        onDefaultAiOpPlayer2 { attemptCombatOp(it.target) }
    }

    private fun StandardNpcAccess.attemptCombatOp(target: Player) {
        if (!canAttack(target)) {
            resetMode()
            return
        }
        // TODO(combat): Use proper/active npc attack type.
        val attack = CombatAttack.NpcMelee(MeleeAttackType.Slash)
        combat.attack(this, target, attack)
    }

    private fun StandardNpcAccess.canAttack(target: Player): Boolean {
        val singleCombat = !inMultiCombatArea()
        if (singleCombat) {
            if (target.lastCombatPvp + ACTIVE_COMBAT_DELAY > mapClock) {
                return false
            }

            if (target.lastCombat + ACTIVE_COMBAT_DELAY > mapClock) {
                if (target.aggressiveNpc != null && target.aggressiveNpc != npc.uid) {
                    return false
                }
            }
        }
        return true
    }
}
