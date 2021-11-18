package com.barion.the_witcher.data;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.stuff.TWTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class TWEntityTags extends EntityTypeTagsProvider {
    public TWEntityTags(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, TheWitcher.ModID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        isMagicMob(EntityType.VEX);
    }

    private void isMagicMob(EntityType... entities){
        tag(TWTags.Entities.MagicMob).add(entities);
    }
}
