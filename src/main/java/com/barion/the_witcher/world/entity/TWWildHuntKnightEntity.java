package com.barion.the_witcher.world.entity;

import com.barion.the_witcher.util.TWTags;
import com.barion.the_witcher.world.TWItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

public class TWWildHuntKnightEntity extends Monster implements TWWildHuntEntity{
    public TWWildHuntKnightEntity(EntityType<TWWildHuntKnightEntity> entity, Level level) {super(entity, level);}

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        goalSelector.addGoal(2, new RandomStrollGoal(this, 0.8));
        goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false));

        targetSelector.addGoal(1, new HurtByTargetGoal(this));
        targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, LivingEntity.class, false, (entity) -> !entity.getType().is(TWTags.Entities.WildHuntIgnore)));
    }

    @NotNull
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 28)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.ATTACK_DAMAGE, 2);
    }

    @Override @ParametersAreNonnullByDefault
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag tag) {
        populateDefaultEquipmentSlots(difficulty);
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData, tag);
    }

    @Override
    protected void populateDefaultEquipmentSlots(@NotNull DifficultyInstance difficulty) {
        populateEquipmentSlot(EquipmentSlot.HEAD);
        populateEquipmentSlot(EquipmentSlot.CHEST);
        populateEquipmentSlot(EquipmentSlot.LEGS);
        populateEquipmentSlot(EquipmentSlot.FEET);
        setItemSlot(EquipmentSlot.MAINHAND, getEquipmentItemForSlot(EquipmentSlot.MAINHAND, random.nextInt(3) > 0));
        if(random.nextInt(3) == 2){
            setItemSlot(EquipmentSlot.OFFHAND, getEquipmentItemForSlot(EquipmentSlot.OFFHAND, false));
        }
    }

    protected void populateEquipmentSlot(EquipmentSlot slot){
        int chance = random.nextInt(5);
        if(chance <=  1) {return;}

        setItemSlot(slot, getEquipmentItemForSlot(slot, chance == 4));
    }

    protected ItemStack getEquipmentItemForSlot(EquipmentSlot slot, boolean isRare){
        if(isRare){
            switch(slot){
                case HEAD -> {return new ItemStack(TWItems.ReinforcedLeatherHelmet.get());}
                case CHEST -> {return new ItemStack(TWItems.ReinforcedLeatherChestplate.get());}
                case LEGS -> {return new ItemStack(TWItems.ReinforcedLeatherLeggings.get());}
                case FEET -> {return new ItemStack(TWItems.ReinforcedLeatherBoots.get());}
                case MAINHAND -> {return new ItemStack(TWItems.SteelSword.get());}
                case OFFHAND -> {return new ItemStack(Items.SHIELD);}
            }
        }else {
            switch(slot){
                case HEAD -> {return new ItemStack(Items.IRON_HELMET);}
                case CHEST -> {return new ItemStack(Items.IRON_CHESTPLATE);}
                case LEGS -> {return new ItemStack(Items.IRON_LEGGINGS);}
                case FEET -> {return new ItemStack(Items.IRON_BOOTS);}
                case MAINHAND -> {return new ItemStack(Items.IRON_SWORD);}
                case OFFHAND -> {return new ItemStack(Items.SHIELD);}
            }
        }
        return ItemStack.EMPTY;
    }
}