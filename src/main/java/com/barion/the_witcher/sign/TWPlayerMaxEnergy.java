package com.barion.the_witcher.sign;

import net.minecraft.nbt.CompoundTag;

public class TWPlayerMaxEnergy {
    private int maxEnergy = 100;
    public static final String NBT_ID = "max_energy";

    public int get() {return maxEnergy;}
    public void set(int val) {maxEnergy = val;}
    public void saveToNBT(CompoundTag nbt) {nbt.putInt(NBT_ID, maxEnergy);}
    public void loadFromNBT(CompoundTag nbt) {maxEnergy = nbt.getInt(NBT_ID);}
    public void copy(TWPlayerMaxEnergy from) {maxEnergy = from.get();}
}