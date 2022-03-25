package com.barion.the_witcher.world.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

public class TWIceGhost extends Monster implements FlyingAnimal {
    public TWIceGhost(EntityType<TWIceGhost> type, Level level) {super(type, level);}

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false));
        goalSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, false));
        goalSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Animal.class, false));
        goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        goalSelector.addGoal(1, new WaterAvoidingRandomFlyingGoal(this, 0.8));
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.2)
                .add(Attributes.ATTACK_DAMAGE, 3)
                .add(Attributes.ATTACK_KNOCKBACK, 0.1)
                .add(Attributes.FOLLOW_RANGE, 20);
    }

    @Override @ParametersAreNonnullByDefault
    protected int getExperienceReward(Player player) {return 5 + level.random.nextInt(5);}

    @Override @ParametersAreNonnullByDefault
    public boolean isPreventingPlayerRest(Player player) {return true;}

    @Override
    public boolean isFlying() {return !this.isOnGround();}
}