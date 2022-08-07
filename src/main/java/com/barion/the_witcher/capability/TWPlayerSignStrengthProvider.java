package com.barion.the_witcher.capability;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TWPlayerSignStrengthProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<TWPlayerSignStrength> Instance = CapabilityManager.get(new CapabilityToken<>() {});

    private TWPlayerSignStrength signStrength = null;
    private final LazyOptional<TWPlayerSignStrength> optional = LazyOptional.of(this::get);

    private TWPlayerSignStrength get() {
        if(signStrength == null){
            signStrength = new TWPlayerSignStrength();
        }

        return signStrength;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == Instance){
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        get().saveToNBT(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        get().loadFromNBT(nbt);}
}