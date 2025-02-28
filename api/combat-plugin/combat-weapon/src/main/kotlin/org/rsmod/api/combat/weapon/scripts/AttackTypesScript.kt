package org.rsmod.api.combat.weapon.scripts

import jakarta.inject.Inject
import org.rsmod.api.combat.weapon.types.AttackTypes
import org.rsmod.plugin.scripts.PluginScript
import org.rsmod.plugin.scripts.ScriptContext

internal class AttackTypesScript @Inject constructor(private val attackTypes: AttackTypes) :
    PluginScript() {
    override fun ScriptContext.startUp() {
        attackTypes.startUp()
    }
}
