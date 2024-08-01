package dev.kosmx.emotesCompat.rp

import net.minecraft.util.Identifier
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.event.RegisterCommandsEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.network.NetworkEvent
import net.minecraftforge.fml.network.simple.SimpleChannel
import java.util.function.Supplier

@Mod("emotescompat")
object PacketRecording {
    private val CHANNEL_NAME = "emotescompat"
    private val networkChannel: SimpleChannel = net.minecraftforge.fml.network.NetworkRegistry.newSimpleChannel(
        Identifier(CHANNEL_NAME, "recording"),
        { "1" },
        { it == "1" },
        { Supplier { net.minecraftforge.fml.network.NetworkEvent.Context::new } })

    fun register() {
        networkChannel.registerMessage(
            0,
            PacketRecording.Handler::class.java,
            PacketRecording.Handler::encode,
            PacketRecording.Handler::decode,
            PacketRecording.Handler::handle
        )
    }

    class Handler {
        fun encode(packet: PacketRecording.Handler?, buf: net.minecraft.network.PacketByteBuf) {}
        fun decode(buf: net.minecraft.network.PacketByteBuf?): PacketRecording.Handler? {
            return PacketRecording.Handler()
        }

        fun handle(packet: PacketRecording.Handler?, context: net
        .minecraftforge.fml.network.NetworkEvent.Context?): Boolean {
            return true
        }
    }
}
