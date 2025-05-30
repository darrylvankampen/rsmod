package org.rsmod.events

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotSame
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class SuspendEventBusTest {
    @Test
    fun `ensure suspend execution`() = runTest {
        val locFunc0: suspend Unit.(LocOp) -> Unit = { throw IllegalStateException() }
        val locFunc1: suspend Unit.(LocOp) -> Unit = { /* no-op */ }
        val events = eventBus {
            this[LocOp::class.java, 0L] = locFunc0
            this[LocOp::class.java, 1L] = locFunc1
        }
        val op = LocOp()
        val event0 = checkNotNull(events[LocOp::class.java, 0L])
        val event1 = checkNotNull(events[LocOp::class.java, 1L])
        assertThrows<IllegalStateException> { event0.invoke(Unit, op) }
        assertDoesNotThrow { event1.invoke(Unit, op) }
    }

    @Test
    fun `get correct suspend lambda given key`() {
        val locFunc0: suspend Unit.(LocOp) -> Unit = { /* no-op */ }
        val locFunc1: suspend Unit.(LocOp) -> Unit = { /* no-op */ }
        val locFunc2: suspend Unit.(LocOp) -> Unit = { /* no-op */ }
        val events = eventBus {
            this[LocOp::class.java, 0L] = locFunc0
            this[LocOp::class.java, 1L] = locFunc1
            this[LocOp::class.java, 2L] = locFunc2
        }
        assertSame(locFunc0, events[LocOp::class.java, 0L])
        assertNotSame(locFunc1, events[LocOp::class.java, 0L])
        assertNotSame(locFunc2, events[LocOp::class.java, 0L])

        assertSame(locFunc1, events[LocOp::class.java, 1L])
        assertNotSame(locFunc0, events[LocOp::class.java, 1L])
        assertNotSame(locFunc2, events[LocOp::class.java, 1L])

        assertSame(locFunc2, events[LocOp::class.java, 2L])
        assertNotSame(locFunc0, events[LocOp::class.java, 2L])
        assertNotSame(locFunc1, events[LocOp::class.java, 2L])
    }

    @Test
    fun `contains correct suspendable type and key`() {
        val events = eventBus {
            this[LocOp::class.java, 0L] = { /* no-op */ }
            this[ObjOp::class.java, 1L] = { /* no-op */ }
        }
        assertTrue(events.contains(LocOp::class.java, 0L))
        assertFalse(events.contains(LocOp::class.java, 1L))
        assertFalse(events.contains(ObjOp::class.java, 0L))
        assertTrue(events.contains(ObjOp::class.java, 1L))
        assertFalse(events.contains(PlayerOp::class.java, 0L))
        assertFalse(events.contains(PlayerOp::class.java, 1L))
        assertFalse(events.contains(SuspendEvent::class.java, 0L))
        assertFalse(events.contains(SuspendEvent::class.java, 1L))
    }

    private fun eventBus(init: SuspendEventBus.() -> Unit): SuspendEventBus =
        SuspendEventBus().apply(init)

    private data class LocOp(val loc: Int = 0, val shape: Int = 10, val angle: Int = 0) :
        SuspendEvent<Unit> {
        override val id: Long = loc.toLong()
    }

    private data class ObjOp(val obj: Int) : SuspendEvent<Unit> {
        override val id: Long = obj.toLong()
    }

    private data class PlayerOp(val pid: Int) : SuspendEvent<Unit> {
        override val id: Long = pid.toLong()
    }

    private operator fun <K, T : SuspendEvent<K>> SuspendEventBus.set(
        type: Class<T>,
        key: Long,
        action: suspend K.(T) -> Unit,
    ): Unit = set(type, key, action)
}
