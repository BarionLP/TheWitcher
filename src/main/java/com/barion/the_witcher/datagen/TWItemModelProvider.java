package com.barion.the_witcher.datagen;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.TWBlocks;
import com.barion.the_witcher.world.TWItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Objects;

public class TWItemModelProvider extends ItemModelProvider {
    private final ModelFile generatedItem = getExistingFile(mcLoc("item/generated"));
    private final ModelFile bigSword = getExistingFile(modLoc("item/big_sword"));

    public TWItemModelProvider(DataGenerator generator, ExistingFileHelper fileHelper){super(generator, TheWitcher.ModID, fileHelper);}

    @Override
    protected void registerModels() {
        blocks(TWBlocks.SilverOre.get(),
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
    protected final void item(String name, String texture) {getBuilder(name).parent(generatedItem).texture("layer0", "item/" + texture);}

    protected final void blocks(Block... blocks){
        for(Block block : blocks) {
            block(block);
        }
    }
    protected final void blockGroup(Block block, StairBlock stair, SlabBlock slab, WallBlock wall){
        String texture = getName(block);
        block(block, texture);
        stairBlock(stair, texture);
        slabBlock(slab, texture);
        wallBlock(wall, texture);
    }

    protected final void stairBlock(StairBlock stair, String texture) {stairs(getName(stair), location(texture), location(texture), location(texture));}
    protected final void slabBlock(SlabBlock slab, String texture) {slab(getName(slab), location(texture), location(texture), location(texture));}
    protected final void wallBlock(WallBlock wall, String texture) {wallInventory(getName(wall), location(texture));}

    protected final void block(Block block) {block(block, getName(block));}
    protected final void block(Block block, String parent){
        TheWitcher.LOGGER.info(location(parent));
        //withExistingParent(getName(block), location(parent));
        withExistingParent(getName(block), modLoc("block/" + parent));
    }

    @SafeVarargs
    protected final <S extends SwordItem> void bigSword(S... swords) {
        for(S sword : swords){
            String name = Objects.requireNonNull(sword.getRegistryName()).getPath();
            bigSword(name, name);
        }
    }
    protected final void bigSword(String name, String texture) {getBuilder(name).parent(bigSword).texture("layer0", "item/" + texture);}

    protected final String getName(Item item) {return Objects.requireNonNull(item.getRegistryName()).getPath();}
    protected final String getName(Block block) {return Objects.requireNonNull(block.getRegistryName()).getPath();}
    protected final ResourceLocation location(String name) {return modLoc("block/" + name);
    }
}