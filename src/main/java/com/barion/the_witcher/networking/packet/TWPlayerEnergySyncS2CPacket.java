package com.barion.the_witcher.networking.packet;

import com.barion.the_witcher.client.TWPlayerEnergyData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class TWPlayerEnergySyncS2CPacket {
    private final float energy;

    public TWPlayerEnergySyncS2CPacket(float energy) {this.energy = energy;}
    public TWPlayerEnergySyncS2CPacket(FriendlyByteBuf buf) {this.energy = buf.readFloat();}
    public void toBytes(FriendlyByteBuf buf) {buf.writeFloat(energy);}

    public boolean handle(Supplier<NetworkEvent.Context> contextSupplier){
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(()-> {
            // on Client
            TWPlayerEnergyData.set(energy);
        });
        return true;
    }
}