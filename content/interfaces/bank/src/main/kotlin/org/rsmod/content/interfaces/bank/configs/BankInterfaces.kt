package org.rsmod.content.interfaces.bank.configs

import org.rsmod.api.type.refs.comp.ComponentReferences
import org.rsmod.api.type.refs.interf.InterfaceReferences

internal typealias bank_interfaces = BankInterfaces

internal typealias bank_components = BankComponents

internal typealias bank_comsubs = BankSubComponents

object BankInterfaces : InterfaceReferences() {
    val tutorial_overlay = find("bank_tutorial", 1206696351)
}

object BankComponents : ComponentReferences() {
    val tutorial_button = find("bank_com4", 7135446288139269005)
    val capacity_container = find("bank_com7", 5691092119508665688)
    val capacity_text = find("bank_com9", 71329117100551008)
    val main_inventory = find("bank_com13", 8484261777138475560)
    val tabs = find("bank_com11", 5066672266370361425)
    val incinerator_confirm = find("bank_com50", 7492851284321215925)
    val com52 = find("bank_com52", 801223983307344610)
    val worn_off_stab = find("bank_com99", 3871284138851419694)
    val worn_off_slash = find("bank_com100", 7687055685561439413)
    val worn_off_crush = find("bank_com101", 2279455195416683324)
    val worn_off_magic = find("bank_com102", 1812363776450705232)
    val worn_off_range = find("bank_com103", 5628135323160724951)
    val worn_speed_base = find("bank_com133", 1094789004798606996)
    val worn_speed = find("bank_com134", 8259240679252668340)
    val worn_def_stab = find("bank_com105", 1391589516031612869)
    val worn_def_slash = find("bank_com106", 5207361062741632588)
    val worn_def_crush = find("bank_com107", 9023132609451652307)
    val worn_def_range = find("bank_com109", 3148440700340918126)
    val worn_def_magic = find("bank_com108", 8556041190485674215)
    val worn_melee_str = find("bank_com111", 8135266930066581852)
    val worn_ranged_str = find("bank_com112", 2727666439921825763)
    val worn_magic_dmg = find("bank_com113", 6543437986631845482)
    val worn_prayer = find("bank_com114", 1135837496487089393)
    val worn_undead = find("bank_com116", 247971817102018936)
    val worn_slayer = find("bank_com117", 4063743363812038655)
    val tutorial_overlay_target = find("bank_com125", 5345750290142623059)
    val confirmation_overlay_target = find("bank_com126", 7725483948440596984)
    val tooltip = find("bank_com128", 4370591860360031647)

    val rearrange_mode_swap = find("bank_com19", 7319232678072104634)
    val rearrange_mode_insert = find("bank_com21", 6869961168519985648)
    val withdraw_mode_item = find("bank_com24", 2510729662576342869)
    val withdraw_mode_note = find("bank_com26", 3245570119814374912)
    val always_placehold = find("bank_com40", 5373906735621325153)
    val deposit_inventory = find("bank_com44", 2621356993398576010)
    val deposit_worn = find("bank_com46", 4616617229019892865)
    val quantity_1 = find("bank_com30", 7134228484220256887)
    val quantity_5 = find("bank_com32", 3565830576145944234)
    val quantity_10 = find("bank_com34", 585247277110118155)
    val quantity_x = find("bank_com36", 6455702818875624943)
    val quantity_all = find("bank_com38", 2264218406509099907)

    val incinerator_toggle = find("bank_com56", 8262227114365051622)
    val tutorial_button_toggle = find("bank_com57", 1837419760172867825)
    val inventory_item_options_toggle = find("bank_com60", 5357236080421197393)
    val deposit_inv_toggle = find("bank_com61", 5357236080421197394)
    val deposit_worn_toggle = find("bank_com62", 8877052400669526960)
    val potion_store_toggle = find("bank_com63", 8877052400669526961)
    val release_placehold = find("bank_com64", 2414861200116997797)
    val bank_fillers_1 = find("bank_com67", 6468140908947024831)
    val bank_fillers_10 = find("bank_com69", 8767875417182338532)
    val bank_fillers_50 = find("bank_com71", 8334483426213812053)
    val bank_fillers_x = find("bank_com73", 6142727057154355056)
    val bank_fillers_all = find("bank_com75", 1073143106896443203)
    val bank_fillers_fill = find("bank_com77", 4545019539988763618)
    val bank_tab_display = find("bank_com138", 6110944052766837765)

    val side_inventory = find("bank_inventory_com3", 1885880344080200061)
    val worn_inventory = find("bank_inventory_com4", 6203990611586493264)
    val side_com11 = find("bank_inventory_com11", 8800055068705330501)
    val side_com18 = find("bank_inventory_com18", 81253577765913503)
    val side_com40 = find("bank_inventory_com40", 6202930921141607001)

    val tutorial_close_button = find("bank_tutorial_com9", 8373824249352593324)
    val tutorial_next_page = find("bank_tutorial_com31", 2368578001968595651)
    val tutorial_prev_page = find("bank_tutorial_com32", 7461125518300620858)
}

@Suppress("ConstPropertyName")
object BankSubComponents {
    const val main_tab = 10
    val other_tabs = 11..19

    val tab_extended_slots_offset = 19..28
}
