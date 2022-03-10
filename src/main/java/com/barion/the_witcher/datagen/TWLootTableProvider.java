package com.barion.the_witcher.datagen;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.TWBlocks;
import com.barion.the_witcher.world.TWItems;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.ChestLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.*;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TWLootTableProvider extends LootTableProvider {
    public TWLootTableProvider(DataGenerator generator) {super(generator);}

    public static class TWBlockLoot extends BlockLoot{
        @Override
        protected void addTables() {
            dropSelf(TWBlocks.SilverBlock.get(),
                    TWBlocks.RawSilverBlock.get(),

                    TWBlocks.FrostedStoneStairs.get(),
                    TWBlocks.FrostedStoneSlab.get(),
                    TWBlocks.FrostedStoneWall.get(),
                    TWBlocks.FrostedCobblestone.get(),
                    TWBlocks.FrostedCobblestoneStairs.get(),
                    TWBlocks.FrostedCobblestoneSlab.get(),
                    TWBlocks.FrostedCobblestoneWall.get(),

                    TWBlocks.DeepFrostedCobblestone.get());

            dropOther(TWBlocks.FrostedStone.get(), TWBlocks.FrostedCobblestone.get());
            dropOther(TWBlocks.DeepFrostedStone.get(), TWBlocks.DeepFrostedCobblestone.get());
            dropOreLoot(TWBlocks.SilverOre.get(), TWItems.RawSilver.get());
            dropOreLoot(TWBlocks.DeepslateSilverOre.get(), TWItems.RawSilver.get());
        }

        @SafeVarargs private <T extends Block> void dropSelf(T... Blocks) {for(Block Block : Blocks) {dropSelf(Block);}}
        private void dropOreLoot(Block ore, Item rawOre) {add(ore, createOreDrop(ore, rawOre));}
        @Override @Nonnull protected Iterable<Block> getKnownBlocks() {return TWBlocks.Registry.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());}
    }

    public static class TWChestLoot extends ChestLoot{
        @Override @ParametersAreNonnullByDefault
        public void accept(BiConsumer<ResourceLocation, LootTable.Builder> lootTable) {
            {
                lootTable.accept(location("white_frost_portal"), LootTable.lootTable()
                        .withPool(lootPool(one())
                                .add(lootItem(Items.FLINT_AND_STEEL, 1, one())))
                        .withPool(lootPool(lootNumber(4, 8))
                                .add(lootItem(Blocks.ICE, 20, lootNumber(3, 5)))
                                .add(lootItem(TWItems.SilverNugget.get(), 8, lootNumber(1, 3)))
                                .add(lootItem(TWItems.RawSilver.get(), 5, lootNumber(0, 1)))
                                .add(lootItem(TWItems.SilverIngot.get(), 4, lootNumber(0, 1)))
                                .add(lootItem(TWItems.SteelNugget.get(), 1, lootNumber(0, 3)))
                                .add(potion(1, Potions.STRENGTH, lootNumber(0, 1)))));
            } //White Frost Portal
        }

        private LootPoolEntryContainer.Builder<?> lootItem(ItemLike item, int weight, NumberProvider amount){
            return LootItem.lootTableItem(item).setWeight(weight).apply(SetItemCountFunction.setCount(amount));
        }
        private LootPoolEntryContainer.Builder<?> enchantedLootItem(Item item, int weight, NumberProvider enchant, NumberProvider amount){
            return LootItem.lootTableItem(item).setWeight(weight).apply(SetItemCountFunction.setCount(amount)).apply(EnchantWithLevelsFunction.enchantWithLevels(enchant));
        }
        private LootPoolEntryContainer.Builder<?> enchantedLootItem(Item item, int weight, NumberProvider amount){
            return LootItem.lootTableItem(item).setWeight(weight).apply(SetItemCountFunction.setCount(amount)).apply(EnchantRandomlyFunction.randomApplicableEnchantment());
        }
        private LootPoolEntryContainer.Builder<?> suspiciousStew(int weight, NumberProvider amount){
            return LootItem.lootTableItem(Items.SUSPICIOUS_STEW).setWeight(weight).apply(SetItemCountFunction.setCount(amount)).apply(SetStewEffectFunction.stewEffect().withEffect(MobEffects.NIGHT_VISION, lootNumber(7, 10)).withEffect(MobEffects.JUMP, lootNumber(7, 10)).withEffect(MobEffects.WEAKNESS, lootNumber(6, 8)).withEffect(MobEffects.BLINDNESS, lootNumber(5, 7)).withEffect(MobEffects.POISON, lootNumber(10, 20)).withEffect(MobEffects.SATURATION, lootNumber(7, 10)));
        }
        private LootPoolEntryContainer.Builder<?> potion(int weight, Potion potion, NumberProvider amount){
            return LootItem.lootTableItem(Items.POTION).setWeight(weight).apply(SetItemCountFunction.setCount(amount)).apply(SetPotionFunction.setPotion(potion));
        }

        private NumberProvider one() {return ConstantValue.exactly(1);}
        private NumberProvider lootNumber(int amount) {return ConstantValue.exactly(amount);}
        private NumberProvider lootNumber(int minAmount, int maxAmount) {return UniformGenerator.between(minAmount, maxAmount);}

        private LootPool.Builder lootPool(NumberProvider rolls) {return LootPool.lootPool().setRolls(rolls);}

        private static ResourceLocation location(String name) {return new ResourceLocation(TheWitcher.ModID, "chests/" + name);}
    }

    @Override @Nonnull
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {return ImmutableList.of(Pair.of(TWBlockLoot::new, LootContextParamSets.BLOCK), Pair.of(TWChestLoot::new, LootContextParamSets.CHEST));}
    @Override @ParametersAreNonnullByDefault
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationContext) {map.forEach((location, lootTable) -> LootTables.validate(validationContext, location, lootTable));}
}