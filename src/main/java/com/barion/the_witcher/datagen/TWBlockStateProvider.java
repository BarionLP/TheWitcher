package com.barion.the_witcher.datagen;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.TWBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.Objects;

public class TWBlockStateProvider extends BlockStateProvider {
    public TWBlockStateProvider(DataGenerator generator, ExistingFileHelper fileHelper){
        super(generator, TheWitcher.ModID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels(){
        simpleBlock(TWBlocks.getAllBlocks());
    }

    protected  <B extends Block> void simpleBlock(List<B> blocks){
        for(B block : blocks) {
            if(block instanceof StairBlock){
                stairs((StairBlock) block);
            }else if(block instanceof SlabBlock) {
                slab((SlabBlock) block);
            }else if(block instanceof WallBlock){
                wall((WallBlock) block);
            }else if(block instanceof RotatedPillarBlock){
                if(getName(block).contains("wood")) {
                    wood((RotatedPillarBlock) block);
                }else{
                    logBlock((RotatedPillarBlock) block);
                }
            }else if(block instanceof SaplingBlock){
                sapling((SaplingBlock) block);
            }else{
                simpleBlock(block);
            }
        }
    }


    protected void wood(RotatedPillarBlock wood){
        ResourceLocation texture = location(getName(wood).replace("wood", "log"));
        axisBlock(wood, texture, texture);
    }
    protected void stairs(StairBlock stairBlock){
        stairsBlock(stairBlock, location(getName(stairBlock).replace("_stairs", "")));
    }
    protected void slab(SlabBlock slabBlock){
        ResourceLocation texture = location(getName(slabBlock).replace("_slab", ""));
        slabBlock(slabBlock, texture, texture);
    }
    protected void wall(WallBlock wallBlock){
        wallBlock(wallBlock, location(getName(wallBlock).replace("_wall", "")));
    }
    protected void sapling(SaplingBlock sapling){
        String name = getName(sapling);
        simpleBlock(sapling, models().cross(name, location(name)));
    }

    protected String getName(Block block) {return Objects.requireNonNull(block.getRegistryName()).getPath();}

    protected final ResourceLocation location(String name) {return modLoc("block/" + name);}
    protected final ResourceLocation location(Block block) {return modLoc("block/" + getName(block));}
}