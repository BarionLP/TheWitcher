package com.barion.the_witcher.world;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.entity.TWIceGhostEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.ParametersAreNonnullByDefault;

public class TWEntities {
    public static final DeferredRegister<EntityType<?>> Registry = DeferredRegister.create(ForgeRegistries.ENTITIES, TheWitcher.ModID);

    public static final RegistryObject<EntityType<TWIceGhostEntity>> IceGhost = register("ice_ghost", TWIceGhostEntity::new, MobCategory.MONSTER, 1, 2);

    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(TWEntities.IceGhost.get(), TWIceGhostEntity.createAttributes().build());
    }

    @ParametersAreNonnullByDefault
    private static <E extends Entity>RegistryObject<EntityType<E>> register(String name, EntityType.EntityFactory<E> entity, MobCategory category, float size, float height){
        return Registry.register(name, ()-> EntityType.Builder.of(entity, category).sized(size, height).build(new ResourceLocation(TheWitcher.ModID, name).toString()));
    }
}