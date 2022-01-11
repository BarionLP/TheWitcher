package com.barion.the_witcher.world.stuff;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class TWBaseTier implements Tier {
    private final float dmgBonus, speed;
    private final int enchant, harvestLvl, durability;
    private final Supplier<Ingredient> repairIng;

    public TWBaseTier(float dmg, float speed, int enchant, int harvestLvl, int durability, Supplier<Ingredient> repairIng){
        this.dmgBonus = dmg;
        this.speed = speed;
        this.enchant = enchant;
        this.harvestLvl = harvestLvl;
        this.durability = durability;
        this.repairIng = repairIng;
    }

    @Override
    public int getUses() {
        return durability;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return dmgBonus;
    }

    @Override
    public int getLevel() {
        return harvestLvl;
    }

    @Override
    public int getEnchantmentValue() {
        return enchant;
    }

    @Override @NotNull
    public Ingredient getRepairIngredient() {
        return repairIng.get();
    }
}
