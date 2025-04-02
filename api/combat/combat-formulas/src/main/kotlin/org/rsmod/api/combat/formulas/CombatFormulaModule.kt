package org.rsmod.api.combat.formulas

import org.rsmod.api.combat.formulas.accuracy.magic.NvPMagicAccuracy
import org.rsmod.api.combat.formulas.accuracy.magic.PvNMagicAccuracy
import org.rsmod.api.combat.formulas.accuracy.melee.NvNMeleeAccuracy
import org.rsmod.api.combat.formulas.accuracy.melee.NvPMeleeAccuracy
import org.rsmod.api.combat.formulas.accuracy.melee.PvNMeleeAccuracy
import org.rsmod.api.combat.formulas.accuracy.melee.PvPMeleeAccuracy
import org.rsmod.api.combat.formulas.accuracy.ranged.NvPRangedAccuracy
import org.rsmod.api.combat.formulas.accuracy.ranged.PvNRangedAccuracy
import org.rsmod.api.combat.formulas.attributes.collector.CombatMagicAttributeCollector
import org.rsmod.api.combat.formulas.attributes.collector.CombatMeleeAttributeCollector
import org.rsmod.api.combat.formulas.attributes.collector.CombatNpcAttributeCollector
import org.rsmod.api.combat.formulas.attributes.collector.CombatRangedAttributeCollector
import org.rsmod.api.combat.formulas.attributes.collector.DamageReductionAttributeCollector
import org.rsmod.api.combat.formulas.maxhit.magic.NvPMagicMaxHit
import org.rsmod.api.combat.formulas.maxhit.magic.PvNMagicMaxHit
import org.rsmod.api.combat.formulas.maxhit.melee.NvNMeleeMaxHit
import org.rsmod.api.combat.formulas.maxhit.melee.NvPMeleeMaxHit
import org.rsmod.api.combat.formulas.maxhit.melee.PvNMeleeMaxHit
import org.rsmod.api.combat.formulas.maxhit.melee.PvPMeleeMaxHit
import org.rsmod.api.combat.formulas.maxhit.ranged.NvPRangedMaxHit
import org.rsmod.api.combat.formulas.maxhit.ranged.PvNRangedMaxHit
import org.rsmod.plugin.module.PluginModule

public class CombatFormulaModule : PluginModule() {
    override fun bind() {
        bindInstance<CombatMagicAttributeCollector>()
        bindInstance<CombatMeleeAttributeCollector>()
        bindInstance<CombatNpcAttributeCollector>()
        bindInstance<CombatRangedAttributeCollector>()
        bindInstance<DamageReductionAttributeCollector>()

        bindInstance<AccuracyFormulae>()
        bindInstance<MaxHitFormulae>()

        bindInstance<PvNMagicAccuracy>()
        bindInstance<NvPMagicAccuracy>()
        bindInstance<PvNMagicMaxHit>()
        bindInstance<NvPMagicMaxHit>()

        bindInstance<NvPMeleeAccuracy>()
        bindInstance<NvNMeleeAccuracy>()
        bindInstance<PvNMeleeAccuracy>()
        bindInstance<PvPMeleeAccuracy>()
        bindInstance<NvPMeleeMaxHit>()
        bindInstance<NvNMeleeMaxHit>()
        bindInstance<PvNMeleeMaxHit>()
        bindInstance<PvPMeleeMaxHit>()

        bindInstance<NvPRangedAccuracy>()
        bindInstance<PvNRangedAccuracy>()
        bindInstance<NvPRangedMaxHit>()
        bindInstance<PvNRangedMaxHit>()
    }
}
