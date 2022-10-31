package com.barion.the_witcher.world.item;

import com.ametrinstudios.ametrin.AmetrinUtil;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class TWFoods {
    public static final FoodProperties HotWaterBottle = new FoodProperties.Builder().alwaysEat().nutrition(0).saturationMod(0).build();
    public static final FoodProperties Beer = new FoodProperties.Builder().alwaysEat().nutrition(6).saturationMod(0.1f).effect(()-> new MobEffectInstance(MobEffects.CONFUSION, AmetrinUtil.SecondsToTicks(10)), 1).build();
}