package com.barion.the_witcher.datagen;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.TWBlocks;
import com.barion.the_witcher.world.TWItems;
import com.barion.the_witcher.world.block.TWGrowableBushBlock;
import com.barion.the_witcher.world.block.TWIcicleBlock;
import com.barion.the_witcher.world.block.TWPowerBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.List;

import static com.ametrinstudios.ametrin.AmetrinUtil.*;

public class TWItemModelProvider extends ItemModelProvider {
    private final ModelFile generatedItem = getExistingFile(mcLoc("item/generated"));
    private final ModelFile bigHandheld = getExistingFile(modLoc("item/big_sword"));
    private final ModelFile spawnEgg = getExistingFile(mcLoc("item/template_spawn_egg"));

    public TWItemModelProvider(DataGenerator generator, ExistingFileHelper fileHelper){super(generator, TheWitcher.ModID, fileHelper);}

    @Override
    protected void registerModels() {
        blocks(TWBlocks.getAllBlocks());
        items(TWItems.getAllItems());
    }

    private <B extends Block> void blocks(List<B> blocks){
        for(B block : blocks) {
            if(block instanceof TWGrowableBushBlock){
                continue;
            }

            String name = getBlockName(block);
            ResourceLocation texture;
            if(block instanceof StairBlock) {
                if(shouldAppendS(name)) {texture = blockTexture(name.replace("_stairs", "s"));}
                else {texture = blockTexture(name.replace("_stairs", ""));}
                stairs(name, texture, texture, texture);
            }else if(block instanceof SlabBlock) {
                if(shouldAppendS(name)) {texture = blockTexture(name.replace("_slab", "s"));}
                else {texture = blockTexture(name.replace("_slab", ""));}
                slab(name, texture, texture, texture);
            }else if(block instanceof WallBlock) {
                if(shouldAppendS(name)) {texture = blockTexture(name.replace("_wall", "s"));}
                else {texture = blockTexture(name.replace("_wall", ""));}
                wallInventory(name, texture);
            }else if(block instanceof SaplingBlock){
                itemBlock(name);
            }else if(block instanceof TWIcicleBlock){
                itemBlock(getExistingFile(mcLoc("item/pointed_dripstone")), name, name + "/down/tip");
            }else if(block instanceof ButtonBlock){
                if(shouldAppendS(name)) {texture = blockTexture(name.replace("_button", "s"));}
                else {texture = blockTexture(name.replace("_button", ""));}
                buttonInventory(name, texture);
            }else if(block instanceof TWPowerBlock){
                withExistingParent(name, modLoc(BLOCK_FOLDER + "/" + name + "/on"));
            }else{
                block(name);
            }
        }
    }
    private void block(String name) {withExistingParent(name, modLoc(BLOCK_FOLDER + "/" + name));}
    private void itemBlock(String name) {itemBlock(name, name);}
    private void itemBlock(String name, String texture) {itemBlock(generatedItem, name, texture);}
    private void itemBlock(ModelFile parent, String name, String texture) {getBuilder(name).parent(parent).texture("layer0", BLOCK_FOLDER + "/" + texture);}

    private <I extends Item> void items(List<I> items){
        for (I item : items){
            String name = getItemName(item);

            if(item instanceof SignItem){
                item(name);
            }else if(item instanceof BlockItem && !(item instanceof ItemNameBlockItem)){
                continue;
            }else if(item instanceof SwordItem) {
                item(name, bigHandheld);
            }else if(item instanceof SpawnEggItem){
                getBuilder(name).parent(spawnEgg);
            }else{
                item(name);
            }
        }
    }

    protected final void item(String name) {item(name, generatedItem, name);}
    protected final void item(String name, ModelFile model) {item(name, model, name);}
    protected final void item(String name, ModelFile model, String texture) {getBuilder(name).parent(model).texture("layer0", ITEM_FOLDER + "/" + texture);}

    protected final ResourceLocation blockTexture(String name) {return modLoc(BLOCK_FOLDER + "/" + name);}
}