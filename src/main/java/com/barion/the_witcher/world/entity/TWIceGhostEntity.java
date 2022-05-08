package com.barion.the_witcher.world.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.EnumSet;

public class TWIceGhostEntity extends Monster {
    public TWIceGhostEntity(EntityType<TWIceGhostEntity> type, Level level) {
        super(type, level);
        moveControl = new GhostMoveControl(this);
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        goalSelector.addGoal(2, new GhostRandomMoveGoal());
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
    public boolean causeFallDamage(float p_147105_, float p_147106_, @NotNull DamageSource source) {return false;}
    @Override
    protected void checkFallDamage(double p_20809_, boolean p_20810_, @NotNull BlockState fallOnBlockState, @NotNull BlockPos landingPos) {}
    @Override @ParametersAreNonnullByDefault
    protected int getExperienceReward(Player player) {return 5 + level.random.nextInt(5);}
    @Override @ParametersAreNonnullByDefault
    public boolean isPreventingPlayerRest(Player player) {return true;}

    public class GhostMoveControl extends MoveControl {
        public GhostMoveControl(PathfinderMob entity) {
            super(entity);
        }

        public void tick() {
            if (this.operation == MoveControl.Operation.MOVE_TO) {
                Vec3 vec3 = new Vec3(this.wantedX - getX(), this.wantedY - getY(), this.wantedZ - getZ());
                double distance = vec3.length();
                if (distance < getBoundingBox().getSize()) {
                    this.operation = MoveControl.Operation.WAIT;
                    setDeltaMovement(getDeltaMovement().scale(0.5D));
                } else {
                    setDeltaMovement(getDeltaMovement().add(vec3.scale(this.speedModifier * 0.05D / distance)));
                    if (getTarget() == null) {
                        Vec3 vec31 = getDeltaMovement();
                        setYRot(-((float) Mth.atan2(vec31.x, vec31.z)) * (180f / (float)Math.PI));
                        yBodyRot = getYRot();
                    } else {
                        double xDist = getTarget().getX() - getX();
                        double yDist = getTarget().getZ() - getZ();
                        setYRot(-((float)Mth.atan2(xDist, yDist)) * (180f / (float)Math.PI));
                        yBodyRot = getYRot();
                    }
                }

            }
        }
    }

    public class GhostRandomMoveGoal extends Goal{
        public GhostRandomMoveGoal() {setFlags(EnumSet.of(Goal.Flag.MOVE));}

        public boolean canUse() {
            return getMoveControl().hasWanted() && random.nextInt(reducedTickDelay(7)) == 0;
        }

        public boolean canContinueToUse() {return false;}

        public void tick() {
            for(int i = 0; i < 3; ++i) {
                BlockPos targetPos = blockPosition().offset(random.nextInt(15) - 7, random.nextInt(11) - 5, random.nextInt(15) - 7);
                if (level.isEmptyBlock(targetPos)) {
                    moveControl.setWantedPosition((double)targetPos.getX() + 0.5D, (double)targetPos.getY() + 0.5D, (double)targetPos.getZ() + 0.5D, 0.25D);
                    if (getTarget() == null) {
                        getLookControl().setLookAt((double)targetPos.getX() + 0.5D, (double)targetPos.getY() + 0.5D, (double)targetPos.getZ() + 0.5D, 180f, 20f);
                    }
                    break;
                }
            }

        }
    }
}