package com.barion.the_witcher.sign;

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

public class TWPlayerEnergyProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<TWPlayerEnergy> Instance = CapabilityManager.get(new CapabilityToken<>() {});

    private TWPlayerEnergy energy = null;
    private final LazyOptional<TWPlayerEnergy> optional = LazyOptional.of(this::get);

    private TWPlayerEnergy get() {
        if(energy == null){
            energy = new TWPlayerEnergy();
        }

        return energy;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == Instance){
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT(){
        CompoundTag nbt = new CompoundTag();
        get().saveToNBT(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        get().loadFromNBT(nbt);}
}