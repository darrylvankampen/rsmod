package org.rsmod.api.weapons.scripts

import jakarta.inject.Inject
import org.rsmod.api.weapons.WeaponManager
import org.rsmod.api.weapons.WeaponMap
import org.rsmod.api.weapons.WeaponRepository
import org.rsmod.plugin.scripts.PluginScript
import org.rsmod.plugin.scripts.ScriptContext

internal class WeaponScript
@Inject
constructor(
    private val repo: WeaponRepository,
    private val manager: WeaponManager,
    private val weapons: Set<WeaponMap>,
) : PluginScript() {
    override fun ScriptContext.startUp() {
        weapons.registerAll()
    }

    private fun Iterable<WeaponMap>.registerAll() {
        for (weapons in this) {
            weapons.register()
        }
    }

    private fun WeaponMap.register(): Unit = repo.register(manager)
}
