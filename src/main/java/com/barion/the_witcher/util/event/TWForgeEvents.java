package com.barion.the_witcher.util.event;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.networking.TWMessages;
import com.barion.the_witcher.networking.packet.TWPlayerEnergySyncS2CPacket;
import com.barion.the_witcher.networking.packet.TWPlayerMaxEnergySyncS2CPacket;
import com.barion.the_witcher.networking.packet.TWPlayerSignStrengthSyncS2CPacket;
import com.barion.the_witcher.sign.*;
import com.barion.the_witcher.util.TWUtil;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TheWitcher.ModID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TWForgeEvents{

    @SubscribeEvent
    public static void playerTick(TickEvent.PlayerTickEvent event){
        if(event.side == LogicalSide.SERVER){
            event.player.getCapability(TWPlayerEnergyProvider.Instance).ifPresent(energy -> {
                if(energy.isFull(event.player)) {return;}
                energy.increase(1, (ServerPlayer) event.player);
            });
        }
    }

    @SubscribeEvent
    public static void playerCloned(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            event.getOriginal().getCapability(TWPlayerSignStrengthProvider.Instance).ifPresent(oldStore ->
                    event.getEntity().getCapability(TWPlayerSignStrengthProvider.Instance).ifPresent(newStore -> newStore.copy(oldStore)));
            event.getOriginal().getCapability(TWPlayerMaxEnergyProvider.Instance).ifPresent(oldStore ->
                    event.getEntity().getCapability(TWPlayerMaxEnergyProvider.Instance).ifPresent(newStore -> newStore.copy(oldStore)));
        }
    }

    @SubscribeEvent
    public static void attachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof Player){
            if(!event.getObject().getCapability(TWPlayerEnergyProvider.Instance).isPresent()) {
                event.addCapability(TWUtil.location(TWPlayerEnergy.NBT_ID), new TWPlayerEnergyProvider());
            }
            if(!event.getObject().getCapability(TWPlayerMaxEnergyProvider.Instance).isPresent()) {
                event.addCapability(TWUtil.location(TWPlayerMaxEnergy.NBT_ID), new TWPlayerMaxEnergyProvider());
            }
            if(!event.getObject().getCapability(TWPlayerSignStrengthProvider.Instance).isPresent()) {
                event.addCapability(TWUtil.location(TWPlayerSignStrength.NBT_ID), new TWPlayerSignStrengthProvider());
            }
        }
    }

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event){
        event.register(TWPlayerSignStrength.class);
    }

    @SubscribeEvent
    public static void entityJoinLevel(EntityJoinLevelEvent event){
        if(!event.getLevel().isClientSide()){
            if(event.getEntity() instanceof ServerPlayer player){
                player.getCapability(TWPlayerEnergyProvider.Instance).ifPresent(energy -> TWMessages.sendToPlayer(new TWPlayerEnergySyncS2CPacket(energy.get()), player));
                player.getCapability(TWPlayerMaxEnergyProvider.Instance).ifPresent(maxEnergy -> TWMessages.sendToPlayer(new TWPlayerMaxEnergySyncS2CPacket(maxEnergy.get()), player));
                player.getCapability(TWPlayerSignStrengthProvider.Instance).ifPresent(signStrength -> TWMessages.sendToPlayer(new TWPlayerSignStrengthSyncS2CPacket(signStrength.get()), player));
            }
        }
    }
}