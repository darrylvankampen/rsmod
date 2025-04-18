package org.rsmod.content.generic.locs.search

import org.rsmod.api.config.refs.content
import org.rsmod.api.config.refs.params
import org.rsmod.api.type.editors.loc.LocEditor

internal object SearchLocEdits : LocEditor() {
    init {
        crate("stack_crate_355")
        crate("big_crate_357")
        crate("stack_crate")
        crate("big_crate")
        crate("stack_nicecrate")

        sack("sacks")

        boxes("stack_smallboxes_359")
    }

    private fun crate(internal: String) {
        edit(internal) {
            param[params.game_message] = SearchConstants.EMPTY_CRATE
            contentGroup = content.empty_crate
        }
    }

    private fun sack(internal: String) {
        edit(internal) {
            param[params.game_message] = SearchConstants.EMPTY_SACKS
            contentGroup = content.empty_sacks
        }
    }

    private fun boxes(internal: String) {
        edit(internal) {
            param[params.game_message] = SearchConstants.EMPTY_BOXES
            contentGroup = content.empty_boxes
        }
    }
}

internal object SearchConstants {
    // You search the crates but find nothing of value. <- one type of box in varrock castle
    const val EMPTY_CRATE = "You search the crate but find nothing."
    const val EMPTY_CHEST = "You search the chest but find nothing."
    const val EMPTY_CRATE2 = "The crate is empty."
    const val EMPTY_BOXES = "There is nothing interesting in these boxes."
    const val EMPTY_SACKS = "There is nothing interesting in these sacks."

    const val DEFAULT = "You find nothing of interest."
}
