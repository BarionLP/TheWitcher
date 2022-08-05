package com.barion.the_witcher.networking.packet;

import com.barion.the_witcher.client.TWPlayerSignStrengthData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class TWPlayerSignStrengthSyncS2CPacket {
    private final int signStrength;

    public TWPlayerSignStrengthSyncS2CPacket(int signStrength) {this.signStrength = signStrength;}
    public TWPlayerSignStrengthSyncS2CPacket(FriendlyByteBuf buf) {this.signStrength = buf.readInt();}
    public void toBytes(FriendlyByteBuf buf) {buf.writeInt(signStrength);}

    public boolean handle(Supplier<NetworkEvent.Context> contextSupplier){
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(()-> {
            // on Client
            TWPlayerSignStrengthData.set(signStrength);
        });
        return true;
    }
}