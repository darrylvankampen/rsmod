package org.rsmod.api.combat.scripts

import jakarta.inject.Inject
import org.rsmod.api.combat.NpcCombat
import org.rsmod.api.combat.commons.magic.MagicSpell
import org.rsmod.api.combat.npc.aggressivePlayer
import org.rsmod.api.combat.npc.lastCombat
import org.rsmod.api.combat.player.ACTIVE_COMBAT_DELAY
import org.rsmod.api.combat.player.aggressiveNpc
import org.rsmod.api.combat.player.attackRange
import org.rsmod.api.combat.player.inMultiCombatArea
import org.rsmod.api.combat.player.lastCombat
import org.rsmod.api.combat.player.lastCombatPvp
import org.rsmod.api.combat.player.resolveCombatAttack
import org.rsmod.api.combat.weapon.styles.AttackStyles
import org.rsmod.api.combat.weapon.types.AttackTypes
import org.rsmod.api.player.protect.ProtectedAccess
import org.rsmod.api.player.righthand
import org.rsmod.api.script.advanced.onDefaultApNpc2
import org.rsmod.api.script.advanced.onDefaultOpNpc2
import org.rsmod.game.entity.Npc
import org.rsmod.plugin.scripts.PluginScript
import org.rsmod.plugin.scripts.ScriptContext

internal class NpcTargetScript
@Inject
constructor(
    private val styles: AttackStyles,
    private val types: AttackTypes,
    private val combat: NpcCombat,
) : PluginScript() {
    override fun ScriptContext.startUp() {
        onDefaultApNpc2 { attemptCombatAp(it.npc) }
        onDefaultOpNpc2 { attemptCombatOp(it.npc) }
    }

    private suspend fun ProtectedAccess.attemptCombatAp(target: Npc) {
        val type = types.get(player)
        val style = styles.get(player)
        val attackRange = attackRange(style)
        val canAttack = canAttack(target)

        // Weapons such as salamanders have an attack range of `1` but can attack with both ranged
        // and magic. These attacks should be treated as ap range, not op.
        val isMeleeAttackType = type == null || type.isMelee
        if (attackRange == 1 && isMeleeAttackType) {
            apRange(-1)
            return
        }

        if (!canAttack) {
            return
        }

        if (!isWithinDistance(target, attackRange)) {
            apRange(attackRange)
            return
        }

        val weapon = player.righthand
        val spell: MagicSpell? = null // TODO(combat): Resolve spell based on auto cast id.
        val attack = resolveCombatAttack(weapon, type, style, spell)

        combat.attack(this, target, attack)
    }

    private suspend fun ProtectedAccess.attemptCombatOp(target: Npc) {
        if (!canAttack(target)) {
            return
        }

        val type = types.get(player)
        val style = styles.get(player)
        val weapon = player.righthand

        val spell: MagicSpell? = null // TODO(combat): Resolve spell based on auto cast id.
        val attack = resolveCombatAttack(weapon, type, style, spell)

        combat.attack(this, target, attack)
    }

    private fun ProtectedAccess.canAttack(npc: Npc): Boolean {
        // TODO(combat): Handle "can attack hooks" here. Seems like the ones that give dialogues
        //  have a cool-down period, but it's more than likely something hardcoded into
        //  their specific conditions. Some npcs like the mage arena (wilderness) npcs
        //  don't give any sort of message, but simply won't allow players to melee them.
        //  (Will stop at ap range, doesn't drag you into melee range)

        val singleCombat = !inMultiCombatArea()
        if (singleCombat) {
            if (lastCombatPvp + ACTIVE_COMBAT_DELAY > mapClock) {
                // TODO(combat): Is this also a spam type message for pvp?
                spam("I'm already under attack.")
                return false
            }

            if (lastCombat + ACTIVE_COMBAT_DELAY > mapClock) {
                if (aggressiveNpc != null && aggressiveNpc != npc.uid) {
                    spam("I'm already under attack.")
                    return false
                }
            }

            // TODO(combat): Support for npcs that only target a single player, such as barrows.
            if (npc.lastCombat + ACTIVE_COMBAT_DELAY > mapClock) {
                if (npc.aggressivePlayer != null && npc.aggressivePlayer != player.uid) {
                    mes("Someone else is fighting that.")
                    return false
                }
            }
        }
        return true
    }
}
