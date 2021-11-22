package com.barion.the_witcher.data;

import com.barion.the_witcher.TWBlocks;
import com.barion.the_witcher.TWItems;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.fmllegacy.RegistryObject;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TWLootTables extends LootTableProvider {
    public TWLootTables(DataGenerator generator){super(generator);}

    @Override @Nonnull
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return ImmutableList.of(Pair.of(TWBlockLoot::new, LootContextParamSets.BLOCK));
    }
    @Override @ParametersAreNonnullByDefault
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationContext) {
        map.forEach((x, y) -> LootTables.validate(validationContext, x, y));
    }

    public static class TWBlockLoot extends BlockLoot {
        @Override
        protected void addTables() {
            dropSelf(TWBlocks.SilverBlock.get(),
                    TWBlocks.RawSilverBlock.get());
            dropOreLoot(TWBlocks.SilverOre.get(), TWItems.RawSilver.get());
            dropOreLoot(TWBlocks.DeepslateSilverOre.get(), TWItems.RawSilver.get());
        }

        @SafeVarargs
        private <T extends Block> void dropSelf(T... Blocks){
            for (Block Block : Blocks){
                dropSelf(Block);
            }
        }
        private void dropOreLoot(Block ore, Item rawOre){
            add(ore, createOreDrop(ore, rawOre));
        }
        @Override @Nonnull
        protected Iterable<Block> getKnownBlocks() {
            return TWBlocks.Blocks.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
        }
    }
}