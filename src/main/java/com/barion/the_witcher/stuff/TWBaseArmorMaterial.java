package com.barion.the_witcher.stuff;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Supplier;

public class TWBaseArmorMaterial implements ArmorMaterial {

    private final int enchant, durabilityMultiplier;
    private static final int[] baseDurability = new int[]{13, 15, 16, 11};
    private final int[] protections;
    private final float knockbackResi, toughness;
    private final String name;
    private final SoundEvent sound;
    private final Supplier<Ingredient> repairIng;

    public TWBaseArmorMaterial(String name, int durabilityMulit, int[] protections, float knockbackResi, float toughness, int enchant, SoundEvent sound, Ingredient repairIng){
        this.name = name;
        this.durabilityMultiplier = durabilityMulit;
        this.protections = protections;
        this.knockbackResi = knockbackResi;
        this.toughness = toughness;
        this.enchant = enchant;
        this.sound = sound;
        this.repairIng = () -> repairIng;
    }

    @Override @ParametersAreNonnullByDefault
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return baseDurability[slot.getIndex()] * durabilityMultiplier;
    }

    @Override @ParametersAreNonnullByDefault
    public int getDefenseForSlot(EquipmentSlot slot) {
        return protections[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchant;
    }

    @Override
    public SoundEvent getEquipSound() {
        return sound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIng.get();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResi;
    }
}
