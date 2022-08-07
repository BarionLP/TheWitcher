package com.barion.the_witcher.networking.packet;

import com.barion.the_witcher.capability.TWPlayerEnergyProvider;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.Objects;
import java.util.function.Supplier;

public class TWSetPlayerEnergyC2SPacket {
    private final int energy;

    public TWSetPlayerEnergyC2SPacket(int energy) {this.energy = energy;}
    public TWSetPlayerEnergyC2SPacket(FriendlyByteBuf buf) {this.energy = buf.readInt();}
    public void toBytes(FriendlyByteBuf buf) {buf.writeInt(energy);}

    public boolean handle(Supplier<NetworkEvent.Context> contextSupplier){
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(()-> {
            // on Server
            Objects.requireNonNull(context.getSender()).getCapability(TWPlayerEnergyProvider.Instance).ifPresent(energy-> energy.set(this.energy, context.getSender()));
        });
        return true;
    }
}