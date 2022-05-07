package com.barion.the_witcher.datagen;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.TWBlocks;
import com.barion.the_witcher.world.TWItems;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
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
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.*;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
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

public class TWLootTableProvider extends LootTableProvider {
    public TWLootTableProvider(DataGenerator generator) {super(generator);}

    public static class TWBlockLoot extends BlockLoot{
        @Override
        protected void addTables() {
            dropSelf(TWBlocks.SilverBlock.get(),
                    TWBlocks.RawSilverBlock.get(),
                    TWBlocks.MasterSmithingTable.get(),

                    TWBlocks.FrostedStoneStairs.get(),
                    TWBlocks.FrostedStoneSlab.get(),
                    TWBlocks.FrostedStoneWall.get(),
                    TWBlocks.FrostedCobblestone.get(),
                    TWBlocks.FrostedCobblestoneStairs.get(),
                    TWBlocks.FrostedCobblestoneSlab.get(),
                    TWBlocks.FrostedCobblestoneWall.get(),
                    TWBlocks.FrostedStoneBricks.get(),
                    TWBlocks.FrostedStoneBrickStairs.get(),
                    TWBlocks.FrostedStoneBrickSlab.get(),
                    TWBlocks.FrostedStoneBrickWall.get(),
                    TWBlocks.FrostedStoneBrickButton.get(),

                    TWBlocks.DeepFrostedStoneStairs.get(),
                    TWBlocks.DeepFrostedStoneSlab.get(),
                    TWBlocks.DeepFrostedStoneWall.get(),
                    TWBlocks.DeepFrostedCobblestone.get(),
                    TWBlocks.DeepFrostedCobblestoneStairs.get(),
                    TWBlocks.DeepFrostedCobblestoneSlab.get(),
                    TWBlocks.DeepFrostedCobblestoneWall.get(),
                    TWBlocks.DeepFrostedStoneBricks.get(),
                    TWBlocks.DeepFrostedStoneBrickStairs.get(),
                    TWBlocks.DeepFrostedStoneBrickSlab.get(),
                    TWBlocks.DeepFrostedStoneBrickWall.get(),
                    TWBlocks.DeepFrostedStoneBrickButton.get(),
                    TWBlocks.DeepFrostedStoneTiles.get(),
                    TWBlocks.DeepFrostedStoneTileStairs.get(),
                    TWBlocks.DeepFrostedStoneTileSlab.get(),
                    TWBlocks.DeepFrostedStoneTileWall.get(),
                    TWBlocks.Icicle.get()
            );

            dropOther(TWBlocks.FrostedStone.get(), TWBlocks.FrostedCobblestone.get());
            dropOther(TWBlocks.DeepFrostedStone.get(), TWBlocks.DeepFrostedCobblestone.get());

            dropBush(TWBlocks.WhiteMyrtleBush.get(), TWItems.WhiteMyrtle.get());
            dropBush(TWBlocks.CelandineBush.get(), TWItems.Celandine.get());
        }

