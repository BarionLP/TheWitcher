package com.barion.the_witcher.world.item;

import com.barion.the_witcher.world.TWItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

public class TWKikimoraToothItem extends Item {
    public TWKikimoraToothItem() {super(TWItems.Stacks16);}

    @Override @ParametersAreNonnullByDefault
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        target.addEffect(new MobEffectInstance(MobEffects.POISON, 120), attacker);
        return true;
    }
}