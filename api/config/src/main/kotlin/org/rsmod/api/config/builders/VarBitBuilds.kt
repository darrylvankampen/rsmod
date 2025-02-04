package org.rsmod.api.config.builders

import org.rsmod.api.config.refs.varps
import org.rsmod.api.type.builders.varbit.VarBitBuilder

internal object VarBitBuilds : VarBitBuilder() {
    init {
        build("small_pouch_storage_type") {
            baseVar = varps.generic_storage_65531
            startBit = 0
            endBit = 0
        }

        build("small_pouch_storage_count") {
            baseVar = varps.generic_storage_65531
            startBit = 1
            endBit = 2
        }

        build("medium_pouch_storage_type") {
            baseVar = varps.generic_storage_65531
            startBit = 3
            endBit = 3
        }

        build("medium_pouch_storage_count") {
            baseVar = varps.generic_storage_65531
            startBit = 4
            endBit = 6
        }

        build("large_pouch_storage_type") {
            baseVar = varps.generic_storage_65531
            startBit = 7
            endBit = 7
        }

        build("large_pouch_storage_count") {
            baseVar = varps.generic_storage_65531
            startBit = 9
            endBit = 12
        }

        build("giant_pouch_storage_type") {
            baseVar = varps.generic_storage_65531
            startBit = 13
            endBit = 13
        }

        build("giant_pouch_storage_count") {
            baseVar = varps.generic_storage_65531
            startBit = 14
            endBit = 17
        }

        build("colossal_pouch_storage_type") {
            baseVar = varps.generic_storage_65531
            startBit = 18
            endBit = 18
        }

        build("colossal_pouch_storage_count") {
            baseVar = varps.generic_storage_65531
            startBit = 19
            endBit = 24
        }

        build("coal_bag_storage_count") {
            baseVar = varps.generic_storage_65531
            startBit = 25
            endBit = 30
        }
    }
}
