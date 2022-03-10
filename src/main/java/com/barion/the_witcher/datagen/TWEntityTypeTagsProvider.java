package com.barion.the_witcher.datagen;

import com.barion.the_witcher.TWTags;
import com.barion.the_witcher.TheWitcher;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class TWEntityTypeTagsProvider extends EntityTypeTagsProvider {
    public TWEntityTypeTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, TheWitcher.ModID, existingFileHelper);
    }

    @Override
    protected void addTags(){
        isMagicMob(EntityType.VEX);
    }

    private void isMagicMob(EntityType<?>... entities) {tag(TWTags.Entities.MagicMob).add(entities);}
}