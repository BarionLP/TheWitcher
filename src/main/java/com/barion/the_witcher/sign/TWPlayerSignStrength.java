package com.barion.the_witcher.sign;

import net.minecraft.nbt.CompoundTag;

public class TWPlayerSignStrength {
    private int strength = 0;
    private static final int maxStrength = 5;
    private static final int minStrength = 0;
    public static final String NBT_ID = "sign_strength";

    public int get() {return strength;}

    public void increase() {strength = Math.min(strength+1, maxStrength);}
    public void set(int val) {strength = Math.max(minStrength, Math.min(val, maxStrength));}

    public void saveToNBT(CompoundTag nbt) {nbt.putInt(NBT_ID, strength);}
    public void loadFromNBT(CompoundTag nbt) {strength = nbt.getInt(NBT_ID);}

    public void copy(TWPlayerSignStrength from) {strength = from.get();}
}