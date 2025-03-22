package org.rsmod.api.combat.formulas

import org.rsmod.api.combat.formulas.accuracy.melee.NvPMeleeAccuracy
import org.rsmod.api.combat.formulas.accuracy.melee.PvNMeleeAccuracy
import org.rsmod.api.combat.formulas.attributes.collector.CombatMeleeAttributeCollector
import org.rsmod.api.combat.formulas.attributes.collector.CombatNpcAttributeCollector
import org.rsmod.api.combat.formulas.attributes.collector.CombatRangedAttributeCollector
import org.rsmod.api.combat.formulas.attributes.collector.DamageReductionAttributeCollector
import org.rsmod.api.combat.formulas.maxhit.melee.NvPMeleeMaxHit
import org.rsmod.api.combat.formulas.maxhit.melee.PvNMeleeMaxHit
import org.rsmod.api.combat.formulas.maxhit.ranged.NvPRangedMaxHit
import org.rsmod.api.combat.formulas.maxhit.ranged.PvNRangedMaxHit
import org.rsmod.plugin.module.PluginModule

public class CombatFormulaModule : PluginModule() {
    override fun bind() {
        bindInstance<CombatMeleeAttributeCollector>()
        bindInstance<CombatNpcAttributeCollector>()
        bindInstance<CombatRangedAttributeCollector>()
        bindInstance<DamageReductionAttributeCollector>()

        bindInstance<NvPMeleeAccuracy>()
        bindInstance<PvNMeleeAccuracy>()

        bindInstance<NvPMeleeMaxHit>()
        bindInstance<PvNMeleeMaxHit>()
        bindInstance<NvPRangedMaxHit>()
        bindInstance<PvNRangedMaxHit>()

        bindInstance<AccuracyFormulae>()
        bindInstance<MaxHitFormulae>()
    }
}
