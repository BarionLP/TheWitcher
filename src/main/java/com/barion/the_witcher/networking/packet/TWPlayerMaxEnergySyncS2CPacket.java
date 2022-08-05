package com.barion.the_witcher.networking.packet;

import com.barion.the_witcher.client.TWPlayerEnergyData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class TWPlayerMaxEnergySyncS2CPacket {
    private final int maxEnergy;

    public TWPlayerMaxEnergySyncS2CPacket(int maxEnergy) {this.maxEnergy = maxEnergy;}
    public TWPlayerMaxEnergySyncS2CPacket(FriendlyByteBuf buf) {this.maxEnergy = buf.readInt();}
    public void toBytes(FriendlyByteBuf buf) {buf.writeInt(maxEnergy);}

    public boolean handle(Supplier<NetworkEvent.Context> contextSupplier){
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(()-> {
            // on Client
            TWPlayerEnergyData.setMax(maxEnergy);
        });
        return true;
    }
}