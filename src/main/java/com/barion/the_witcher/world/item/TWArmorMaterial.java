package com.barion.the_witcher.world.item;

import com.barion.the_witcher.world.TWItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum TWArmorMaterial implements ArmorMaterial {
    ReinforcedLeather("reinforced_leather", 41, new int[]{3, 7, 9, 4}, 19, SoundEvents.ARMOR_EQUIP_LEATHER, 3, 0.1f, () -> Ingredient.of(TWItems.SteelIngot.get()));
    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    TWArmorMaterial(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.slotProtections = slotProtections;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }

    @Override public int getDurabilityForSlot(EquipmentSlot slot) {return HEALTH_PER_SLOT[slot.getIndex()] * durabilityMultiplier;}
    @Override public int getDefenseForSlot(EquipmentSlot slot) {return this.slotProtections[slot.getIndex()];}
    @Override public int getEnchantmentValue() {return this.enchantmentValue;}
    @Override public @NotNull SoundEvent getEquipSound() {return this.sound;}
    @Override public @NotNull Ingredient getRepairIngredient() {return this.repairIngredient.get();}
    @Override public @NotNull String getName() {return this.name;}
    @Override public float getToughness() {return this.toughness;}
    @Override public float getKnockbackResistance() {return this.knockbackResistance;}
}