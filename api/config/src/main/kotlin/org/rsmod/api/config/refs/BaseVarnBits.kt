package org.rsmod.api.config.refs

import org.rsmod.api.type.refs.varnbit.VarnBitReferences

typealias varnbits = BaseVarnBits

object BaseVarnBits : VarnBitReferences() {
    val respawn_pending = find("respawn_pending")
}