        @SafeVarargs private <T extends Block> void dropSelf(T... Blocks) {for(Block Block : Blocks) {dropSelf(Block);}}
        private void dropBush(Block bush, ItemLike drop){
            this.add(bush, (block) -> applyExplosionDecay(block, LootTable.lootTable()
                    .withPool(LootPool.lootPool()
                            .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(bush).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3)))
                            .add(LootItem.lootTableItem(drop)).apply(SetItemCountFunction.setCount(one())).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));
        }
        private void dropOreLoot(Block ore, Item rawOre) {add(ore, createOreDrop(ore, rawOre));}
        @Override @Nonnull protected Iterable<Block> getKnownBlocks() {return TWBlocks.Registry.getEntries().stream().map(RegistryObject::get).toList();}
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
                                .add(potion(1, Potions.STRENGTH, lootNumber(0, 1)))
                        ));
            } // White Frost Portal

            {
                lootTable.accept(location("witcher_castle/brewing"), LootTable.lootTable()
                        .withPool(lootPool(lootNumber(10, 15))
                                .add(lootItem(TWItems.WhiteMyrtle.get(), 6, one()))
                                //.add(lootItem(TWItems.Beer.get(), 4, one()))
                                .add(lootItem(Items.WHEAT, 10, lootNumber(1, 4)))
                                .add(lootItem(Items.GUNPOWDER, 10, lootNumber(1, 2)))
                                .add(lootItem(Items.SPIDER_EYE, 12, lootNumber(1, 3)))
                                .add(lootItem(Items.GLOWSTONE_DUST, 2, one()))
                                //.add(lootItem(TWItems.HotWaterBottle.get(), 4, one()))
                                .add(lootItem(Items.REDSTONE, 3, one())))
                        .withPool(lootPool(lootNumber(1, 3))
                                .add(lootItem(TWItems.Celandine.get(), 2, lootNumber(1, 2)))
                                .add(lootItem(TWItems.KikimoraTooth.get(), 2, one()))
                                .add(lootItem(Items.BLAZE_POWDER, 1, one()))
                                //.add(lootItem(TWItems.WhiteGull.get(), 2, one()))
                                //.add(lootItem(TWItems.PotionOfZireael.get(), 1, lootNumber(0, 1))
                        ));

                lootTable.accept(location("witcher_castle/food"), LootTable.lootTable()
                        .withPool(lootPool(lootNumber(14, 19))
                                .add(lootItem(Items.BREAD, 2, one()))
                                .add(lootItem(Items.WHEAT_SEEDS, 4, one()))
                                .add(lootItem(Items.PUMPKIN_SEEDS, 3, one()))
                                .add(lootItem(Items.MELON_SEEDS, 3, one()))
                                .add(lootItem(Items.GOLDEN_CARROT, 1, one()))
                                .add(lootItem(Items.GOLDEN_APPLE, 1, lootNumber(0, 1)))
                                .add(lootItem(Items.APPLE, 2, one()))
                                .add(suspiciousStew(2, one()))
                                .add(lootItem(Items.BAKED_POTATO, 2, one()))
                                .add(lootItem(Items.POTATO, 2, one()))
                                .add(lootItem(Items.CARROT, 2, one()))
                                .add(lootItem(Items.SUGAR_CANE, 2, one()))
                                .add(lootItem(Items.MUSHROOM_STEW, 2, one()))
                                .add(lootItem(Items.ROTTEN_FLESH, 5, one()))
                                .add(lootItem(Items.COOKED_MUTTON, 1, one()))
                                .add(lootItem(Items.COOKED_BEEF, 1, one()))
                                .add(lootItem(Items.COOKED_PORKCHOP, 1, one()))
                                .add(lootItem(Items.COOKED_CHICKEN, 1, one()))
                                .add(lootItem(Items.COOKED_RABBIT, 1, one()))
                                .add(lootItem(Items.COOKED_SALMON, 1, one()))
                                .add(lootItem(Items.COOKED_COD, 1, one()))
                                //.add(lootItem(TWItems.Beer.get(), 1, lootNumber(0, 1)))
                        ));

                lootTable.accept(location("witcher_castle/smithing"), LootTable.lootTable()
                        .withPool(lootPool(lootNumber(4, 6))
                                .add(lootItem(TWItems.SilverNugget.get(), 2, lootNumber(3, 4)))
                                .add(lootItem(TWItems.RawSilver.get(), 1, lootNumber(1, 2)))
                                .add(lootItem(Items.IRON_INGOT, 5, lootNumber(2, 3)))
                                .add(lootItem(Items.IRON_NUGGET, 7, lootNumber(3, 6)))
                                .add(lootItem(Items.RAW_IRON, 5, lootNumber(2, 4)))
                                .add(lootItem(Items.GOLD_INGOT, 5, lootNumber(2, 3)))
                                .add(lootItem(Items.GOLD_NUGGET, 6, lootNumber(3, 6)))
                                .add(lootItem(Items.RAW_GOLD, 5, lootNumber(2, 4))))
                        .withPool(lootPool(lootNumber(0, 2))
                                .add(lootItem(TWItems.ReinforcedLeatherHelmet.get(), 2, lootNumber(0, 1)))
                                .add(lootItem(TWItems.ReinforcedLeatherChestplate.get(), 2, lootNumber(0, 1)))
                                .add(lootItem(TWItems.ReinforcedLeatherLeggings.get(), 2, lootNumber(0, 1)))
                                .add(lootItem(TWItems.ReinforcedLeatherBoots.get(), 2, lootNumber(0, 1)))
                                .add(lootItem(TWItems.SteelSword.get(), 2, one()))
                                .add(lootItem(TWItems.SteelIngot.get(), 2, one()))
                                .add(lootItem(TWItems.SilverIngot.get(), 3, one()))
                                .add(lootItem(TWItems.SteelNugget.get(), 3, lootNumber(1, 2)))
                                .add(lootItem(Items.BLAZE_POWDER, 1, one()))
                        ));

                lootTable.accept(location("witcher_castle/util"), LootTable.lootTable()
                        .withPool(lootPool(lootNumber(7, 14))
                                .add(lootItem(Items.ARROW, 12, lootNumber(1, 3)))
                                .add(lootItem(Items.COBWEB, 7, one()))
                                .add(lootItem(Items.STRING, 9, lootNumber(1, 3)))
                                .add(lootItem(TWItems.SilverNugget.get(), 1, one()))
                                .add(lootItem(TWItems.SteelNugget.get(), 1, lootNumber(0, 1)))
                                .add(lootItem(Items.REDSTONE, 7, one()))
                                .add(lootItem(Items.ROTTEN_FLESH, 14, lootNumber(1, 3)))
                                .add(lootItem(Items.GUNPOWDER, 9, one()))
                                .add(lootItem(Items.PAPER, 10, one()))
                                .add(lootItem(Items.BLAZE_POWDER, 1, lootNumber(0, 1)))
                                .add(lootItem(TWItems.KikimoraTooth.get(), 1, lootNumber(0, 1)))
                        ));
            } // Witcher Castle
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

        private static ResourceLocation location(String name) {return new ResourceLocation(TheWitcher.ModID, "chests/" + name);}
    }

    protected static NumberProvider one() {return lootNumber(1);}
    protected static NumberProvider lootNumber(int amount) {return ConstantValue.exactly(amount);}
    protected static NumberProvider lootNumber(int minAmount, int maxAmount) {return UniformGenerator.between(minAmount, maxAmount);}

    protected static LootPool.Builder lootPool(NumberProvider rolls) {return LootPool.lootPool().setRolls(rolls);}

    @Override @Nonnull
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {return ImmutableList.of(Pair.of(TWBlockLoot::new, LootContextParamSets.BLOCK), Pair.of(TWChestLoot::new, LootContextParamSets.CHEST));}
    @Override @ParametersAreNonnullByDefault
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationContext) {map.forEach((location, lootTable) -> LootTables.validate(validationContext, location, lootTable));}
}