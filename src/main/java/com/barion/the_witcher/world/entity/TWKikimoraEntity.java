package com.barion.the_witcher.world.entity;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

public class TWKikimoraEntity extends Spider {
    public TWKikimoraEntity(EntityType<? extends Spider> type, Level level) {super(type, level);}

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
        goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, false));
        goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Animal.class, false));
        goalSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(getClass()));
        goalSelector.addGoal(1, new RandomStrollGoal(this, 0.8));
        goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        goalSelector.addGoal(1, new FloatGoal(this));
    }
    @NotNull
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
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

    @Override @ParametersAreNonnullByDefault
    public boolean doHurtTarget(Entity entity){
        if(!super.doHurtTarget(entity)){
            return false;
        }
        if(entity instanceof LivingEntity){
            ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.POISON, 200, 2));
        }
        return true;
    }
}