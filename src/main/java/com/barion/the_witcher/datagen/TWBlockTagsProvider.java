package com.barion.the_witcher.datagen;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.util.TWTags;
import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.TWBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.*;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.Objects;

public class TWBlockTagsProvider extends BlockTagsProvider {
    public TWBlockTagsProvider(DataGenerator generator, ExistingFileHelper fileHelper){
        super(generator, TheWitcher.ModID, fileHelper);
    }

    @Override
    protected void addTags() {
        handleDefaults(TWBlocks.getAllBlocks());

        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                TWBlocks.RawSilverBlock.get(),
                TWBlocks.SilverBlock.get(),

                TWBlocks.FrostedCobblestone.get(),
                TWBlocks.FrostedCobblestoneStairs.get(),
                TWBlocks.FrostedCobblestoneSlab.get(),
                TWBlocks.FrostedCobblestoneWall.get(),
                TWBlocks.FrostedStone.get(),
                TWBlocks.FrostedStoneStairs.get(),
                TWBlocks.FrostedStoneSlab.get(),
                TWBlocks.FrostedStoneWall.get(),
                TWBlocks.FrostedStoneBricks.get(),
                TWBlocks.FrostedStoneBrickStairs.get(),
                TWBlocks.FrostedStoneBrickSlab.get(),
                TWBlocks.FrostedStoneBrickWall.get(),
                TWBlocks.FrostedStoneBrickButton.get(),
                TWBlocks.CrackedFrostedStoneBricks.get(),
                TWBlocks.CrackedFrostedStoneBrickStairs.get(),
                TWBlocks.CrackedFrostedStoneBrickSlab.get(),
                TWBlocks.CrackedFrostedStoneBrickWall.get(),

                TWBlocks.DeepFrostedCobblestone.get(),
                TWBlocks.DeepFrostedCobblestoneStairs.get(),
                TWBlocks.DeepFrostedCobblestoneSlab.get(),
                TWBlocks.DeepFrostedCobblestoneWall.get(),
                TWBlocks.DeepFrostedStone.get(),
                TWBlocks.DeepFrostedStoneStairs.get(),
                TWBlocks.DeepFrostedStoneSlab.get(),
                TWBlocks.DeepFrostedStoneWall.get(),
                TWBlocks.DeepFrostedStoneBricks.get(),
                TWBlocks.DeepFrostedStoneBrickStairs.get(),
                TWBlocks.DeepFrostedStoneBrickSlab.get(),
                TWBlocks.DeepFrostedStoneBrickWall.get(),
                TWBlocks.DeepFrostedStoneBrickButton.get(),
                TWBlocks.DeepFrostedStoneTiles.get(),
                TWBlocks.DeepFrostedStoneTileStairs.get(),
                TWBlocks.DeepFrostedStoneTileSlab.get(),
                TWBlocks.DeepFrostedStoneTileWall.get()
        );

        tag(BlockTags.MINEABLE_WITH_AXE).add(
                TWBlocks.MasterSmithingTable.get()
        );

/*        tag(BlockTags.STAIRS).add(
                TWBlocks.FrostedCobblestoneStairs.get(),
                TWBlocks.FrostedStoneStairs.get(),
                TWBlocks.FrostedStoneBrickStairs.get(),
                TWBlocks.DeepFrostedCobblestoneStairs.get(),
                TWBlocks.DeepFrostedStoneStairs.get(),
                TWBlocks.DeepFrostedStoneBrickStairs.get(),
                TWBlocks.DeepFrostedStoneTileStairs.get()
        );

        tag(BlockTags.SLABS).add(
                TWBlocks.FrostedCobblestoneSlab.get(),
                TWBlocks.FrostedStoneSlab.get(),
                TWBlocks.FrostedStoneBrickSlab.get(),
                TWBlocks.DeepFrostedCobblestoneSlab.get(),
                TWBlocks.DeepFrostedStoneSlab.get(),
                TWBlocks.DeepFrostedStoneBrickSlab.get(),
                TWBlocks.DeepFrostedStoneTileSlab.get()
        );

        tag(BlockTags.WALLS).add(
                TWBlocks.FrostedCobblestoneWall.get(),
                TWBlocks.FrostedStoneWall.get(),
                TWBlocks.FrostedStoneBrickWall.get(),
                TWBlocks.DeepFrostedCobblestoneWall.get(),
                TWBlocks.DeepFrostedStoneWall.get(),
                TWBlocks.DeepFrostedStoneBrickWall.get(),
                TWBlocks.DeepFrostedStoneTileWall.get()
        );*/

        tag(BlockTags.BUTTONS).add(
                TWBlocks.FrostedStoneBrickButton.get(),
                TWBlocks.DeepFrostedStoneBrickButton.get()
        );

        tag(BlockTags.NEEDS_IRON_TOOL).add(
                TWBlocks.RawSilverBlock.get(),
                TWBlocks.SilverBlock.get()
        );

        tag(BlockTags.BEACON_BASE_BLOCKS).add(TWBlocks.SilverBlock.get());
        tag(TWTags.Blocks.StorageBlocksSilver).add(TWBlocks.SilverBlock.get());
        tag(TWTags.Blocks.StorageBlocksRawSilver).add(TWBlocks.RawSilverBlock.get());
        tag(TWTags.Blocks.SpikesCanPlace).add(TWBlocks.FrostedStone.get(), TWBlocks.DeepFrostedStone.get(), Blocks.STONE, Blocks.DIRT, Blocks.GRASS_BLOCK);
        tag(Tags.Blocks.STORAGE_BLOCKS).addTags(TWTags.Blocks.StorageBlocksSilver, TWTags.Blocks.StorageBlocksRawSilver);
    }

    private void handleDefaults(List<Block> allBlocks) {
        for(Block block : allBlocks) {
            String name = getName(block);

            if(block instanceof StairBlock){
                if(TWUtil.isWooden(name)){
                    tag(BlockTags.WOODEN_STAIRS).add(block);
                } else {
                    tag(BlockTags.STAIRS).add(block);
                }
            }
            if(block instanceof SlabBlock){
                if(TWUtil.isWooden(name)){
                    tag(BlockTags.WOODEN_SLABS).add(block);
                } else {
                    tag(BlockTags.SLABS).add(block);
                }
            }
            if(block instanceof WallBlock) {
                tag(BlockTags.WALLS).add(block);
            }
            if(block instanceof FenceBlock){
                tag(BlockTags.FENCES).add(block);
            }
            if(block instanceof FenceGateBlock){
                tag(BlockTags.FENCE_GATES).add(block);
            }
        }
    }

    protected String getName(Block block) {return Objects.requireNonNull(block.getRegistryName()).getPath();}
}