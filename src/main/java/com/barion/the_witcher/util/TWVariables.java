package com.barion.the_witcher.util;

import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Supplier;

public class TWVariables {

    public static void initNetwork(FMLCommonSetupEvent event){
        TWUtil.addNetworkMessage(PlayerDataSyncMessage.class, PlayerDataSyncMessage::buffer, PlayerDataSyncMessage::new, PlayerDataSyncMessage::handler);
    }

    public static void initCapabilities(RegisterCapabilitiesEvent event){
        event.register(PlayerData.class);
    }

    public static final Capability<PlayerData> PlayerDataCapability = CapabilityManager.get(new CapabilityToken<>() {});

    @Mod.EventBusSubscriber
    private static class PlayerDataProvider implements ICapabilitySerializable<Tag> {
        @SubscribeEvent
        public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
            if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer)){
                event.addCapability(TWUtil.location("player_data"), new PlayerDataProvider());
            }
        }

        private final PlayerData playerData = new PlayerData();
        private final LazyOptional<PlayerData> instance = LazyOptional.of(() -> playerData);

        @Override
        public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> cap, Direction side) {
            return cap == PlayerDataCapability ? instance.cast() : LazyOptional.empty();
        }

        @Override
        public Tag serializeNBT() {
            return playerData.writeNBT();
        }

        @Override
        public void deserializeNBT(Tag nbt) {
            playerData.readNBT(nbt);
        }
    }

    public static class PlayerData {
        public boolean JoinedFirstTime = true;
        public int SignStrength = 1;
        public int Sign = 0;
        public float Energy = 0;
        public float MaxEnergy = 100;

        public void syncPlayerVariables(Entity entity) {
            if (entity instanceof ServerPlayer serverPlayer) {
                TWUtil.PacketHandler.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerDataSyncMessage(this));
            }
        }

        public Tag writeNBT() {
            CompoundTag nbt = new CompoundTag();
            nbt.putBoolean("joined_first_time", JoinedFirstTime);
            nbt.putInt("sign_strength", SignStrength);
            nbt.putInt("sign", Sign);
            nbt.putFloat("energy", Energy);
            nbt.putFloat("max_energy", MaxEnergy);
            return nbt;
        }

        public void readNBT(Tag Tag) {
            CompoundTag nbt = (CompoundTag) Tag;
            JoinedFirstTime = nbt.getBoolean("joined_first_time");
            SignStrength = nbt.getInt("sign_strength");
            Sign = nbt.getInt("sign");
            Energy = nbt.getFloat("energy");
            MaxEnergy = nbt.getFloat("max_energy");
        }

    }

    public static class PlayerDataSyncMessage {
        public PlayerData data;

        public PlayerDataSyncMessage(FriendlyByteBuf buffer) {
            this.data = new PlayerData();
            this.data.readNBT(buffer.readNbt());
        }

        public PlayerDataSyncMessage(PlayerData data) {
            this.data = data;
        }

        public static void buffer(PlayerDataSyncMessage message, FriendlyByteBuf buffer) {
            buffer.writeNbt((CompoundTag) message.data.writeNBT());
        }

        public static void handler(PlayerDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
            NetworkEvent.Context context = contextSupplier.get();
            context.enqueueWork(() -> {
                if (!context.getDirection().getReceptionSide().isServer()) {
                    PlayerData variables = Objects.requireNonNull(Minecraft.getInstance().player).getCapability(PlayerDataCapability, null)
                            .orElse(new PlayerData());
                    variables.JoinedFirstTime = message.data.JoinedFirstTime;
                    variables.SignStrength = message.data.SignStrength;
                    variables.Sign = message.data.Sign;
                    variables.Energy = message.data.Energy;
                    variables.MaxEnergy = message.data.MaxEnergy;
                }
            });
            context.setPacketHandled(true);
        }
    }

}