package dev.kosmx.emotesCompat.rp.init

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import org.spongepowered.asm.mixin.Mixins
import org.spongepowered.asm.mixin.connect.IMixinConnector

@Mod.EventBusSubscriber(modid = "emotescompat")
class MixinPlugin : IMixinConnector {
    override fun connect() {
        Mixins.addConfiguration("emotesCompat.mixins.json")
    }
}
