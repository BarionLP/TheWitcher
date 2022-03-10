package com.barion.the_witcher;

import com.barion.the_witcher.world.TWBlocks;
import com.barion.the_witcher.world.TWItems;
import com.barion.the_witcher.world.util.TWBaseArmorMaterial;
import com.barion.the_witcher.world.util.TWBaseTier;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class TWUtil {
    public static final CreativeModeTab TheWitcherTab = new TheWitcherTab();

    public static class Tiers{
        public static final Tier Silver = new TWBaseTier(1, 0, 20, 2, 1000, ()-> Ingredient.of(TWTags.Items.SilverIngots));
        public static final Tier Steel = new TWBaseTier(9, -2, 20, 5, 2500, ()-> Ingredient.of(TWTags.Items.SteelIngots));
    }

    public static class ArmorMaterials{
        public static final TWBaseArmorMaterial ReinforcedLeather = new TWBaseArmorMaterial("reinforced_leather_armor", 45, new int[] {4, 7, 9, 4}, 0.1f, 3, 20, SoundEvents.ARMOR_EQUIP_LEATHER, Ingredient.of(TWTags.Items.SteelIngots));
    }

    public static class Swords{
        public static class Silver extends SwordItem {
            private final int DamageBonus;
            public Silver(Tier tier, int damageBonus, float speed, Properties properties) {
                super(tier, 0, speed, properties);
                DamageBonus = damageBonus;
            }

            /*@Override
            public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
                if(TWTags.Entities.MagicMob.contains(entity.getType())){
                    entity.hurt(DamageSource.GENERIC, DamageBonus);
                }
                return true;
            }*/

            @Override @ParametersAreNonnullByDefault
            public boolean hurtEnemy(ItemStack itemStack, LivingEntity attacker, LivingEntity target) {
                if(target.getType().is(TWTags.Entities.MagicMob)){
                    target.hurt(DamageSource.GENERIC, DamageBonus);
                }
                return super.hurtEnemy(itemStack, attacker, target);
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

            items.add(TWBlocks.FrostedStone.get().asItem().getDefaultInstance());
            items.add(TWBlocks.FrostedCobblestone.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedStone.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedCobblestone.get().asItem().getDefaultInstance());
        }

        @Override @Nonnull
        public ItemStack makeIcon() {
            return TWItems.TabLogo.get().getDefaultInstance();
        }
    }

    public static ResourceLocation createResourceLocation(String key){
        return new ResourceLocation(TheWitcher.ModID, key);
    }
}