package com.barion.the_witcher.stuff;

import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class TWUtil {
    public static final CreativeModeTab TheWitcherTab = new TheWitcherTab();

    public static class Tiers{
        public static final Tier Silver = new SilverTier();
        public static final Tier Steel = new SteelTier();
        private static class SilverTier implements Tier {
            @Override
            public int getUses() {
                return 1000;
            }

            @Override
            public float getSpeed() {
                return 0;
            }

            @Override
            public float getAttackDamageBonus() {
                return 1;
            }

            @Override
            public int getLevel() {
                return 2;
            }

            @Override
            public int getEnchantmentValue() {
                return 20;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(TWItems.SilverIngot.get());
            }
        }
        private static class SteelTier implements Tier{

            @Override
            public int getUses() {
                return 2500;
            }

            @Override
            public float getSpeed() {
                return -2;
            }

            @Override
            public float getAttackDamageBonus() {
                return 9;
            }

            @Override
            public int getLevel() {
                return 5;
            }

            @Override
            public int getEnchantmentValue() {
                return 20;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(TWItems.SteelIngot.get());
            }
        }
    }

    public static class Swords{
        public static class Silver extends SwordItem {
            private final int DamageBonus;
            public Silver(Tier tier, int damageBonus, float speed, Properties properties) {
                super(tier, 0, speed, properties);
                DamageBonus = damageBonus;
            }

            @Override
            public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
                if(TWTags.Entities.MagicMob.contains(entity.getType())){
                    entity.hurt(DamageSource.GENERIC, DamageBonus);
                }
                return false;
            }

            @Override @ParametersAreNonnullByDefault
            public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> components, TooltipFlag flag) {
                super.appendHoverText(item, level, components, flag);
                components.add(new TranslatableComponent(item.getDescriptionId() + ".info"));
            }
        }
    }

    private static class TheWitcherTab extends CreativeModeTab {
        public TheWitcherTab() {
            super("the_witcher");
        }

        @Override
        public void fillItemList(NonNullList<ItemStack> items) {
            items.add(TWBlocks.SilverOre.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepslateSilverOre.get().asItem().getDefaultInstance());
            items.add(TWBlocks.RawSilverBlock.get().asItem().getDefaultInstance());
            items.add(TWItems.RawSilver.get().getDefaultInstance());
            items.add(TWBlocks.SilverBlock.get().asItem().getDefaultInstance());
            items.add(TWItems.SilverIngot.get().getDefaultInstance());
            items.add(TWItems.SilverNugget.get().getDefaultInstance());
            items.add(TWItems.SilverSword.get().getDefaultInstance());
            items.add(TWItems.MasterfulSilverSword.get().getDefaultInstance());

            items.add(TWItems.SteelIngot.get().getDefaultInstance());
            items.add(TWItems.SteelNugget.get().getDefaultInstance());
        }

        @Override
        public ItemStack makeIcon() {
            return TWItems.TabLogo.get().getDefaultInstance();
        }
    }
}