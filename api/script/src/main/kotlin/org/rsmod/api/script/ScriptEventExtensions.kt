package org.rsmod.api.script

import org.rsmod.api.cheat.CheatHandlerBuilder
import org.rsmod.api.cheat.register
import org.rsmod.api.controller.access.StandardConAccess
import org.rsmod.api.game.process.GameLifecycle
import org.rsmod.api.npc.access.StandardNpcAccess
import org.rsmod.api.player.protect.ProtectedAccess
import org.rsmod.events.KeyedEvent
import org.rsmod.events.SuspendEvent
import org.rsmod.events.UnboundEvent
import org.rsmod.plugin.scripts.ScriptContext

public fun ScriptContext.onBootUp(action: GameLifecycle.BootUp.() -> Unit): Unit =
    eventBus.subscribe<GameLifecycle.BootUp>(action)

public fun ScriptContext.onCommand(command: String, build: CheatHandlerBuilder.() -> Unit): Unit =
    cheatCommandMap.register(command, build)

public inline fun <reified T : UnboundEvent> ScriptContext.onEvent(
    noinline action: T.() -> Unit
): Unit = eventBus.subscribe<T>(action)

public inline fun <reified T : KeyedEvent> ScriptContext.onEvent(
    id: Number,
    noinline action: T.() -> Unit,
): Unit = eventBus.subscribe<T>(id, action)

public inline fun <reified T : SuspendEvent<ProtectedAccess>> ScriptContext.onProtectedEvent(
    id: Number,
    noinline action: suspend ProtectedAccess.(T) -> Unit,
): Unit = eventBus.subscribe(T::class.java, id, action)

public inline fun <reified T : SuspendEvent<StandardNpcAccess>> ScriptContext.onNpcAccessEvent(
    id: Number,
    noinline action: suspend StandardNpcAccess.(T) -> Unit,
): Unit = eventBus.subscribe(T::class.java, id, action)

public inline fun <reified T : SuspendEvent<StandardConAccess>> ScriptContext.onConAccessEvent(
    id: Number,
    noinline action: suspend StandardConAccess.(T) -> Unit,
): Unit = eventBus.subscribe(T::class.java, id, action)
