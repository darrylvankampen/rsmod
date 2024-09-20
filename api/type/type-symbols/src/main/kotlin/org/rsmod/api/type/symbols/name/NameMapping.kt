package org.rsmod.api.type.symbols.name

public data class NameMapping(
    public val categories: Map<String, Int> = mutableMapOf(),
    public val clientscripts: Map<String, Int> = mutableMapOf(),
    public val components: Map<String, Int> = mutableMapOf(),
    public val content: Map<String, Int> = mutableMapOf(),
    public val currencies: Map<String, Int> = mutableMapOf(),
    public val enums: Map<String, Int> = mutableMapOf(),
    public val interfaces: Map<String, Int> = mutableMapOf(),
    public val invs: Map<String, Int> = mutableMapOf(),
    public val locs: Map<String, Int> = mutableMapOf(),
    public val models: Map<String, Int> = mutableMapOf(),
    public val npcs: Map<String, Int> = mutableMapOf(),
    public val objs: Map<String, Int> = mutableMapOf(),
    public val params: Map<String, Int> = mutableMapOf(),
    public val seqs: Map<String, Int> = mutableMapOf(),
    public val stats: Map<String, Int> = mutableMapOf(),
    public val structs: Map<String, Int> = mutableMapOf(),
    public val synths: Map<String, Int> = mutableMapOf(),
    public val timers: Map<String, Int> = mutableMapOf(),
    public val varbits: Map<String, Int> = mutableMapOf(),
    public val varps: Map<String, Int> = mutableMapOf(),
    public val varns: Map<String, Int> = mutableMapOf(),
    public val varnbits: Map<String, Int> = mutableMapOf(),
    public val varobjbits: Map<String, Int> = mutableMapOf(),
    public val modLevels: Map<String, Int> = mutableMapOf(),
    public val modGroups: Map<String, Int> = mutableMapOf(),
    public val mesanims: Map<String, Int> = mutableMapOf(),
    public val fonts: Map<String, Int> = mutableMapOf(),
)
