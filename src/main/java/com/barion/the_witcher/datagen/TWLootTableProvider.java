package com.barion.the_witcher.datagen;

import com.ametrinstudios.ametrin.datagen.ExtendedLootTableProvider;
import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.TWBlocks;
import com.barion.the_witcher.world.TWItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class TWLootTableProvider extends ExtendedLootTableProvider {
    private static List<SubProviderEntry> tables;
    public TWLootTableProvider(PackOutput output) {
        super(output, TheWitcher.ModID);
        tables = List.of(new SubProviderEntry(TWBlockLoot::new, LootContextParamSets.BLOCK), new SubProviderEntry(TWChestLoot::new, LootContextParamSets.CHEST));
    }

    @Override
    public @NotNull List<SubProviderEntry> getTables() {
        return tables;
    }

    public class TWBlockLoot extends ExtendedBlockLootSubProvider{
        @Override
        protected void generate() {
            dropSelf(TWBlocks.SilverBlock.get(),
                    TWBlocks.RawSilverBlock.get(),
                    TWBlocks.MasterSmithingTable.get(),

                    TWBlocks.FrostedStoneStairs.get(),
                    TWBlocks.FrostedStoneSlab.get(),
                    TWBlocks.FrostedStoneWall.get(),
                    TWBlocks.FrostedStoneButton.get(),
                    TWBlocks.FrostedCobblestone.get(),
                    TWBlocks.FrostedCobblestoneStairs.get(),
                    TWBlocks.FrostedCobblestoneSlab.get(),
                    TWBlocks.FrostedCobblestoneWall.get(),
                    TWBlocks.FrostedCobblestoneButton.get(),
                    TWBlocks.FrostedStoneBricks.get(),
                    TWBlocks.FrostedStoneBrickStairs.get(),
                    TWBlocks.FrostedStoneBrickSlab.get(),
                    TWBlocks.FrostedStoneBrickWall.get(),
                    TWBlocks.FrostedStoneBrickButton.get(),
                    TWBlocks.CrackedFrostedStoneBricks.get(),
                    TWBlocks.CrackedFrostedStoneBrickStairs.get(),
                    TWBlocks.CrackedFrostedStoneBrickSlab.get(),
                    TWBlocks.CrackedFrostedStoneBrickWall.get(),
                    TWBlocks.CrackedFrostedStoneBrickButton.get(),

                    TWBlocks.DeepFrostedStoneStairs.get(),
                    TWBlocks.DeepFrostedStoneSlab.get(),
                    TWBlocks.DeepFrostedStoneWall.get(),
                    TWBlocks.DeepFrostedStoneButton.get(),
                    TWBlocks.DeepFrostedCobblestone.get(),
                    TWBlocks.DeepFrostedCobblestoneStairs.get(),
                    TWBlocks.DeepFrostedCobblestoneSlab.get(),
                    TWBlocks.DeepFrostedCobblestoneWall.get(),
                    TWBlocks.DeepFrostedCobblestoneButton.get(),
                    TWBlocks.DeepFrostedStoneBricks.get(),
                    TWBlocks.DeepFrostedStoneBrickStairs.get(),
                    TWBlocks.DeepFrostedStoneBrickSlab.get(),
                    TWBlocks.DeepFrostedStoneBrickWall.get(),
                    TWBlocks.DeepFrostedStoneBrickButton.get(),
                    TWBlocks.CrackedDeepFrostedStoneBricks.get(),
                    TWBlocks.CrackedDeepFrostedStoneBrickStairs.get(),
                    TWBlocks.CrackedDeepFrostedStoneBrickSlab.get(),
                    TWBlocks.CrackedDeepFrostedStoneBrickWall.get(),
                    TWBlocks.CrackedDeepFrostedStoneBrickButton.get(),
                    TWBlocks.DeepFrostedStoneTiles.get(),
                    TWBlocks.DeepFrostedStoneTileStairs.get(),
                    TWBlocks.DeepFrostedStoneTileSlab.get(),
                    TWBlocks.DeepFrostedStoneTileWall.get(),
                    TWBlocks.DeepFrostedStoneTileButton.get(),
                    TWBlocks.CrackedDeepFrostedStoneTiles.get(),
                    TWBlocks.CrackedDeepFrostedStoneTileStairs.get(),
                    TWBlocks.CrackedDeepFrostedStoneTileSlab.get(),
                    TWBlocks.CrackedDeepFrostedStoneTileWall.get(),
                    TWBlocks.CrackedDeepFrostedStoneTileButton.get(),

                    TWBlocks.HallucinatedStone.get(),
                    TWBlocks.HallucinatedStoneStairs.get(),
                    TWBlocks.HallucinatedStoneSlab.get(),
                    TWBlocks.HallucinatedStoneWall.get(),
                    TWBlocks.HallucinatedStoneButton.get(),
                    TWBlocks.Alcite.get()
            );

            dropOther(TWBlocks.FrostedStone.get(), TWBlocks.FrostedCobblestone.get());
            dropOther(TWBlocks.DeepFrostedStone.get(), TWBlocks.DeepFrostedCobblestone.get());
            dropWhenSilkTouch(TWBlocks.Icicle.get());
            dropWhenSilkTouch(TWBlocks.Larimar.get());

            dropBush(TWBlocks.WhiteMyrtleBush.get(), TWItems.WhiteMyrtle.get());
            dropBush(TWBlocks.CelandineBush.get(), TWItems.Celandine.get());
        }

        private void dropBush(Block bush, ItemLike drop){
            this.add(bush, (block) -> applyExplosionDecay(block, LootTable.lootTable()
                    .withPool(LootPool.lootPool()
                            .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(bush).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3)))
                            .add(LootItem.lootTableItem(drop)).apply(SetItemCountFunction.setCount(one())))));
        }

        @Override @Nonnull
        protected Iterable<Block> getKnownBlocks() {return TWBlocks.Registry.getEntries().stream().map(RegistryObject::get).toList();}
    }

    public class TWChestLoot extends ExtendedLootTableSubProvider{
        @Override @ParametersAreNonnullByDefault
        public void generate(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
            {
                consumer.accept(location("white_frost_portal"), LootTable.lootTable()
                        .withPool(pool(one())
                                .add(item(Items.FLINT_AND_STEEL, 1, one())))
                        .withPool(pool(number(4, 8))
                                .add(item(Blocks.ICE, 20, number(3, 5)))
                                .add(item(TWItems.SilverNugget.get(), 8, number(1, 3)))
                                .add(item(TWItems.RawSilver.get(), 5, number(0, 1)))
                                .add(item(TWItems.SilverIngot.get(), 4, number(0, 1)))
                                .add(item(TWItems.SteelNugget.get(), 1, number(0, 3)))
                                .add(potion(1, Potions.STRENGTH, number(0, 1)))
                        ));
            } // White Frost Portal

            {
                consumer.accept(location("witcher_castle/brewing"), LootTable.lootTable()
                        .withPool(pool(number(10, 15))
                                .add(item(TWItems.WhiteMyrtle.get(), 6, one()))
                                //.add(lootItem(TWItems.Beer.get(), 4, one()))
                                .add(item(Items.WHEAT, 10, number(1, 4)))
                                .add(item(Items.GUNPOWDER, 10, number(1, 2)))
                                .add(item(Items.SPIDER_EYE, 12, number(1, 3)))
                                .add(item(Items.GLOWSTONE_DUST, 2, one()))
                                //.add(lootItem(TWItems.HotWaterBottle.get(), 4, one()))
                                .add(item(Items.REDSTONE, 3, one())))
                        .withPool(pool(number(1, 3))
                                .add(item(TWItems.Celandine.get(), 2, number(1, 2)))
                                .add(item(TWItems.KikimoraTooth.get(), 2, one()))
                                .add(item(Items.BLAZE_POWDER, 1, one()))
                                //.add(lootItem(TWItems.WhiteGull.get(), 2, one()))
                                //.add(lootItem(TWItems.PotionOfZireael.get(), 1, lootNumber(0, 1))
                        ));

                consumer.accept(location("witcher_castle/food"), LootTable.lootTable()
                        .withPool(pool(number(14, 19))
                                .add(item(Items.BREAD, 2, one()))
                                .add(item(Items.WHEAT_SEEDS, 4, one()))
                                .add(item(Items.PUMPKIN_SEEDS, 3, one()))
                                .add(item(Items.MELON_SEEDS, 3, one()))
                                .add(item(Items.GOLDEN_CARROT, 1, one()))
                                .add(item(Items.GOLDEN_APPLE, 1, number(0, 1)))
                                .add(item(Items.APPLE, 2, one()))
                                .add(suspiciousStew(2, one()))
                                .add(item(Items.BAKED_POTATO, 2, one()))
                                .add(item(Items.POTATO, 2, one()))
                                .add(item(Items.CARROT, 2, one()))
                                .add(item(Items.SUGAR_CANE, 2, one()))
                                .add(item(Items.MUSHROOM_STEW, 2, one()))
                                .add(item(Items.ROTTEN_FLESH, 5, one()))
                                .add(item(Items.COOKED_MUTTON, 1, one()))
                                .add(item(Items.COOKED_BEEF, 1, one()))
                                .add(item(Items.COOKED_PORKCHOP, 1, one()))
                                .add(item(Items.COOKED_CHICKEN, 1, one()))
                                .add(item(Items.COOKED_RABBIT, 1, one()))
                                .add(item(Items.COOKED_SALMON, 1, one()))
                                .add(item(Items.COOKED_COD, 1, one()))
                                //.add(lootItem(TWItems.Beer.get(), 1, lootNumber(0, 1)))
                        ));

                consumer.accept(location("witcher_castle/smithing"), LootTable.lootTable()
                        .withPool(pool(number(4, 6))
                                .add(item(TWItems.SilverNugget.get(), 2, number(3, 4)))
                                .add(item(TWItems.RawSilver.get(), 1, number(1, 2)))
                                .add(item(Items.IRON_INGOT, 5, number(2, 3)))
                                .add(item(Items.IRON_NUGGET, 7, number(3, 6)))
                                .add(item(Items.RAW_IRON, 5, number(2, 4)))
                                .add(item(Items.GOLD_INGOT, 5, number(2, 3)))
                                .add(item(Items.GOLD_NUGGET, 6, number(3, 6)))
                                .add(item(Items.RAW_GOLD, 5, number(2, 4))))
                        .withPool(pool(number(0, 2))
                                .add(item(TWItems.ReinforcedLeatherHelmet.get(), 2, number(0, 1)))
                                .add(item(TWItems.ReinforcedLeatherChestplate.get(), 2, number(0, 1)))
                                .add(item(TWItems.ReinforcedLeatherLeggings.get(), 2, number(0, 1)))
                                .add(item(TWItems.ReinforcedLeatherBoots.get(), 2, number(0, 1)))
                                .add(item(TWItems.SteelSword.get(), 2, one()))
                                .add(item(TWItems.SteelIngot.get(), 2, one()))
                                .add(item(TWItems.SilverIngot.get(), 3, one()))
                                .add(item(TWItems.SteelNugget.get(), 3, number(1, 2)))
                                .add(item(Items.BLAZE_POWDER, 1, one()))
                        ));

                consumer.accept(location("witcher_castle/util"), LootTable.lootTable()
                        .withPool(pool(number(7, 14))
                                .add(item(Items.ARROW, 12, number(1, 3)))
                                .add(item(Items.COBWEB, 7, one()))
                                .add(item(Items.STRING, 9, number(1, 3)))
                                .add(item(TWItems.SilverNugget.get(), 1, one()))
                                .add(item(TWItems.SteelNugget.get(), 1, number(0, 1)))
                                .add(item(Items.REDSTONE, 7, one()))
                                .add(item(Items.ROTTEN_FLESH, 14, number(1, 3)))
                                .add(item(Items.GUNPOWDER, 9, one()))
                                .add(item(Items.PAPER, 10, one()))
                                .add(item(Items.BLAZE_POWDER, 1, number(0, 1)))
                                .add(item(TWItems.KikimoraTooth.get(), 1, number(0, 1)))
                        ));
            } // Witcher Castle
        }
    }

    @Override @ParametersAreNonnullByDefault
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationContext) {map.forEach((location, lootTable) -> LootTables.validate(validationContext, location, lootTable));}
}