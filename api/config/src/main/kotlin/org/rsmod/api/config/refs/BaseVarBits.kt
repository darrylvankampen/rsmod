@file:Suppress("SpellCheckingInspection", "unused")

package org.rsmod.api.config.refs

import org.rsmod.api.type.refs.varbit.VarBitReferences

typealias varbits = BaseVarBits

object BaseVarBits : VarBitReferences() {
    val combat_level = find("combat_level", 56930885834068)
    val combat_level_decimal = find("combat_level_decimal", 116230836668633)
    val autocast_enabled = find("autocast_enabled", 5565072492265)
    val autocast_spell = find("autocast_spell", 5565072497878)
    val defensive_casting_mode = find("defensive_casting_mode", 22618316438405)

    val hide_toplevel = find("hide_toplevel", 52603174306817)
    val cinematic_view = find("cinematic_view", 52603174314724)
    val minimap_compass_state = find("minimap_compass_state", 52603174339590)
    val hide_health_hud = find("hide_health_hud", 87430947458308)

    val accept_aid = find("accept_aid", 22000071917329)
    val chatbox_unlocked = find("chatbox_unlocked", 89491762451420)
    val modal_widthandheight_mode = find("modal_widthandheight_mode", 52603174328291)
    val hide_roofs = find("hide_roofs", 158374502976336)
    val rt7_enabled = find("rt7_enabled", 195520692873859)
    val rt7_mode = find("rt7_mode", 195520692877642)
    val rt7_enabled2 = find("rt7_enabled2", 195520692881425)
    val drop_item_warning = find("drop_item_warning", 14632658384937)
    val drop_item_minimum_value = find("drop_item_minimum_value", 14632658390428)
    val combat_tab_weapon_style_type = find("combat_tab_weapon_style_type", 43432547647987)
    val esc_closes_current_interface = find("esc_closes_current_interface", 63061810400789)

    val demon_slayer_progress = find("demon_slayer_progress", 11438395171949)
    val lost_tribe_progress = find("lost_tribe_quest", 23957846140009)
    val kings_ransom_progress = find("kings_ransom_progress", 54097265147926)

    val glass_box_emote = find("glass_box_emote", 16126749241145)
    val climb_rope_emote = find("climb_rope_emote", 16126749244928)
    val lean_emote = find("lean_emote", 16126749248711)
    val glass_wall_emote = find("glass_wall_emote", 16126749237362)
    val idea_emote = find("idea_emote", 41320212308399)
    val stamp_emote = find("stamp_emote", 41320212312182)
    val flap_emote = find("flap_emote", 41320212300833)
    val slap_head_emote = find("slap_head_emote", 41320212304616)
    val zombie_walk_emote = find("zombie_walk_emote", 16126749260608)
    val zombie_dance_emote = find("zombie_dance_emote", 16126749256825)
    val scared_emote = find("scared_emote", 16126749252494)
    val rabbit_hop_emote = find("rabbit_hop_emote", 16126749264524)
    val drill_demon_emotes = find("drill_demon_emotes", 16126749282329)
    val party_emote = find("party_emote", 16126749321967)
    val zombie_hand_emote = find("zombie_hand_emote", 16126749271033)
    val hypermobile_drinker_emote = find("hypermobile_drinker_emote", 16126749289963)
    val air_guitar_emote = find("air_guitar_emote", 16126749278488)
    val uri_transform_emote = find("uri_transform_emote", 16126749294047)
    val smooth_dance_emote = find("smooth_dance_emote", 16126749298322)
    val crazy_dance_emote = find("crazy_dance_emote", 16126749302105)
    val premier_shield_emote = find("premier_shield_emote", 16126749306330)
    val flex_emote = find("flex_emote", 16126749323697)
    val explore_emote = find("explore_emote", 16126749314186)
    val relic_unlock_emote = find("relic_unlock_emote", 148688672513070)
    val trick_emote = find("trick_emote", 16126749334521)

