package com.barion.the_witcher.sign;

import com.barion.the_witcher.networking.TWMessages;
import com.barion.the_witcher.networking.packet.TWPlayerEnergySyncS2CPacket;
import com.barion.the_witcher.util.TWUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

public class TWPlayerEnergy {
    private int energy = 0;
    private static final int minEnergy = 0;
    public static final String NBT_ID = "energy";

    public int get() {return energy;}

    public void increase(int by, ServerPlayer player){
        energy = Math.min(energy + by, getMax(player));
        sync(player);
    }
    public void decrease(int sub, ServerPlayer player){
        energy = Math.max(minEnergy, energy - sub);
        sync(player);
    }
    public void set(int val, ServerPlayer player){
        energy = Math.max(minEnergy, Math.min(val, getMax(player)));
        sync(player);
    }
    private void sync(ServerPlayer player) {TWMessages.sendToPlayer(new TWPlayerEnergySyncS2CPacket(energy), player);}

    public void saveToNBT(CompoundTag nbt) {nbt.putInt(NBT_ID, energy);}
    public void loadFromNBT(CompoundTag nbt) {energy = nbt.getInt(NBT_ID);}
    public void copy(TWPlayerEnergy from) {energy = from.get();}

    public int getMax(Player player) {
        if(player.getCapability(TWPlayerMaxEnergyProvider.Instance).resolve().isEmpty()){
            TWUtil.Logger.warn(player.getName().getString() + " has no max energy!");
            return 100;
        }
        return player.getCapability(TWPlayerMaxEnergyProvider.Instance).resolve().get().get();
    }

    public boolean isFull(Player player) {return get() >= getMax(player);}
}