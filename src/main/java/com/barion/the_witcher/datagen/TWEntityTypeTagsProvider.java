package com.barion.the_witcher.datagen;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.util.TWTags;
import com.barion.the_witcher.world.TWEntities;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class TWEntityTypeTagsProvider extends EntityTypeTagsProvider {
    public TWEntityTypeTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, TheWitcher.ModID, existingFileHelper);
    }

    @Override
    protected void addTags(){
        tag(TWTags.Entities.MagicMob).add(
                EntityType.VEX,
                EntityType.CREEPER,
                TWEntities.WildHuntHound.get(),
                TWEntities.IceGhost.get()
        );

        tag(TWTags.Entities.WildHunt).add(
                TWEntities.WildHuntHound.get(),
                TWEntities.WildHuntKnight.get()
        );

        tag(TWTags.Entities.WildHuntIgnore).addTag(TWTags.Entities.WildHunt).add(
                EntityType.AXOLOTL,
                EntityType.BEE,
                EntityType.CREEPER,
                EntityType.DOLPHIN,
                EntityType.FOX,
                EntityType.POLAR_BEAR,
                EntityType.PARROT,
                EntityType.SKELETON_HORSE
        );

        tag(EntityTypeTags.FREEZE_IMMUNE_ENTITY_TYPES).add(
                TWEntities.WildHuntHound.get(),
                TWEntities.WildHuntKnight.get(),
                TWEntities.IceGhost.get()
        );
        tag(EntityTypeTags.POWDER_SNOW_WALKABLE_MOBS).add(
                TWEntities.WildHuntHound.get(),
                TWEntities.IceGhost.get()
        );
    }
}