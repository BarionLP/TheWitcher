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
            String name = getName(block);
            ResourceLocation texture;

            if(block instanceof StairBlock) {
                stairsBlock((StairBlock) block, location(name.replace("_stairs", "")));
            }else if(block instanceof SlabBlock) {
                texture = location(name.replace("_slab", ""));
                slabBlock((SlabBlock) block, texture, texture);
            }else if(block instanceof WallBlock) {
                wallBlock((WallBlock) block, location(name.replace("_wall", "")));
            }else if(block instanceof RotatedPillarBlock) {
                if(getName(block).contains("wood")) {
                    texture = location(name.replace("wood", "log"));
                    axisBlock((RotatedPillarBlock) block, texture, texture);
                }else{
                    logBlock((RotatedPillarBlock) block);
                }
            }else if(block instanceof SaplingBlock) {
                simpleBlock(block, models().cross(name, location(name)));
            }else {
                simpleBlock(block);
            }
        }
    }

    protected String getName(Block block) {return Objects.requireNonNull(block.getRegistryName()).getPath();}

    protected final ResourceLocation location(String name) {return modLoc("block/" + name);}
    protected final ResourceLocation location(Block block) {return modLoc("block/" + getName(block));}
}