    val enabled_prayers = find("prayer_enabled_full", 4277063138774)
    val using_quick_prayers = find("using_quick_prayers", 19321012450480)

    val thick_skin = find("prayer_thick_skin", 4277063137069)
    val burst_of_strength = find("prayer_burst_of_strength", 4277063140852)
    val clarity_of_thought = find("prayer_clarity_of_thought", 4277063144635)
    val rock_skin = find("prayer_rock_skin", 4277063148418)
    val superhuman_strength = find("prayer_superhuman_strength", 4277063152201)
    val improved_reflexes = find("prayer_improved_reflexes", 4277063155984)
    val rapid_restore = find("prayer_rapid_restore", 4277063159767)
    val rapid_heal = find("prayer_rapid_heal", 4277063163550)
    val protect_item = find("prayer_protect_item", 4277063167333)
    val steel_skin = find("prayer_steel_skin", 4277063171116)
    val ultimate_strength = find("prayer_ultimate_strength", 4277063174899)
    val incredible_reflexes = find("prayer_incredible_reflexes", 4277063178682)
    val protect_from_magic = find("prayer_protect_from_magic", 4277063182465)
    val protect_from_missiles = find("prayer_protect_from_missiles", 4277063186248)
    val protect_from_melee = find("prayer_protect_from_melee", 4277063190031)
    val retribution = find("prayer_retribution", 4277063193814)
    val redemption = find("prayer_redemption", 4277063197597)
    val smite = find("prayer_smite", 4277063201380)
    val preserve = find("prayer_preserve", 4277063244327)
    val sharp_eye = find("prayer_sharp_eye", 4277063205163)
    val mystic_will = find("prayer_mystic_will", 4277063208946)
    val hawk_eye = find("prayer_hawk_eye", 4277063212729)
    val mystic_lore = find("prayer_mystic_lore", 4277063216512)
    val eagle_eye = find("prayer_eagle_eye", 4277063220295)
    val mystic_might = find("prayer_mystic_might", 4277063224078)
    val chivalry = find("prayer_chivalry", 4277063231643)
    val piety = find("prayer_piety", 4277063235426)
    val rigour = find("prayer_rigour", 4277063229197)
    val augury = find("prayer_augury", 4277063240544)
    val preserve_unlocked = find("preserve_prayer_unlocked", 73623487039670)
    val rigour_unlocked = find("rigour_prayer_unlocked", 73623487032104)
    val augury_unlocked = find("augury_prayer_unlocked", 73623487035887)
    val deadeye_unlocked = find("deadeye_unlocked", 239828214727554)
    val mystic_vigour_unlocked = find("mystic_vigour_unlocked", 239828214731337)

    val setting_max_hit_hitsplats_threshold =
        find("setting_max_hit_hitsplats_threshold", 183001241817303)

    /* Server-side only types */
    val saved_autocast_spell_staff = find("saved_autocast_spell_staff")
    val saved_defensive_casting_staff = find("saved_defensive_casting_staff")
    val saved_autocast_spell_bladed_staff = find("saved_autocast_spell_bladed_staff")
    val saved_defensive_casting_bladed_staff = find("saved_defensive_casting_bladed_staff")
    val accept_aid_restore = find("accept_aid_restore")
    val bank_capacity = find("bank_capacity")
    val coal_bag_storage_count = find("coal_bag_storage_count")
    val small_pouch_storage_type = find("small_pouch_storage_type")
    val small_pouch_storage_count = find("small_pouch_storage_count")
    val medium_pouch_storage_type = find("medium_pouch_storage_type")
    val medium_pouch_storage_count = find("medium_pouch_storage_count")
    val large_pouch_storage_type = find("large_pouch_storage_type")
    val large_pouch_storage_count = find("large_pouch_storage_count")
    val giant_pouch_storage_type = find("giant_pouch_storage_type")
    val giant_pouch_storage_count = find("giant_pouch_storage_count")
    val colossal_pouch_storage_type = find("colossal_pouch_storage_type")
    val colossal_pouch_storage_count = find("colossal_pouch_storage_count")
}
