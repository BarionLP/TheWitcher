package com.barion.the_witcher.datagen;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.TWBlocks;
import com.barion.the_witcher.world.TWItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.Objects;

public class TWItemModelProvider extends ItemModelProvider {
    private final ModelFile generatedItem = getExistingFile(mcLoc("item/generated"));
    private final ModelFile bigSword = getExistingFile(modLoc("item/big_sword"));

    public TWItemModelProvider(DataGenerator generator, ExistingFileHelper fileHelper){super(generator, TheWitcher.ModID, fileHelper);}

    @Override
    protected void registerModels() {
        simpleBlock(TWBlocks.getAllBlocks());

        item(TWItems.TabLogo.get(),
                TWItems.RawSilver.get(),
                TWItems.SilverIngot.get(),
                TWItems.SilverNugget.get(),
                TWItems.SteelIngot.get(),
                TWItems.SteelNugget.get());

        bigSword(TWItems.SilverSword.get(),
                TWItems.MasterfulSilverSword.get(),
                TWItems.SteelSword.get(),
                TWItems.MasterfulSteelSword.get());
    }

    @SafeVarargs
    protected  final  <I extends Item> void item(I... items){
        for(I item : items){
            String name = getName(item);
            item(name, name);
        }
    }
    protected final <I extends Item> void item(I item, String texture){
        String name = getName(item);
        item(name, texture);
    }
    protected final void item(String name, String texture) {getBuilder(name).parent(generatedItem).texture("layer0", ITEM_FOLDER + "/" + texture);}
    private void item(Item item){
        String name = getName(item);
        getBuilder(name).parent(generatedItem).texture("layer0", ITEM_FOLDER + "/" + name);
    }

    @SafeVarargs
    protected final <S extends SwordItem> void bigSword(S... swords) {
        for(S sword : swords){
            String name = Objects.requireNonNull(sword.getRegistryName()).getPath();
            bigSword(name, name);
        }
    }
    protected final void bigSword(String name, String texture) {getBuilder(name).parent(bigSword).texture("layer0", ITEM_FOLDER + "/" + texture);}

    private <B extends Block> void simpleBlock(List<B> blocks){
        for(B block : blocks) {
            String name = getName(block);
            ResourceLocation texture;
            TheWitcher.LOGGER.info(modLoc(BLOCK_FOLDER + "/" + name));
            if(block instanceof StairBlock){
                texture = modLoc(BLOCK_FOLDER + "/" + name.replace("_stairs", ""));
                stairs(name, texture, texture, texture);
            }else if(block instanceof SlabBlock) {
                texture = modLoc(BLOCK_FOLDER + "/" + name.replace("_slab", ""));
                slab(name, texture, texture, texture);
            }else if(block instanceof WallBlock){
                texture = modLoc(BLOCK_FOLDER + "/" + name.replace("_wall", ""));
                wallInventory(name, texture);
            }else if(block instanceof SaplingBlock){
                sapling(name);
            }else{
                simpleBlock(name);
            }
        }
    }
    private void simpleBlock(String name) {withExistingParent(name, modLoc(BLOCK_FOLDER + "/" + name));}
    private void sapling(String name) {getBuilder(name).parent(generatedItem).texture("layer0", BLOCK_FOLDER + "/" + name);}

    protected final String getName(Item item) {return Objects.requireNonNull(item.getRegistryName()).getPath();}
    protected final String getName(Block block) {return Objects.requireNonNull(block.getRegistryName()).getPath();}
    protected final ResourceLocation location(String name) {return modLoc(BLOCK_FOLDER + "/" + name);}
}