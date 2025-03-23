plugins {
    id("base-conventions")
}

dependencies {
    api(libs.guice)
    api(libs.bundles.logging)
    api(projects.api.cache)
    api(projects.api.cheat)
    api(projects.api.combat.combatCommons)
    api(projects.api.combat.combatWeapon)
    api(projects.api.config)
    api(projects.api.controller)
    api(projects.api.death)
    api(projects.api.gameProcess)
    api(projects.api.invtx)
    api(projects.api.market)
    api(projects.api.npc)
    api(projects.api.npcSpawns)
    api(projects.api.objSpawns)
    api(projects.api.player)
    api(projects.api.playerOutput)
    api(projects.api.random)
    api(projects.api.repo)
    api(projects.api.route)
    api(projects.api.script)
    api(projects.api.shops)
    api(projects.api.stats.levelmod)
    api(projects.api.stats.xpmod)
    api(projects.api.type.typeBuilders)
    api(projects.api.type.typeEditors)
    api(projects.api.type.typeReferences)
    api(projects.api.type.typeScriptDsl)
    api(projects.api.utils.utilsFormat)
    api(projects.api.utils.utilsIo)
    api(projects.api.utils.utilsVars)
    api(projects.engine.annotations)
    api(projects.engine.coroutine)
    api(projects.engine.events)
    api(projects.engine.game)
    api(projects.engine.map)
    api(projects.engine.objtx)
    api(projects.engine.routefinder)
    api(projects.engine.plugin)
    api(projects.engine.scheduler)
}
