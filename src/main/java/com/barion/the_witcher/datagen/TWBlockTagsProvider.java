package com.barion.the_witcher.datagen;

import com.ametrinstudios.ametrin.datagen.ExtendedBlockTagsProvider;
import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.util.TWTags;
import com.barion.the_witcher.world.TWBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TWBlockTagsProvider extends ExtendedBlockTagsProvider {
    public TWBlockTagsProvider(DataGenerator generator, ExistingFileHelper fileHelper){
        super(generator, TheWitcher.ModID, fileHelper);
    }

    @Override
    protected void addTags() {
        runRules(TWBlocks.getAllBlocks());

        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                TWBlocks.RawSilverBlock.get(),
                TWBlocks.SilverBlock.get(),

                TWBlocks.FrostedCobblestone.get(),
                TWBlocks.FrostedCobblestoneStairs.get(),
                TWBlocks.FrostedCobblestoneSlab.get(),
                TWBlocks.FrostedCobblestoneWall.get(),
                TWBlocks.FrostedCobblestoneButton.get(),
                TWBlocks.FrostedStone.get(),
                TWBlocks.FrostedStoneStairs.get(),
                TWBlocks.FrostedStoneSlab.get(),
                TWBlocks.FrostedStoneWall.get(),
                TWBlocks.FrostedStoneButton.get(),
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

                TWBlocks.DeepFrostedCobblestone.get(),
                TWBlocks.DeepFrostedCobblestoneStairs.get(),
                TWBlocks.DeepFrostedCobblestoneSlab.get(),
                TWBlocks.DeepFrostedCobblestoneWall.get(),
                TWBlocks.DeepFrostedCobblestoneButton.get(),
                TWBlocks.DeepFrostedStone.get(),
                TWBlocks.DeepFrostedStoneStairs.get(),
                TWBlocks.DeepFrostedStoneSlab.get(),
                TWBlocks.DeepFrostedStoneWall.get(),
                TWBlocks.DeepFrostedStoneButton.get(),
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
                TWBlocks.Icicle.get()
        );

        tag(BlockTags.MINEABLE_WITH_AXE).add(
                TWBlocks.MasterSmithingTable.get(),
                TWBlocks.Icicle.get()
        );

        tag(BlockTags.NEEDS_IRON_TOOL).add(
                TWBlocks.RawSilverBlock.get(),
                TWBlocks.SilverBlock.get()
        );

        tag(BlockTags.BEACON_BASE_BLOCKS).add(TWBlocks.SilverBlock.get());
        tag(TWTags.Blocks.StorageBlocksSilver).add(TWBlocks.SilverBlock.get());
        tag(TWTags.Blocks.StorageBlocksRawSilver).add(TWBlocks.RawSilverBlock.get());
        tag(TWTags.Blocks.SpikesCanPlace).add(TWBlocks.FrostedStone.get(), TWBlocks.DeepFrostedStone.get(), Blocks.STONE, Blocks.DIRT, Blocks.GRASS_BLOCK, Blocks.SNOW_BLOCK, Blocks.POWDER_SNOW);
        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(TWTags.Blocks.StorageBlocksSilver).addTag(TWTags.Blocks.StorageBlocksRawSilver);
    }
}