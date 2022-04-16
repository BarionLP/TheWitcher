package com.barion.the_witcher.datagen;

import com.barion.the_witcher.TheWitcher;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class TWBiomeTagsProvider extends BiomeTagsProvider {
    public TWBiomeTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper exFileHelper) {
        super(generator, TheWitcher.ModID, exFileHelper);
    }

    @Override
    protected void addTags() {}
}