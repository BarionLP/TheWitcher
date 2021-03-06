package com.barion.the_witcher.datagen;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.TWBlocks;
import com.barion.the_witcher.world.block.TWGrowableBushBlock;
import com.barion.the_witcher.world.block.TWIcicleBlock;
import com.barion.the_witcher.world.block.TWMasterSmithingTableBlock;
import com.barion.the_witcher.world.block.TWPowerBlock;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.List;

import static com.barion.the_witcher.util.TWUtil.getBlockName;

public class TWBlockStateProvider extends BlockStateProvider {
    private static final String Cutout = "cutout";
    public TWBlockStateProvider(DataGenerator generator, ExistingFileHelper fileHelper){
        super(generator, TheWitcher.ModID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {simpleBlock(TWBlocks.getAllBlocks());}

    protected  <B extends Block> void simpleBlock(List<B> blocks){
        for(B block : blocks) {
            String name = getBlockName(block);
            ResourceLocation texture;

            if(block instanceof StairBlock) {
                if(TWUtil.shouldAppendS(name)) {texture = blockTexture(name.replace("_stairs", "s"));}
                else {texture = blockTexture(name.replace("_stairs", ""));}
                stairsBlock((StairBlock) block, texture);
            }else if(block instanceof SlabBlock) {
                if(TWUtil.shouldAppendS(name)) {texture = blockTexture(name.replace("_slab", "s"));}
                else {texture = blockTexture(name.replace("_slab", ""));}
                slabBlock((SlabBlock) block, texture, texture);
            }else if(block instanceof WallBlock) {
                if(TWUtil.shouldAppendS(name)) {texture = blockTexture(name.replace("_wall", "s"));}
                else {texture = blockTexture(name.replace("_wall", ""));}
                wallBlock((WallBlock) block, texture);
            }else if(block instanceof RotatedPillarBlock) {
                if(getBlockName(block).contains("wood")) {
                    texture = blockTexture(name.replace("wood", "log"));
                    axisBlock((RotatedPillarBlock) block, texture, texture);
                }else{
                    logBlock((RotatedPillarBlock) block);
                }
            }else if(block instanceof TWMasterSmithingTableBlock) {
                simpleBlock(block, models().cube(name, blockTexture(name + "_bottom"), blockTexture(name + "_top"), blockTexture(name + "_front"), blockTexture(name + "_front"), blockTexture(name + "_side"), blockTexture(name + "_side")).texture("particle", blockTexture(name + "_top")));
            }else if(block instanceof SaplingBlock) {
                simpleBlock(block, models().cross(name, blockTexture(name)));
            }else if(block instanceof TWGrowableBushBlock) {
                simpleGrowableBush(block, name);
            }else if(block instanceof TWIcicleBlock) {
                icicleBlock(block, name);
            }else if(block instanceof TWPowerBlock) {
                powerBlock(block, name);
            }else if(block instanceof ButtonBlock) {
                if(TWUtil.shouldAppendS(name)) {texture = blockTexture(name.replace("_button", "s"));}
                else {texture = blockTexture(name.replace("_button", ""));}
                buttonBlock((ButtonBlock) block, texture);
            }else {
                simpleBlock(block);
            }
        }
    }

    protected void powerBlock(Block powerBlock, String name){
        ModelFile on = models().cubeAll("block/" + name + "/on", blockTexture(name + "/on"));
        ModelFile off = models().cubeAll("block/" + name + "/off", blockTexture(name + "/off"));
        getVariantBuilder(powerBlock).forAllStates(state -> {
            final boolean hasPower = state.getValue(TWPowerBlock.hasPower);
            return ConfiguredModel.builder().modelFile(hasPower ? on : off).build();
        });
    }
    protected void simpleGrowableBush(Block bush, String name) {
        ModelFile Age0 = models().cross("block/" + name + "/stage0", mcLoc("block/sweet_berry_bush_stage0")).renderType(Cutout);
        ModelFile Age1 = models().cross("block/" + name + "/stage1", mcLoc("block/sweet_berry_bush_stage1")).renderType(Cutout);
        ModelFile Age2 = models().cross("block/" + name + "/stage2", blockTexture(name+"/stage2")).renderType(Cutout);
        ModelFile Age3 = models().cross("block/" + name + "/stage3", blockTexture(name+"/stage3")).renderType(Cutout);
        getVariantBuilder(bush).forAllStates(state -> {
            final int age = state.getValue(TWGrowableBushBlock.Age);
            return ConfiguredModel.builder().modelFile((age == 0) ? Age0 : (age == 1) ? Age1 : (age == 2) ? Age2 : Age3).build();
        });
    }
    protected void icicleBlock(Block icicle, String name) {
        ModelFile downBase = models().cross("block/" + name + "/down/base", blockTexture(name + "/down/base")).renderType(Cutout);
        ModelFile downFrustum = models().cross("block/" + name + "/down/frustum", blockTexture(name + "/down/frustum")).renderType(Cutout);
        ModelFile downMiddle = models().cross("block/" + name + "/down/middle", blockTexture(name + "/down/middle")).renderType(Cutout);
        ModelFile downTip = models().cross("block/" + name + "/down/tip", blockTexture(name + "/down/tip")).renderType(Cutout);
        ModelFile downTipMerge = models().cross("block/" + name + "/down/tip_merge", blockTexture(name + "/down/tip_merge")).renderType(Cutout);
        ModelFile upBase = models().cross("block/" + name + "/up/base", blockTexture(name + "/up/base")).renderType(Cutout);
        ModelFile upFrustum = models().cross("block/" + name + "/up/frustum", blockTexture(name + "/up/frustum")).renderType(Cutout);
        ModelFile upMiddle = models().cross("block/" + name + "/up/middle", blockTexture(name + "/up/middle")).renderType(Cutout);
        ModelFile upTip = models().cross("block/" + name + "/up/tip", blockTexture(name + "/up/tip")).renderType(Cutout);
        ModelFile upTipMerge = models().cross("block/" + name + "/up/tip_merge", blockTexture(name + "/up/tip_merge")).renderType(Cutout);
        getVariantBuilder(icicle).forAllStates(state -> {
            final DripstoneThickness thickness = state.getValue(TWIcicleBlock.Thickness);
            final Direction direction = state.getValue(TWIcicleBlock.TipDirection);
            return ConfiguredModel.builder().modelFile((direction == Direction.UP) ? (thickness == DripstoneThickness.BASE) ? upBase : (thickness == DripstoneThickness.FRUSTUM) ? upFrustum : (thickness == DripstoneThickness.MIDDLE) ? upMiddle : (thickness == DripstoneThickness.TIP_MERGE) ? upTipMerge : upTip : (thickness == DripstoneThickness.BASE) ? downBase : (thickness == DripstoneThickness.FRUSTUM) ? downFrustum : (thickness == DripstoneThickness.MIDDLE) ? downMiddle : (thickness == DripstoneThickness.TIP_MERGE) ? downTipMerge : downTip).build();
        });
    }

    protected final ResourceLocation blockTexture(String name) {return modLoc("block/" + name);}
}