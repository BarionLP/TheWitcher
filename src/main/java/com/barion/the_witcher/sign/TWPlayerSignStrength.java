package com.barion.the_witcher.sign;

import com.barion.the_witcher.networking.TWMessages;
import com.barion.the_witcher.networking.packet.TWPlayerEnergySyncS2CPacket;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class TWPlayerSignStrength {
    private int strength = 0;
    public static final int maxStrength = 5;
    public static final int minStrength = 0;
    public static final String NBT_ID = "sign_strength";

    public int get() {return strength;}

    public void increase(ServerPlayer player){
        strength = Math.min(strength+1, maxStrength);
        sync(player);
        updateMaxEnergy(player);
    }
    public void set(int val, ServerPlayer player){
        strength = Math.max(minStrength, Math.min(val, maxStrength));
        sync(player);
        updateMaxEnergy(player);
    }
    private void sync(ServerPlayer player) {TWMessages.sendToPlayer(new TWPlayerEnergySyncS2CPacket(strength), player);}
    private void updateMaxEnergy(ServerPlayer player){
        player.getCapability(TWPlayerMaxEnergyProvider.Instance).ifPresent(maxEnergy-> {
            if(get() == 0){
                maxEnergy.set(0, player);
                return;
            }
            maxEnergy.set(90 + get() * 10, player);
        });
    }
    public boolean isMax() {return strength == maxStrength;}
    public boolean canUpgrade(Player player, Level level){
        return !isMax();
    }


    public void saveToNBT(CompoundTag nbt) {nbt.putInt(NBT_ID, strength);}
    public void loadFromNBT(CompoundTag nbt) {strength = nbt.getInt(NBT_ID);}

    public void copy(TWPlayerSignStrength from) {strength = from.get();}
}