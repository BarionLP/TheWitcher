package com.barion.the_witcher.world.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

public class TWIceGhostEntity extends Monster {
    public TWIceGhostEntity(EntityType<TWIceGhostEntity> type, Level level) {super(type, level);}

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        goalSelector.addGoal(2, new WaterAvoidingRandomFlyingGoal(this, 0.8));
        goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false));

        targetSelector.addGoal(1, new HurtByTargetGoal(this));
        targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, LivingEntity.class, false));
    }

    @NotNull
    public static AttributeSupplier.Builder createAttributes(){
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.2)
                .add(Attributes.ATTACK_DAMAGE, 3)
                .add(Attributes.ATTACK_KNOCKBACK, 0.1)
                .add(Attributes.FOLLOW_RANGE, 20);
    }


    @Override
    public boolean causeFallDamage(float p_147105_, float p_147106_, @NotNull DamageSource p_147107_) {return false;}
    @Override
    protected void checkFallDamage(double p_20809_, boolean p_20810_, @NotNull BlockState p_20811_, @NotNull BlockPos p_20812_) {}
    @Override @ParametersAreNonnullByDefault
    protected int getExperienceReward(Player player) {return 5 + level.random.nextInt(5);}
    @Override @ParametersAreNonnullByDefault
    public boolean isPreventingPlayerRest(Player player) {return true;}
}