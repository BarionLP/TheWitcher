package com.barion.the_witcher.client.event;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.client.TWKeyBinding;
import com.barion.the_witcher.networking.TWMessages;
import com.barion.the_witcher.networking.packet.TWSetPlayerEnergyC2SPacket;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TheWitcher.ModID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT) @OnlyIn(Dist.CLIENT)
public class TWForgeClientEvents {
    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event){
        if(TWKeyBinding.CastSign.consumeClick()){
            TWMessages.sendToServer(new TWSetPlayerEnergyC2SPacket(0));
        }
    }
}