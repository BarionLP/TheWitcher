package com.barion.the_witcher.networking;

import com.barion.the_witcher.networking.packet.TWPlayerEnergySyncS2CPacket;
import com.barion.the_witcher.networking.packet.TWPlayerMaxEnergySyncS2CPacket;
import com.barion.the_witcher.networking.packet.TWPlayerSignStrengthSyncS2CPacket;
import com.barion.the_witcher.networking.packet.TWSetPlayerEnergyC2SPacket;
import com.barion.the_witcher.util.TWUtil;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class TWMessages {
    private static SimpleChannel Instance;
    private static int packetID = 0;
    private static int id() {return packetID++;}

    public static void register(){
        Instance = NetworkRegistry.ChannelBuilder
                .named(TWUtil.location("messages"))
                .networkProtocolVersion(()-> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        Instance.messageBuilder(TWSetPlayerEnergyC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(TWSetPlayerEnergyC2SPacket::new)
                .encoder(TWSetPlayerEnergyC2SPacket::toBytes)
                .consumerMainThread(TWSetPlayerEnergyC2SPacket::handle)
                .add();

        Instance.messageBuilder(TWPlayerEnergySyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(TWPlayerEnergySyncS2CPacket::new)
                .encoder(TWPlayerEnergySyncS2CPacket::toBytes)
                .consumerMainThread(TWPlayerEnergySyncS2CPacket::handle)
                .add();
        Instance.messageBuilder(TWPlayerMaxEnergySyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(TWPlayerMaxEnergySyncS2CPacket::new)
                .encoder(TWPlayerMaxEnergySyncS2CPacket::toBytes)
                .consumerMainThread(TWPlayerMaxEnergySyncS2CPacket::handle)
                .add();
        Instance.messageBuilder(TWPlayerSignStrengthSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(TWPlayerSignStrengthSyncS2CPacket::new)
                .encoder(TWPlayerSignStrengthSyncS2CPacket::toBytes)
                .consumerMainThread(TWPlayerSignStrengthSyncS2CPacket::handle)
                .add();

    }

    public static <MSG> void sendToServer(MSG message) {Instance.sendToServer(message);}
    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {Instance.send(PacketDistributor.PLAYER.with(()-> player), message);}
}