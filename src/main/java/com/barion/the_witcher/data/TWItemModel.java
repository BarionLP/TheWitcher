package com.barion.the_witcher.data;

import com.barion.the_witcher.TheWitcher;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TWItemModel extends ItemModelProvider {
    private final ModelFile generatedItem = getExistingFile(mcLoc("item/generated"));
    private final ModelFile bigSword = getExistingFile(modLoc("item/big_sword"));
    public TWItemModel(DataGenerator generator, ExistingFileHelper fileHelper){
        super(generator, TheWitcher.ModID, fileHelper);
    }

    @Override
    protected void registerModels() {
        regItem("tab_logo");

        regBlock("silver_ore");
        regBlock("deepslate_silver_ore");
        regBlock("silver_block");
        regBlock("raw_silver_block");
        regItem("raw_silver");
        regItem("silver_ingot");
        regItem("silver_nugget");
        regBigSword("silver_sword");
        regBigSword("masterful_silver_sword");

        regItem("steel_ingot");
        regItem("steel_nugget");
        regBigSword("steel_sword");
        regBigSword("masterful_steel_sword");
    }
    private void regBlock(String name, String texture){
        withExistingParent(name, modLoc("block/" + texture));
    }
    private void regBlock(String name){regBlock(name, name);}

    private void regItem(String name){
        regItem(name, name);
    }
    private void regItem(String name, String texture){
        getBuilder(name).parent(generatedItem).texture("layer0", "item/" + texture);
    }
    private void regBigSword(String name){
        regBigSword(name, name);
    }
    private void regBigSword(String name, String texture){
        getBuilder(name).parent(bigSword).texture("layer0", "item/" + texture);
    }
}