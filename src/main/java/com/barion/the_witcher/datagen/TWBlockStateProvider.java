package com.barion.the_witcher.datagen;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.TWBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Objects;

public class TWBlockStateProvider extends BlockStateProvider {
    public TWBlockStateProvider(DataGenerator generator, ExistingFileHelper fileHelper){
        super(generator, TheWitcher.ModID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlocks(TWBlocks.SilverOre.get(),
                TWBlocks.DeepslateSilverOre.get(),
                TWBlocks.SilverBlock.get(),
                TWBlocks.RawSilverBlock.get(),

                TWBlocks.DeepFrostedStone.get(),
                TWBlocks.DeepFrostedCobblestone.get());

        blockGroup(TWBlocks.FrostedStone.get(),
                TWBlocks.FrostedStoneStairs.get(),
                TWBlocks.FrostedStoneSlab.get(),
                TWBlocks.FrostedStoneWall.get());

        blockGroup(TWBlocks.FrostedCobblestone.get(),
                TWBlocks.FrostedCobblestoneStairs.get(),
                TWBlocks.FrostedCobblestoneSlab.get(),
                TWBlocks.FrostedCobblestoneWall.get());
    }

    protected final void stairBlock(StairBlock block, String texture) {stairsBlock(block, location(texture));}
    protected final void slabBlock(SlabBlock block, String texture) {slabBlock(block, location(texture), location(texture));}
    protected final void wallBlock(WallBlock block, String texture) {wallBlock(block, location(texture));}

    protected final void blockGroup(Block block, StairBlock stairBlock, SlabBlock slabBlock, WallBlock wallBlock){
        String texture = Objects.requireNonNull(block.getRegistryName()).getPath();
        simpleBlock(block);
        stairBlock(stairBlock, texture);
        slabBlock(slabBlock, texture);
        wallBlock(wallBlock, texture);
    }


    @SafeVarargs
    protected final <B extends Block> void simpleBlocks(B... blocks){
        for (B block : blocks) {
            simpleBlock(block);
        }
    }


    protected final ResourceLocation location(String name) {
        return modLoc("block/" + name);
    }
}