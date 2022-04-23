package com.barion.the_witcher.datagen;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.TWBlocks;
import com.barion.the_witcher.world.TWItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.Objects;

public class TWItemModelProvider extends ItemModelProvider {
    private final ModelFile generatedItem = getExistingFile(mcLoc("item/generated"));
    private final ModelFile bigHandheld = getExistingFile(modLoc("item/big_sword"));

    public TWItemModelProvider(DataGenerator generator, ExistingFileHelper fileHelper){super(generator, TheWitcher.ModID, fileHelper);}

    @Override
    protected void registerModels() {
        blocks(TWBlocks.getAllBlocks());
        items(TWItems.getAllItems());
    }

    private <B extends Block> void blocks(List<B> blocks){
        for(B block : blocks) {
            String name = getName(block);
            ResourceLocation texture;
            if(block instanceof StairBlock) {
                if(TWUtil.shouldAppendS(name)) {texture = blockTexture(name.replace("_stairs", "s"));}
                else {texture = blockTexture(name.replace("_stairs", ""));}
                stairs(name, texture, texture, texture);
            }else if(block instanceof SlabBlock) {
                if(TWUtil.shouldAppendS(name)) {texture = blockTexture(name.replace("_slab", "s"));}
                else {texture = blockTexture(name.replace("_slab", ""));}
                slab(name, texture, texture, texture);
            }else if(block instanceof WallBlock) {
                if(TWUtil.shouldAppendS(name)) {texture = blockTexture(name.replace("_wall", "s"));}
                else {texture = blockTexture(name.replace("_wall", ""));}
                wallInventory(name, texture);
            }else if(block instanceof SaplingBlock){
                sapling(name);
            }else if(block instanceof ButtonBlock){
                if(TWUtil.shouldAppendS(name)) {texture = blockTexture(name.replace("_button", "s"));}
                else {texture = blockTexture(name.replace("_button", ""));}
                buttonInventory(name, texture);
            }else{
                block(name);
            }
        }
    }
    private void block(String name) {withExistingParent(name, modLoc(BLOCK_FOLDER + "/" + name));}
    private void sapling(String name) {getBuilder(name).parent(generatedItem).texture("layer0", BLOCK_FOLDER + "/" + name);}

    private <I extends Item> void items(List<I> items){
        for (Item item : items){
            String name = getName(item);

            if(item instanceof SignItem){
                item(name);
            }else if(item instanceof BlockItem){
                continue;
            }else if(item instanceof SwordItem){
                item(name, bigHandheld);
            }else{
                item(name);
            }
        }
    }

    protected final void item(String name) {item(name, generatedItem, name);}
    protected final void item(String name, ModelFile model) {item(name, model, name);}
    protected final void item(String name, ModelFile model, String texture) {getBuilder(name).parent(model).texture("layer0", ITEM_FOLDER + "/" + texture);}

    protected final String getName(Item item) {return Objects.requireNonNull(item.getRegistryName()).getPath();}
    protected final String getName(Block block) {return Objects.requireNonNull(block.getRegistryName()).getPath();}
    protected final ResourceLocation blockTexture(String name) {return modLoc(BLOCK_FOLDER + "/" + name);}
}