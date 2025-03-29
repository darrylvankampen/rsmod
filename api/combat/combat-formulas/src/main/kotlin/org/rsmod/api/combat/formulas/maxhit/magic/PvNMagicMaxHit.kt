package org.rsmod.api.combat.formulas.maxhit.magic

import jakarta.inject.Inject
import java.util.EnumSet
import org.rsmod.api.combat.commons.magic.MagicSpell
import org.rsmod.api.combat.commons.magic.Spellbook
import org.rsmod.api.combat.formulas.attributes.CombatNpcAttributes
import org.rsmod.api.combat.formulas.attributes.CombatSpellAttributes
import org.rsmod.api.combat.formulas.attributes.collector.CombatMagicAttributeCollector
import org.rsmod.api.combat.formulas.attributes.collector.CombatNpcAttributeCollector
import org.rsmod.api.combat.formulas.isSlayerTask
import org.rsmod.api.config.refs.params
import org.rsmod.api.config.refs.varps
import org.rsmod.api.player.bonus.WornBonuses
import org.rsmod.api.player.stat.magicLvl
import org.rsmod.api.player.vars.intVarp
import org.rsmod.game.entity.Npc
import org.rsmod.game.entity.Player
import org.rsmod.game.type.npc.UnpackedNpcType
import org.rsmod.game.type.obj.ObjType

public class PvNMagicMaxHit
@Inject
constructor(
    private val bonuses: WornBonuses,
    private val npcAttributes: CombatNpcAttributeCollector,
    private val magicAttributes: CombatMagicAttributeCollector,
) {
    private var Player.maxHit by intVarp(varps.com_maxhit)

    public fun getSpellMaxHit(
        player: Player,
        target: Npc,
        spellbook: Spellbook,
        magicSpell: MagicSpell,
        baseMaxHit: Int,
        usedSunfireRune: Boolean,
    ): IntRange {
        val targetType = target.visType
        val elementalWeakness = targetType.param(params.elemental_weakness_percent)
        val maxHit =
            computeSpellMaxHit(
                source = player,
                target = targetType,
                targetCurrHp = target.hitpoints,
                targetMaxHp = target.baseHitpointsLvl,
                targetWeaknessPercent = elementalWeakness,
                spellObj = magicSpell.obj,
                baseMaxHit = baseMaxHit,
                spellbook = spellbook,
                usedSunfireRune = usedSunfireRune,
            )
        player.maxHit = maxHit.last
        return maxHit
    }

    public fun computeSpellMaxHit(
        source: Player,
        target: UnpackedNpcType,
        targetCurrHp: Int,
        targetMaxHp: Int,
        targetWeaknessPercent: Int,
        spellObj: ObjType,
        baseMaxHit: Int,
        spellbook: Spellbook,
        usedSunfireRune: Boolean,
    ): IntRange {
        val spellAttributes =
            magicAttributes.spellCollect(source, spellObj, spellbook, usedSunfireRune)

        val slayerTask = target.isSlayerTask(source)
        val npcAttributes = npcAttributes.collect(target, targetCurrHp, targetMaxHp, slayerTask)

        val modifiedDamage =
            computeSpellModifiedDamage(source, baseMaxHit, spellAttributes, npcAttributes)
        return modifySpellPostSpec(
            modifiedDamage = modifiedDamage,
            baseDamage = baseMaxHit,
            targetWeaknessPercent = targetWeaknessPercent,
            spellAttributes = spellAttributes,
            npcAttributes = npcAttributes,
        )
    }

    public fun computeSpellModifiedDamage(
        source: Player,
        baseDamage: Int,
        spellAttributes: EnumSet<CombatSpellAttributes>,
        npcAttributes: EnumSet<CombatNpcAttributes>,
    ): Int {
        val magicDmgBonus = bonuses.magicDamageBonusBase(source)
        val prayerDmgBonus = MagicMaxHitOperations.getMagicDamagePrayerBonus(source)
        return MagicMaxHitOperations.modifySpellBaseDamage(
            baseDamage = baseDamage,
            sourceMagic = source.magicLvl,
            sourceBaseMagicDmgBonus = magicDmgBonus,
            sourceMagicPrayerBonus = prayerDmgBonus,
            spellAttributes = spellAttributes,
            npcAttributes = npcAttributes,
        )
    }

    public fun modifySpellPostSpec(
        modifiedDamage: Int,
        baseDamage: Int,
        targetWeaknessPercent: Int,
        spellAttributes: EnumSet<CombatSpellAttributes>,
        npcAttributes: EnumSet<CombatNpcAttributes>,
    ): IntRange =
        MagicMaxHitOperations.modifySpellPostSpec(
            modifiedDamage = modifiedDamage,
            baseDamage = baseDamage,
            targetWeaknessPercent = targetWeaknessPercent,
            spellAttributes = spellAttributes,
            npcAttributes = npcAttributes,
        )
}
