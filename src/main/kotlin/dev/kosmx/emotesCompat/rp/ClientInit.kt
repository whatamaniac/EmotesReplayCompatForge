package dev.kosmx.emotesCompat.rp

import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.TickEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import dev.kosmx.emotesCompat.init.Packets

@Mod("emotescompat")
object ClientInit {

    init {
        MinecraftForge.EVENT_BUS.register(this)
    }

    @SubscribeEvent
    fun onClientTick(event: TickEvent.ClientTickEvent) {
        if (event.phase == TickEvent.Phase.END) {
            Packets.tick()
        }
    }

    @SubscribeEvent
    fun onClientStopping(event: net.minecraftforge.client.event.ClientPlayerNetworkEvent.LoggedOutEvent) {
        Packets.close()
    }
}
