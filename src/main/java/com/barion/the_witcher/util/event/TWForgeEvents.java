package com.barion.the_witcher.util.event;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.capability.*;
import com.barion.the_witcher.command.TWGetEnergyCommand;
import com.barion.the_witcher.command.TWGetSignStrengthCommand;
import com.barion.the_witcher.command.TWSetEnergyCommand;
import com.barion.the_witcher.command.TWSetSignStrengthCommand;
import com.barion.the_witcher.effect.TWEffects;
import com.barion.the_witcher.networking.TWMessages;
import com.barion.the_witcher.networking.packet.TWPlayerEnergySyncS2CPacket;
import com.barion.the_witcher.networking.packet.TWPlayerMaxEnergySyncS2CPacket;
import com.barion.the_witcher.networking.packet.TWPlayerSignStrengthSyncS2CPacket;
import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.gen.TWLevels;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = TheWitcher.ModID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TWForgeEvents{
    @SubscribeEvent
    public static void entityTick(final LivingEvent.LivingTickEvent event){
        LivingEntity entity = event.getEntity();
        if(entity == null) {return;}

        if(entity.level.dimension() == TWLevels.WhiteFrost && !entity.hasEffect(TWEffects.FrostResistance.get())){
            if(entity instanceof Player && ((Player)entity).getAbilities().invulnerable) {return;}
            entity.setIsInPowderSnow(true);
            entity.setTicksFrozen(Math.min(entity.getTicksRequiredToFreeze()+2, entity.getTicksFrozen() + 3)); //very bad, need a better solution
        }
    }

    @SubscribeEvent
    public static void playerTick(TickEvent.PlayerTickEvent event){
        if(event.side == LogicalSide.SERVER){
            event.player.getCapability(TWPlayerEnergyProvider.Instance).ifPresent(energy -> {
                if(energy.isFull(event.player)) {return;}
                event.player.getCapability(TWPlayerSignStrengthProvider.Instance).ifPresent(signStrength-> {
                    float base = 0.2f;
                    if(event.player.hasEffect(TWEffects.EnergyRegen.get())){
                        base += (event.player.getEffect(TWEffects.EnergyRegen.get()).getAmplifier()+1)/5f;
                    }
                    energy.increase(base + (signStrength.get() / 5f), (ServerPlayer) event.player);
                });
            });
        }
    }

    @SubscribeEvent
    public static void playerCloned(PlayerEvent.Clone event) {
        if (event.isWasDeath() && event.getEntity() instanceof ServerPlayer) {
            event.getOriginal().getCapability(TWPlayerSignStrengthProvider.Instance).ifPresent(oldStore ->
                    event.getEntity().getCapability(TWPlayerSignStrengthProvider.Instance).ifPresent(newStore -> newStore.copy(oldStore, (ServerPlayer) event.getEntity())));
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
        event.register(TWPlayerEnergy.class);
        event.register(TWPlayerMaxEnergy.class);
    }

    @SubscribeEvent
    public static void playerLoggedIn(PlayerEvent.PlayerLoggedInEvent event){
        if(event.getEntity() instanceof ServerPlayer player){
            player.getCapability(TWPlayerEnergyProvider.Instance).ifPresent(energy -> TWMessages.sendToPlayer(new TWPlayerEnergySyncS2CPacket(energy.get()), player));
            player.getCapability(TWPlayerMaxEnergyProvider.Instance).ifPresent(maxEnergy -> TWMessages.sendToPlayer(new TWPlayerMaxEnergySyncS2CPacket(maxEnergy.get()), player));
            player.getCapability(TWPlayerSignStrengthProvider.Instance).ifPresent(signStrength -> TWMessages.sendToPlayer(new TWPlayerSignStrengthSyncS2CPacket(signStrength.get()), player));
        }
    }

    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event){
        new TWSetEnergyCommand(event.getDispatcher());
        new TWGetEnergyCommand(event.getDispatcher());
        new TWSetSignStrengthCommand(event.getDispatcher());
        new TWGetSignStrengthCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }
}