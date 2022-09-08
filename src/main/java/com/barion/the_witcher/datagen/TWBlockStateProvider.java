package com.barion.the_witcher.datagen;

import com.ametrinstudios.ametrin.datagen.ExtendedBlockStateProvider;
import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.TWBlocks;
import com.barion.the_witcher.world.block.TWGrowableBushBlock;
import com.barion.the_witcher.world.block.TWIcicleBlock;
import com.barion.the_witcher.world.block.TWMasterSmithingTableBlock;
import com.barion.the_witcher.world.block.TWPowerBlock;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TWBlockStateProvider extends ExtendedBlockStateProvider {
    public TWBlockStateProvider(DataGenerator generator, ExistingFileHelper existingFileHelper){
        super(generator, TheWitcher.ModID, existingFileHelper);
    }

    {
        blockStateProviderRules.add((block, name, texture)-> {
            if(!(block instanceof TWMasterSmithingTableBlock)) {return false;}
            masterSmithingTableBlock((TWMasterSmithingTableBlock)block, name, texture);
            return true;
        });
        blockStateProviderRules.add((block, name, texture)-> {
            if(!(block instanceof TWIcicleBlock)) {return false;}
            icicleBlock((TWIcicleBlock) block, name, texture);
            return true;
        });
        blockStateProviderRules.add((block, name, texture)-> {
            if(!(block instanceof TWPowerBlock)) {return false;}
            powerBlock((TWPowerBlock) block, name, texture);
            return true;
        });
        blockStateProviderRules.add((block, name, texture)-> {
            if(!(block instanceof TWGrowableBushBlock)) {return false;}
            simpleGrowableBushBlock((TWGrowableBushBlock) block, name, texture);
            return true;
        });
    }

    @Override
    protected void registerStatesAndModels() {
        handleDefaults(TWBlocks.getAllBlocks());
    }

    /*protected  <B extends Block> void simpleBlock(List<B> blocks){
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
    }*/

    protected void powerBlock(TWPowerBlock powerBlock, String name, String texture){
        ModelFile on = models().cubeAll("block/" + name + "/on", modBlockLoc(texture + "/on"));
        ModelFile off = models().cubeAll("block/" + name + "/off", modBlockLoc(texture + "/off"));
        getVariantBuilder(powerBlock).forAllStates(state -> ConfiguredModel.builder().modelFile(state.getValue(TWPowerBlock.hasPower) ? on : off).build());
    }
    protected void simpleGrowableBushBlock(TWGrowableBushBlock bush, String name, String texture) {
        ModelFile Age0 = models().cross("block/" + name + "/stage0", mcLoc("block/sweet_berry_bush_stage0")).renderType(RenderTypes.Cutout);
        ModelFile Age1 = models().cross("block/" + name + "/stage1", mcLoc("block/sweet_berry_bush_stage1")).renderType(RenderTypes.Cutout);
        ModelFile Age2 = models().cross("block/" + name + "/stage2", modBlockLoc(texture + "/stage2")).renderType(RenderTypes.Cutout);
        ModelFile Age3 = models().cross("block/" + name + "/stage3", modBlockLoc(texture + "/stage3")).renderType(RenderTypes.Cutout);
        getVariantBuilder(bush).forAllStates(state -> {
            final int age = state.getValue(TWGrowableBushBlock.Age);
            return ConfiguredModel.builder().modelFile((age == 0) ? Age0 : (age == 1) ? Age1 : (age == 2) ? Age2 : Age3).build();
        });
    }

    protected void masterSmithingTableBlock(TWMasterSmithingTableBlock block, String name, String texture){
        ResourceLocation bottom = modBlockLoc(texture + "_bottom");
        ResourceLocation top = modBlockLoc(texture + "_top");
        ResourceLocation front = modBlockLoc(texture + "_front");
        ResourceLocation side = modBlockLoc(texture + "_side");
        simpleBlock(block, models().cube("master_smithing_table", bottom, top, front, front, side, side).texture("particle", top));
    }

    protected void icicleBlock(TWIcicleBlock icicle, String name, String texture) {
        ModelFile downBase = models().cross("block/" + name + "/down/base", modBlockLoc(texture + "/down/base")).renderType(RenderTypes.Cutout);
        ModelFile downFrustum = models().cross("block/" + name + "/down/frustum", modBlockLoc(texture + "/down/frustum")).renderType(RenderTypes.Cutout);
        ModelFile downMiddle = models().cross("block/" + name + "/down/middle", modBlockLoc(texture + "/down/middle")).renderType(RenderTypes.Cutout);
        ModelFile downTip = models().cross("block/" + name + "/down/tip", modBlockLoc(texture + "/down/tip")).renderType(RenderTypes.Cutout);
        ModelFile downTipMerge = models().cross("block/" + name + "/down/tip_merge", modBlockLoc(texture + "/down/tip_merge")).renderType(RenderTypes.Cutout);
        ModelFile upBase = models().cross("block/" + name + "/up/base", modBlockLoc(texture + "/up/base")).renderType(RenderTypes.Cutout);
        ModelFile upFrustum = models().cross("block/" + name + "/up/frustum", modBlockLoc(texture + "/up/frustum")).renderType(RenderTypes.Cutout);
        ModelFile upMiddle = models().cross("block/" + name + "/up/middle", modBlockLoc(texture + "/up/middle")).renderType(RenderTypes.Cutout);
        ModelFile upTip = models().cross("block/" + name + "/up/tip", modBlockLoc(texture + "/up/tip")).renderType(RenderTypes.Cutout);
        ModelFile upTipMerge = models().cross("block/" + name + "/up/tip_merge", modBlockLoc(texture + "/up/tip_merge")).renderType(RenderTypes.Cutout);
        getVariantBuilder(icicle).forAllStates(state -> {
            final DripstoneThickness thickness = state.getValue(TWIcicleBlock.Thickness);
            final Direction direction = state.getValue(TWIcicleBlock.TipDirection);
            return ConfiguredModel.builder().modelFile((direction == Direction.UP) ? (thickness == DripstoneThickness.BASE) ? upBase : (thickness == DripstoneThickness.FRUSTUM) ? upFrustum : (thickness == DripstoneThickness.MIDDLE) ? upMiddle : (thickness == DripstoneThickness.TIP_MERGE) ? upTipMerge : upTip : (thickness == DripstoneThickness.BASE) ? downBase : (thickness == DripstoneThickness.FRUSTUM) ? downFrustum : (thickness == DripstoneThickness.MIDDLE) ? downMiddle : (thickness == DripstoneThickness.TIP_MERGE) ? downTipMerge : downTip).build();
        });
    }
}