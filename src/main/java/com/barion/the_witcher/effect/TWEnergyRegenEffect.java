package com.barion.the_witcher.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class TWEnergyRegenEffect extends MobEffect {
    protected TWEnergyRegenEffect() {super(MobEffectCategory.BENEFICIAL, -103);}

    @Override
    public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {}
    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {return true;}
}