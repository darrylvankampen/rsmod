package org.rsmod.content.generic.locs.coops

import org.rsmod.api.config.refs.content
import org.rsmod.api.type.editors.loc.LocEditor

object ChickenCoopLocEditor : LocEditor() {
    init {
        coop("chicken_coop_5571")
        coop("chicken_coop_5572")
        coop("chicken_coop_5573")
    }

    private fun coop(internal: String) {
        edit(internal) { contentGroup = content.chicken_coop }
    }
}
