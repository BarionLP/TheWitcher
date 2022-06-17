package com.barion.the_witcher.world.item;

import com.barion.the_witcher.world.gen.util.TWDamageSources;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

public class TWHotWaterBottleItem extends Item {
    public TWHotWaterBottleItem(Properties properties) {
        super(properties);
    }

    @Override @ParametersAreNonnullByDefault
    public @NotNull ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity entity) {
        super.finishUsingItem(itemStack, level, entity);
        if (entity instanceof ServerPlayer serverplayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, itemStack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (!level.isClientSide) {
            entity.hurt(TWDamageSources.HotWater, 10);
        }

        if (itemStack.isEmpty()) {
            return new ItemStack(Items.GLASS_BOTTLE);
        } else {
            if (entity instanceof Player player && !((Player)entity).getAbilities().instabuild) {
                ItemStack itemstack = new ItemStack(Items.GLASS_BOTTLE);
                if (!player.getInventory().add(itemstack)) {
                    player.drop(itemstack, false);
                }
            }

            return itemStack;
        }
    }

    @Override public int getUseDuration(@NotNull ItemStack itemStack) {return 40;}
    @Override public @NotNull UseAnim getUseAnimation(@NotNull ItemStack p_41358_) {return UseAnim.DRINK;}
    @Override public @NotNull SoundEvent getDrinkingSound() {return SoundEvents.HONEY_DRINK;}
    @Override public @NotNull SoundEvent getEatingSound() {return SoundEvents.HONEY_DRINK;}

    @Override public @NotNull @ParametersAreNonnullByDefault InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {return ItemUtils.startUsingInstantly(level, player, hand);}
}