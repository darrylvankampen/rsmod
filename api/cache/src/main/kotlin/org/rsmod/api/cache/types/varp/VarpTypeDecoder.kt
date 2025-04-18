package org.rsmod.api.cache.types.varp

import io.netty.buffer.ByteBuf
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
import java.io.IOException
import org.openrs2.buffer.use
import org.openrs2.cache.Cache
import org.rsmod.api.cache.Js5Archives
import org.rsmod.api.cache.Js5Configs
import org.rsmod.api.cache.util.TextUtil
import org.rsmod.game.type.TypeResolver
import org.rsmod.game.type.varp.UnpackedVarpType
import org.rsmod.game.type.varp.VarpLifetime
import org.rsmod.game.type.varp.VarpTransmitLevel
import org.rsmod.game.type.varp.VarpTypeBuilder
import org.rsmod.game.type.varp.VarpTypeList

public object VarpTypeDecoder {
    public fun decodeAll(cache: Cache): VarpTypeList {
        val types = Int2ObjectOpenHashMap<UnpackedVarpType>()
        val files = cache.list(Js5Archives.CONFIG, Js5Configs.VARPLAYER)
        for (file in files) {
            val data = cache.read(Js5Archives.CONFIG, Js5Configs.VARPLAYER, file.id)
            val type = data.use { decode(it).build(file.id) }
            types[file.id] = type.apply { TypeResolver[this] = file.id }
        }
        return VarpTypeList(types)
    }

    public fun decode(data: ByteBuf): VarpTypeBuilder {
        val builder = VarpTypeBuilder(TextUtil.NULL)
        while (data.isReadable) {
            val code = data.readUnsignedByte().toInt()
            if (code == 0) {
                break
            }
            decode(builder, data, code)
        }
        return builder
    }

    public fun decode(builder: VarpTypeBuilder, data: ByteBuf, code: Int): Unit =
        with(builder) {
            when (code) {
                5 -> clientCode = data.readUnsignedShort()
                202 -> bitProtect = true
                203 -> {
                    val id = data.readByte().toInt()
                    val scope = VarpLifetime[id]

                    checkNotNull(scope) { "`VarpLifetime` for id `$id` does not exist." }
                    this.scope = scope
                }
                204 -> {
                    val id = data.readByte().toInt()
                    val transmit = VarpTransmitLevel[id]

                    checkNotNull(transmit) { "`VarpTransmitLevel` for id `$id` does not exist." }
                    this.transmit = transmit
                }
                else -> throw IOException("Error unrecognised .varp config code: $code")
            }
        }
}
