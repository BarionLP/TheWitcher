package com.barion.the_witcher.datagen;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.TWBlocks;
import com.barion.the_witcher.world.TWItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

public class TWItemModel extends ItemModelProvider {
    private final ModelFile generatedItem = getExistingFile(mcLoc("item/generated"));
    private final ModelFile bigSword = getExistingFile(modLoc("item/big_sword"));

    public TWItemModel(DataGenerator generator, ExistingFileHelper fileHelper){super(generator, TheWitcher.ModID, fileHelper);}

    @Override
    protected void registerModels() {
        block(TWBlocks.SilverOre.get(),
                TWBlocks.DeepslateSilverOre.get(),
                TWBlocks.SilverBlock.get(),
                TWBlocks.RawSilverBlock.get(),
                TWBlocks.FrostedStone.get(),
                TWBlocks.FrostedCobblestone.get(),
                TWBlocks.DeepFrostedStone.get(),
                TWBlocks.DeepFrostedCobblestone.get());

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
    private <B extends Block> void block(B... blocks){
        for(B block : blocks) {
            String name = Objects.requireNonNull(block.getRegistryName()).getPath();
            withExistingParent(name, modLoc("block/" + name));
        }
    }
    private <B extends Block> void block(RegistryObject<B> block, String texture){
        String name = Objects.requireNonNull(block.get().getRegistryName()).getPath();
        withExistingParent(name, modLoc("block/" + texture));
    }

    @SafeVarargs
    private <I extends Item> void item(I... items){
        for(I item : items){
            String name = Objects.requireNonNull(item.getRegistryName()).getPath();
            item(name, name);
        }
    }
    private <I extends Item> void item(I item, String texture){
        String name = Objects.requireNonNull(item.getRegistryName()).getPath();
        item(name, texture);
    }
    private void item(String name, String texture){getBuilder(name).parent(generatedItem).texture("layer0", "item/" + texture);}

    @SafeVarargs
    private <S extends SwordItem> void bigSword(S... swords){
        for(S sword : swords){
            String name = Objects.requireNonNull(sword.getRegistryName()).getPath();
            bigSword(name, name);
        }
    }
    private void bigSword(String name, String texture){getBuilder(name).parent(bigSword).texture("layer0", "item/" + texture);}
}