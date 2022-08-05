package com.barion.the_witcher.sign;

import com.barion.the_witcher.networking.TWMessages;
import com.barion.the_witcher.networking.packet.TWPlayerMaxEnergySyncS2CPacket;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;

public class TWPlayerMaxEnergy {
    private int maxEnergy = 100;
    public static final String NBT_ID = "max_energy";

    public int get() {return maxEnergy;}
    public void set(int val, ServerPlayer player){
        maxEnergy = val;
        sync(player);
        updateEnergy(player);
    }

    private void updateEnergy(ServerPlayer player){
        player.getCapability(TWPlayerEnergyProvider.Instance).ifPresent(energy-> {
            if(energy.get() > get()){
                energy.set(maxEnergy, player);
            }
        });
    }
    private void sync(ServerPlayer player) {TWMessages.sendToPlayer(new TWPlayerMaxEnergySyncS2CPacket(maxEnergy), player);}

    public void saveToNBT(CompoundTag nbt) {nbt.putInt(NBT_ID, maxEnergy);}
    public void loadFromNBT(CompoundTag nbt) {maxEnergy = nbt.getInt(NBT_ID);}
    public void copy(TWPlayerMaxEnergy from) {maxEnergy = from.get();}
}